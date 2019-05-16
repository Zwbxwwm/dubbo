package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: guns-parent
 * @description: 热门影片模块Vo层
 * @author: Zwb
 * @create: 2019-05-14 16:37
 **/

@Data
public class FilmsVo implements Serializable {

    private static final long serialVersionUID = -6247054555835621468L;

    private int filmNum ;

    private List<FilmInfo> filmInfo;


}
