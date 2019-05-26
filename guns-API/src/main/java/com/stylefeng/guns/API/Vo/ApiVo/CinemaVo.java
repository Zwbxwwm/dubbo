package com.stylefeng.guns.API.Vo.ApiVo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: getCinemas接口的Vo层
 * @author: Zwb
 * @create: 2019-05-26 14:07
 **/

@Data
public class CinemaVo implements Serializable {

    private static final long serialVersionUID = 7263728472256397980L;

    private String uuid;

    private String cinemaName;

    private String address;

    private String minimumPrice;

}
