package com.yuepeng.web.manage.dict.bean.entity;

import java.io.Serializable;
import java.util.Date;

public class TProjectKeyword implements Serializable {
    private Integer projectKeywordId;

    private String projectKeyword;

    private Integer orderNum;

    private Integer createUserId;

    private Date createDate;

    private Integer updateUserId;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getProjectKeywordId() {
        return projectKeywordId;
    }

    public void setProjectKeywordId(Integer projectKeywordId) {
        this.projectKeywordId = projectKeywordId;
    }

    public String getProjectKeyword() {
        return projectKeyword;
    }

    public void setProjectKeyword(String projectKeyword) {
        this.projectKeyword = projectKeyword;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}