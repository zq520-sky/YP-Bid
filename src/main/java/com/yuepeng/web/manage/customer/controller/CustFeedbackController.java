package com.yuepeng.web.manage.customer.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.customer.bean.excel.FeedbackExcel;
import com.yuepeng.web.manage.customer.bean.vo.FeedbackVo;
import com.yuepeng.web.manage.customer.service.impl.CustFeedbackServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 客户反馈Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/19 19:40
 * Copyright (c) 2019, Samton. All rights reserved
 */
@RequestMapping("/manage/customer/")
@Controller
public class CustFeedbackController extends BaseController {

    @Resource(name = "custFeedbackServiceImpl")
    private CustFeedbackServiceImpl feedbackService;

    @Resource
    private ILogService logService;
    /**
     * @Author ZhongShengbin
     * @Description  客户反馈分页
     * @Date 2020/5/19 0019
     * @Param [paramBean, subscribeSearchVo]
     * @return java.lang.String
     **/
    @RequestMapping("feedback/queryFeedBackList"+ WebConstant.PAGE_SUFFIX)
    public String queryFeedbackList(Pagination<FeedbackVo> paramBean, FeedbackVo subscribeSearchVo) throws Exception{
        paramBean.setSearch(subscribeSearchVo);
        Pagination<FeedbackVo> pageData = feedbackService.queryFeedbackPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "customer/custFeedback";
    }

    /**
     * @Author ZhongShengbin
     * @Description客户反馈导出
     * @Date 2020/5/19 0019
     * @Param [paramBean, subscribeSearchVo]
     * @return java.lang.String
     **/
    @RequestMapping("feedback/exportFeedBackList" + WebConstant.BUSINESS_SUFFIX)
    public String exportFeedbackList(Pagination<FeedbackVo> paramBean, FeedbackVo feedbackVo) throws Exception {
        paramBean.setSearch(feedbackVo);
        Pagination<FeedbackExcel> list = feedbackService.exportFeedbackPageList(paramBean);
        logService.addLog(new TSysLog("客户反馈-导出", "导出客户反馈信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response,"客户反馈管理" + String.format("%1$tY%1$tm%1$td", new Date()), FeedbackExcel.class, list.getData());
        return null;
    }

    /**
     * @Author ZhongShengbin
     * @Description 客户反馈查看
     * @Date 2020/5/19 0019
     * @Param [subscribeSearchId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("feedback/viewFeedBack" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewReturn(Integer feedbackId) throws Exception {
        FeedbackVo feedbackVo = feedbackService.queryFeedbackPageListById(feedbackId);
        return this.getResultMap(true, feedbackVo);
    }
}
