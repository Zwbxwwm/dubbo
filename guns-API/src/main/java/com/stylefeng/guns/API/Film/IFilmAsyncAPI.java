package com.stylefeng.guns.API.Film;

import com.stylefeng.guns.API.Vo.*;
import com.stylefeng.guns.API.Vo.ApiVo.FilmDetailVo;

import java.util.List;

public interface IFilmAsyncAPI {

    //查询影片的描述信息
    FilmDesVo getFilmDesc(String filmId);

    //查找影片的演员照片
    ImgVo getImg(String filmId);

    //查找影片的导演信息
    ActorVo getDectInfo(String filmId);

    //查找影片的演员表
    List<ActorVo> getActors(String filmId);

}
