package com.yuepeng.web.manage.datasource.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.datasource.bean.entity.TDatasource;
import java.io.Serializable;
/**
 * DatasourceExcel
 *
 * @author wzq
 * @since 2020-05-21 09:07:49
 */
public class DatasourceExcel extends TDatasource implements Serializable{

    @Excel(name = "数据来源类型名称", width = 20)
    private String datasourceTypeName;

    @Excel(name = "数据来源名称（网站）", width = 25)
    private String datasourceWebname;

    @Excel(name = "数据来源网站", width = 30)
    private String datasourceWeburl;

    @Excel(name = "所在省市", width = 10)
    private String provinceName;

    @Excel(name = "所在省市", width = 10)
    private String cityName;

    @Excel(name = "是否禁用", width = 10, replace = {"正常_0","已禁用_1"})
    private Integer isForbid;

    public String getDatasourceTypeName() {
        return datasourceTypeName;
    }

    public void setDatasourceTypeName(String datasourceTypeName) {
        this.datasourceTypeName = datasourceTypeName;
    }

    @Override
    public String getDatasourceWebname() {
        return datasourceWebname;
    }

    @Override
    public void setDatasourceWebname(String datasourceWebname) {
        this.datasourceWebname = datasourceWebname;
    }

    @Override
    public String getDatasourceWeburl() {
        return datasourceWeburl;
    }

    @Override
    public void setDatasourceWeburl(String datasourceWeburl) {
        this.datasourceWeburl = datasourceWeburl;
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

    @Override
    public Integer getIsForbid() {
        return isForbid;
    }

    @Override
    public void setIsForbid(Integer isForbid) {
        this.isForbid = isForbid;
    }
}