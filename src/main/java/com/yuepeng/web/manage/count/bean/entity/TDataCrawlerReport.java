package com.yuepeng.web.manage.count.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TDataCrawlerReport implements Serializable {

    private Integer crawlerReportId;//爬取统计id

    private Integer projectType;//项目类型：  1：招投标项目 2：拟建项目

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date crawlerDate;//爬取日期

    private Integer crawlerNum;// 当天爬取数据总量

    public Integer getCrawlerReportId() {
        return crawlerReportId;
    }

    public void setCrawlerReportId(Integer crawlerReportId) {
        this.crawlerReportId = crawlerReportId;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public Date getCrawlerDate() {
        return crawlerDate;
    }

    public void setCrawlerDate(Date crawlerDate) {
        this.crawlerDate = crawlerDate;
    }

    public Integer getCrawlerNum() {
        return crawlerNum;
    }

    public void setCrawlerNum(Integer crawlerNum) {
        this.crawlerNum = crawlerNum;
    }
}
