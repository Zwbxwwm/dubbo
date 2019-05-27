package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.Vo.ApiVo.CinemaVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocCinemaT;

/**
 * @program: guns-parent
 * @description: moocCinemaT实体类转CinemaVo类
 * @author: Zwb
 * @create: 2019-05-27 16:53
 **/
public class MoocCinemaT2CinemaVo {
    public static CinemaVo converter(MoocCinemaT moocCinemaT){
        CinemaVo cinemaVo = new CinemaVo();
        cinemaVo.setUuid(moocCinemaT.getUuid()+"");
        cinemaVo.setMinimumPrice(moocCinemaT.getMinimumPrice()+"");
        cinemaVo.setCinemaName(cinemaVo.getCinemaName());
        cinemaVo.setAddress(cinemaVo.getAddress());
        return cinemaVo;
    }
}
