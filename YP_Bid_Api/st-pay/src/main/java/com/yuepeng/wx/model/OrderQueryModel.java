package com.yuepeng.wx.model;

import com.yuepeng.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName: OrderQueryModel
 * @Description: 订单查询
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 13:59

 **/
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderQueryModel extends BaseModel {
    /**appId need*/
    private String appid;
    private String sub_appid;
    /**商户号 need*/
    private String mch_id;
    private String sub_mch_id;
    /**微信订单号 和商户订单号 二选一 */
    private String transaction_id;
    /**商户订单号*/
    private String out_trade_no;
    private String order_id;
    private String out_order_no;
    private String out_return_no;
    /**随机字符串 need*/
    private String nonce_str;
    /**签名need*/
    private String sign;
    /**签名类型 no-need*/
    private String sign_type;
}