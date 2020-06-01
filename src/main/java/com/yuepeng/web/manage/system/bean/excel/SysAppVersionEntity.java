package com.yuepeng.web.manage.system.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @Description: excel
 * @Author: ZhongShengbin
 * @Date: 2020/05/22 15:10
 * Copyright (c) 2019, Samton. All rights reserved
 */
public class SysAppVersionEntity {

    @Excel(name = "APP版本号", width = 20)
    private String versionCode;

    @Excel(name = "是否强制更新", width = 20)
    private String isForceUpdateCn;

    @Excel(name = "更新内容", width = 20)
    private String updateMemo;

    @Excel(name = "发布时间", format = "yyyy-MM-dd HH:mm:ss", width = 25)
    private Date publishTime;

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getIsForceUpdateCn() {
        return isForceUpdateCn;
    }

    public void setIsForceUpdateCn(String isForceUpdateCn) {
        this.isForceUpdateCn = isForceUpdateCn;
    }

    public String getUpdateMemo() {
        return updateMemo;
    }

    public void setUpdateMemo(String updateMemo) {
        this.updateMemo = updateMemo;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}
