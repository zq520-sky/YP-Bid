package com.yuepeng.web.manage.collect.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @Description: 收藏单位excel
 * @Author: ZhongShengbin
 * @Date: 2020/05/18 14:35
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class CompanyCollectEntity {

    @Excel(name = "客户编号", width = 20)
    private String custCode;

    @Excel(name = "手机号码", width = 20)
    private String mobile;

    @Excel(name = "会员类型", width = 20)
    private String memberTypeCn;

    @Excel(name = "招标单位编号", width = 20)
    private String projectCompanyCode;

    @Excel(name = "招标单位名称", width = 20)
    private String projectCompanyName;

    @Excel(name = "收藏时间" , width = 25,format = "yyyy-MM-dd HH:mm:ss")
    private Date collectDate;


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

    public String getMemberTypeCn() {
        return memberTypeCn;
    }

    public void setMemberTypeCn(String memberTypeCn) {
        this.memberTypeCn = memberTypeCn;
    }

    public String getProjectCompanyCode() {
        return projectCompanyCode;
    }

    public void setProjectCompanyCode(String projectCompanyCode) {
        this.projectCompanyCode = projectCompanyCode;
    }

    public String getProjectCompanyName() {
        return projectCompanyName;
    }

    public void setProjectCompanyName(String projectCompanyName) {
        this.projectCompanyName = projectCompanyName;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }
}
