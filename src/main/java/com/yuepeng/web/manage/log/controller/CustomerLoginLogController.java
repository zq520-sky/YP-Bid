package com.yuepeng.web.manage.log.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.log.bean.excel.CustomerLoginLogExcel;
import com.yuepeng.web.manage.log.bean.vo.AppLogLoginVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerMesVo;
import com.yuepeng.web.manage.log.bean.vo.ResultVo;
import com.yuepeng.web.manage.log.service.AppLogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description:  客户登录日志 Controller
 * @Author: xtq
 * @Date: 2020/5/27 14:47
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/log/")
public class CustomerLoginLogController extends BaseController {

    @Autowired
    private AppLogLoginService appLogLoginService;

    @Resource
    private ILogService logService;

    /**
     * 查询客户登录日志表 -分页list
     * @param paramBean
     * @param appLogLoginVo
     * @return
     * @throws Exception
     */
    @RequestMapping("queryAppLogLoginList" + WebConstant.PAGE_SUFFIX)
    public String queryAppLogLoginList(Pagination<AppLogLoginVo> paramBean, AppLogLoginVo appLogLoginVo) throws Exception{
        paramBean.setSearch(appLogLoginVo);
        Pagination<AppLogLoginVo> pageData = appLogLoginService.queryAppLogLoginList(paramBean);
        this.addAttr("pageData", pageData);
        //搜索数据回显
        AppLogLoginVo searchDataShow = this.dataShow(appLogLoginVo);
        if(searchDataShow != null){
            this.addAttr("searchDataShow", searchDataShow);
        }
        return "log/custLoginLog";
    }


    /**
     * 导出客户登录日志
     * @param paramBean
     * @param appLogLoginVo
     * @return
     * @throws Exception
     */
    @RequestMapping("exportCustLoginLogList" + WebConstant.BUSINESS_SUFFIX)
    public String exportCustLoginLogList(Pagination<AppLogLoginVo> paramBean, AppLogLoginVo appLogLoginVo) throws Exception {
        paramBean.setSearch(appLogLoginVo);
        Pagination<CustomerLoginLogExcel> list = appLogLoginService.exportCustLoginLogList(paramBean);
        logService.addLog(new TSysLog("客户登录日志-导出", "导出客户登录日志！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "客户登录日志" + String.format("%1$tY%1$tm%1$td", new Date()), CustomerLoginLogExcel.class, list.getData());
        return null;
    }

    /**
     * 通过logLoginId查询客户相关信息
     * @param logLoginId
     * @return
     */
    @RequestMapping("queryCstMsgByLogLoginId"  + WebConstant.PAGE_SUFFIX)
    @ResponseBody
    public ResultVo<AppLogLoginVo> queryCstMsgByLogLoginId(Integer logLoginId){
        AppLogLoginVo appLogLoginVo = appLogLoginService.queryCstMsgByLogLoginId(logLoginId);
        if(appLogLoginVo != null){
            return new ResultVo<AppLogLoginVo>(true,"success",appLogLoginVo);
        }
        return new ResultVo<AppLogLoginVo>(false,"error",null);
    }

    //前端页面 数据回显 私有方法
    private AppLogLoginVo dataShow(AppLogLoginVo appLogLoginVo){
        AppLogLoginVo dataShowAppLogLoginVo = null;
        if (appLogLoginVo != null){
            dataShowAppLogLoginVo = new AppLogLoginVo();
            if (appLogLoginVo.getCustCode() != null && appLogLoginVo.getCustCode().length() > 0){
                dataShowAppLogLoginVo.setCustCode(appLogLoginVo.getCustCode());
            }
            if (appLogLoginVo.getMobile() != null && appLogLoginVo.getMobile().length() > 0){
                dataShowAppLogLoginVo.setMobile(appLogLoginVo.getMobile());
            }
            if(appLogLoginVo.getLoginIp() != null && appLogLoginVo.getLoginIp().length() > 0){
                dataShowAppLogLoginVo.setLoginIp(appLogLoginVo.getLoginIp());
            }
            if(appLogLoginVo.getLoginType() != null){
                dataShowAppLogLoginVo.setLoginType(appLogLoginVo.getLoginType());
            }
        }
        return dataShowAppLogLoginVo;
    }

}
