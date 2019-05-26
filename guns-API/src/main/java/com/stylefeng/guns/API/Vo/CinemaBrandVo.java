package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影院模块->getCondition->brand
 * @author: Zwb
 * @create: 2019-05-26 14:10
 **/

@Data
public class CinemaBrandVo implements Serializable {

    private static final long serialVersionUID = 4429007796510774209L;

    private String brandId;

    private String brandName;

    private boolean isActive;

}
