package com.yuepeng.web.manage.log.bean.entity;

import java.io.Serializable;

public class TDatacrawlerService implements Serializable {

    private Integer datacrawlerServiceId;//爬虫服务id

    private String datacrawlerServiceName;//爬虫服务名称

    private Integer serviceType;//爬虫服务类型 0：实时爬取 1：历史变更 2：单次爬取

    private Integer pageNum;//禁用状态 0：正常 ：已禁用

    public Integer getDatacrawlerServiceId() {
        return datacrawlerServiceId;
    }

    public void setDatacrawlerServiceId(Integer datacrawlerServiceId) {
        this.datacrawlerServiceId = datacrawlerServiceId;
    }

    public String getDatacrawlerServiceName() {
        return datacrawlerServiceName;
    }

    public void setDatacrawlerServiceName(String datacrawlerServiceName) {
        this.datacrawlerServiceName = datacrawlerServiceName;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
