package com.yuepeng.web.manage.system.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class TMemberRole implements Serializable {
    private Integer memberRoleId;

    private Integer memberType;

    private Integer isTextsearch;

    private Integer readProjectNum;

    private Integer subscribeNum;

    private Integer collectNum;

    private Integer recommendNum;

    private Integer planProjectNum;

    private Integer advancedNum;

    private String remark;

    private Integer createUserId;

    private Date createDate;

    private Integer updateUserId;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Integer getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(Integer memberRoleId) {
        this.memberRoleId = memberRoleId;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getIsTextsearch() {
        return isTextsearch;
    }

    public void setIsTextsearch(Integer isTextsearch) {
        this.isTextsearch = isTextsearch;
    }

    public Integer getReadProjectNum() {
        return readProjectNum;
    }

    public void setReadProjectNum(Integer readProjectNum) {
        this.readProjectNum = readProjectNum;
    }

    public Integer getSubscribeNum() {
        return subscribeNum;
    }

    public void setSubscribeNum(Integer subscribeNum) {
        this.subscribeNum = subscribeNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Integer getPlanProjectNum() {
        return planProjectNum;
    }

    public void setPlanProjectNum(Integer planProjectNum) {
        this.planProjectNum = planProjectNum;
    }

    public Integer getAdvancedNum() {
        return advancedNum;
    }

    public void setAdvancedNum(Integer advancedNum) {
        this.advancedNum = advancedNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}