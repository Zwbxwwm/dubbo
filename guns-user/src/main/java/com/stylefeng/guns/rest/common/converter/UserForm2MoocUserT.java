package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.from.UserForm;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;
import org.springframework.beans.BeanUtils;

/**
 * @program: guns-parent
 * @description: 表单类转换实体类
 * @author: Zwb
 * @create: 2019-04-28 20:50
 **/
public class UserForm2MoocUserT {
    public static MoocUserT converter(UserForm userForm){
        MoocUserT moocUserT = new MoocUserT();

        //对密码进行md5加密
        userForm.setPassword(MD5Util.encrypt(userForm.getPassword()));
        moocUserT.setUserName(userForm.getUsername());
        moocUserT.setUserPwd(userForm.getPassword());
        moocUserT.setEmail(userForm.getEmail());
        moocUserT.setUserPhone(userForm.getPhone());
        moocUserT.setAddress(userForm.getAddress());
        return moocUserT;
    }
}
