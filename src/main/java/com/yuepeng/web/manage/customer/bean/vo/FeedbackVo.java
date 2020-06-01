package com.yuepeng.web.manage.customer.bean.vo;

import com.yuepeng.web.manage.customer.bean.entity.TFeedback;

/**
 * @Description: 客户反馈Vo
 * @Author: ZhongShengbin
 * @Date: 2020/05/19 17:51
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class FeedbackVo extends TFeedback {

    private String custCode;

    private String mobile;


    @Override
    public String getCustCode() {
        return custCode;
    }

    @Override
    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    @Override
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
