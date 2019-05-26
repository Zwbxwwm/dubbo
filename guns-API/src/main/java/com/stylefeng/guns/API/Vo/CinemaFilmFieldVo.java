package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影院模块->getField->filmField
 * @author: Zwb
 * @create: 2019-05-26 14:34
 **/
@Data
public class CinemaFilmFieldVo implements Serializable {

    private static final long serialVersionUID = 724427153954191004L;

    private String fieldId;

    private String beginTime;

    private String endTime;

    private String language;

    private String hallName;

    private String price;
}
