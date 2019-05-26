package com.stylefeng.guns.API.cinema;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.API.Vo.*;
import com.stylefeng.guns.API.Vo.ApiVo.CinemaVo;
import com.stylefeng.guns.API.from.CinemaFom;

import java.util.List;

public interface ICinemaAPI {
    // 1、根据CinemaQueryVO，查询影院列表
    Page<CinemaVo> getCinemas(CinemaFom cinemaFom);

    //2、根据条件获取品牌列表
    List<CinemaBrandVo> getBrands(int brandId);

    //3、获取行政区域列表
    List<CinemaAreaVo> getAreas(int areaId);

    //4、获取影厅类型列表
    List<CinemaHallTypeVo> getHallType(int hallTypes);

    //5、根据影院编号，获取影院信息
    CinemaInfoVo getCinemaInfoById(int cinemaId);

    //6、获取所有电影的信息和对应的放映场次信息，根据影院编号
    CinemaFilmInfoVo getCinemaFilmInfo(int cinemaId);

    //8、根据放映场次ID获取放映信息
    CinemaFilmFieldVo getFilmField(int fieldId);

    //9、根据放映场次查询播放的电影编号，然后根据电影编号获取对应的电影信息
    CinemaFilmInfoVo getFilmInfoByFieldId(int fieldId);

}
