package com.stylefeng.guns.rest.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.API.User.IUserAPI;
import com.stylefeng.guns.API.Vo.UserVo;
import com.stylefeng.guns.API.from.UserForm;
import com.stylefeng.guns.rest.common.CurrentUserInfo;
import com.stylefeng.guns.rest.common.response.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: guns-parent
 * @description: 用户模块接口
 * @author: Zwb
 * @create: 2019-04-30 10:45
 **/


@RequestMapping("/user/")
@RestController
public class userController {

    private final static Logger log = LoggerFactory.getLogger(userController.class);

    @Reference(interfaceClass = IUserAPI.class,check = false)
    private IUserAPI iUserAPI;

    @PostMapping("register")
    public ServerResponse register(UserForm userForm){
        if(userForm.getUsername() == null || userForm.getUsername().trim().length()==0){
            return ServerResponse.error("用户名无效");
        }
        if(userForm.getPassword() == null || userForm.getPassword().trim().length()==0){
            return ServerResponse.error("密码无效");
        }

        boolean result = iUserAPI.register(userForm);
        if(result){
            return ServerResponse.success("注册成功");
        }else{
            log.info("【用户模块】注册失败，userForm={}",userForm);
            return ServerResponse.error();
        }
    }

    @PostMapping("check")
    public ServerResponse check(String username) {
        if(username == null || username.trim().length() == 0){
            return ServerResponse.error("用户名不能为空");
        }
        boolean notExit = iUserAPI.checkUser(username);
        if(notExit){
            return ServerResponse.success("用户名不存在");
        }else{
            return ServerResponse.error("用户名已存在");
        }
    }

    @GetMapping("logout")
    public ServerResponse logout(){

        return ServerResponse.success("退出成功");

    }

    @GetMapping("getUserInfo")
    public ServerResponse getUserInfo(){
        String userId = CurrentUserInfo.getUserId();
        if(userId == null || userId.trim().length() == 0){
            return ServerResponse.error("用户不存在");
        }
        Integer uuid = Integer.parseInt(userId);
        UserVo userVo = iUserAPI.getUserInfo(uuid);
        if(userVo != null){
            return ServerResponse.success(userVo);
        }else{
            return ServerResponse.error("查询失败");
        }

    }

    @PostMapping("updateUserInfo")
    public ServerResponse updateUserInfo(UserVo userVo){
        String userId = CurrentUserInfo.getUserId();
        if(userId == null || userId.trim().length() == 0){
            return ServerResponse.error("用户不存在");
        }
        Integer uuid = Integer.parseInt(userId);
        UserVo userVo1 = iUserAPI.update(userVo);
        if(uuid != userVo1.getUuid()){
            return ServerResponse.error("请修改个人信息");
        }
        if(userVo != null){
            return ServerResponse.success(userVo1);
        }else{
            return ServerResponse.error("查询失败");
        }
    }

}









