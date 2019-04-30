package com.stylefeng.guns.rest.common;

import com.stylefeng.guns.API.Vo.UserVo;

/**
 * @program: guns-parent
 * @description: 在线程中储存用户信息标识
 * @author: Zwb
 * @create: 2019-04-28 17:10
 **/
public class CurrentUserInfo {

    public static final ThreadLocal<String> threadUser = new ThreadLocal<>();

    public static void saveUserId(String userId){
        threadUser.set(userId);
    }

    public static  String getUserId(){
        return threadUser.get();
    }


}
