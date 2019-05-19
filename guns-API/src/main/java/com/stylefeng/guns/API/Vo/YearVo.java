package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 电影年代Vo
 * @author: Zwb
 * @create: 2019-05-16 17:42
 **/

@Data
public class YearVo implements Serializable {

    private static final long serialVersionUID = -2930803117843366049L;

    private String yearId;

    private String yearName;

    private String isActive = "false";

}
