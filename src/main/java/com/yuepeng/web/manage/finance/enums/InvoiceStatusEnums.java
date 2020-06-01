package com.yuepeng.web.manage.finance.enums;

/**
 * 〈功能概述〉<br>
 *
 * @className: InvoiceStatusEnums
 * @package: com.yuepeng.web.manage.finance.enums
 * @author: wzq
 * @date: 2020/5/20 15:07
 */
public enum InvoiceStatusEnums {
    NO_INVOICE(0, "未开票"),
    INVOICED(1, "已开票"),
    CANCEL(2, "取消开票")
    ;

    private Integer status;

    private String desc;

    InvoiceStatusEnums(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDesc(Integer status){
        InvoiceStatusEnums[] values = InvoiceStatusEnums.values();
        for (InvoiceStatusEnums value : values) {
            if(value.getStatus().equals(status)){
                return value.getDesc();
            }
        }
        return null;
    }
}
