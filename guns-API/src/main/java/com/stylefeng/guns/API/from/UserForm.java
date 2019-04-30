package com.stylefeng.guns.API.from;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 用户信息建模
 * @author: Zwb
 * @create: 2019-04-28 12:23
 **/

@Data
public class UserForm implements Serializable {
    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;
}
