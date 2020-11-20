package com.hisense.keylab.aihealth.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hisense.keylab.aihealth.pojo.Permission;
import com.hisense.keylab.aihealth.pojo.Role;
import com.hisense.keylab.aihealth.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/19 13:23
 *
 * spring security实现类
 */
@Component
public class SpringSecurityUserServiceImpl implements UserDetailsService {

    @Reference
    private UserServiceApi userService;

    /**
     * 根据用户名查询数据库获取用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null){
            // 用户名不存在
            return null;
        }

        List<GrantedAuthority> list = new ArrayList<>();

        // 动态给用户授权
        Set<Role> roles = user.getRoles();
        if (roles == null){
            return null;
        }
        for (Role role : roles) {
            // 遍历角色集合，为用户授予角色
            list.add(new SimpleGrantedAuthority(role.getKeyword()));
            Set<Permission> permissions = role.getPermissions();
            if (permissions == null){
                return null;
            }
            for (Permission permission : permissions) {
                // 遍历角色集合，为用户授权
                list.add(new SimpleGrantedAuthority(permission.getKeyword()));
            }
        }

        org.springframework.security.core.userdetails.User securityUser =
                new org.springframework.security.core.userdetails.User(username, user.getPassword(), list);

        return securityUser;
    }
}
