package com.yuepeng.ali.exception;

/**
 * @ClassName: AliPayException
 * @Description: 阿里支付异常
 * @Author: wuzhiqiang
 * @Date: 2020-03-06 15:19

 **/
public class AliPayException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;
    private Integer code = 1100;

    public AliPayException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public AliPayException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public AliPayException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public AliPayException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}