package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.Vo.UserVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;

/**
 * @program: guns-parent
 * @description: 数据库表实体类转成view层实体类
 * @author: Zwb
 * @create: 2019-04-29 10:39
 **/
public class MoocUserT2UserVo {
    public static UserVo converter(MoocUserT moocUserT){
        UserVo userVo = new UserVo();
        userVo.setUuid(moocUserT.getUuid());
        userVo.setUsername(moocUserT.getUserName());
        userVo.setSex(moocUserT.getUserSex());
        userVo.setEmail(moocUserT.getEmail());
        userVo.setAddress(moocUserT.getAddress());
        userVo.setPhone(moocUserT.getUserPhone());
        userVo.setNickname(moocUserT.getNickName());
        userVo.setLifeState(moocUserT.getLifeState());
        userVo.setHeadAddress(moocUserT.getHeadUrl());
        userVo.setUpdateTime(moocUserT.getUpdateTime());
        userVo.setCreateTime(moocUserT.getBeginTime());
        userVo.setBirthday(moocUserT.getBirthday());
        userVo.setBiography(moocUserT.getBiography());
        return userVo;
    }
}
