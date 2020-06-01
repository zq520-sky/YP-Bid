package com.yuepeng.web.manage.finance.bean.vo;

import com.yuepeng.web.manage.customer.enums.MemberTypeEnums;
import com.yuepeng.web.manage.finance.bean.entity.TOrder;
import com.yuepeng.web.manage.finance.enums.PayModeEnums;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: OrderVo
 * @package: com.yuepeng.web.manage.finance.bean.vo
 * @author: wzq
 * @date: 2020/5/12 11:33
 */
public class OrderVo extends TOrder {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDateBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDateEnd;

    private Integer memberType;

    private String memberTypeCN;

    private String payModeCN;

    private String custCode;

    private String mobile;

    private String nickName;

    public Date getOrderDateBegin() {
        return orderDateBegin;
    }

    public void setOrderDateBegin(Date orderDateBegin) {
        this.orderDateBegin = orderDateBegin;
    }

    public Date getOrderDateEnd() {
        return orderDateEnd;
    }

    public void setOrderDateEnd(Date orderDateEnd) {
        this.orderDateEnd = orderDateEnd;
    }

    public String getMemberTypeCN() {
        return memberTypeCN;
    }

    public String getPayModeCN() {
        return payModeCN;
    }

    @Override
    public void setPayMode(Integer payMode){
        super.setPayMode(payMode);
        this.payModeCN = PayModeEnums.getDescByMode(payMode);
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
        this.memberTypeCN = MemberTypeEnums.getName(memberType);
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
}
