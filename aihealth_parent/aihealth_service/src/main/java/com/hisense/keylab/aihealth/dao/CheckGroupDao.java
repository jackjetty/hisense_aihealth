package com.hisense.keylab.aihealth.dao;

import com.github.pagehelper.Page;
import com.hisense.keylab.aihealth.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/16 12:56
 *
 * 检查组 dao
 */
public interface CheckGroupDao {

    /**
     * 新增检查组
     * @param checkGroup
     */
    public void add(CheckGroup checkGroup);

    /**
     * 向 检查组和检查项 中间关系表添加数据
     * @param map
     */
    public void setCheckGroupAndCheckItem(Map map);

    /**
     * 根据条件查询检查组
     * @param queryString
     * @return
     */
    public Page<CheckGroup> findByCondition(String queryString);

    /**
     * 根据 id 查询检查项
     * @param id
     * @return
     */
    public CheckGroup findById(Integer id);

    /**
     * 根据检查组 id 查找检查项
     * @param id
     * @return
     */
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    /**
     * 编辑检查组
     * @param checkGroup
     */
    public void edit(CheckGroup checkGroup);

    /**
     * 根据检查组关联 id 删除检查项
     * @param id
     */
    public void deleteAssocication(Integer id);

    /**
     * 查询所有检查组
     * @return
     */
    public List<CheckGroup> findAll();

}
