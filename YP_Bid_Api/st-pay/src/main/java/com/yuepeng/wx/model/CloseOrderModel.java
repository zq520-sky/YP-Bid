package com.yuepeng.wx.model;

import com.yuepeng.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName: CloseOrderModel
 * @Description: 关闭订单Model
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 14:07

 **/
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseOrderModel extends BaseModel {
    /**appid need*/
    private String appid;
    private String sub_appid;
    /**商户号 need*/
    private String mch_id;
    private String sub_mch_id;
    /**商户订单号 need*/
    private String out_trade_no;
    /**随机字符串 need*/
    private String nonce_str;
    /**签名 need*/
    private String sign;
    /**签名类型 no-need*/
    private String sign_type;
}