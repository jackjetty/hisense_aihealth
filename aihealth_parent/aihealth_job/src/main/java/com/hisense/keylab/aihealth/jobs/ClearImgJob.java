package com.hisense.keylab.aihealth.jobs;

import com.hisense.keylab.aihealth.constant.RedisConstant;
import com.hisense.keylab.aihealth.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/16 17:43
 */
public class ClearImgJob {

    @Autowired
    private JedisPool jedisPool;

    public void clearImg(){
        // 根据 redis 中的两个图片集合的差值清理垃圾图片
        Set<String> set = jedisPool.getResource()
                .sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        if (set != null){
            for (String picName : set) {
                // 删除云上的垃圾图片
                QiniuUtils.deleteFileFromQiniu(picName);
                // 从 redis 中删除
                jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES, picName);
            }
        }
    }
}
