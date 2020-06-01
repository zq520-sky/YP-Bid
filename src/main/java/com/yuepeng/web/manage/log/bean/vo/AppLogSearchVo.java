package com.yuepeng.web.manage.log.bean.vo;

import com.yuepeng.web.manage.log.bean.entity.TAppLogSearch;

/**
 * @Description:
 * @Author: xtq
 * @Date: 2020/5/27 14:35
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class AppLogSearchVo extends TAppLogSearch {
    /*
    * cust.cust_code,
        cust.mobile,
        cust.head_img,
        cust.nick_name,*/

    private Integer custId;

    private String custCode;

    private String mobile;

    private String headImg;

    private String nickName;

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public Integer getCustId() {
        return custId;
    }

    @Override
    public void setCustId(Integer custId) {
        this.custId = custId;
    }
}
