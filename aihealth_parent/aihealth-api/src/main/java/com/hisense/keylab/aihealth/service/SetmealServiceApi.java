package com.hisense.keylab.aihealth.service;

import com.hisense.keylab.aihealth.entity.PageResult;
import com.hisense.keylab.aihealth.entity.QueryPageBean;
import com.hisense.keylab.aihealth.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/16 16:09
 *
 * 套餐选项服务接口
 */
public interface SetmealServiceApi {

    /**
     * 套餐选项添加接口
     * @param setmeal
     * @param checkgroupIds
     */
    public void add(Setmeal setmeal, Integer[] checkgroupIds);

    /**
     * 分页查询套餐选项
     * @param queryPageBean
     * @return
     */
    public PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 返回所有套餐
     * @return
     */
    public List<Setmeal> findAll();

    /**
     * 根据套餐ID查询套餐详情
     * @param id
     * @return
     */
    public Setmeal findById(int id);

    /**
     * 查询套餐数目
     * @return
     */
    public List<Map<String, Object>> findSetmealCount();

}
