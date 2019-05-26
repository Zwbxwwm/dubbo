package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影院模块->getFields->cinemaInfo
 * @author: Zwb
 * @create: 2019-05-26 14:21
 **/
@Data
public class CinemaInfoVo implements Serializable {

    private static final long serialVersionUID = -7027856977051817902L;

    private String cinemaId;

    private String imgUrl;

    private String cinemaName;

    private String cinemaAddress;

    private String cinemaPhone;
}
