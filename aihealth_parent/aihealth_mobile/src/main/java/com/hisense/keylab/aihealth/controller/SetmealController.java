package com.hisense.keylab.aihealth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hisense.keylab.aihealth.constant.MessageConstant;
import com.hisense.keylab.aihealth.entity.Result;
import com.hisense.keylab.aihealth.pojo.Setmeal;
import com.hisense.keylab.aihealth.service.SetmealServiceApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/17 12:38
 *
 * 套餐管理controller_m
 */
@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Reference
    private SetmealServiceApi setmealService;

    @RequestMapping("/getSetmeal")
    public Result getAllSetmeal(){
        try{
            List<Setmeal> list = setmealService.findAll();
            return new Result(true, MessageConstant.GET_SETMEAL_LIST_SUCCESS, list);
        }catch (Exception e){
            return new Result(false, MessageConstant.GET_SETMEAL_LIST_FAIL);
        }
    }

    @RequestMapping("/findById")
    public Result findById(int id){
        try{
            Setmeal setmeal = setmealService.findById(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setmeal);
        } catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }
}
