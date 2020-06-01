package com.yuepeng.web.manage.planProject.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @Description: 拟建项目管理Excel
 * @Author: ZhongShengbin
 * @Date: 2020/05/26 20:59
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class PlanProjectEntity {

    @Excel(name = "数据来源名称(网站)", width = 20)
    private String datasourceWebname;

    @Excel(name = "国家编码\\项目代码", width = 20)
    private String projectName;

    @Excel(name = "项目名称", width = 40)
    private String projectCode;

    @Excel(name = "项目类型", width = 40)
    private String projectType;

    @Excel(name = "审批部门", width = 40)
    private String examineDepart;

    @Excel(name = "新增时间", format = "yyyy-MM-dd HH:mm:ss", width = 25)
    private Date addDate;

    public String getDatasourceWebname() {
        return datasourceWebname;
    }

    public void setDatasourceWebname(String datasourceWebname) {
        this.datasourceWebname = datasourceWebname;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getExamineDepart() {
        return examineDepart;
    }

    public void setExamineDepart(String examineDepart) {
        this.examineDepart = examineDepart;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
