package com.hisense.keylab.aihealth.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hisense.keylab.aihealth.dao.PermissionDao;
import com.hisense.keylab.aihealth.dao.RoleDao;
import com.hisense.keylab.aihealth.dao.UserDao;
import com.hisense.keylab.aihealth.pojo.Permission;
import com.hisense.keylab.aihealth.pojo.Role;
import com.hisense.keylab.aihealth.pojo.User;
import com.hisense.keylab.aihealth.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/19 13:41
 *
 * 用户服务实现
 */
@Service(interfaceClass = UserServiceApi.class)
@Transactional
public class UserServiceImpl implements UserServiceApi {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public User findByUsername(String username) {
        // 查询用户基本信息，不包含角色
        User user = userDao.findByUsername(username);
        if (user == null){
            return null;
        }
        Integer userId = user.getId();

        // 根据用户 id 查询对应的角色
        Set<Role> roles = roleDao.findByUserId(userId);
        for (Role role : roles) {
            Integer roleId = role.getId();
            // 根据角色id查询权限
            Set<Permission> permissions = permissionDao.findByRoleId(roleId);
            role.setPermissions(permissions);
        }

        // 用户关联角色
        user.setRoles(roles);
        return user;
    }
}
