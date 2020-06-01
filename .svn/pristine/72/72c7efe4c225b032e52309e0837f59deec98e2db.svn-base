package com.yuepeng.web.manage.planProject.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanProject;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description: 拟建项目Vo
 * @Author: ZhongShengbin
 * @Date: 2020/05/26 20:23
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class PlanProjectVo extends TPlanProject {

    private String projectName;

    private String projectDetail;

    private String datasourceWebname;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDateBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDateEnd;

    private String classIdCn;

    private String industrySubName;

    private String cityName;

    private String provinceName;

    private String datasourceTypeName;

    private String datasourceWeburl;

    /**
     * 搜索类型：1-标题搜索， 2-全文搜索
     */
    private Integer searchType;

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String getProjectDetail() {
        return projectDetail;
    }

    @Override
    public void setProjectDetail(String projectDetail) {
        this.projectDetail = projectDetail;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(Date createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public String getClassIdCn() {
        return classIdCn;
    }

    public void setClassIdCn(String classIdCn) {
        this.classIdCn = classIdCn;
    }

    public String getIndustrySubName() {
        return industrySubName;
    }

    public void setIndustrySubName(String industrySubName) {
        this.industrySubName = industrySubName;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDatasourceWebname() {
        return datasourceWebname;
    }

    public void setDatasourceWebname(String datasourceWebname) {
        this.datasourceWebname = datasourceWebname;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDatasourceTypeName() {
        return datasourceTypeName;
    }

    public void setDatasourceTypeName(String datasourceTypeName) {
        this.datasourceTypeName = datasourceTypeName;
    }

    public String getDatasourceWeburl() {
        return datasourceWeburl;
    }

    public void setDatasourceWeburl(String datasourceWeburl) {
        this.datasourceWeburl = datasourceWeburl;
    }
}

