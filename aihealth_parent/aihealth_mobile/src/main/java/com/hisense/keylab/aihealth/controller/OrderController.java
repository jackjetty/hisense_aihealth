package com.hisense.keylab.aihealth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hisense.keylab.aihealth.constant.MessageConstant;
import com.hisense.keylab.aihealth.constant.RedisMessageConstant;
import com.hisense.keylab.aihealth.entity.Result;
import com.hisense.keylab.aihealth.pojo.Order;
import com.hisense.keylab.aihealth.service.OrderServiceApi;
import com.hisense.keylab.aihealth.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/18 13:48
 *
 * 预约处理controller
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private JedisPool jedisPool;

    @Reference
    private OrderServiceApi orderService;

    @RequestMapping("/submit")
    public Result submit(@RequestBody Map map){
        // 用redis验证码校验
        String telephone = (String) map.get("telephone");
        String codeInRedis = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_ORDER);
        String validateCode = (String) map.get("validateCode");
        if (codeInRedis != null && validateCode != null && validateCode.equals(codeInRedis)){
            map.put("orderType", Order.ORDERTYPE_WEIXIN);
            Result result = null;
            try{
                result = orderService.order(map);
            }catch (Exception e){
                e.printStackTrace();
                return result;
            }
            if (result.isFlag()){
                // 预约成功，发送短信
                try{
                    SMSUtils.sendShortMessage(SMSUtils.ORDER_NOTICE, telephone, (String) map.get("orderDate"));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            return result;
        } else {
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try{
            Map map = orderService.findById(id);
            return new Result(true, MessageConstant.QUERY_ORDER_SUCCESS, map);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_ORDER_FAIL);
        }
    }
}
