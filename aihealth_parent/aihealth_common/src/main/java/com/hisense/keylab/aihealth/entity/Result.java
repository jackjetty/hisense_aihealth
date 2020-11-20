package com.hisense.keylab.aihealth.entity;

import java.io.Serializable;

/**
 * @author : sunkepeng E-mail:sunkepengouc@163.com
 * @date : 2020/11/15 15:40
 *
 * 封装返回结果
 */
public class Result implements Serializable {
    /**
     * 执行结果，返回true为执行成功，false为执行失败
     */
    private boolean flag;
    /**
     * 返回结果信息，用于页面提示
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public Result(boolean flag, String message){
        super();
        this.flag = flag;
        this.message = message;
    }

    public Result(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
