package com.yuepeng.module.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 客户发票申请表(OrderInvoice)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:07:22
 */
@Data
@SuppressWarnings("serial")
@TableName("t_order_invoice")
public class OrderInvoiceEntity extends Model<OrderInvoiceEntity> {
    /**
     * 发票申请ID
     */
    private Integer invoiceId;
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 1：增值税普通发票
     * 2：增值税专用发票
     */
    private Integer invoiceType;
    /**
     * 发票金额
     */
    private BigDecimal invoiceMoney;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 发票-单位名称
     */
    private String unitName;
    /**
     * 发票-纳税人识别号
     */
    private String unitTin;
    /**
     * 发票-企业地址
     */
    private String unitAddress;
    /**
     * 发票-联系电话
     */
    private String unitTel;
    /**
     * 发票-开户行
     */
    private String unitBank;
    /**
     * 发票-银行账号
     */
    private String unitBankaccount;
    /**
     * 收件人
     */
    private String addressee;
    /**
     * 收件人电话
     */
    private String tel;
    /**
     * 收件地址
     */
    private String address;
    /**
     * 0：未开票
     * 1：已开票
     */
    private Integer status;
    /**
     * 开票时间
     */
    private Date makeTime;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.invoiceId;
    }
}