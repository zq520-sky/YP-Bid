package com.yuepeng.web.manage.describe.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribeSearchEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeSearchVo;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeVo;
import com.yuepeng.web.manage.describe.service.ISubscribeSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 客户订阅查询Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/19 14:04
 * Copyright (c) 2019, Samton. All rights reserved
 */
@RequestMapping("/manage/subscribe/")
@Controller
public class SubscribeSearchController extends BaseController {

    @Resource
    private ISubscribeSearchService subscribeSearchService;

    @Resource
    private ILogService logService;
    /**
     * @Author ZhongShengbin
     * @Description  客户订阅查询分页
     * @Date 2020/5/19 0019
     * @Param [paramBean, subscribeSearchVo]
     * @return java.lang.String
     **/
    @RequestMapping("search/querySubscribeSearchList"+ WebConstant.PAGE_SUFFIX)
    public String queryCustAccountList(Pagination<SubscribeSearchVo> paramBean, SubscribeSearchVo subscribeSearchVo) throws Exception{
        paramBean.setSearch(subscribeSearchVo);
        Pagination<SubscribeSearchVo> pageData = subscribeSearchService.querySubscribeSearchPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "describe/custDescribeSearch";
    }

    @RequestMapping("search/exportSubscribeSearchList" + WebConstant.BUSINESS_SUFFIX)
    public String exportCustAccountList(Pagination<SubscribeSearchVo> paramBean, SubscribeSearchVo subscribeSearchVo) throws Exception {
        paramBean.setSearch(subscribeSearchVo);
        Pagination<custSubscribeSearchEntity> list = subscribeSearchService.exportSubscribeSearchPageList(paramBean);
        logService.addLog(new TSysLog("客户订阅查询-导出", "导出客户订阅查询信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response,"客户订阅查询管理" + String.format("%1$tY%1$tm%1$td", new Date()), custSubscribeSearchEntity.class, list.getData());
        return null;
    }

    @RequestMapping("search/viewSubscribeSearch" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewReturn(Integer subscribeSearchId) throws Exception {
        SubscribeSearchVo subscribeSearchVo = subscribeSearchService.querySubscribeSearchPageListById(subscribeSearchId);
        return this.getResultMap(true, subscribeSearchVo);
    }
}
