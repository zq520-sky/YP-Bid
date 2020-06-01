package com.yuepeng.web.manage.project.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.project.bean.entity.TProject;
import java.io.Serializable;
import java.util.Date;

/**
 * ProjectExcel
 *
 * @author wzq
 * @since 2020-05-19 09:41:14
 */
public class ProjectExcel extends TProject implements Serializable{

    @Excel(name = "数据来源名称（网站）", width = 25)
    private String datasourceWebname;

    @Excel(name = "对应招标信息类型", width = 20)
    private String infotypeName;

    @Excel(name = "对应招标行业类型", width = 20)
    private String industryName;

    @Excel(name = "项目标题", width = 55)
    private String projectTitle;

    @Excel(name = "新增时间", format = "yyyy-MM-dd HH:mm:ss", width = 25)
    private Date addDate;

    public String getDatasourceWebname() {
        return datasourceWebname;
    }

    public void setDatasourceWebname(String datasourceWebname) {
        this.datasourceWebname = datasourceWebname;
    }

    public String getInfotypeName() {
        return infotypeName;
    }

    public void setInfotypeName(String infotypeName) {
        this.infotypeName = infotypeName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    @Override
    public String getProjectTitle() {
        return projectTitle;
    }

    @Override
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    @Override
    public Date getAddDate() {
        return addDate;
    }

    @Override
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}