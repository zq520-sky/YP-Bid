package com.yuepeng.dispose.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 统一返回码
 */
@Getter
public enum RCode {

    /**
     * 资源找不到
     */
    NOT_FOUND(404, String.format("哎呀，无法找到这个资源啦(%s)", HttpStatus.NOT_FOUND.getReasonPhrase())),

    /**
     * 405 对于请求所标识的资源，不允许使用请求行中所指定的方法。请确保为所请求的资源设置了正确的 MIME 类型
     */
    METHOD_NOT_ALLOWED(405, String.format("请换个姿势操作试试(%s)", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase())),

    /**
     * 415 Unsupported Media Type
     */
    UNSUPPORTED_MEDIA_TYPE(415,
                           String.format("呀，不支持该媒体类型(%s)", HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase())),

    /**
     * 系统异常 500 服务器的内部错误
     */
    EXCEPTION(500, "服务器开小差，请稍后再试"),

    /**
     * 系统限流
     */
    TRAFFIC_LIMITING(429, "哎呀，网络拥挤请稍后再试试"),

    /**
     * 服务调用异常
     */
    API_GATEWAY_ERROR(9999, "网络繁忙，请稍后再试"),

    /**
     * 参数错误
     */
    PARAM_ERROR(100, "参数错误"),

    /**
     * 非法请求
     */
    ILLEGAL_REQUEST(401, "非法请求"),

    /**
     * rpc调用异常
     */
    RPC_ERROR(510, "呀，网络出问题啦！"),

    /**
     * 通用业务异常
     */
    BUSINESS_ERROR(1000,"业务异常"),

    /**
     * 签名错误
     */
    SIGN_ERROR(1300, "签名错误！"),

    /**
     * 请求失效
     */
    REQUEST_TIME_OUT(1301, "请求失效！"),

    /**
     * 数据请求失败
     */
    REQUEST_READ_ERROR(1302, "数据请求失败！"),

    /**
     * token为空
     */
    TOKEN_EMPTY(1400, "token为空！"),

    /**
     * token失效
     */
    TOKEN_PAST(1401, "token失效，请重新登录！"),

    /**
     * 调用支付宝失败（请求不到， 返回错误等）
     */
    ALI_PAY_ERROR(1100, "支付宝请求失败！"),

    /**
     * 调用微信失败（请求不到， 返回错误等）
     */
    WECHAT_PAY_ERROR(1200, "微信请求失败！"),

    /**
     * 用户相关
     */
    CUSTOMER_FORBIDED(1500, "您已被禁止使用！"),
    CUSTOMER_PWD_ERROR(1501, "密码错误！"),
    CUSTOMER_NOT_EXIST(1502, "用户不存在，请先进行注册！"),
    CUSTOMER_IDCARD_BINDED(1503, "该身份用户已经实名认证！"),
    CUSTOMER_REALNAME_FAIL(1504, "实名认证失败！"),
    CUSTOMER_EXISTED(1504, "手机号已注册！");
    ;

    private Integer code;
    private String msg;

    RCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
