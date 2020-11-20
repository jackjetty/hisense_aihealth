package com.hisense.keylab.aihealth.service;

import com.hisense.keylab.aihealth.pojo.User;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/19 13:27
 *
 * 用户信息接口
 */
public interface UserServiceApi {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
