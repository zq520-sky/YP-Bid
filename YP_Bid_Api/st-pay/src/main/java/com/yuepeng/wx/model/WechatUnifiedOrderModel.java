package com.yuepeng.wx.model;

import com.yuepeng.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName: WechatUnifiedOrderModel
 * @Description: 统一下单model
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 10:26

 **/
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WechatUnifiedOrderModel extends BaseModel {

    /**app的应用id，need（必填）*/
    private String appid;
    /**商户号 need*/
    private String mch_id;
    private String sub_appid;
    private String sub_mch_id;
    /**设备号 no-need（非必填）*/
    private String device_info;
    /**随机字符串 need*/
    private String nonce_str;
    /**签名 need*/
    private String sign;
    /**签名类型 no-need 默认MD5*/
    private String sign_type;
    /**商品描述 need */
    private String body;
    /**商品详情 no-need */
    private String detail;
    /**附加数据 no-need */
    private String attach;
    /**商户订单号 need*/
    private String out_trade_no;
    /**货币类型	no-need 默认CNY*/
    private String fee_type;
    /**总金额 need 单位分*/
    private String total_fee;
    /**终端IP need*/
    private String spbill_create_ip;
    /**交易起始时间 no-need*/
    private String time_start;
    /**交易结束时间 no-need*/
    private String time_expire;
    /**订单优惠标记 no-need*/
    private String goods_tag;
    /**通知地址 need*/
    private String notify_url;
    /**交易类型 need*/
    private String trade_type;
    /***/
    private String product_id;
    /**指定支付方式	no-need*/
    private String limit_pay;
    private String openid;
    private String sub_openid;
    /**开发票入口开放标识 no-need*/
    private String receipt;
    private String scene_info;
    private String profit_sharing;

}