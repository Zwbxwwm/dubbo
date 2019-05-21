package com.stylefeng.guns.API.Vo.ApiVo;

import com.stylefeng.guns.API.Vo.InfoRequestVo;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影片详情信息
 * @author: Zwb
 * @create: 2019-05-21 10:19
 **/

@Data
public class FilmDetailVo implements Serializable {

    private static final long serialVersionUID = -7318381194371890593L;

    private String filmId;

    private String filmName;

    private String filmEnName;

    private String imgAddress;

    private String score;

    private String scoreNum;

    private String totalBox;

    private String info01;

    private String info02;

    private String info03;

    private InfoRequestVo info04;


}
