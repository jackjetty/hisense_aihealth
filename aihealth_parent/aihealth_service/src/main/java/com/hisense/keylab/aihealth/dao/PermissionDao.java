package com.hisense.keylab.aihealth.dao;

import com.hisense.keylab.aihealth.pojo.Permission;

import java.util.Set;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/19 13:48
 *
 * 权限dao
 */
public interface PermissionDao {

    /**
     * 根据角色id查询权限
     * @param roleId
     * @return
     */
    public Set<Permission> findByRoleId(Integer roleId);
}
