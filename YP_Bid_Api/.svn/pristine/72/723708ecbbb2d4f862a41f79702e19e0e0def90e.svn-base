package com.yuepeng.wx.exception;

/**
 * @ClassName: WechatPayException
 * @Description: 自定义微信支付异常
 * @Author: wuzhiqiang
 * @Date: 2020-03-05 16:36

 **/
public class WechatPayException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;
    private Integer code = 1200;

    public WechatPayException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public WechatPayException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public WechatPayException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public WechatPayException(String msg, int code, Throwable e) {
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