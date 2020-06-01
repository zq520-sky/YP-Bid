package com.yuepeng.web.manage.describe.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TSubscribeSearch extends TSubscribeSet implements Serializable {
    private Integer subscribeSearchId;

    private Integer searchTimes;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date searchTime;

    private static final long serialVersionUID = 1L;

    public Integer getSubscribeSearchId() {
        return subscribeSearchId;
    }

    public void setSubscribeSearchId(Integer subscribeSearchId) {
        this.subscribeSearchId = subscribeSearchId;
    }

    public Integer getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(Integer searchTimes) {
        this.searchTimes = searchTimes;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }
}