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
public class CustomerLoginLogExcel extends AppLogLoginVo implements Serializable {

    @Excel(name = "客户编号", width = 15)
    private String custCode;

    @Excel(name = "手机号码", width = 15)
    private String mobile;

    @Excel(name = "昵称", width = 15)
    private String nickName;

    @Excel(name = "登录时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date loginDate;

    @Excel(name = "登录ip", width = 15)
    private String loginIp;

    @Excel(name = "登录方式", width = 15, replace = {"密码登录_1", "验证码登录_2"})
    private Integer loginType;//1：密码登录 2：验证码登录

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

    @Override
    public Date getLoginDate() {
        return loginDate;
    }

    @Override
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String getLoginIp() {
        return loginIp;
    }

    @Override
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public Integer getLoginType() {
        return loginType;
    }

    @Override
    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }
}
