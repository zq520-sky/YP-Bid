package com.yuepeng.web.manage.datasource.bean.vo;

import com.yuepeng.web.manage.datasource.bean.entity.TDatacrawlerSet;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 爬取规则Vo
 * @Author: ZhongShengbin
 * @Date: 2020/05/28 09:33
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class DatacrawlerSetVo extends TDatacrawlerSet {

    private Integer datasourceId;

    private String datasourceWebname;

    private String isForbidCn;

    private Integer datacrawlerServiceId;

    private String datacrawlerServiceName;

    private String datasourceWeburl;

    private String provinceName;

    private String cityName;

    private String distance;

    private String datasourceTypeName;

    private Integer datasourceInfotypeId;

    private Integer datasourceTypeId;


    @Override
    public Integer getDatasourceId() {
        return datasourceId;
    }

    @Override
    public void setDatasourceId(Integer datasourceId) {
        this.datasourceId = datasourceId;
    }

    public String getDatasourceWebname() {
        return datasourceWebname;
    }

    public void setDatasourceWebname(String datasourceWebname) {
        this.datasourceWebname = datasourceWebname;
    }

    public String getIsForbidCn() {
        return isForbidCn;
    }

    public void setIsForbidCn(String isForbidCn) {
        this.isForbidCn = isForbidCn;
    }

    @Override
    public Integer getDatacrawlerServiceId() {
        return datacrawlerServiceId;
    }

    @Override
    public void setDatacrawlerServiceId(Integer datacrawlerServiceId) {
        this.datacrawlerServiceId = datacrawlerServiceId;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getDatasourceWeburl() {
        return datasourceWeburl;
    }

    public void setDatasourceWeburl(String datasourceWeburl) {
        this.datasourceWeburl = datasourceWeburl;
    }

    public String getDatacrawlerServiceName() {
        return datacrawlerServiceName;
    }

    public void setDatacrawlerServiceName(String datacrawlerServiceName) {
        this.datacrawlerServiceName = datacrawlerServiceName;
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

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDatasourceTypeName() {
        return datasourceTypeName;
    }

    public void setDatasourceTypeName(String datasourceTypeName) {
        this.datasourceTypeName = datasourceTypeName;
    }

    public Integer getDatasourceInfotypeId() {
        return datasourceInfotypeId;
    }

    public void setDatasourceInfotypeId(Integer datasourceInfotypeId) {
        this.datasourceInfotypeId = datasourceInfotypeId;
    }

    public Integer getDatasourceTypeId() {
        return datasourceTypeId;
    }

    public void setDatasourceTypeId(Integer datasourceTypeId) {
        this.datasourceTypeId = datasourceTypeId;
    }


}
