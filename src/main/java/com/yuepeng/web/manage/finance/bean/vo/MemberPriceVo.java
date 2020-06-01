package com.yuepeng.web.manage.finance.bean.vo;

import com.yuepeng.web.manage.customer.enums.MemberTypeEnums;
import com.yuepeng.web.manage.finance.bean.entity.TMemberPrice;

/**
 * 〈功能概述〉<br>
 *
 * @className: MemberPriceVo
 * @package: com.yuepeng.web.manage.finance.bean.vo
 * @author: wzq
 * @date: 2020/5/14 20:12
 */
public class MemberPriceVo extends TMemberPrice {

    private String memberTypeCN;

    private String isForbidCN;

    public String getMemberTypeCN() {
        return memberTypeCN;
    }

    public String getIsForbidCN() {
        return isForbidCN;
    }

    @Override
    public void setMemberType(Integer memberType) {
        super.setMemberType(memberType);

        this.memberTypeCN = MemberTypeEnums.getName(memberType);
    }

    @Override
    public void setIsForbid(Integer isForbid) {
        super.setIsForbid(isForbid);
        this.isForbidCN = isForbid == 0 ? "否" : "是";
    }
}
