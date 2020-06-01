package com.yuepeng.ali.model;

import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.SignParams;
import com.yuepeng.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @ClassName: WechatUnifiedOrderModel
 * @Description: 统一下单model
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 10:26

 **/
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AliUnifiedOrderModel extends BaseModel {

    private String timeout_express;
    /**必填*/
    private String total_amount;
    private String product_code;
    /***/
    private String body;
    /**必填*/
    private String subject;
    /**必填*/
    private String out_trade_no;
    private String time_expire;
    private String goods_type;
    private String promo_params;
    private String passback_params;
    private String merchant_order_no;
    private String enable_pay_channels;
    private String store_id;
    private String specified_channel;
    private String disable_pay_channels;
    private String business_params;
    private List<GoodsDetail> goodsDetails;
    private ExtendParams extendParams;
    private ExtUserInfo extUserInfo;
    private SignParams signParams;

}