package com.yuepeng.web.manage.log.bean.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: xtq
 * @Date: 2020/5/29 15:05
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class DataCrawlerLogVo implements Serializable {

    private String datacrawlerServiceName;//爬虫服务名称

    private String datasourceWebname;//数据来源名称

    private Date crawlerStartTime;//爬虫执行时间

    private Date crawlerEndTime;//爬虫结束时间

    private Integer crawlerNum;//爬虫数量

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDateTime;

    public String getDatacrawlerServiceName() {
        return datacrawlerServiceName;
    }

    public void setDatacrawlerServiceName(String datacrawlerServiceName) {
        this.datacrawlerServiceName = datacrawlerServiceName;
    }

    public String getDatasourceWebname() {
        return datasourceWebname;
    }

    public void setDatasourceWebname(String datasourceWebname) {
        this.datasourceWebname = datasourceWebname;
    }

    public Date getCrawlerStartTime() {
        return crawlerStartTime;
    }

    public void setCrawlerStartTime(Date crawlerStartTime) {
        this.crawlerStartTime = crawlerStartTime;
    }

    public Date getCrawlerEndTime() {
        return crawlerEndTime;
    }

    public void setCrawlerEndTime(Date crawlerEndTime) {
        this.crawlerEndTime = crawlerEndTime;
    }

    public Integer getCrawlerNum() {
        return crawlerNum;
    }

    public void setCrawlerNum(Integer crawlerNum) {
        this.crawlerNum = crawlerNum;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }
}
