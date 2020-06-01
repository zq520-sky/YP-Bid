package com.yuepeng.web.manage.log.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.log.bean.excel.CustomerSearchLogExcel;
import com.yuepeng.web.manage.log.bean.vo.*;
import com.yuepeng.web.manage.log.service.AppLogSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 客户搜索日志 Controller
 * @Author: xtq
 * @Date: 2020/5/27 14:47
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/log/")
public class CustomerSearchLogController extends BaseController {

    @Autowired
    private AppLogSearchService appLogSearchService;

    @Resource
    private ILogService logService;

    /**
     * 查询客户搜索日志表 -分页list
     * @param paramBean
     * @param appLogSearchVo
     * @return
     * @throws Exception
     */
    @RequestMapping("queryAppLogSearchList" + WebConstant.PAGE_SUFFIX)
    public String queryAppLogSearchList(Pagination<AppLogSearchVo> paramBean, AppLogSearchVo appLogSearchVo) throws Exception{
        paramBean.setSearch(appLogSearchVo);
        Pagination<AppLogSearchVo> pageData = appLogSearchService.queryAppLogSearchList(paramBean);
        this.addAttr("pageData", pageData);
        //搜索数据回显
        AppLogSearchVo searchDataShow = this.dataShow(appLogSearchVo);
        if(searchDataShow != null){
            this.addAttr("searchDataShow", searchDataShow);
        }
        return "log/custSearchLog";
    }


    /**
     * 导出客户搜索日志
     * @param paramBean
     * @param appLogSearchVo
     * @return
     * @throws Exception
     */
    @RequestMapping("exportCustSearchLogList" + WebConstant.BUSINESS_SUFFIX)
    public String exportCustLoginLogList(Pagination<AppLogSearchVo> paramBean, AppLogSearchVo appLogSearchVo) throws Exception {
        paramBean.setSearch(appLogSearchVo);
        Pagination<CustomerSearchLogExcel> list = appLogSearchService.exportCustSearchLogList(paramBean);
        logService.addLog(new TSysLog("客户搜索记录-导出", "导出客户搜索记录！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "客户搜索记录" + String.format("%1$tY%1$tm%1$td", new Date()), CustomerSearchLogExcel.class, list.getData());
        return null;
    }

    /**
     * 通过logSearchId查看客户搜索记录相关信息
     * @param logSearchId
     * @return
     */
    @RequestMapping("/queryCstMsgBySearchId" + WebConstant.PAGE_SUFFIX)
    @ResponseBody
    public ResultVo<CustomerSearchLookVo> queryCstMsgBySearchId(Integer logSearchId){
        CustomerSearchLookVo resCustomerSearchLookVo = appLogSearchService.queryCstMsgBySearchId(logSearchId);
        if(resCustomerSearchLookVo != null){
            return new ResultVo(true,"success",resCustomerSearchLookVo);
        }
        return new ResultVo(false,"error",resCustomerSearchLookVo);
    }

    //前端页面 数据回显 私有方法
    private AppLogSearchVo dataShow(AppLogSearchVo appLogSearchVo){
        AppLogSearchVo dataShowAppLogSearchVo = null;
        if (appLogSearchVo != null){
            dataShowAppLogSearchVo = new AppLogSearchVo();
            if (appLogSearchVo.getCustCode() != null && appLogSearchVo.getCustCode().length() > 0){
                dataShowAppLogSearchVo.setCustCode(appLogSearchVo.getCustCode());
            }
            if (appLogSearchVo.getMobile() != null && appLogSearchVo.getMobile().length() > 0){
                dataShowAppLogSearchVo.setMobile(appLogSearchVo.getMobile());
            }

        }
        return dataShowAppLogSearchVo;
    }
}
