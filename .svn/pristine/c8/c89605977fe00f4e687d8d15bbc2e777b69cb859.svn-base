package com.yuepeng.web.manage.log.bean.vo;

import java.io.Serializable;

/**
 * json响应
 * @param <T>
 */
public class ResultVo<T> implements Serializable {

    private boolean flag;//标识
    private String msg;//信息内容

    private T data;//返回对象

    public ResultVo() {}

    public ResultVo(boolean flag, String msg, T data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
