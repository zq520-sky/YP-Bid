package com.yuepeng.web.manage.customer.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.customer.bean.entity.TMember;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: MemberExcel
 * @package: com.yuepeng.web.manage.customer.bean.excel
 * @author: wzq
 * @date: 2020/5/12 9:52
 */
public class MemberExcel extends TMember implements Serializable {

    @Excel(name = "客户编号", width = 15)
    private String custCode;
    @Excel(name = "手机号码", width = 15)
    private String mobile;
    @Excel(name = "昵称", width = 15)
    private String nickName;
    @Excel(name = "性别", width = 10, replace = {"未知_0","男_1","女_2"})
    private Integer sex;
    @Excel(name = "会员类型", width = 10, replace = {"省级VIP_1","高级VIP_2","项目VIP_3"})
    private Integer memberType;
    @Excel(name = "权限区域", width = 20)
    private String roleProvinceNames;
    @Excel(name = "会员开始时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date useStartTime;
    @Excel(name = "会员结束时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date useEndTime;
    @Excel(name = "入会时间", format = "yyyy-MM-dd HH:mm:ss",  width = 25)
    private Date createDate;

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
    }

    @Override
    public Integer getMemberType() {
        return memberType;
    }

    @Override
    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    @Override
    public String getRoleProvinceNames() {
        return roleProvinceNames;
    }

    @Override
    public void setRoleProvinceNames(String roleProvinceNames) {
        this.roleProvinceNames = roleProvinceNames;
    }

    @Override
    public Date getUseStartTime() {
        return useStartTime;
    }

    @Override
    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    @Override
    public Date getUseEndTime() {
        return useEndTime;
    }

    @Override
    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
