package com.stylefeng.guns.rest.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.API.Film.IFilmAPI;
import com.stylefeng.guns.API.Vo.ApiVo.FilmConditionVo;
import com.stylefeng.guns.API.Vo.ApiVo.FilmIndexVo;
import com.stylefeng.guns.API.Vo.CatVo;
import com.stylefeng.guns.API.Vo.SourceVo;
import com.stylefeng.guns.API.Vo.YearVo;
import com.stylefeng.guns.API.from.FilmForm;
import com.stylefeng.guns.rest.common.response.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        filmIndexVo.setHotFilms(iFilmAPI.getHotFilms(true,8,0,0,0,0,0));
        filmIndexVo.setSoonFilms(iFilmAPI.getSoonFilms(true,80,0,0,0,0,0));
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
        return  null;
    }















}
