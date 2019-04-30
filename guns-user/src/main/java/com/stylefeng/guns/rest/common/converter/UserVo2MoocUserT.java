package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.Vo.UserVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;

/**
 * @program: guns-parent
 * @description: view层实体类转换成数据库层实体类
 * @author: Zwb
 * @create: 2019-04-29 11:25
 **/
public class UserVo2MoocUserT {
    public static MoocUserT converter(UserVo userVo){
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(userVo.getUsername());
        moocUserT.setUuid(userVo.getUuid());
        moocUserT.setUserSex(userVo.getSex());
        moocUserT.setUpdateTime(userVo.getUpdateTime());
        moocUserT.setNickName(userVo.getNickname());
        moocUserT.setLifeState(userVo.getLifeState());
        moocUserT.setHeadUrl(userVo.getHeadAddress());
        moocUserT.setBirthday(userVo.getBirthday());
        moocUserT.setBiography(userVo.getBiography());
        moocUserT.setBeginTime(userVo.getCreateTime());
        moocUserT.setEmail(userVo.getEmail());
        moocUserT.setUserPhone(userVo.getPhone());
        moocUserT.setAddress(userVo.getAddress());
        moocUserT.setUserPwd(userVo.getPassword());
        return moocUserT;
    }
}
