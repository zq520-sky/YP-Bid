package com.yuepeng.web.manage.dict.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Description: 招标信息类型Excel
 * @Author: ZhongShengbin
 * @Date: 2020/05/20 14:15
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class InfotypeEntity {

    @Excel(name = "所属类别",width = 20)
    private String infotypeName;

    @Excel(name = "招标信息类型名称",width = 20)
    private String classIdCn;

    @Excel(name = "备注",width = 20)
    private String remark;


    public String getInfotypeName() {
        return infotypeName;
    }

    public void setInfotypeName(String infotypeName) {
        this.infotypeName = infotypeName;
    }

    public String getClassIdCn() {
        return classIdCn;
    }

    public void setClassIdCn(String classIdCn) {
        this.classIdCn = classIdCn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
