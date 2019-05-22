package com.stylefeng.guns.rest.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.stylefeng.guns.API.Film.IFilmAPI;
import com.stylefeng.guns.API.Film.IFilmAsyncAPI;
import com.stylefeng.guns.API.Vo.*;
import com.stylefeng.guns.API.Vo.ApiVo.FilmConditionVo;
import com.stylefeng.guns.API.Vo.ApiVo.FilmDetailVo;
import com.stylefeng.guns.API.Vo.ApiVo.FilmIndexVo;
import com.stylefeng.guns.API.from.FilmForm;
import com.stylefeng.guns.rest.common.response.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program: guns-parent
 * @description: 影院模块controller层
 * @author: Zwb
 * @create: 2019-05-14 16:15
 **/

@Controller
@RequestMapping("/film")
public class filmController {

    @Reference(interfaceClass = IFilmAPI.class)
    private IFilmAPI iFilmAPI;

    @Reference(interfaceClass = IFilmAsyncAPI.class,async = true)
    private IFilmAsyncAPI iFilmAsyncAPI;

    @GetMapping("/getIndex")
    @ResponseBody
    public ServerResponse<FilmIndexVo> getIndex(){
        FilmIndexVo filmIndexVo = new FilmIndexVo();
        filmIndexVo.setBanners(iFilmAPI.getBanners());
        filmIndexVo.setBoxRanking(iFilmAPI.getBoxRanKing());
        filmIndexVo.setExpectRanking(iFilmAPI.getExpectRanKing());
        filmIndexVo.setHotFilms(iFilmAPI.getHotFilms(true,8,1,99,99,99,99));
        filmIndexVo.setSoonFilms(iFilmAPI.getSoonFilms(true,80,1,99,99,99,99));
        filmIndexVo.setTop100(iFilmAPI.getTop());
        return ServerResponse.success("www.xingluote.cn/img",filmIndexVo);
    }


    @GetMapping("/getConditionList")
    @ResponseBody
    public ServerResponse getConditionList(@RequestParam(name = "catId",required = false,defaultValue = "99")String catId,
                                           @RequestParam(name = "sourceId",required = false,defaultValue = "99")String sourceId,
                                           @RequestParam(name = "yearId",required = false,defaultValue = "99")String yearId){
        FilmConditionVo filmConditionVo = new FilmConditionVo();

        //根据catId,sourceId,yearId 对 isActive 进行赋值；
        //根据catId进行选择
        List<CatVo> catVos = iFilmAPI.gtCats();
        for(CatVo catVo : catVos){
            if (catVo.getCatId().equals(catId)) {
                catVo.setIsActive("true");
            }
        }
        filmConditionVo.setCatInfo(catVos);

        List<SourceVo> sourceVos = iFilmAPI.getSources();
        for(SourceVo sourceVo : sourceVos){
            if(sourceVo.getSourceId().equals(sourceId)){
                sourceVo.setIsActive("true");
            }
        }
        filmConditionVo.setSourceInfo(sourceVos);

        List<YearVo> yearVos  = iFilmAPI.getYears();
        for(YearVo yearVo : yearVos){
            if(yearVo.getYearId().equals(yearId)){
                yearVo.setIsActive("true");
            }
        }
        filmConditionVo.setYearInfo(yearVos);
        return ServerResponse.success(filmConditionVo);
    }


    @GetMapping("/getFilms")
    @ResponseBody
    public ServerResponse getFilms(@Valid FilmForm filmForm,BindingResult bindingResult){
        FilmsVo filmsVo = null;
        //根据showType进行查询；  查询类型，1-正在热映，2-即将上映，3-经典影片
        switch(filmForm.getShowType()){
            case 1:
                filmsVo = iFilmAPI.getHotFilms(false,filmForm.getPageSize(),filmForm.getNowPage(), filmForm.getSortId(),filmForm.getSourceId(),filmForm.getYearId(),filmForm.getCatId());
                break;
            case 2:
                filmsVo = iFilmAPI.getSoonFilms(false,filmForm.getPageSize(),filmForm.getNowPage(), filmForm.getSortId(),filmForm.getSourceId(),filmForm.getYearId(),filmForm.getCatId());
                break;
            case 3:
                filmsVo = iFilmAPI.getClassicFilms(filmForm.getPageSize(),filmForm.getNowPage(), filmForm.getSortId(),filmForm.getSourceId(),filmForm.getYearId(),filmForm.getCatId());
                break;
            default:
                filmsVo = iFilmAPI.getHotFilms(false,filmForm.getPageSize(),filmForm.getNowPage(), filmForm.getSortId(),filmForm.getSourceId(),filmForm.getYearId(),filmForm.getCatId());
                break;
        }
        return  ServerResponse.success("www.xingluote.cn",filmsVo.getNowPage(),filmsVo.getTotalPage(),filmsVo.getFilmInfo());
    }

    @GetMapping(value = "/films/{searchType}")
    @ResponseBody
    public ServerResponse films(@PathVariable("searchType")int searchType,@RequestParam("searchParam")String searchParam) throws ExecutionException, InterruptedException {

        //根据searchType确定查询的接口类型
        FilmDetailVo filmDetailVo = iFilmAPI.getFilmDetail(searchType,searchParam);

        //查询影片的演员表
//        List<ActorVo> actorVos = iFilmAsyncAPI.getActors(filmDetailVo.getFilmId());
        iFilmAsyncAPI.getActors(filmDetailVo.getFilmId());
        Future<List<ActorVo>> actorVosFuture = RpcContext.getContext().getFuture();


        //查找影片的详细描述
//        FilmDesVo filmDesVo = iFilmAsyncAPI.getFilmDesc(filmDetailVo.getFilmId());
        iFilmAsyncAPI.getFilmDesc(filmDetailVo.getFilmId());
        Future<FilmDesVo> filmDesVoFuture = RpcContext.getContext().getFuture();


        //查找影片导演
//        ActorVo director = iFilmAsyncAPI.getDectInfo(filmDetailVo.getFilmId());
        iFilmAsyncAPI.getDectInfo(filmDetailVo.getFilmId());
        Future<ActorVo> directorVoFuture = RpcContext.getContext().getFuture();

        //查找影片图片信息
//        ImgVo imgVo = iFilmAsyncAPI.getImg(filmDetailVo.getFilmId());
        iFilmAsyncAPI.getImg(filmDetailVo.getFilmId());
        Future<ImgVo> imgVoFuture = RpcContext.getContext().getFuture();


        InfoRequestVo infoRequestVo = new InfoRequestVo();

        //组建info04里面的第一层actors属性
        ActorRequestVo actorRequestVo = new ActorRequestVo();
        actorRequestVo.setDirector(directorVoFuture.get());
        actorRequestVo.setActors(actorVosFuture.get());

        //组建info04
        infoRequestVo.setActors(actorRequestVo);
        infoRequestVo.setBiography(filmDesVoFuture.get().getBiography());
        infoRequestVo.setImgs(imgVoFuture.get());
        infoRequestVo.setFilmId(filmDetailVo.getFilmId());

        filmDetailVo.setInfo04(infoRequestVo);


        return ServerResponse.success("www.xingluote.cn",filmDetailVo);
    }















}
