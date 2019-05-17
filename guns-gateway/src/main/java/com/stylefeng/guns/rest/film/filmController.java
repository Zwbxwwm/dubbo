package com.stylefeng.guns.rest.film;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.API.Film.IFilmAPI;
import com.stylefeng.guns.API.Vo.ApiVo.FilmConditionVo;
import com.stylefeng.guns.API.Vo.ApiVo.FilmIndexVo;
import com.stylefeng.guns.rest.common.response.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        filmIndexVo.setHotFilms(iFilmAPI.getHotFilms(true,8));
        filmIndexVo.setSoonFilms(iFilmAPI.getSoonFilms(true,8));
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

        return null;
    }
}
