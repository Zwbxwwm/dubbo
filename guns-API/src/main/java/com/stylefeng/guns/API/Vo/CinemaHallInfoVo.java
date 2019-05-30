package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影院模块->getFieldInfo->hallInfo
 * @author: Zwb
 * @create: 2019-05-26 15:11
 **/
@Data
public class CinemaHallInfoVo implements Serializable {

    private static final long serialVersionUID = 2969449963869763726L;

    private String hallFieldId;

    private String hallName;

    private String price;

    private String seatFile;

    private String soldSeats;
}
