package com.yuepeng.web.manage.log.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.log.bean.entity.TDatacrawlerService;
import com.yuepeng.web.manage.log.bean.excel.DataCrawlerLogExcel;
import com.yuepeng.web.manage.log.bean.vo.DataCrawlerLogVo;
import com.yuepeng.web.manage.log.service.DataCrawlerLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: 数据爬取日志 Controller
 * @Author: xtq
 * @Date: 2020/5/29 13:43
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/log/")
public class DataCrawlerLogController extends BaseController {

    @Resource
    private ILogService logService;

    @Autowired
    private DataCrawlerLogService dataCrawlerLogService;

    /**
     * 查询 -分页list
     * @param paramBean
     * @param dataCrawlerLogVo
     * @return
     * @throws Exception
     */
    @RequestMapping("queryDataCrawlerLogList" + WebConstant.PAGE_SUFFIX)
    public String queryDataCrawlerLogList(Pagination<DataCrawlerLogVo> paramBean, DataCrawlerLogVo dataCrawlerLogVo) throws Exception{
        paramBean.setSearch(dataCrawlerLogVo);
        Pagination<DataCrawlerLogVo> pageData = dataCrawlerLogService.queryDataCrawlerLogList(paramBean);
        this.addAttr("pageData", pageData);
        //全部爬虫服务list
        List<TDatacrawlerService> datacrawlerServiceList = this.queryDatacrawlerServiceAll();
        this.addAttr("datacrawlerServiceList", datacrawlerServiceList);
        //数据回显
        DataCrawlerLogVo searchDataShow = this.dataShow(dataCrawlerLogVo);
        if(searchDataShow != null){
            this.addAttr("searchDataShow", searchDataShow);
        }
        return "log/dataCrawlerLog";
    }


    /**
     * 导出
     * @param paramBean
     * @param dataCrawlerLogVo
     * @return
     * @throws Exception
     */
    @RequestMapping("exportDataCrawlerLogList" + WebConstant.BUSINESS_SUFFIX)
    public String exportCustLoginLogList(Pagination<DataCrawlerLogVo> paramBean, DataCrawlerLogVo dataCrawlerLogVo) throws Exception {
        paramBean.setSearch(dataCrawlerLogVo);
        Pagination<DataCrawlerLogExcel> list = dataCrawlerLogService.exportDataCrawlerLogList(paramBean);
        logService.addLog(new TSysLog("数据爬取日志-导出", "导出数据爬取日志！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "数据爬取日志" + String.format("%1$tY%1$tm%1$td", new Date()), DataCrawlerLogExcel.class, list.getData());
        return null;
    }

    //全部爬虫服务列表
    private List<TDatacrawlerService> queryDatacrawlerServiceAll(){
        return dataCrawlerLogService.queryDatacrawlerServiceAll();
    }

    //数据回显
    private DataCrawlerLogVo dataShow(DataCrawlerLogVo dataCrawlerLogVo) throws Exception{
        DataCrawlerLogVo resDataCrawlerLogVo = null;
        if(dataCrawlerLogVo != null){
            resDataCrawlerLogVo = new DataCrawlerLogVo();

            //第一次访问初始化搜索表单 爬虫执行时间、结束时间 --start
            resDataCrawlerLogVo = this.initSearchForm(dataCrawlerLogVo, resDataCrawlerLogVo);
            //第一次访问初始化搜索表单 爬虫执行时间、结束时间 --end

            if(dataCrawlerLogVo.getStartDateTime() != null){
                resDataCrawlerLogVo.setStartDateTime(dataCrawlerLogVo.getStartDateTime());
            }
            if(dataCrawlerLogVo.getEndDateTime() != null){
                resDataCrawlerLogVo.setEndDateTime(dataCrawlerLogVo.getEndDateTime());
            }
            if(dataCrawlerLogVo.getDatasourceWebname() != null && dataCrawlerLogVo.getDatasourceWebname().length()>0){
                resDataCrawlerLogVo.setDatasourceWebname(dataCrawlerLogVo.getDatasourceWebname());
            }
        }
        return resDataCrawlerLogVo;
    }

    //第一次访问初始化搜索表单 爬虫执行时间、结束时间
    private DataCrawlerLogVo initSearchForm(DataCrawlerLogVo dataCrawlerLogVo,DataCrawlerLogVo resDataCrawlerLogVo) throws ParseException {
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
