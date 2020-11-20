package com.hisense.keylab.aihealth.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 14:39
 *
 * 预约设置
 */
public class OrderSetting implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 预约设置日期
     */
    private Date orderDate;
    /**
     * 可预约人数限制
     */
    private int number;
    /**
     * 已预约人数
     */
    private int reservations;

    public OrderSetting() {
    }

    public OrderSetting(Date orderDate, int number) {
        this.orderDate = orderDate;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getReservations() {
        return reservations;
    }

    public void setReservations(int reservations) {
        this.reservations = reservations;
    }
}
