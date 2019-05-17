package com.stylefeng.guns.API.Film;

import com.stylefeng.guns.API.Vo.*;

import java.util.List;

public interface IFilmAPI {
    //获取banner图
     List<BannerVo> getBanners();

    //获取热映影片
    FilmsVo getHotFilms(boolean isLimit, int nums);

    //获取即将上映影片
    FilmsVo getSoonFilms(boolean isLimit, int nums);

    //获取票房排行榜
    List<FilmInfo> getBoxRanKing();

    //获取人气排行榜
    List<FilmInfo> getExpectRanKing();

    //获取Top100
    List<FilmInfo> getTop();

    //获取分类
    List<CatVo> gtCats();

    //获取片源
    List<SourceVo> getSources();

    //获取影片年代
    List<YearVo> getYears();

}
