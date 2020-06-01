package com.yuepeng.web.manage.planProject.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanProject;
import com.yuepeng.web.manage.planProject.bean.excel.PlanProjectEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanProjectVo;
import com.yuepeng.web.manage.planProject.constants.PlanProjectExpCodeConstant;
import com.yuepeng.web.manage.planProject.service.IPlanProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 版本控制
 * @Author: ZhongShengbin
 * @Date: 2020/05/22 15:57
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/planproject/")
public class PlanProjectController extends BaseController {

    @Resource
    private IPlanProjectService planProjectService;

    @Resource
    private ILogService logService;

    private SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
    private SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @return java.lang.String
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/18 0018
     * @Param [paramBean, searchHotwordVo]
     **/
    @RequestMapping("info/queryPlanprojectList" + WebConstant.PAGE_SUFFIX)
    public String queryPlanList(Pagination<PlanProjectVo> paramBean, PlanProjectVo planProjectVo) throws Exception {
        if (planProjectVo.getSearchType() == null) {
            planProjectVo.setSearchType(1);
        }
        if (planProjectVo.getCreateDateBegin() == null) {
            planProjectVo.setCreateDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (planProjectVo.getCreateDateEnd() == null) {
            planProjectVo.setCreateDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(planProjectVo);
        Pagination<PlanProjectVo> pageData = planProjectService.queryPlanPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "plan/planManage";
    }

    /**
     * @return java.lang.String
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/27 0027
     * @Param [paramBean, searchHotwordVo]
     **/
    @RequestMapping("info/exportPlanprojecList" + WebConstant.BUSINESS_SUFFIX)
    public String exporPlanList(Pagination<PlanProjectVo> paramBean, PlanProjectVo planProjectVo) throws Exception {
        if (planProjectVo.getSearchType() == null) {
            planProjectVo.setSearchType(1);
        }
        if (planProjectVo.getCreateDateBegin() == null) {
            planProjectVo.setCreateDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (planProjectVo.getCreateDateEnd() == null) {
            planProjectVo.setCreateDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(planProjectVo);
        Pagination<PlanProjectEntity> list = planProjectService.exportPlanPageList(paramBean);
        logService.addLog(new TSysLog("拟建项目信息-导出", "导出拟建项目信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "拟建项目信息" + String.format("%1$tY%1$tm%1$td", new Date()), PlanProjectEntity.class, list.getData());
        return null;
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/27 0027
     * @Param [planProjectId]
     **/
    @RequestMapping("info/viewPlanproject" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewPlanProject(Integer planProjectId) throws Exception {
        PlanProjectVo planProjectVo = planProjectService.queryPlanPageListById(planProjectId);
        return this.getResultMap(true, planProjectVo);
    }


    @RequestMapping("info/updatePlanproject" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updatePlanProject(TPlanProject planProject) throws Exception {
        if (planProject.getPlanProjectId() == null) {
            throw new ServiceException(PlanProjectExpCodeConstant.PLAN_EDIT_ERROR);
        }
        boolean result = planProjectService.updateSelectiveById(planProject);
        if (result) {
            if (result) {
                logService.addLog(new TSysLog("拟建项目信息-编辑", "编辑拟建项目信息【" + planProject.getProjectName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("拟建项目信息-编辑", "编辑拟建项目信息【" + planProject.getProjectName() + "】失败 ！", PmStateConstant.LOG_PLATFORM));
            }
            if (!result) {
                throw new ServiceException(PlanProjectExpCodeConstant.REQUEST_RESUBMIT_ERROR);
            }
        }
        return this.getResultMap(true, result);
    }


    @RequestMapping("info/delPlanProject" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> deletePlan(@RequestParam(value = "planProjectId", required = true) Integer versionId) throws Exception {
        boolean result = planProjectService.deleteById(versionId);
        if (result) {
            if (result) {
                logService.addLog(new TSysLog("拟建项目信息-删除", "删除版本信息成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("拟建项目信息-删除", "删除版本信息失败 ！", PmStateConstant.LOG_PLATFORM));
            }
            if (!result) {
                throw new ServiceException(PlanProjectExpCodeConstant.PLAN_TYPE_VIEW_ERROR);
            }
        }
        return this.getResultMap(true, result);
    }


    @RequestMapping("info/addPlanProject" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addPlan(PlanProjectVo planProjectVo) throws Exception {
        planProjectVo.setAddDate(new Date());
        boolean result = planProjectService.insertSelective(planProjectVo);
        if (result) {
            logService.addLog(new TSysLog("拟建项目信息-新增", "新增拟建项目信息【" + planProjectVo.getProjectName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("拟建项目信息-新增", "新增拟建项目信息【" + planProjectVo.getProjectName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(PlanProjectExpCodeConstant.PLAN_ADD_ERROR);
        }
        return this.getResultMap(true, result);
    }

    //编辑详情
    @RequestMapping("info/updateDetail" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateDetail(PlanProjectVo planProjectVo) throws Exception {
        //校验主键ID
        if (planProjectVo.getPlanProjectId() == null) {
            throw new ServiceException(PlanProjectExpCodeConstant.PLAN_EDIT_ERROR);
        }
        //执行
        boolean result = planProjectService.updateSelectiveById(planProjectVo);
        if (result) {
            logService.addLog(new TSysLog("拟建项目信息-编辑详情", "编辑拟建项目详情【" + planProjectVo.getProjectCode() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("拟建项目信息-编辑详情", "编辑拟建项目详情【" + planProjectVo.getProjectCode() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(PlanProjectExpCodeConstant.PLAN_TYPE_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }
}
