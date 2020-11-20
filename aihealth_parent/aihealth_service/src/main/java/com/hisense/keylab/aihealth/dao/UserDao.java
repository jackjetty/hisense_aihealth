package com.hisense.keylab.aihealth.dao;

import com.hisense.keylab.aihealth.pojo.User;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/19 13:43
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
