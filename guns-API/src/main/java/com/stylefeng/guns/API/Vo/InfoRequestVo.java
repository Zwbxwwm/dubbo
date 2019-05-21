package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 组建info04
 * @author: Zwb
 * @create: 2019-05-21 20:14
 **/

@Data
public class InfoRequestVo implements Serializable {

    private static final long serialVersionUID = 1603583896435983774L;

    private ActorRequestVo actors;

    private ImgVo imgs;

    private String filmId;
}
