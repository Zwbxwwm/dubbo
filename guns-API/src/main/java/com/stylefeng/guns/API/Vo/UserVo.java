package com.stylefeng.guns.API.Vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: guns-parent
 * @description: 用户信息的VO类
 * @author: Zwb
 * @create: 2019-04-28 12:33
 **/

@Data

public class UserVo implements Serializable {
    public Integer Uuid;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

    private Integer sex;

    private String birthday;

    private Integer lifeState;

    private String biography;

    private String headAddress;

    private Date createTime;

    private Date updateTime;



}
