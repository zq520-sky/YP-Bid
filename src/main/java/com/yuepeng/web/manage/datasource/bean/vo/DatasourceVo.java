package com.yuepeng.web.manage.datasource.bean.vo;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasource;

import java.util.List;

/**
 * DatasourceVo
 *
 * @author wzq
 * @since 2020-05-21 09:07:49
 */
public class DatasourceVo extends TDatasource{

    private String datasourceTypeName;

    private String cityName;

    private String provinceName;

    private String isForbidCN;

    private List<DatasourceIndustryVo> children;

    public String getDatasourceTypeName() {
        return datasourceTypeName;
    }

    public void setDatasourceTypeName(String datasourceTypeName) {
        this.datasourceTypeName = datasourceTypeName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getIsForbidCN() {
        return isForbidCN;
    }

    @Override
    public void setIsForbid(Integer isForbid) {
        super.setIsForbid(isForbid);
        if(isForbid != null){
            this.isForbidCN = isForbid == 1 ? "已禁用" : "正常";
        }
    }

    public List<DatasourceIndustryVo> getChildren() {
        return children;
    }

    public void setChildren(List<DatasourceIndustryVo> children) {
        this.children = children;
    }
}