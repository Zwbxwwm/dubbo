package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影院模块->getCondition->hallType
 * @author: Zwb
 * @create: 2019-05-26 14:16
 **/
@Data
public class CinemaHallTypeVo implements Serializable {

    private static final long serialVersionUID = 4476550994560614000L;

    private String hallTypeId;

    private String hallTypeName;

    private boolean isActive;
}
