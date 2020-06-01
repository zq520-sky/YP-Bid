package com.yuepeng.web.manage.customer.enums;

/**
 * 〈功能概述〉<br>
 * 会员类型枚举
 * @className: MemberTypeEnums
 * @package: com.yuepeng.web.manage.customer.enums
 * @author: wzq
 * @date: 2020/5/12 10:45
 */
public enum MemberTypeEnums {
    NORMAL(0, "普通用户"),
    PROVINCE_VIP(1, "省级VIP"),
    ADVANCED_VIP(2, "高级VIP"),
    PROJECT_VIP(3, "项目VIP");

    private Integer memberType;
    private String name;

    MemberTypeEnums(Integer memberType, String name) {
        this.memberType = memberType;
        this.name = name;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public String getName() {
        return name;
    }

    public static String getName(Integer memberType){
        MemberTypeEnums[] values = MemberTypeEnums.values();
        for (MemberTypeEnums value : values) {
            if(value.getMemberType().equals(memberType)){
                return value.getName();
            }
        }
        return null;
    }
}
