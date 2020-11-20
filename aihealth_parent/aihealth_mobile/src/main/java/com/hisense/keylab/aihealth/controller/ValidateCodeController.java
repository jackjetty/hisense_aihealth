package com.hisense.keylab.aihealth.controller;

import com.hisense.keylab.aihealth.constant.MessageConstant;
import com.hisense.keylab.aihealth.constant.RedisMessageConstant;
import com.hisense.keylab.aihealth.entity.Result;
import com.hisense.keylab.aihealth.utils.SMSUtils;
import com.hisense.keylab.aihealth.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/18 13:33
 *
 * 验证码 controller
 */
@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {

    @Autowired
    private JedisPool jedisPool;

    //用户在线体检预约发送验证码
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone){
        //随机生成4位数字验证码
        Integer validateCode = ValidateCodeUtils.generateValidateCode(4);
        //给用户发送验证码
        try{
            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,telephone,validateCode.toString());
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        //将验证码保存到redis（5分钟）
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_ORDER,300,validateCode.toString());
        return new Result(true,MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

    //用户登录发送验证码
    @RequestMapping("/send4Login")
    public Result send4Login(String telephone){
        //随机生成4位数字验证码
        Integer validateCode = ValidateCodeUtils.generateValidateCode(6);
        //给用户发送验证码
        try{
            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,telephone,validateCode.toString());
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        //将验证码保存到redis（5分钟）
        jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_LOGIN,300,validateCode.toString());
        return new Result(true,MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

}
