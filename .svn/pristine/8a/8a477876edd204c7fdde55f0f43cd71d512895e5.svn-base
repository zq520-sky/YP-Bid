package com.yuepeng.web.manage.customer.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wzq
 * @className CustomerExcel
 * @description
 * @date 2020/5/11 15:23
 */
public class CustomerExcel extends TCustomer implements Serializable {

    @Excel(name = "客户编号", width = 15)
    private String custCode;
    @Excel(name = "手机号码", width = 15)
    private String mobile;
    @Excel(name = "昵称", width = 15)
    private String nickName;
    @Excel(name = "性别", width = 10, replace = {"未知_0","男_1","女_2"})
    private Integer sex;
    @Excel(name = "所在省市", width = 10)
    private String provinceName;
    @Excel(name = "所在省市", width = 10, mergeRely = {5})
    private String cityName;
    @Excel(name = "是否会员", width = 10, replace = {"否_0","是_1"})
    private Integer isMember;
    @Excel(name = "禁用状态", width = 10, replace = {"正常_0","已禁用_1"})
    private Integer isForbid;
    @Excel(name = "注册时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date registerDate;

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
    public Integer getSex() {
        return sex;
    }

    @Override
    public void setSex(Integer sex) {
        this.sex = sex;
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

    @Override
    public Integer getIsMember() {
        return isMember;
    }

    @Override
    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    @Override
    public Integer getIsForbid() {
        return isForbid;
    }

    @Override
    public void setIsForbid(Integer isForbid) {
        this.isForbid = isForbid;
    }

    @Override
    public Date getRegisterDate() {
        return registerDate;
    }

    @Override
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
