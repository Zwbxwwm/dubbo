package com.stylefeng.guns.API.from;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 接受请求的表单输入实体类
 * @author: Zwb
 * @create: 2019-05-17 22:07
 **/

@Data
public class FilmForm implements Serializable {


    private static final long serialVersionUID = 4202423524159843698L;

    private Integer showType = 1;

    private Integer sortId = 1;

    private Integer catId = 99;

    private Integer sourceId = 99;

    private Integer yearId = 99;

    private Integer nowPage = 1;

    private Integer pageSize = 18;

}
