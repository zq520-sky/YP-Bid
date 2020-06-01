package com.yuepeng.dispose.config;

import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.common.RCode;

/**
 * 返回结果工具类
 */
public class RUtils {

    private RUtils(){}

    /**
     * 成功
     * @return
     */
    public static R ok(){
        return new R();
    }

    /**
     * 返回成功数据
     * @param data
     * @return
     */
    public static R ok(Object data){
        R r = new R();
        r.setData(data);
        return r;
    }

    /**
     * 返回失败
     * @param code 错误码
     * @param msg 错误描述
     * @return
     */
    public static R fail(Integer code, String msg){
        return RUtils.fail(code, msg, null);
    }

    /**
     * 返回失败
     * @param code 错误码
     * @param msg 错误描述
     * @param data 数据
     * @return
     */
    public static R fail(Integer code, String msg, Object data){
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    /**
     * 返回失败
     * @param rCode
     * @return
     */
    public static R fail(RCode rCode){
        return RUtils.fail(rCode.getCode(), rCode.getMsg());
    }

    /**
     * 失败返回
     * @return
     */
    public static R fail(){
        return RUtils.fail(RCode.BUSINESS_ERROR);
    }

}
