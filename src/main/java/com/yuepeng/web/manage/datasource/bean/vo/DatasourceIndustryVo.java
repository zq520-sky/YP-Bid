package com.yuepeng.web.manage.datasource.bean.vo;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceIndustry;

/**
 * DatasourceIndustryVo
 *
 * @author wzq
 * @since 2020-05-22 16:20:57
 */
public class DatasourceIndustryVo extends TDatasourceIndustry{

    private String datasourceTypeName;

    private String datasourceWebname;

    private String datasourceWeburl;

    private String remark;

    private String provinceName;

    private String cityName;

    private String industryName;

    private Integer datasourceTypeId;

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

    public String getDatasourceWeburl() {
        return datasourceWeburl;
    }

    public void setDatasourceWeburl(String datasourceWeburl) {
        this.datasourceWeburl = datasourceWeburl;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Integer getDatasourceTypeId() {
        return datasourceTypeId;
    }

    public void setDatasourceTypeId(Integer datasourceTypeId) {
        this.datasourceTypeId = datasourceTypeId;
    }
}