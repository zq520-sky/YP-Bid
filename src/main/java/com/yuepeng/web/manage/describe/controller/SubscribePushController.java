package com.yuepeng.web.manage.describe.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribePushEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribePushVo;
import com.yuepeng.web.manage.describe.service.ISubscribePushService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 客户订阅推送Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/19 16:13
 * Copyright (c) 2019, Samton. All rights reserved
 */
@RequestMapping("/manage/subscribe/")
@Controller
public class SubscribePushController extends BaseController {

    @Resource
    private ISubscribePushService subscribePushService;

    @Resource
    private ILogService logService;
    /**
     * @Author ZhongShengbin
     * @Description  客户订阅推送分页
     * @Date 2020/5/19 0019
     * @Param [paramBean, subscribeSearchVo]
     * @return java.lang.String
     **/
    @RequestMapping("push/querySubscribePushList"+ WebConstant.PAGE_SUFFIX)
    public String querySubscribePushList(Pagination<SubscribePushVo> paramBean, SubscribePushVo subscribeSearchVo) throws Exception{
        paramBean.setSearch(subscribeSearchVo);
        Pagination<SubscribePushVo> pageData = subscribePushService.querySubscribePushPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "describe/custDescribeSearchPush";
    }

    /**
     * @Author ZhongShengbin
     * @Description客户订阅推送导出
     * @Date 2020/5/19 0019
     * @Param [paramBean, subscribeSearchVo]
     * @return java.lang.String
     **/
    @RequestMapping("push/exportSubscribePushList" + WebConstant.BUSINESS_SUFFIX)
    public String exportSubscribePushList(Pagination<SubscribePushVo> paramBean, SubscribePushVo subscribeSearchVo) throws Exception {
        paramBean.setSearch(subscribeSearchVo);
        Pagination<custSubscribePushEntity> list = subscribePushService.exportSubscribePushPageList(paramBean);
        logService.addLog(new TSysLog("客户订阅查询-导出", "导出客户订阅查询信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response,"客户订阅查询管理" + String.format("%1$tY%1$tm%1$td", new Date()), custSubscribePushEntity.class, list.getData());
        return null;
    }

    /**
     * @Author ZhongShengbin
     * @Description 客户订阅推送查看
     * @Date 2020/5/19 0019
     * @Param [subscribeSearchId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("push/viewSubscribePush" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewSubscribePush(Integer searchPushId) throws Exception {
        SubscribePushVo subscribeSearchVo = subscribePushService.querySubscribePushPageListById(searchPushId);
        return this.getResultMap(true, subscribeSearchVo);
    }
}
