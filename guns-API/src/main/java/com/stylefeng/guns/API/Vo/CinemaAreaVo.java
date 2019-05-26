package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影院模块->getCondition->area
 * @author: Zwb
 * @create: 2019-05-26 14:14
 **/
@Data
public class CinemaAreaVo implements Serializable {


    private static final long serialVersionUID = 2365904611553361754L;

    private String areaId;

    private String areaName;

    private boolean isActive;
}
