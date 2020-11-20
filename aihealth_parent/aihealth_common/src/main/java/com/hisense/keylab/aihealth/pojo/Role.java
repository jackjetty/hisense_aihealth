package com.hisense.keylab.aihealth.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 14:39
 *
 * 角色信息
 */
public class Role implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色关键字，用作权限控制
     */
    private String keyword;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 用户集合
     */
    private Set<User> users = new HashSet<>(0);
    /**
     * 权限集合
     */
    private Set<Permission> permissions = new HashSet<>(0);
    /**
     * 菜单项集合
     */
    private LinkedHashSet<Menu> menus = new LinkedHashSet<>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public LinkedHashSet<Menu> getMenus() {
        return menus;
    }

    public void setMenus(LinkedHashSet<Menu> menus) {
        this.menus = menus;
    }
}
