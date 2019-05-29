package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.Vo.CinemaAreaVo;
import com.stylefeng.guns.API.Vo.CinemaBrandVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocAreaDictT;
import com.stylefeng.guns.rest.common.persistence.model.MoocBrandDictT;

/**
 * @program: guns-parent
 * @description: MoocBrandDictT转换成CinemaBrandVo
 * @author: Zwb
 * @create: 2019-05-27 21:34
 **/
public class MoocAreaDictT2CinemaAreaVo {

    public static CinemaAreaVo converter(MoocAreaDictT moocAreaDictT){
        CinemaAreaVo cinemaAreaVo = new CinemaAreaVo();
        cinemaAreaVo.setAreaName(moocAreaDictT.getShowName());
        cinemaAreaVo.setAreaId(moocAreaDictT.getUuid()+"");
        return cinemaAreaVo;
    }

}
