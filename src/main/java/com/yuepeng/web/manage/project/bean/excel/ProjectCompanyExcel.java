package com.yuepeng.web.manage.project.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.project.bean.entity.TProjectCompany;
import java.io.Serializable;
import java.util.Date;

/**
 * ProjectCompanyExcel
 *
 * @author wzq
 * @since 2020-05-22 11:01:33
 */
public class ProjectCompanyExcel extends TProjectCompany implements Serializable{

    @Excel(name = "招标单位编号", width = 15)
    private String projectCompanyCode;

    @Excel(name = "招标单位名称", width = 25)
    private String projectCompanyName;

    @Excel(name = "招标项目数量", width = 15)
    private Integer ifbAmount;

    @Excel(name = "更新时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date updateDate;

    @Override
    public String getProjectCompanyCode() {
        return projectCompanyCode;
    }

    @Override
    public void setProjectCompanyCode(String projectCompanyCode) {
        this.projectCompanyCode = projectCompanyCode;
    }

    @Override
    public String getProjectCompanyName() {
        return projectCompanyName;
    }

    @Override
    public void setProjectCompanyName(String projectCompanyName) {
        this.projectCompanyName = projectCompanyName;
    }

    @Override
    public Integer getIfbAmount() {
        return ifbAmount;
    }

    @Override
    public void setIfbAmount(Integer ifbAmount) {
        this.ifbAmount = ifbAmount;
    }

    @Override
    public Date getUpdateDate() {
        return updateDate;
    }

    @Override
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}