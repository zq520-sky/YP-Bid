package com.yuepeng.web.manage.log.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;

import java.util.Date;

public class CustomerVisitLookVo extends TCustomer {
    /**
     *     cst.cust_id,
     * 	    cst.cust_code,
     * 			cst.mobile,
     * 			cst.head_img,
     * 			cst.nick_name,
     * 			cst.sex,
     * 	    tpr.industry_name,
     * 	    tp.project_title,
     * 	    tpv.visit_date,
     * 	    tpv.visit_id
     */
    private String projectTitle;
    private String industryName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date visitDate;
    private Integer visitId;

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }
}
