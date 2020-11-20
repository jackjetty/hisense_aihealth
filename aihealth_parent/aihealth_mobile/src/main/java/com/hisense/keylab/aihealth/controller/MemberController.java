package com.hisense.keylab.aihealth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.hisense.keylab.aihealth.constant.MessageConstant;
import com.hisense.keylab.aihealth.constant.RedisMessageConstant;
import com.hisense.keylab.aihealth.entity.Result;
import com.hisense.keylab.aihealth.pojo.Member;
import com.hisense.keylab.aihealth.service.MemberServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/18 17:19
 *
 * 会员controller
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private JedisPool jedisPool;

    @Reference
    private MemberServiceApi memberService;

    /**
     * 手机号快速登录
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public Result login(HttpServletResponse response, @RequestBody Map map){
        String telephone = (String) map.get("telephone");
        String validateCodeInRedis = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_LOGIN);
        String validateCode = (String) map.get("validateCode");
        if (validateCodeInRedis !=null && validateCode != null && validateCode.equals(validateCodeInRedis)){
            // 验证码正确
            // 判断当前用户是否会员
            Member member = memberService.findByTelephone(telephone);
            if (member == null){
                // 不是会员,自动注册
                member.setRegTime(new Date());
                member.setPhoneNumber(telephone);
                memberService.add(member);
            }
            // 向客户端浏览器写入cookie，内容为手机号
            Cookie cookie = new Cookie("member_telephone", telephone);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            // 保存cookie到redis
            String json = JSON.toJSON(member).toString();
            jedisPool.getResource().setex(telephone, 60*30, json);
            return new Result(true, MessageConstant.LOGIN_SUCCESS);
        } else {
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
    }
}
