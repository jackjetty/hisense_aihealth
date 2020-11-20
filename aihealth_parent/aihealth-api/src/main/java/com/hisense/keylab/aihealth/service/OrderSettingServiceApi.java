package com.hisense.keylab.aihealth.service;

import com.hisense.keylab.aihealth.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/16 18:28
 *
 * 预约设置接口
 */
public interface OrderSettingServiceApi {

    /**
     * 添加预约设置
     * @param data
     */
    public void add(List<OrderSetting> data);

    /**
     * 获取预约数据
     * @param date
     * @return
     */
    public List<Map> getOrderSettingByMonth(String date);
}
