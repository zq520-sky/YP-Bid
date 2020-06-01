package com.yuepeng.web.manage.datasource.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @Description:
 * @Author: ZhongShengbin
 * @Date: 2020/05/28 09:39
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class DatacrawlerExcel {

    @Excel(name = "爬虫服务名称", width = 20)
    private String datasourceTypeName;

    @Excel(name = "数据来源名称(网站)", width = 40)
    private String datasourceWeburl;

    @Excel(name = "执行开始时间/天", width = 40, format = "yyyy-MM-dd HH:mm:ss")
    private Date exeStartTime;

    @Excel(name = "执行介绍时间/天", width = 30, format = "yyyy-MM-dd HH:mm:ss")
    private Date exeEndTime;

    @Excel(name = "执行间隔(次/天)", width = 20)
    private Integer exeIntervalMin;

    @Excel(name = "执行次数(次/天)", width = 20)
    private Integer exeNumsDay;

    @Excel(name = "是否禁用", width = 10, replace = {"正常_0", "已禁用_1"})
    private String isForbidCn;

    public String getDatasourceTypeName() {
        return datasourceTypeName;
    }

    public void setDatasourceTypeName(String datasourceTypeName) {
        this.datasourceTypeName = datasourceTypeName;
    }

    public String getDatasourceWeburl() {
        return datasourceWeburl;
    }

    public void setDatasourceWeburl(String datasourceWeburl) {
        this.datasourceWeburl = datasourceWeburl;
    }

    public Date getExeStartTime() {
        return exeStartTime;
    }

    public void setExeStartTime(Date exeStartTime) {
        this.exeStartTime = exeStartTime;
    }

    public Date getExeEndTime() {
        return exeEndTime;
    }

    public void setExeEndTime(Date exeEndTime) {
        this.exeEndTime = exeEndTime;
    }

    public Integer getExeIntervalMin() {
        return exeIntervalMin;
    }

    public void setExeIntervalMin(Integer exeIntervalMin) {
        this.exeIntervalMin = exeIntervalMin;
    }

    public Integer getExeNumsDay() {
        return exeNumsDay;
    }

    public void setExeNumsDay(Integer exeNumsDay) {
        this.exeNumsDay = exeNumsDay;
    }

    public String getIsForbidCn() {
        return isForbidCn;
    }

    public void setIsForbidCn(String isForbidCn) {
        this.isForbidCn = isForbidCn;
    }
}
