package com.yuepeng.web.manage.finance.enums;

/**
 * 〈功能概述〉<br>
 *
 * @className: PayModeEnums
 * @package: com.yuepeng.web.manage.finance.enums
 * @author: wzq
 * @date: 2020/5/18 8:54
 */
public enum PayModeEnums {
    ALI(1, "支付宝"),
    WECHAT(0, "微信"),
    UNION(2, "银联"),
    OTHER(10, "系统")
    ;

    private Integer mode;
    private String desc;

    PayModeEnums(Integer mode, String desc){
        this.mode = mode;
        this.desc = desc;
    }

    public static String getDescByMode(Integer mode){
        PayModeEnums[] values = PayModeEnums.values();
        for (PayModeEnums value : values) {
            if(value.getMode().equals(mode)){
                return value.getDesc();
            }
        }
        return null;
    }

    public Integer getMode() {
        return mode;
    }

    public String getDesc() {
        return desc;
    }
}
