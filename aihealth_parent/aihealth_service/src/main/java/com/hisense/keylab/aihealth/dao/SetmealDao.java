package com.hisense.keylab.aihealth.dao;

import com.github.pagehelper.Page;
import com.hisense.keylab.aihealth.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/16 16:19
 *
 * 套餐选项 dao
 */
public interface SetmealDao {

    /**
     * 添加套餐选项
     * @param setmeal
     */
    public void add(Setmeal setmeal);

    /**
     * 设置套餐和检查组关联关系
     * @param map
     */
    public void setSetmealAndCheckGroup(Map map);

    /**
     * 根据条件查询套餐
     * @param queryString
     * @return
     */
    public Page<Setmeal> findByCondition(String queryString);

    /**
     * 查询所有套餐
     * @return
     */
    public List<Setmeal> findAll();

    /**
     * 根据套餐ID查询套餐详情
     * @param id
     * @return
     */
    public Setmeal findById4Detail(int id);

    /**
     * 查询套餐数目
     * @return
     */
    public List<Map<String, Object>> findSetmealCount();
}
