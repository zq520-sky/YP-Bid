package com.yuepeng.web.manage.system.bean.vo;

import com.yuepeng.web.manage.system.bean.entity.TMemberRole;

/**
 * @Description: 会员权限设置Vo
 * @Author: ZhongShengbin
 * @Date: 2020/05/24 11:26
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class MemberRoleVo extends TMemberRole {

    private String isTextsearchCn;

    private String memberTypeCn;

    private String collectNumCn;

    private String planProjectNumCn;

    private String advancedNumCn;

    private Integer cNum;

    private Integer pNum;

    private Integer aNum;

    public MemberRoleVo() {
    }

    public String getIsTextsearchCn() {
        return isTextsearchCn;
    }

    public void setIsTextsearchCn(String isTextsearchCn) {
        this.isTextsearchCn = isTextsearchCn;
    }

    public String getMemberTypeCn() {
        return memberTypeCn;
    }

    public void setMemberTypeCn(String memberTypeCn) {
        this.memberTypeCn = memberTypeCn;
    }

    public void setCollectNum(Integer collectNum) {
        if (collectNum != null) {
            this.cNum = collectNum;
            this.collectNumCn = collectNum == -1 ? "无限制" : collectNum.toString();
        } else {
            this.collectNumCn = null;
        }
    }

    public void setPlanProjectNum(Integer planProjectNum) {
        if (planProjectNum != null) {
            this.pNum = planProjectNum;
            this.planProjectNumCn = planProjectNum == -1 ? "不支持" : planProjectNum.toString();
        } else {
            this.planProjectNumCn = null;
        }
    }

    public void setAdvancedNum(Integer advancedNum) {
        if (advancedNum != null) {
            this.aNum = advancedNum;
            this.advancedNumCn = advancedNum == -1 ? "不支持" : advancedNum.toString();
        } else {
            this.advancedNumCn = null;
        }
    }

    public String getCollectNumCn() {
        return collectNumCn;
    }

    public String getPlanProjectNumCn() {
        return planProjectNumCn;
    }

    public String getAdvancedNumCn() {
        return advancedNumCn;
    }

    public Integer getcNum() {
        return cNum;
    }

    public Integer getpNum() {
        return pNum;
    }

    public Integer getaNum() {
        return aNum;
    }
}
