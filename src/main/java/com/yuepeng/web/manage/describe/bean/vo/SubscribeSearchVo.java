package com.yuepeng.web.manage.describe.bean.vo;

import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSearch;

/**
 * @Description: 客户订阅查询Vo
 * @Author: ZhongShengbin
 * @Date: 2020/05/19 13:46
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class SubscribeSearchVo extends TSubscribeSearch {

    private String custCode;

    private String mobile;

    //会员类型
    private String memberTypeSn;

    //搜索类型
    private String serarchTypeCn;

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

    public String getMemberTypeSn() {
        return memberTypeSn;
    }

    public void setMemberTypeSn(String memberTypeSn) {
        this.memberTypeSn = memberTypeSn;
    }

    public String getSerarchTypeCn() {
        return serarchTypeCn;
    }

    public void setSerarchTypeCn(String serarchTypeCn) {
        this.serarchTypeCn = serarchTypeCn;
    }
}
