package com.yuepeng.ali.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: AliNotifyResponse
 * @Description: 阿里异步回调reponse
 * @Author: wuzhiqiang
 * @Date: 2020-03-06 14:44

 **/
@Data
public class AliNotifyResponse {

    /**通知时间*/
    @JsonProperty("notify_time")
    private Date notifyTime;
    /**通知类型*/
    @JsonProperty("notify_type")
    private String notifyType;
    /**通知校验ID*/
    @JsonProperty("notify_id")
    private String notifyId;
    /**支付宝分配给开发者的应用Id*/
    @JsonProperty("appId")
    private String app_id;
    /**编码格式*/
    private String charset;
    /**接口版本*/
    private String version;
    /**签名类型*/
    @JsonProperty("sign_type")
    private String signType;
    /**签名*/
    private String sign;
    /**支付宝交易号*/
    @JsonProperty("trade_no")
    private String tradeNo;
    /**商户订单号*/
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    /**商户业务号*/
    @JsonProperty("out_biz_no")
    private String outBizNo;
    /**买家支付宝用户号*/
    @JsonProperty("buyer_id")
    private String buyerId;
    /**买家支付宝账号*/
    @JsonProperty("buyer_logon_id")
    private String buyerLogonId;
    /**卖家支付宝用户号*/
    @JsonProperty("seller_id")
    private String sellerId;
    /**卖家支付宝账号*/
    @JsonProperty("seller_email")
    private String sellerEmail;
    /**交易状态*/
    @JsonProperty("trade_status")
    private String tradeStatus;
    /**订单金额*/
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;
    /**实收金额*/
    @JsonProperty("receipt_amount")
    private BigDecimal receiptAmount;
    /**开票金额*/
    @JsonProperty("invoice_amount")
    private BigDecimal invoiceAmount;
    /**付款金额*/
    @JsonProperty("buyer_pay_amount")
    private BigDecimal buyerPayAmount;
    /**集分宝金额*/
    @JsonProperty("pointAmount")
    private BigDecimal point_amount;
    /**总退款金额*/
    @JsonProperty("refund_fee")
    private BigDecimal refundFee;
    /**订单标题*/
    private String subject;
    /**商品描述*/
    private String body;
    /**交易创建时间*/
    @JsonProperty("gmt_create")
    private Date gmtCreate;
    /**交易付款时间*/
    @JsonProperty("gmt_payment")
    private Date gmtPayment;
    /**交易退款时间*/
    @JsonProperty("gmt_refund")
    private Date gmtRefund;
    /**交易结束时间*/
    @JsonProperty("gmt_close")
    private Date gmtClose;
    /**支付金额信息*/
    @JsonProperty("fund_bill_list")
    private String fundBillList;
    /**回传参数*/
    @JsonProperty("passback_params")
    private String passbackParams;
    /**优惠券信息*/
    @JsonProperty("voucher_detail_list")
    private String voucherDetailList;


}