package com.yuepeng.web.manage.datasource.service.impl;

import com.yuepeng.web.manage.log.bean.vo.DataCrawlerLogVo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class DatacrawServiceImplTest {

    public static void main(String[] args) throws ParseException {
        DataCrawlerLogVo dataCrawlerLogVo = new DataCrawlerLogVo();
        DataCrawlerLogVo logVo = initSearchForm(dataCrawlerLogVo);
        System.out.println(logVo);
    }

    //第一次访问初始化搜索表单 爬虫执行时间、结束时间
    public static DataCrawlerLogVo initSearchForm(DataCrawlerLogVo dataCrawlerLogVo) throws ParseException {
        DataCrawlerLogVo resDataCrawlerLogVo = new DataCrawlerLogVo();
        if(dataCrawlerLogVo.getStartDateTime() == null){
            Date startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 00:00:00");
            resDataCrawlerLogVo.setStartDateTime(startDateTime);
        }
        if(dataCrawlerLogVo.getEndDateTime() == null){
            Date endDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 23:59:59");
            resDataCrawlerLogVo.setEndDateTime(endDateTime);
        }
        return resDataCrawlerLogVo;
    }

}