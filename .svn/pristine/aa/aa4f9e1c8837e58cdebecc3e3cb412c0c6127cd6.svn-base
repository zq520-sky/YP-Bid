package com.yuepeng.web.manage.finance.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuepeng.web.manage.customer.enums.SexTypeEnums;
import com.yuepeng.web.manage.finance.bean.entity.TOrderInvoice;
import com.yuepeng.web.manage.finance.enums.InvoiceStatusEnums;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: OrderInvoiceVo
 * @package: com.yuepeng.web.manage.finance.bean.vo
 * @author: wzq
 * @date: 2020/5/14 20:12
 */
public class OrderInvoiceVo extends TOrderInvoice {

    private String custCodeOrMobile;

    private String orderCode;

    private String custCode;

    private String mobile;

    private Integer payMode;

    private String nickName;

    private String invoiceTypeCN;

    private String statusCN;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTimeBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyTimeEnd;

    private Integer sex;

    private String sexCN;

    private String companyName;

    private String job;

    private String provinceName;

    private String cityName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerDate;


    public String getCustCodeOrMobile() {
        return custCodeOrMobile;
    }

    public void setCustCodeOrMobile(String custCodeOrMobile) {
        this.custCodeOrMobile = custCodeOrMobile;
    }

    public String getOrderCode() {
        return orderCode;
    }

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

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getInvoiceTypeCN() {
        return invoiceTypeCN;
    }

    public String getStatusCN() {
        return statusCN;
    }

    public Date getApplyTimeBegin() {
        return applyTimeBegin;
    }

    public void setApplyTimeBegin(Date applyTimeBegin) {
        this.applyTimeBegin = applyTimeBegin;
    }

    public Date getApplyTimeEnd() {
        return applyTimeEnd;
    }

    public void setApplyTimeEnd(Date applyTimeEnd) {
        this.applyTimeEnd = applyTimeEnd;
    }

    @Override
    public void setInvoiceType(Integer invoiceType) {
        super.setInvoiceType(invoiceType);
        this.invoiceTypeCN = invoiceType == 1 ? "增值税普通发票" : "增值税专用发票";

    }

    @Override
    public void setStatus(Integer status) {
        super.setStatus(status);
        this.statusCN = InvoiceStatusEnums.getDesc(status);
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
        this.sexCN = SexTypeEnums.getDesc(sex);
    }

    public String getSexCN() {
        return sexCN;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
