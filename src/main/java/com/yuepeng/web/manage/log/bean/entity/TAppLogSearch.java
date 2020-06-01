package com.yuepeng.web.manage.log.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class TAppLogSearch implements Serializable {
    private Integer logSearchId;

    private Integer custId;

    private String searchWord;

    private Integer searchTimes;

    private Date searchTime;

    private static final long serialVersionUID = 1L;

    public Integer getLogSearchId() {
        return logSearchId;
    }

    public void setLogSearchId(Integer logSearchId) {
        this.logSearchId = logSearchId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public Integer getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(Integer searchTimes) {
        this.searchTimes = searchTimes;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }
}