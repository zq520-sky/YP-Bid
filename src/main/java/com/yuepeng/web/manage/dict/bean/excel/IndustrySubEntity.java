package com.yuepeng.web.manage.dict.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Description: 行业子类Excel
 * @Author: ZhongShengbin
 * @Date: 2020/05/25 11:19
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class IndustrySubEntity {

    @Excel(name = "行业大类名称", width = 20)
    private String industryName;

    @Excel(name = "行业分类名称", width = 20)
    private String industrySubName;

    @Excel(name = "子类关键字", width = 20)
    private String keyWords;

    @Excel(name = "顺序号", width = 20)
    private String orderNum;

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getIndustrySubName() {
        return industrySubName;
    }

    public void setIndustrySubName(String industrySubName) {
        this.industrySubName = industrySubName;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
