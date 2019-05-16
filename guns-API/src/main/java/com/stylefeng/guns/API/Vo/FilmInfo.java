package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 电影信息Vo层
 * @author: Zwb
 * @create: 2019-05-14 16:39
 **/

@Data
public class FilmInfo implements Serializable {


    private static final long serialVersionUID = -6943628345962523559L;

    private  String filmId;

    private String filmType;

    private String imgAddress;

    private String filmName;

    private String filmScore;

    private int expectNum;

    private String showTime;

    private int boxNum;

    private String score;
}
