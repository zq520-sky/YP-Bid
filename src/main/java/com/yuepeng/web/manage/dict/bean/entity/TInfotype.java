package com.yuepeng.web.manage.dict.bean.entity;

import java.io.Serializable;

public class TInfotype implements Serializable {
    private Integer infotypeId;

    private String infotypeName;

    private Integer classId;

    private Integer orderNum;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getInfotypeId() {
        return infotypeId;
    }

    public void setInfotypeId(Integer infotypeId) {
        this.infotypeId = infotypeId;
    }

    public String getInfotypeName() {
        return infotypeName;
    }

    public void setInfotypeName(String infotypeName) {
        this.infotypeName = infotypeName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}