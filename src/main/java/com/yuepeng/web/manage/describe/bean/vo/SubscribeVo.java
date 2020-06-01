package com.yuepeng.web.manage.describe.bean.vo;

import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSet;

/**
 * @Description: 客户订阅Vo
 * @Author: ZhongShengbin
 * @Date: 2020/05/17 14:07
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class SubscribeVo extends TSubscribeSet {

    private String mobile;

    private String keyWords;

    //会员类型
    private String memberTypeSn;

    //客户编号
    private String custCode;

    //搜索类型
    private String serarchTypeCn;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String getKeyWords() {
        return keyWords;
    }

    @Override
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getMemberTypeSn() {
        return memberTypeSn;
    }

    public void setMemberTypeSn(String memberTypeSn) {
        this.memberTypeSn = memberTypeSn;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getSerarchTypeCn() {
        return serarchTypeCn;
    }

    public void setSerarchTypeCn(String serarchTypeCn) {
        this.serarchTypeCn = serarchTypeCn;
    }

}

