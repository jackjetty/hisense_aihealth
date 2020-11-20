package com.hisense.keylab.aihealth.controller;

import com.hisense.keylab.aihealth.constant.MessageConstant;
import com.hisense.keylab.aihealth.entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/19 14:49
 *
 * 用户信息controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUsername")
    public Result getUsername(){
        // 用户信息在spring security上下文中
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null){
            String username = user.getUsername();
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS, username);
        }
        return new Result(false, MessageConstant.GET_USERNAME_FAIL);
    }
}
