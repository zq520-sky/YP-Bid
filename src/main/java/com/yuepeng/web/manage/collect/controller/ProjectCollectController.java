package com.yuepeng.web.manage.collect.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.collect.bean.excel.ProjectCollectEntity;
import com.yuepeng.web.manage.collect.bean.vo.ProjectCollectVo;
import com.yuepeng.web.manage.collect.service.IProjectCollectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 客户订阅Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/18 10:09
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/collect/")
public class ProjectCollectController extends BaseController {
    @Resource
    private IProjectCollectService projectCollectService;

    @Resource
    private ILogService logService;

    /**
     * @Author ZhongShengbin
     * @Description //TODO 收藏项目分页
     * @Date 2020/5/18 0018
     * @Param [paramBean, projectCollectVo]
     * @return java.lang.String
     **/
    @RequestMapping("project/queryProjectList"+ WebConstant.PAGE_SUFFIX)
    public String queryProjectList(Pagination<ProjectCollectVo> paramBean, ProjectCollectVo projectCollectVo) throws Exception{
        paramBean.setSearch(projectCollectVo);
        Pagination<ProjectCollectVo> pageData = projectCollectService.queryCollectPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "collect/custProjectCollect";
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 收藏项目导出
     * @Date 2020/5/18 0018
     * @Param [paramBean, projectCollectVo]
     * @return java.lang.String
     **/
    @RequestMapping("project/exportProjectList" + WebConstant.BUSINESS_SUFFIX)
    public String exportCollectList(Pagination<ProjectCollectVo> paramBean, ProjectCollectVo projectCollectVo) throws Exception {
        paramBean.setSearch(projectCollectVo);
        Pagination<ProjectCollectEntity> list = projectCollectService.exportCollectPageList(paramBean);
        logService.addLog(new TSysLog("客户收藏管理-导出", "导出客户收藏信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response,"客户收藏管理" + String.format("%1$tY%1$tm%1$td", new Date()), ProjectCollectEntity.class, list.getData());
        return null;
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 收藏项目查看
     * @Date 2020/5/18 0018
     * @Param [collectId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("project/viewProjectCollect" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewProject(Integer collectId) throws Exception {
        ProjectCollectVo projectCollectVo = projectCollectService.queryCollectPageListById(collectId);
        return this.getResultMap(true, projectCollectVo);
    }
}
