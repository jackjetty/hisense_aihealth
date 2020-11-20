package com.hisense.keylab.aihealth.dao;

import com.github.pagehelper.Page;
import com.hisense.keylab.aihealth.pojo.CheckItem;

import java.util.List;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 17:54
 *
 * 检查项 dao
 */
public interface CheckItemDao {
    /**
     * 检查项添加 dao
     * @param checkItem
     */
    public void add(CheckItem checkItem);

    /**
     * 根据条件查询检查项
     * @param queryString
     * @return
     */
    public Page<CheckItem> selectByCondition(String queryString);

    /**
     * 查询检查组检查项中间关系表有无检查项记录
     * @param id
     * @return
     */
    public long findCountByCheckItemId(Integer id);

    /**
     * 根据 id 删除检查项
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 检查项编辑 dao
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
