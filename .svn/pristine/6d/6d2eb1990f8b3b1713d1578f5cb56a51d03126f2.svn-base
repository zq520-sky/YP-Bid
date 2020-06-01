package com.yuepeng.web.manage.customer.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuepeng.web.manage.customer.bean.entity.TMember;
import com.yuepeng.web.manage.customer.enums.MemberTypeEnums;
import com.yuepeng.web.manage.customer.enums.SexTypeEnums;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: MemberVo
 * @package: com.yuepeng.web.manage.customer.bean.vo
 * @author: wzq
 * @date: 2020/5/12 9:52
 */
public class MemberVo extends TMember {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDateBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDateEnd;

    private String headImg;
    private String custCode;
    private String mobile;
    private String nickName;
    private Integer sex;
    private String sexCN;
    private String companyName;
    private String job;
    private String provinceName;
    private String cityName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerDate;
    private Integer memberType;
    private String memberTypeCN;

    public Date getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(Date createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
        this.sexCN = SexTypeEnums.getDesc(sex);
    }

    public String getSexCN() {
        return sexCN;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public Integer getMemberType() {
        return memberType;
    }

    @Override
    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
        this.memberTypeCN = MemberTypeEnums.getName(memberType);
    }

    public String getMemberTypeCN() {
        return memberTypeCN;
    }
}
