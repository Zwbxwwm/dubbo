package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: guns-parent
 * @description: 影院模块->getField->filmInfo
 * @author: Zwb
 * @create: 2019-05-26 14:30
 **/
@Data
public class CinemaFilmInfoVo implements Serializable {

    private static final long serialVersionUID = 7539827479823591341L;

    private String filmId;

    private String filmName;

    private String filmLength;

    private String filmType;

    private String filmCats;

    private String actors;

    private String imgAddress;

    private List<CinemaFilmInfoVo> filmFields;
}
