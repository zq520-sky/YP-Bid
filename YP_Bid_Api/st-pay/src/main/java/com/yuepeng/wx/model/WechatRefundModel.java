package com.yuepeng.wx.model;

import com.yuepeng.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName: WechatRefundModel
 * @Description: 退款
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 14:10

 **/
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WechatRefundModel extends BaseModel {
    private String appid;
    private String sub_appid;
    private String mch_id;
    private String sub_mch_id;
    private String nonce_str;
    private String sign;
    private String sign_type;
    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private String total_fee;
    private String refund_fee;
    private String refund_fee_type;
    private String refund_desc;
    private String refund_account;
    private String notify_url;
}