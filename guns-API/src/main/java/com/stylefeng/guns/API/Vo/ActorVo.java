package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影片演员Vo
 * @author: Zwb
 * @create: 2019-05-21 16:42
 **/
@Data
public class ActorVo implements Serializable {

    private static final long serialVersionUID = 3941285918968041462L;

    private String imgAddress;

    private String directorName;

    private String roleName;
}
