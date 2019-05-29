package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.Vo.ApiVo.CinemaVo;
import com.stylefeng.guns.API.Vo.CinemaBrandVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocBrandDictT;

/**
 * @program: guns-parent
 * @description: MoocBrandDictT转换成CinemaBrandVo
 * @author: Zwb
 * @create: 2019-05-27 21:34
 **/
public class MoocBrandDictT2CinemaBrandVo {

    public static CinemaBrandVo converter(MoocBrandDictT moocBrandDictT){
        CinemaBrandVo cinemaBrandVo = new CinemaBrandVo();
        cinemaBrandVo.setBrandName(moocBrandDictT.getShowName());
        cinemaBrandVo.setBrandId(moocBrandDictT.getUuid()+"");
        return cinemaBrandVo;
    }

}
