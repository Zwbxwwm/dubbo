package com.stylefeng.guns.API.User;


import com.stylefeng.guns.API.from.UserForm;
import com.stylefeng.guns.API.Vo.UserVo;

public interface IUserAPI {
    int login(String name, String password);

    boolean register(UserForm userForm);

    boolean checkUser(String username);

    UserVo getUserInfo(int uuid);

    UserVo update(UserVo userVo);

}
