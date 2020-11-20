package com.hisense.keylab.aihealth.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 14:40
 *
 * 套餐选项
 */
public class Setmeal implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称信息
     */
    private String name;
    /**
     * 选项码
     */
    private String code;
    /**
     * 助记码
     */
    private String helpCode;
    /**
     * 性别信息
     */
    private String sex;
    /**
     * 年龄信息
     */
    private String age;
    /**
     * 价格
     */
    private Float price;
    /**
     * 介绍
     */
    private String remark;
    /**
     * 注意事项
     */
    private String attention;
    /**
     * 套餐对应图片存储路劲
     */
    private String img;
    /**
     * 套餐对应的检查组，多对多
     */
    private List<CheckGroup> checkGroups;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHelpCode() {
        return helpCode;
    }

    public void setHelpCode(String helpCode) {
        this.helpCode = helpCode;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<CheckGroup> getCheckGroups() {
        return checkGroups;
    }

    public void setCheckGroups(List<CheckGroup> checkGroups) {
        this.checkGroups = checkGroups;
    }
}
