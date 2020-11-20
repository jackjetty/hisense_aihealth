package com.hisense.keylab.aihealth.service;

import com.hisense.keylab.aihealth.entity.PageResult;
import com.hisense.keylab.aihealth.entity.QueryPageBean;
import com.hisense.keylab.aihealth.pojo.CheckItem;

import java.util.List;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 17:37
 *
 * 检查项服务接口
 */
public interface CheckItemServiceApi {
    /**
     * 新增检查项
     * @param checkItem
     */
    public void add(CheckItem checkItem);

    /**
     * 检查项分页查询
     * @param queryPageBean
     * @return
     */
    public PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 根据 id 删除检查项
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 编辑检查项
     * @param checkItem
     */
    public void edit(CheckItem checkItem);

    /**
     * 根据 id 查询检查项
     * @param id
     * @return
     */
    public CheckItem findById(Integer id);

    /**
     * 查询所有检查项
     * @return
     */
    public List<CheckItem> findAll();
}
