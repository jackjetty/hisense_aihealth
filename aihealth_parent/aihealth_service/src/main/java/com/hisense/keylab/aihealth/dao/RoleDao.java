package com.hisense.keylab.aihealth.dao;

import com.hisense.keylab.aihealth.pojo.Role;

import java.util.Set;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/19 13:45
 *
 * 角色查询dao
 */
public interface RoleDao {

    /**
     * 根据用户id查询角色
     * @param id
     * @return
     */
    public Set<Role> findByUserId(Integer id);
}
