package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.Vo.CinemaHallTypeVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocHallDictT;

/**
 * @program: guns-parent
 * @description: MoocHallTypeTz转换成CinemaHallTypeVo
 * @author: Zwb
 * @create: 2019-05-29 11:22
 **/
public class MoocHallDictT2CinemaHallTypeVo {
    public static CinemaHallTypeVo converter(MoocHallDictT moocHallDictT) {
        CinemaHallTypeVo cinemaHallTypeVo = new CinemaHallTypeVo();
        cinemaHallTypeVo.setHallTypeId(moocHallDictT.getUuid()+"");
        cinemaHallTypeVo.setHallTypeName(moocHallDictT.getShowName());
        return cinemaHallTypeVo;
    }
}
