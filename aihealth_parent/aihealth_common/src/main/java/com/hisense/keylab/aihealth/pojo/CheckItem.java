package com.hisense.keylab.aihealth.pojo;

import java.io.Serializable;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 14:38
 *
 * 检查项目
 */
public class CheckItem implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 项目编码
     */
    private String code;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄范围
     */
    private String age;
    /**
     * 价格
     */
    private Float price;
    /**
     * 检查项类型。分为检查和检验两种
     */
    private String type;
    /**
     * 项目说明
     */
    private String remark;
    /**
     * 注意事项
     */
    private String attention;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
