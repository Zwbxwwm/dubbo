package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影片剧内信息描述
 * @author: Zwb
 * @create: 2019-05-21 15:43
 **/
@Data
public class FilmDesVo implements Serializable {

    private static final long serialVersionUID = -5633186928163414879L;

    private String biography;

    private String filmId;


}
