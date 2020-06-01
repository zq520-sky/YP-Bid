package com.yuepeng.web.manage.count.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.count.bean.excel.TDataCrawlerReportExcel;
import com.yuepeng.web.manage.count.bean.vo.DataCrawlerReportVo;
import com.yuepeng.web.manage.count.service.DataCrawlerReportService;
import com.yuepeng.web.manage.log.bean.vo.AppLogSearchVo;
import com.yuepeng.web.manage.log.bean.vo.DataCrawlerLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 每日爬取统计报表 Controller
 */
@RequestMapping("/manage/count/")
@Controller
public class DataCrawlerReportController extends BaseController {


    @Autowired
    private DataCrawlerReportService dataCrawlerReportService;

    @Resource
    private ILogService logService;

    /**
     * 每日爬取统计报表-分页
     * @param paramBean
     * @param dataCrawlerReportVo
     * @return
     * @throws Exception
     */
    @RequestMapping("queryDataCrawlerReportList" + WebConstant.PAGE_SUFFIX)
    public String queryDataCrawlerReportList(Pagination<DataCrawlerReportVo> paramBean, DataCrawlerReportVo dataCrawlerReportVo) throws Exception{
        paramBean.setSearch(dataCrawlerReportVo);
        Pagination<DataCrawlerReportVo> pageData = dataCrawlerReportService.queryDataCrawlerReportList(paramBean);
        this.addAttr("pageData", pageData);
        //数据回显
        DataCrawlerReportVo searchDataShow = this.dataShow(dataCrawlerReportVo);
        if(searchDataShow != null){
            this.addAttr("searchDataShow", searchDataShow);
        }
        return "count/everydayCrawlerReport";
    }

    /**
     * 每日爬取统计报表 -导出
     * @param paramBean
     * @param dataCrawlerReportVo
     * @return
     * @throws Exception
     */
    @RequestMapping("exportDataCrawlerReportList" + WebConstant.BUSINESS_SUFFIX)
    public String exportDataCrawlerReportList(Pagination<DataCrawlerReportVo> paramBean, DataCrawlerReportVo dataCrawlerReportVo) throws Exception {
        paramBean.setSearch(dataCrawlerReportVo);
        Pagination<TDataCrawlerReportExcel> list = dataCrawlerReportService.exportDataCrawlerReportList(paramBean);
        logService.addLog(new TSysLog("每日爬取统计报表-导出", "导出每日爬取统计报表！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "每日爬取统计报表" + String.format("%1$tY%1$tm%1$td", new Date()), TDataCrawlerReportExcel.class, list.getData());
        return null;
    }

    //数据回显
    private DataCrawlerReportVo dataShow(DataCrawlerReportVo dataCrawlerReportVo) throws Exception {
        DataCrawlerReportVo resDataShowDataCrawlerReportVo = null;
        if (dataCrawlerReportVo != null){
            resDataShowDataCrawlerReportVo = new DataCrawlerReportVo();

            //初始化爬取开始时间、结束时间
            resDataShowDataCrawlerReportVo = this.initSearchForm(dataCrawlerReportVo, resDataShowDataCrawlerReportVo);

            if (dataCrawlerReportVo.getProjectType() != null){
                resDataShowDataCrawlerReportVo.setProjectType(dataCrawlerReportVo.getProjectType());
            }
            if (dataCrawlerReportVo.getStartDateTime() != null ){
                resDataShowDataCrawlerReportVo.setStartDateTime(dataCrawlerReportVo.getStartDateTime());
            }
            if (dataCrawlerReportVo.getEndDateTime() != null ){
                resDataShowDataCrawlerReportVo.setEndDateTime(dataCrawlerReportVo.getEndDateTime());
            }
        }
        return resDataShowDataCrawlerReportVo;
    }

    //第一次访问初始化搜索表单 爬虫执行时间、结束时间
    private DataCrawlerReportVo initSearchForm(DataCrawlerReportVo dataCrawlerReportVo, DataCrawlerReportVo resDataCrawlerReportVo) throws ParseException {
        if(dataCrawlerReportVo.getStartDateTime() == null){
            Date startDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 00:00:00");
            startDateTime.setMonth(startDateTime.getMonth()-1);
            resDataCrawlerReportVo.setStartDateTime(startDateTime);
        }
        if(dataCrawlerReportVo.getEndDateTime() == null){
            Date endDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 23:59:59");
            resDataCrawlerReportVo.setEndDateTime(endDateTime);
        }
        return resDataCrawlerReportVo;
    }
}
