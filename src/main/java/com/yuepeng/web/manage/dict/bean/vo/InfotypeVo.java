package com.yuepeng.web.manage.dict.bean.vo;

import com.yuepeng.web.manage.dict.bean.entity.TInfotype;

/**
 * @Description: 招标信息类型Vo
 * @Author: ZhongShengbin
 * @Date: 2020/05/20 14:12
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class InfotypeVo extends TInfotype {

    private String infotypeName;

    //1：招标    2：中标    3：变更    4：流标
    private String classIdCn;

    @Override
    public String getInfotypeName() {
        return infotypeName;
    }

    @Override
    public void setInfotypeName(String infotypeName) {
        this.infotypeName = infotypeName;
    }

    public String getClassIdCn() {
        return classIdCn;
    }

    public void setClassIdCn(String classIdCn) {
        this.classIdCn = classIdCn;
    }
}
