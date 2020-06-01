package com.yuepeng.web.manage.customer.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.customer.enums.SexTypeEnums;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wzq
 * @className CustomerVo
 * @description
 * @date 2020/5/11 14:59
 */
public class CustomerVo extends TCustomer {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDateBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDateEnd;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date useStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date useEndTime;

    private String companyName;
    private String job;
    private String provinceName;
    private String cityName;

    private String roleProvinceIds;

    private String roleProvinceNames;

    private String sexCN;

    public Date getRegisterDateBegin() {
        return registerDateBegin;
    }

    public void setRegisterDateBegin(Date registerDateBegin) {
        this.registerDateBegin = registerDateBegin;
    }

    public Date getRegisterDateEnd() {
        return registerDateEnd;
    }

    public void setRegisterDateEnd(Date registerDateEnd) {
        this.registerDateEnd = registerDateEnd;
    }

    public Date getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getSexCN() {
        return sexCN;
    }

    @Override
    public void setSex(Integer sex) {
        super.setSex(sex);
        this.sexCN = SexTypeEnums.getDesc(sex);
    }

    public String getRoleProvinceIds() {
        return roleProvinceIds;
    }

    public void setRoleProvinceIds(String roleProvinceIds) {
        this.roleProvinceIds = roleProvinceIds;
    }

    public String getRoleProvinceNames() {
        return roleProvinceNames;
    }

    public void setRoleProvinceNames(String roleProvinceNames) {
        this.roleProvinceNames = roleProvinceNames;
    }
}
