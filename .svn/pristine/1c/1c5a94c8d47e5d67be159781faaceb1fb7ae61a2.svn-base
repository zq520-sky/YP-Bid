package com.yuepeng.web.manage.log.bean.excel;
import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: xtq
 * @Date: 2020/5/28 14:15
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class CustomerVisitLogExcel implements Serializable {

    @Excel(name = "客户编号", width = 15)
    private String custCode;//客户编号

    @Excel(name = "手机号码", width = 15)
    private String mobile;//手机号

    @Excel(name = "招标行业类型", width = 20)
    private String industryName;//招标行业类型

    @Excel(name = "项目标题", width = 25)
    private String projectTitle;//项目标题

    @Excel(name = "查看时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date visitDate;//查看时间

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

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
