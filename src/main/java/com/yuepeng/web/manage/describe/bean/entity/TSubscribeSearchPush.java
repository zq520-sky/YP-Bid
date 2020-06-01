package com.yuepeng.web.manage.describe.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TSubscribeSearchPush extends TSubscribeSet implements Serializable {
    private Integer searchPushId;

    private Integer searchAmount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date searchTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pushTime;

    private Integer isRead;

    private static final long serialVersionUID = 1L;

    public Integer getSearchPushId() {
        return searchPushId;
    }

    public void setSearchPushId(Integer searchPushId) {
        this.searchPushId = searchPushId;
    }

    public Integer getSearchAmount() {
        return searchAmount;
    }

    public void setSearchAmount(Integer searchAmount) {
        this.searchAmount = searchAmount;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

}