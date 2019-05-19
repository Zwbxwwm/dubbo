package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 电影类型Vo
 * @author: Zwb
 * @create: 2019-05-16 17:36
 **/

@Data
public class CatVo implements Serializable {

    private static final long serialVersionUID = 962668556703475101L;

    private String CatId;

    private String catName;

    private String isActive = "false";
}
