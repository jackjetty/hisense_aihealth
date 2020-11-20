package com.hisense.keylab.aihealth.service;

import com.hisense.keylab.aihealth.entity.Result;

import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/18 13:55
 *
 * 预约接口
 */
public interface OrderServiceApi {

    /**
     * 预约
     * @param map
     * @return
     * @throws Exception
     */
    public Result order(Map map) throws Exception;

    /**
     * 根据 id 查询预约相关信息
     * @param id
     * @return
     */
    public Map findById(Integer id) throws Exception;
}
