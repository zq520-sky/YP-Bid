package com.yuepeng.web.manage.finance.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.finance.bean.entity.TOrder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: OrderExcel
 * @package: com.yuepeng.web.manage.finance.bean.excel
 * @author: wzq
 * @date: 2020/5/12 11:33
 */
public class OrderExcel extends TOrder implements Serializable {

    @Excel(name = "订单编号", width = 30)
    private String orderCode;

    @Excel(name = "客户编号", width = 15)
    private String custCode;

    @Excel(name = "手机号码", width = 15)
    private String mobile;

    @Excel(name = "昵称", width = 20)
    private String nickName;

    @Excel(name = "会员类型", width = 12, replace = {"普通用户_0","省级VIP_1","高级VIP_2","项目VIP_3"})
    private Integer memberType;

    @Excel(name = "订单金额", width = 15)
    private BigDecimal orderPrice;

    @Excel(name = "支付方式", width = 15, replace = {"微信_0","支付宝_1","银联_2","系统充值_10"})
    private Integer payMode;

    @Excel(name = "购买时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date orderDate;

    @Override
    public String getOrderCode() {
        return orderCode;
    }

    @Override
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    @Override
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    @Override
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public Integer getPayMode() {
        return payMode;
    }

    @Override
    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    @Override
    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
