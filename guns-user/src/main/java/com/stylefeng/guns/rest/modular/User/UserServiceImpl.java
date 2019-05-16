package com.stylefeng.guns.rest.modular.User;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.API.from.UserForm;
import com.stylefeng.guns.API.User.IUserAPI;
import com.stylefeng.guns.API.Vo.UserVo;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.converter.MoocUserT2UserVo;
import com.stylefeng.guns.rest.common.converter.UserForm2MoocUserT;
import com.stylefeng.guns.rest.common.converter.UserVo2MoocUserT;
import com.stylefeng.guns.rest.common.persistence.dao.MoocUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: guns-parent
 * @description: 测试
 * @author: Zwb
 * @create: 2019-04-27 19:04
 **/

@Component
@Service(interfaceClass = IUserAPI.class)
public class UserServiceImpl implements IUserAPI {

    @Autowired
    private MoocUserTMapper moocUserTMapper;


    @Override
    public boolean register(UserForm userForm) {
        MoocUserT moocUserT = UserForm2MoocUserT.converter(userForm);
        int insert = moocUserTMapper.insert(moocUserT);
        if(insert>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int login(String username, String password) {

        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(username);
        //查询出用户信息
        MoocUserT result = moocUserTMapper.selectOne(moocUserT);
        //验证用户信息
        if(result != null && result.getUuid()>0){
            String MD5Password = MD5Util.encrypt(password);
            if(MD5Password.equals(result.getUserPwd())){
                return result.getUuid();
            }
        }

        return 0;
    }


    @Override
    public boolean checkUser(String username) {
        EntityWrapper<MoocUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name",username);
        Integer result = moocUserTMapper.selectCount(entityWrapper);
        if(result != null && result > 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public UserVo getUserInfo(int uuid) {
        MoocUserT moocUserT = moocUserTMapper.selectById(uuid);
        UserVo userVo = MoocUserT2UserVo.converter(moocUserT);
        return userVo;
    }

    @Override
    public UserVo update(UserVo userVo) {
        MoocUserT moocUserT = UserVo2MoocUserT.converter(userVo);
        Integer result = moocUserTMapper.updateById(moocUserT);
        if(result != null && result > 0){
            UserVo userVo1 = getUserInfo(userVo.getUuid());
            return userVo1;
        }else{
            return userVo;
        }
    }
}












