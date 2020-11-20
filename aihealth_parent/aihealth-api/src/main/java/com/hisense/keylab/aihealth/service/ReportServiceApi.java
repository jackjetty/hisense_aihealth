package com.hisense.keylab.aihealth.service;

import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/20 10:39
 *
 * 报表服务api
 */
public interface ReportServiceApi {

    /**
     * 获得运营数据统计信息
     * @return
     */
    public Map<String, Object> getBusinessReportData() throws Exception;
}
