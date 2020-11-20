package com.hisense.keylab.aihealth.dao;

import com.hisense.keylab.aihealth.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/17 9:11
 *
 * 预约设置 dao
 */
public interface OrderSettingDao {
    /**
     * 添加预约设置
     * @param orderSetting
     */
    public void add(OrderSetting orderSetting);

    /**
     * 根据预约时间编辑预约数量
     * @param orderSetting
     */
    public void editNumberByOrderDate(OrderSetting orderSetting);

    /**
     * 根据预约时间查询预约人数
     * @param orderDate
     * @return
     */
    public long findCountByOrderDate(Date orderDate);

    /**
     * 根据日期范围查询
     * @param map
     * @return
     */
    public List<OrderSetting> getOrderSettingByMonth(Map<String, String> map);

    /**
     * 查询当前日期预约信息
     * @param orderDate
     * @return
     */
    public OrderSetting findOrderDate(Date orderDate);

    /**
     * 更新预约人数
     * @param orderSetting
     */
    public void editReservationsByOrderDate(OrderSetting orderSetting);
}
