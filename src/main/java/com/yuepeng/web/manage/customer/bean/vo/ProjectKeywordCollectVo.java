package com.yuepeng.web.manage.customer.bean.vo;

import com.yuepeng.web.manage.customer.bean.entity.TProjectKeywordCollect;
import com.yuepeng.web.manage.customer.enums.SexTypeEnums;

/**
 * 〈功能概述〉<br>
 *
 * @className: ProjectKeywordCollectVo
 * @package: com.yuepeng.web.manage.customer.bean.vo
 * @author: wzq
 * @date: 2020/5/13 15:47
 */
public class ProjectKeywordCollectVo extends TProjectKeywordCollect {

    private String custCode;
    private String mobile;
    private String headImg;
    private Integer sex;
    private String sexCN;
    private String nickName;
    private Integer memberType;

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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }
}
