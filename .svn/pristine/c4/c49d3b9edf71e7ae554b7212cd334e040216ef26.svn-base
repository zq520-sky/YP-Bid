package com.yuepeng.web.manage.log.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.log.bean.vo.AppLogLoginVo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: xtq
 * @Date: 2020/5/27 15:35
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class CustomerSearchLogExcel extends AppLogLoginVo implements Serializable {

    @Excel(name = "客户编号", width = 15)
    private String custCode;

    @Excel(name = "手机号码", width = 15)
    private String mobile;

    @Excel(name = "昵称", width = 15)
    private String nickName;

    @Excel(name = "搜索时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date searchTime;

    @Excel(name = "搜索关键字", width = 20)
    private String searchWord;

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

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
