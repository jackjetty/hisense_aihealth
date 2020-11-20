package com.hisense.keylab.aihealth.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 14:40
 *
 * 用户信息
 */
public class User implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 性别信息
     */
    private String gender;
    /**
     * 用户名，唯一不重复
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 状态
     */
    private String station;
    /**
     * 手机号码
     */
    private String telephone;
    /**
     * 对应角色集合
     */
    private Set<Role> roles = new HashSet<>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
