package com.hisense.keylab.aihealth.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 14:38
 *
 * 菜单项
 */
public class Menu implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 访问路径
     */
    private String linkUrl;
    /**
     * 菜单项对应的路由路径
     */
    private String path;
    /**
     * 排序优先级
     */
    private Integer priority;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 显示图标
     */
    private String icon;
    /**
     * 角色集合
     */
    private Set<Role> roles = new HashSet<Role>(0);
    /**
     * 子菜单集合
     */
    private List<Menu> children = new ArrayList<>();
    /**
     * 父菜单id
     */
    private Integer parentMenuId;

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

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Integer getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }
}
