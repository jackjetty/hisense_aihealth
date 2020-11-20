package com.hisense.keylab.aihealth.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hisense.keylab.aihealth.dao.OrderSettingDao;
import com.hisense.keylab.aihealth.pojo.OrderSetting;
import com.hisense.keylab.aihealth.service.OrderSettingServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/17 9:07
 *
 * 预约设置服务实现
 */
@Service(interfaceClass = OrderSettingServiceApi.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingServiceApi{

    @Autowired
    private OrderSettingDao orderSettingDao;

    @Override
    public void add(List<OrderSetting> list) {
        if (list != null && list.size() > 0){
            for (OrderSetting orderSetting : list){
                // 判断当前日期是否已经进行了预约
                long countByOrderDate = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
                if (countByOrderDate > 0){
                    // 已预约，执行更新操作
                    orderSettingDao.editNumberByOrderDate(orderSetting);
                } else {
                    // 未预约，执行插入操作
                    orderSettingDao.add(orderSetting);
                }
            }
        }
    }

    @Override
    public List<Map> getOrderSettingByMonth(String date) {
        String begin = date + "-1";
        String end = date + "-31";
        Map<String, String> map = new HashMap<>();
        map.put("begin", begin);
        map.put("end", end);
        // 调用 dao
        List<OrderSetting> list = orderSettingDao.getOrderSettingByMonth(map);
        List<Map> result = new ArrayList<>();
        if (list != null && list.size() > 0){
            for (OrderSetting orderSetting : list){
                Map<String, Object> m = new HashMap<>();
                 m.put("date", orderSetting.getOrderDate().getDate());
                 m.put("number", orderSetting.getNumber());
                 m.put("reservations", orderSetting.getReservations());
                 result.add(m);
            }
        }
        return result;
    }
}
