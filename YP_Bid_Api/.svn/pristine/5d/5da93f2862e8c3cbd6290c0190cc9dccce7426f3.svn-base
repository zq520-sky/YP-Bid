package com.yuepeng.wx.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName: PayCallbackResponse
 * @Description: 支付回调响应数据
 * @Author: wuzhiqiang
 * @Date: 2020-03-06 09:58

 **/
@Data
public class PayCallbackResponse {

    /**返回状态码*/
    @JsonProperty("return_code")
    private String returnCode;
    /**返回信息*/
    @JsonProperty("return_msg")
    private String returnMsg;
    /**公众账号ID*/
    @JsonProperty("appid")
    private String appId;
    /**商户号*/
    @JsonProperty("mch_id")
    private String mchId;
    /**设备号(否)*/
    @JsonProperty("deviceInfo")
    private String device_info;
    /**随机字符串*/
    @JsonProperty("nonceStr")
    private String nonce_str;
    /**签名*/
    private String sign;
    /**签名类型(否)：目前支持HMAC-SHA256和MD5，默认为MD5*/
    @JsonProperty("sign_type")
    private String signType;
    /**业务结果: SUCCESS/FAIL*/
    @JsonProperty("result_code")
    private String resultCode;
    /**错误代码(否): 错误返回的信息描述*/
    @JsonProperty("err_code")
    private String errCode;
    /**错误代码描述(否)*/
    @JsonProperty("err_code_des")
    private String errCodeDes;
    /**用户标识*/
    @JsonProperty("openid")
    private String openId;
    /**用户是否关注公众账号，Y-关注，N-未关注*/
    @JsonProperty("isSubscribe")
    private String is_subscribe;
    /**交易类型： JSAPI、NATIVE、APP*/
    @JsonProperty("tradeType")
    private String trade_type;
    /**付款银行:银行类型，采用字符串类型的银行标识*/
    @JsonProperty("bankType")
    private String bank_type;
    /**订单金额: 单位分*/
    @JsonProperty("total_fee")
    private Integer totalFee;
    /**应结订单金额(否):应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。*/
    @JsonProperty("settlement_total_fee")
    private Integer settlementTotalFee;
    /**货币种类(否)*/
    @JsonProperty("fee_type")
    private String feeType;
    /**现金支付金额*/
    @JsonProperty("cash_fee")
    private Integer cashFee;
    /**现金支付货币类型(否)*/
    @JsonProperty("cash_fee_type")
    private String cashFeeType;
    /**总代金券金额(否)*/
    @JsonProperty("coupon_fee")
    private Integer couponFee;
    /**	代金券使用数量(否)*/
    @JsonProperty("coupon_count")
    private Integer couponCount;
    /**微信支付订单号*/
    @JsonProperty("transaction_id")
    private String transactionId;
    /**商户订单号*/
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    /**商家数据包(否)*/
    private String attach;
    /**支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010*/
    @JsonProperty("time_end")
    private String 	timeEnd;

}