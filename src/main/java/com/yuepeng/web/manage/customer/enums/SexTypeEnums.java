package com.yuepeng.web.manage.customer.enums;

/**
 * 〈功能概述〉<br>
 * 性别类型枚举
 * @className: SexTypeEnums
 * @package: com.yuepeng.web.manage.customer.enums
 * @author: wzq
 * @date: 2020/5/12 8:45
 */
public enum SexTypeEnums {
    MALE(1, "男"),
    FEMALE(2, "女"),
    UNKNOWN(0, "未知");

    private Integer sex;
    private String desc;

    SexTypeEnums(Integer sex, String desc) {
        this.sex = sex;
        this.desc = desc;
    }

    public static String getDesc(Integer sex){
        SexTypeEnums[] values = SexTypeEnums.values();
        for (SexTypeEnums value : values) {
            if(value.getSex().equals(sex)){
                return value.getDesc();
            }
        }
        return null;
    }

    public Integer getSex() {
        return sex;
    }

    public String getDesc() {
        return desc;
    }
}
