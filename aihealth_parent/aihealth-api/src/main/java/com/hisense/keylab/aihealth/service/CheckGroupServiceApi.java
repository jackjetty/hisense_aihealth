package com.hisense.keylab.aihealth.service;

import com.hisense.keylab.aihealth.entity.PageResult;
import com.hisense.keylab.aihealth.entity.QueryPageBean;
import com.hisense.keylab.aihealth.pojo.CheckGroup;

import java.util.List;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/16 12:44
 *
 * 检查组服务接口
 */
public interface CheckGroupServiceApi {

    /**
     * 新增检查组
     * @param checkGroup
     * @param checkitemIds
     */
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);

    /**
     * 检查组分页查询
     * @param queryPageBean
     * @return
     */
    public PageResult pageQuery(QueryPageBean queryPageBean);

    /**
     * 根据 id 查询检查项
     * @param id
     * @return
     */
    public CheckGroup findById(Integer id);

    /**
     * 通过检查组 id 查询其检查项
     * @param id
     * @return
     */
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    /**
     * 编辑检查组
     * @param checkGroup
     * @param checkitemIds
     */
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    /**
     * 查询所有的检查组
     * @return
     */
    public List<CheckGroup> findAll();
}
