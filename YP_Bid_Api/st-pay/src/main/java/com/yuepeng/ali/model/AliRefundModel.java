package com.yuepeng.ali.model;

import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.OpenApiRoyaltyDetailInfoPojo;
import com.yuepeng.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * @ClassName: AliRefundModel
 * @Description: 阿里退款model
 * @Author: wuzhiqiang
 * @Date: 2020-03-05 13:43

 **/
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AliRefundModel extends BaseModel {
    /**trade_no， 二选一*/
    private String out_trade_no;
    /**和out_trade_no， 二选一*/
    private String trade_no;
    /**必填*/
    private String refund_amount;
    private String refund_currency;
    private String refund_reason;
    private String out_request_no;
    private String operator_id;
    private String store_id;
    private String terminal_id;
    private List<GoodsDetail> goods_detail;
    private List<OpenApiRoyaltyDetailInfoPojo> refund_royalty_parameters;
    private String org_pid;

}