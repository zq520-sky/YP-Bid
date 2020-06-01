package com.yuepeng.web.manage.log.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.log.bean.excel.CustomerVisitLogExcel;
import com.yuepeng.web.manage.log.bean.vo.*;
import com.yuepeng.web.manage.log.service.CustomerVisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description: 客户查看记录 Controller
 * @Author: xtq
 * @Date: 2020/5/28 14:10
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/log/")
public class CustomerVisitLogController extends BaseController {

    @Autowired
    private CustomerVisitLogService customerVisitLogService;

    @Resource
    private ILogService logService;

    /**
     * 查询-客户查看记录 list
     * @param paramBean
     * @param customerVisitLogVo
     * @return
     * @throws Exception
     */
    @RequestMapping("queryCstVisitLogList" + WebConstant.PAGE_SUFFIX)
    public String queryCstVisitLogList(Pagination<CustomerVisitLogVo> paramBean, CustomerVisitLogVo customerVisitLogVo) throws Exception{
        paramBean.setSearch(customerVisitLogVo);
        Pagination<CustomerVisitLogVo> pageData = customerVisitLogService.queryCstVisitLogList(paramBean);
        this.addAttr("pageData", pageData);
        //搜索数据回显
        CustomerVisitLogVo searchDataShow = this.dataShow(customerVisitLogVo);
        //搜索数据回显
        if(searchDataShow != null){
            this.addAttr("searchDataShow", searchDataShow);
        }
        return "log/custVisitLog";
    }

    /**
     * 导出-客户查看记录
     * @param paramBean
     * @param customerVisitLogVo
     * @return
     * @throws Exception
     */
    @RequestMapping("exportCstVisitLogList" + WebConstant.BUSINESS_SUFFIX)
    public String exportCstVisitLogList(Pagination<CustomerVisitLogVo> paramBean, CustomerVisitLogVo customerVisitLogVo) throws Exception {
        paramBean.setSearch(customerVisitLogVo);
        Pagination<CustomerVisitLogExcel> list = customerVisitLogService.exportCstVisitLogList(paramBean);
        logService.addLog(new TSysLog("客户查看记录-导出", "导出客户查看记录成功！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "客户查看记录" + String.format("%1$tY%1$tm%1$td", new Date()), CustomerVisitLogExcel.class, list.getData());
        return null;
    }



    /**
     * 通过客户id  visitId 查询客户相关信息
     * @param visitId
     * @return
     */
    @RequestMapping("/queryCstMsgByVisitId" + WebConstant.PAGE_SUFFIX)
    @ResponseBody
    public ResultVo<CustomerVisitLookVo> queryCstMsgByVisitId(Integer visitId){
        CustomerVisitLookVo resCustomerVisitLookVo = customerVisitLogService.queryCstMsgByVisitId(visitId);
        if(resCustomerVisitLookVo != null){
            return new ResultVo(true,"success",resCustomerVisitLookVo);
        }
        return new ResultVo(false,"error",resCustomerVisitLookVo);
    }

    //前端页面 数据回显 私有方法
    private CustomerVisitLogVo dataShow(CustomerVisitLogVo customerVisitLogVo){
        CustomerVisitLogVo dataShowCustomerVisitLogVo = null;
        if (customerVisitLogVo != null){
            dataShowCustomerVisitLogVo = new CustomerVisitLogVo();
            if (customerVisitLogVo.getCustCode() != null && customerVisitLogVo.getCustCode().length() > 0){
                dataShowCustomerVisitLogVo.setCustCode(customerVisitLogVo.getCustCode());
            }
            if (customerVisitLogVo.getMobile() != null && customerVisitLogVo.getMobile().length() > 0){
                dataShowCustomerVisitLogVo.setMobile(customerVisitLogVo.getMobile());
            }

        }
        return dataShowCustomerVisitLogVo;
    }
}
