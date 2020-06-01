package com.yuepeng.web.manage.customer.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class TFeedback extends TCustomer implements Serializable {
    private Integer feedbackId;

    private String feedbackOpinion;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date feedbackTime;

    private Integer custId;

    private static final long serialVersionUID = 1L;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedbackOpinion() {
        return feedbackOpinion;
    }

    public void setFeedbackOpinion(String feedbackOpinion) {
        this.feedbackOpinion = feedbackOpinion;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }
}