package com.stylefeng.guns.API.Film;

import com.stylefeng.guns.API.Vo.*;
import com.stylefeng.guns.API.Vo.ApiVo.FilmDetailVo;

import java.util.List;

public interface IFilmAPI {
    //获取banner图
     List<BannerVo> getBanners();

    //获取热映影片
    FilmsVo getHotFilms(boolean isLimit, int nums,int nowPage,int sortId,int sourceId,int yearId,int catId);

    //获取即将上映影片
    FilmsVo getSoonFilms(boolean isLimit, int nums,int nowPage,int sortId,int sourceId,int yearId,int catId);

    //获取经典影片
    FilmsVo getClassicFilms(int nums,int nowPage,int sortId,int sourceId,int yearId,int catId);

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

    //获取影片的详情
    FilmDetailVo getFilmDetail(int searchType,String searchParam);

    //查询影片的描述信息
    FilmDesVo getFilmDesc(String filmId);

    //查找影片的演员照片
    ImgVo getImg(String filmId);

    //查找影片的导演信息
    ActorVo getDectInfo(String filmId);

    //查找影片的演员表
    List<ActorVo> getActors(String filmId);

}
