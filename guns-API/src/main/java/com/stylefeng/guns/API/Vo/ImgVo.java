package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 演员照照片
 * @author: Zwb
 * @create: 2019-05-21 15:48
 **/
@Data
public class ImgVo implements Serializable {

    private static final long serialVersionUID = -4354991627088985177L;

    private String mainImg;

    private String img01;

    private String img02;

    private String img03;

    private String img04;

}
