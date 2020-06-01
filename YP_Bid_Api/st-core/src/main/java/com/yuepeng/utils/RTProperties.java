package com.yuepeng.utils;

import lombok.Data;

/**
 * @description: 系统运行时参数
 * @author: Administrator
 * @date: 2019-09-26 9:15
 */
@Data
public class RTProperties {

    public static ThreadLocal<String> currUser = new ThreadLocal<>();

    /**客户唯一属性，一般为custId*/
    public static final String USER_KEY = "identityId";

}
