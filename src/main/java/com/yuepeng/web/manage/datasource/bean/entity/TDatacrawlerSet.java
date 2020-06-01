package com.yuepeng.web.manage.datasource.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TDatacrawlerSet implements Serializable {
    private Integer datacrawlerSetId;

    private Integer datacrawlerServiceId;

    private Integer datasourceId;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date exeStartTime;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date exeEndTime;

    private Integer exeIntervalMin;

    private Integer exeNumsDay;

    private Integer isForbid;

    private Integer runState;

    private static final long serialVersionUID = 1L;

    public Integer getDatacrawlerSetId() {
        return datacrawlerSetId;
    }

    public void setDatacrawlerSetId(Integer datacrawlerSetId) {
        this.datacrawlerSetId = datacrawlerSetId;
    }

    public Integer getDatacrawlerServiceId() {
        return datacrawlerServiceId;
    }

    public void setDatacrawlerServiceId(Integer datacrawlerServiceId) {
        this.datacrawlerServiceId = datacrawlerServiceId;
    }

    public Integer getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(Integer datasourceId) {
        this.datasourceId = datasourceId;
    }

    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    public Date getExeStartTime() {
        return exeStartTime;
    }

    public void setExeStartTime(Date exeStartTime) {
        this.exeStartTime = exeStartTime;
    }

    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
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

    public Integer getIsForbid() {
        return isForbid;
    }

    public void setIsForbid(Integer isForbid) {
        this.isForbid = isForbid;
    }

    public Integer getRunState() {
        return runState;
    }

    public void setRunState(Integer runState) {
        this.runState = runState;
    }
}