package com.yuepeng.web.manage.project.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TProjectCompany implements Serializable {
    private Integer projectCompanyId;

    private String projectCompanyName;

    private Integer ifbAmount;

    private Integer bidAmount;

    private Integer sucbidAmount;

    private String remark;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8" )
    private Date updateDate;

    private String projectCompanyCode;

    private static final long serialVersionUID = 1L;

    public Integer getProjectCompanyId() {
        return projectCompanyId;
    }

    public void setProjectCompanyId(Integer projectCompanyId) {
        this.projectCompanyId = projectCompanyId;
    }

    public String getProjectCompanyName() {
        return projectCompanyName;
    }

    public void setProjectCompanyName(String projectCompanyName) {
        this.projectCompanyName = projectCompanyName;
    }

    public Integer getIfbAmount() {
        return ifbAmount;
    }

    public void setIfbAmount(Integer ifbAmount) {
        this.ifbAmount = ifbAmount;
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Integer getSucbidAmount() {
        return sucbidAmount;
    }

    public void setSucbidAmount(Integer sucbidAmount) {
        this.sucbidAmount = sucbidAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getProjectCompanyCode() {
        return projectCompanyCode;
    }

    public void setProjectCompanyCode(String projectCompanyCode) {
        this.projectCompanyCode = projectCompanyCode;
    }
}