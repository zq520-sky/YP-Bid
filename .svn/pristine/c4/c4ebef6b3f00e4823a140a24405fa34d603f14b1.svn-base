package com.yuepeng.web.manage.collect.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.collect.bean.excel.CompanyCollectEntity;
import com.yuepeng.web.manage.collect.bean.vo.CompanyCollectVo;
import com.yuepeng.web.manage.collect.service.ICompanyCollectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 客户收藏企业Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/18 15:04
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/collect/")
public class CompanyCollectController extends BaseController {

    @Resource
    private ICompanyCollectService companyCollectService;

    @Resource
    private ILogService logService;

    /**
     * @Author ZhongShengbin
     * @Description //TODO 收藏公司分页
     * @Date 2020/5/18 0018
     * @Param [paramBean, companyCollectVo]
     * @return java.lang.String
     **/
    @RequestMapping("company/queryCompanyList"+ WebConstant.PAGE_SUFFIX)
    public String queryCompanyList(Pagination<CompanyCollectVo> paramBean, CompanyCollectVo companyCollectVo) throws Exception{
        paramBean.setSearch(companyCollectVo);
        Pagination<CompanyCollectVo> pageData = companyCollectService.queryCompanyPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "collect/custCompanyCollect";
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 收藏公司导出
     * @Date 2020/5/18 0018
     * @Param [paramBean, companyCollectVo]
     * @return java.lang.String
     **/
    @RequestMapping("company/exportCompanyList" + WebConstant.BUSINESS_SUFFIX)
    public String exportCollectList(Pagination<CompanyCollectVo> paramBean, CompanyCollectVo companyCollectVo) throws Exception {
        paramBean.setSearch(companyCollectVo);
        Pagination<CompanyCollectEntity> list = companyCollectService.exportCompanyPageList(paramBean);
        logService.addLog(new TSysLog("客户收藏企业管理-导出", "导出客户收藏企业信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response,"客户收藏企业管理" + String.format("%1$tY%1$tm%1$td", new Date()), CompanyCollectEntity.class, list.getData());
        return null;
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 收藏公司查看
     * @Date 2020/5/18 0018
     * @Param [projectCompanyId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("company/viewCompanyCollect" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewProject(Integer projectCompanyId) throws Exception {
        CompanyCollectVo companyCollectVo = companyCollectService.queryCompanyPageListById(projectCompanyId);
        return this.getResultMap(true, companyCollectVo);
    }
}
