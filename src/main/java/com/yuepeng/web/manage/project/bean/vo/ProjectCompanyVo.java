package com.yuepeng.web.manage.project.bean.vo;

import com.yuepeng.web.manage.project.bean.entity.TProjectCompany;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * ProjectCompanyVo
 *
 * @author wzq
 * @since 2020-05-22 11:01:33
 */
public class ProjectCompanyVo extends TProjectCompany{

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDateBegin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDateEnd;

    public Date getUpdateDateBegin() {
        return updateDateBegin;
    }

    public void setUpdateDateBegin(Date updateDateBegin) {
        this.updateDateBegin = updateDateBegin;
    }

    public Date getUpdateDateEnd() {
        return updateDateEnd;
    }

    public void setUpdateDateEnd(Date updateDateEnd) {
        this.updateDateEnd = updateDateEnd;
    }
}