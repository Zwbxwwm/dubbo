package com.stylefeng.guns.API.from;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: cinema表单
 * @author: Zwb
 * @create: 2019-05-26 05:43
 **/

@Data
public class CinemaFom implements Serializable {


    private static final long serialVersionUID = 6073588075666935594L;

    private Integer brandId = 99;

    private Integer hallType = 99;

    private Integer districtId = 99;

    private Integer pageSize = 12;

    private Integer nowPage = 1;

}
