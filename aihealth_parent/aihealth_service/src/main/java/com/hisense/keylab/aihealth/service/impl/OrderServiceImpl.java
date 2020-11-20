package com.hisense.keylab.aihealth.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hisense.keylab.aihealth.constant.MessageConstant;
import com.hisense.keylab.aihealth.dao.MemberDao;
import com.hisense.keylab.aihealth.dao.OrderDao;
import com.hisense.keylab.aihealth.dao.OrderSettingDao;
import com.hisense.keylab.aihealth.entity.Result;
import com.hisense.keylab.aihealth.pojo.Member;
import com.hisense.keylab.aihealth.pojo.Order;
import com.hisense.keylab.aihealth.pojo.OrderSetting;
import com.hisense.keylab.aihealth.service.OrderServiceApi;
import com.hisense.keylab.aihealth.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/18 14:04
 *
 * 预约实现类
 */
@Service(interfaceClass = OrderServiceApi.class)
@Transactional
public class OrderServiceImpl implements OrderServiceApi {

    @Autowired
    private OrderSettingDao orderSettingDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private OrderDao orderDao;

    @Override
    public Result order(Map map) throws Exception {
        // 判断当前日期是否可预约
        String  orderDate = (String) map.get("orderDate");
        OrderSetting orderSetting = orderSettingDao.findOrderDate(DateUtils.parseString2Date(orderDate));
        if (orderSetting == null){
            // 日期未设置预约
            return new Result(false, MessageConstant.SELECTED_DATE_CANNOT_ORDER);
        }

        // 判断是否预约满
        int number = orderSetting.getNumber();
        int reservations = orderSetting.getReservations();
        if (reservations >= number){
            // 约满
            return new Result(false, MessageConstant.ORDER_FULL);
        }

        String telephone = (String) map.get("telephone");
        Member member = memberDao.findByTelephone(telephone);
        if (member != null){
            // 是否重复预约
            // 会员 id
            Integer memberId = member.getId();
            // 预约日期
            Date dateOrdered = DateUtils.parseString2Date(orderDate);
            String setmealId = (String) map.get("setmealId");
            Order order = new Order(memberId, dateOrdered, Integer.parseInt(setmealId));
            // 根据条件查询
            List<Order> list = orderDao.findByCondition(order);
            if (list != null && list.size() > 0){
                // 重复预约，拒绝再次预约
                return new Result(false, MessageConstant.HAS_ORDERED);
            }
        } else {
            member = new Member();
            member.setName((String) map.get("name"));
            member.setPhoneNumber(telephone);
            member.setIdCard((String) map.get("idCard"));
            member.setSex((String) map.get("sex"));
            member.setRegTime(new Date());
            //自动完成会员注册
            memberDao.add(member);
        }

        // 预约成功
        Order order = new Order();
        //设置会员ID
        order.setMemberId(member.getId());
        //预约日期
        order.setOrderDate(DateUtils.parseString2Date(orderDate));
        //预约类型
        order.setOrderType((String) map.get("orderType"));
        //到诊状态
        order.setOrderStatus(Order.ORDERSTATUS_NO);
        //套餐ID
        order.setSetmealId(Integer.parseInt((String) map.get("setmealId")));
        orderDao.add(order);

        //设置已预约人数+1
        orderSetting.setReservations(orderSetting.getReservations() + 1);
        orderSettingDao.editReservationsByOrderDate(orderSetting);

        return new Result(true, MessageConstant.ORDER_SUCCESS, order.getId());
    }

    @Override
    public Map findById(Integer id) throws Exception {
        Map map = orderDao.findById4Detail(id);
        if (map != null){
            Date orderDate = (Date) map.get("orderDate");
            map.put("orderDate", DateUtils.parseDate2String(orderDate));
        }
        return map;
    }
}
