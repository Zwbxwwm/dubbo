package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 电影产地Vo
 * @author: Zwb
 * @create: 2019-05-16 17:38
 **/

@Data
public class SourceVo implements Serializable {

    private static final long serialVersionUID = -5155782575360600887L;

    private String sourceId;

    private String sourceName;

    private String isActive;

}
