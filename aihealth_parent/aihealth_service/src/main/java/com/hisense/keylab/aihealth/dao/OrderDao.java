package com.hisense.keylab.aihealth.dao;

import com.hisense.keylab.aihealth.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/18 14:33
 *
 * 预约dao
 */
public interface OrderDao {
    /**
     * 新增套餐
     * @param order
     */
    public void add(Order order);

    /**
     * 根据条件查询套餐
     * @param order
     * @return
     */
    public List<Order> findByCondition(Order order);

    /**
     * 查询套餐详情
     * @param id
     * @return
     */
    public Map findById4Detail(Integer id);

    /**
     * 根据日期查询预约数目
     * @param date
     * @return
     */
    public Integer findOrderCountByDate(String date);

    /**
     * 某日后预约数目
     * @param date
     * @return
     */
    public Integer findOrderCountAfterDate(String date);

    /**
     * 根据日期查询浏览数
     * @param date
     * @return
     */
    public Integer findVisitsCountByDate(String date);

    /**
     * 查询某日后预览数
     * @param date
     * @return
     */
    public Integer findVisitsCountAfterDate(String date);

    /**
     * 查询热门套餐
     * @return
     */
    public List<Map> findHotSetmeal();
}
