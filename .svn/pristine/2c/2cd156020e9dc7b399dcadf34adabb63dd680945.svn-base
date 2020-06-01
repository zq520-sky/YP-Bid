package com.yuepeng.web.manage.count.bean.vo;

import com.yuepeng.web.manage.count.bean.entity.TDataCrawlerReport;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DataCrawlerReportVo extends TDataCrawlerReport {

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDateTime;//爬取开始日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDateTime;//爬取结束日期

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }
}
