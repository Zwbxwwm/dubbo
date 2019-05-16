package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 图标模块Vo层
 * @author: Zwb
 * @create: 2019-05-14 16:30
 **/

@Data
public class BannerVo implements Serializable {

    private static final long serialVersionUID = 683483697515394490L;

    private  String bannerId;

    private  String bannerAddress;

    private String bannerUrl;

}
