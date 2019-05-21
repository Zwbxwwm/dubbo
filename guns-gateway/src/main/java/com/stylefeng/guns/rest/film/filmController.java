package com.stylefeng.guns.rest.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.API.Film.IFilmAPI;
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
    public ServerResponse films(@PathVariable("searchType")int searchType,@RequestParam("searchParam")String searchParam){

        //根据searchType确定查询的接口类型
        FilmDetailVo filmDetailVo = iFilmAPI.getFilmDetail(searchType,searchParam);

        //查询影片的演员表
        List<ActorVo> actorVos = iFilmAPI.getActors(filmDetailVo.getFilmId());

        //查找影片的详细描述
        FilmDesVo filmDesVo = iFilmAPI.getFilmDesc(filmDetailVo.getFilmId());

        //查找影片导演
        ActorVo director = iFilmAPI.getDectInfo(filmDetailVo.getFilmId());

        //查找影片图片信息
        ImgVo imgVo = iFilmAPI.getImg(filmDetailVo.getFilmId());

        InfoRequestVo infoRequestVo = new InfoRequestVo();

        //组建info04里面的第一层actors属性
        ActorRequestVo actorRequestVo = new ActorRequestVo();
        actorRequestVo.setDirector(director);
        actorRequestVo.setActors(actorVos);

        //组建info04
        infoRequestVo.setActors(actorRequestVo);
        infoRequestVo.setImgs(imgVo);
        infoRequestVo.setFilmId(filmDetailVo.getFilmId());

        filmDetailVo.setInfo04(infoRequestVo);

        return ServerResponse.success("www.xingluote.cn",filmDetailVo);
    }















}
