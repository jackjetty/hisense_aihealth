package com.hisense.keylab.aihealth.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hisense.keylab.aihealth.dao.CheckItemDao;
import com.hisense.keylab.aihealth.entity.PageResult;
import com.hisense.keylab.aihealth.entity.QueryPageBean;
import com.hisense.keylab.aihealth.pojo.CheckItem;
import com.hisense.keylab.aihealth.service.CheckItemServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 17:50
 *
 * 检查项服务实现
 */
@Service(interfaceClass = CheckItemServiceApi.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemServiceApi {

    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        // 分页，线程绑定ThreadLocal，执行sql之前添加拦截器拼接查询limit字符串
        PageHelper.startPage(currentPage, pageSize);
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<CheckItem> rows = page.getResult();
        return new PageResult(total, rows);
    }

    @Override
    public void deleteById(Integer id) {
        // 判断当前检查项是否有关联的检查组
        long count = checkItemDao.findCountByCheckItemId(id);
        if (count > 0){
            // 当前检查项有所关联，不允许删除
            throw new RuntimeException("当前检查项已关联其他检查组，不允许删除");
        }
        checkItemDao.deleteById(id);
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }

    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
