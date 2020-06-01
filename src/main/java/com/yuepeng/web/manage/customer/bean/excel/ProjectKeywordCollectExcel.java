package com.yuepeng.web.manage.customer.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.customer.bean.entity.TProjectKeywordCollect;

import java.io.Serializable;

/**
 * 〈功能概述〉<br>
 *
 * @className: ProjectKeywordCollectExcel
 * @package: com.yuepeng.web.manage.customer.bean.excel
 * @author: wzq
 * @date: 2020/5/13 15:47
 */
public class ProjectKeywordCollectExcel extends TProjectKeywordCollect implements Serializable {

    @Excel(name = "客户编号", width = 15)
    private String custCode;
    @Excel(name = "手机号码", width = 15)
    private String mobile;
    @Excel(name = "性别", width = 10, replace = {"未知_0","男_1","女_2"})
    private Integer sex;
    @Excel(name = "昵称", width = 15)
    private String nickName;
    @Excel(name = "项目关键词", width = 25)
    private String projectKeywords;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String getProjectKeywords() {
        return projectKeywords;
    }

    @Override
    public void setProjectKeywords(String projectKeywords) {
        this.projectKeywords = projectKeywords;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
