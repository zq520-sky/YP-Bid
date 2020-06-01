package com.yuepeng.web.manage.planProject.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TPlanSearchHotword implements Serializable {
    private Integer hotwordId;

    private Integer projectType;

    private String hotwordName;

    private Integer searchTimes;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getHotwordId() {
        return hotwordId;
    }

    public void setHotwordId(Integer hotwordId) {
        this.hotwordId = hotwordId;
    }

    public Integer getProjectType() {
        return projectType;
    }

    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }

    public String getHotwordName() {
        return hotwordName;
    }

    public void setHotwordName(String hotwordName) {
        this.hotwordName = hotwordName;
    }

    public Integer getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(Integer searchTimes) {
        this.searchTimes = searchTimes;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}