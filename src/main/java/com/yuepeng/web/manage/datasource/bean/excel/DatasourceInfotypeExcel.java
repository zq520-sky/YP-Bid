package com.yuepeng.web.manage.datasource.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceInfotype;

import java.io.Serializable;

/**
 * DatasourceInfotypeExcel
 *
 * @author wzq
 * @since 2020-05-22 17:09:32
 */
public class DatasourceInfotypeExcel extends TDatasourceInfotype implements Serializable {

    @Excel(name = "数据来源类型名称", width = 25)
    private String datasourceTypeName;

    @Excel(name = "数据来源名称(网站)", width = 30)
    private String datasourceWebname;

    @Excel(name = "行业类型名称", width = 15)
    private String datasourceIndustryName;

    @Excel(name = "对应招标行业类型", width = 25)
    private String datasourceInfotypeName;

    @Excel(name = "对应招标行业类型", width = 25)
    private String infotypeName;

    public String getDatasourceTypeName() {
        return datasourceTypeName;
    }

    public void setDatasourceTypeName(String datasourceTypeName) {
        this.datasourceTypeName = datasourceTypeName;
    }

    public String getDatasourceWebname() {
        return datasourceWebname;
    }

    public void setDatasourceWebname(String datasourceWebname) {
        this.datasourceWebname = datasourceWebname;
    }

    public String getDatasourceIndustryName() {
        return datasourceIndustryName;
    }

    public void setDatasourceIndustryName(String datasourceIndustryName) {
        this.datasourceIndustryName = datasourceIndustryName;
    }

    @Override
    public String getDatasourceInfotypeName() {
        return datasourceInfotypeName;
    }

    @Override
    public void setDatasourceInfotypeName(String datasourceInfotypeName) {
        this.datasourceInfotypeName = datasourceInfotypeName;
    }

    public String getInfotypeName() {
        return infotypeName;
    }

    public void setInfotypeName(String infotypeName) {
        this.infotypeName = infotypeName;
    }
}