package com.yuepeng.web.manage.count.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.count.bean.entity.TDataCrawlerReport;

import java.io.Serializable;
import java.util.Date;

public class TDataCrawlerReportExcel extends TDataCrawlerReport implements Serializable {

    @Excel(name = "项目类型", width = 15, replace = {"招投标项目_1", "拟建项目_2"})
    private Integer projectType;//项目类型：  1：招投标项目 2：拟建项目

    @Excel(name = "爬墙日期", format = "yyyy-MM-dd",  width = 25)
    private Date crawlerDate;//爬墙日期

    @Excel(name = "当天爬取数据总量", width = 15)
    private Integer crawlerNum;// 当天爬取数据总量

    @Override
    public Integer getProjectType() {
        return projectType;
    }

    @Override
    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    @Override
    public Date getCrawlerDate() {
        return crawlerDate;
    }

    @Override
    public void setCrawlerDate(Date crawlerDate) {
        this.crawlerDate = crawlerDate;
    }

    @Override
    public Integer getCrawlerNum() {
        return crawlerNum;
    }

    @Override
    public void setCrawlerNum(Integer crawlerNum) {
        this.crawlerNum = crawlerNum;
    }
}
