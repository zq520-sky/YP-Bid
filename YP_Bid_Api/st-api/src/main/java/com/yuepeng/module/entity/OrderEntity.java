package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 客户支付订单(Order)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:06:28
 */
@Data
@SuppressWarnings("serial")
@TableName("t_order")
public class OrderEntity extends Model<OrderEntity> {
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单金额
     */
    private BigDecimal orderPrice;
    /**
     * 支付方式
     * 0：微信
     * 1：支付宝
     * 2：银联
     * 10：系统操作(后台直接操作)
     */
    private Integer payMode;
    /**
     * 支付订单号
     */
    private String payOrderCode;
    /**
     * 支付成功标识
     * 0：失败
     * 1：成功
     */
    private Integer payFlag;
    /**
     * 支付金额
     */
    private BigDecimal payPrice;
    /**
     * 支付时间
     */
    private Object payDate;
    /**
     * 订单生成时间
     */
    private Object orderDate;
    /**
     * 是否开票
     * 0：否
     * 1：是
     */
    private Integer isInvoice;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Object createDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }
}