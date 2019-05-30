package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.Vo.CinemaInfoVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocCinemaT;

/**
 * @program: guns-parent
 * @description: MoocCinemaT数据层转换成业务层CinemaInfoVo
 * @author: Zwb
 * @create: 2019-05-30 14:54
 **/
public class MoocCinemaT2CinemaInfoVo {
    public static CinemaInfoVo converter(MoocCinemaT moocCinemaT) {
        CinemaInfoVo cinemaInfoVo = new CinemaInfoVo();
        cinemaInfoVo.setCinemaId(moocCinemaT.getUuid()+"");
        cinemaInfoVo.setCinemaName(moocCinemaT.getCinemaName());
        cinemaInfoVo.setImgUrl(moocCinemaT.getImgAddress());
        cinemaInfoVo.setCinemaPhone(moocCinemaT.getCinemaPhone());
        cinemaInfoVo.setCinemaAddress(moocCinemaT.getCinemaAddress());
        return cinemaInfoVo;
    }
}
