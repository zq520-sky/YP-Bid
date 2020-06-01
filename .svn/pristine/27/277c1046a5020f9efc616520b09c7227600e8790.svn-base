package com.yuepeng.web.manage.project.controller;

import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.web.manage.project.bean.entity.TProjectCompany;
import com.yuepeng.web.manage.project.bean.vo.ProjectCompanyVo;
import com.yuepeng.web.manage.project.bean.excel.ProjectCompanyExcel;
import com.yuepeng.web.manage.project.constants.ProjectExpCodeConstant;
import com.yuepeng.web.manage.project.service.IProjectCompanyService;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.pm.service.ILogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 招标单位信息表(ProjectCompany)表控制层
 *
 * @author wzq
 * @since 2020-05-22 11:01:33
 */
@Controller
@RequestMapping("/manage/project/company")
public class ProjectCompanyController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private IProjectCompanyService projectCompanyService;
    
    @Resource
    private ILogService logService;

    private SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
    private SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("queryCompanyList" + WebConstant.PAGE_SUFFIX)
    public String queryProjectCompanyPageList(Pagination<ProjectCompanyVo> paramBean, ProjectCompanyVo projectCompanyVo) throws Exception{
        if (projectCompanyVo.getUpdateDateBegin() == null) {
            projectCompanyVo.setUpdateDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (projectCompanyVo.getUpdateDateEnd() == null) {
            projectCompanyVo.setUpdateDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(projectCompanyVo);
        Pagination<ProjectCompanyVo> pageData = projectCompanyService.queryProjectCompanyPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "project/projectCompanyManage";
    }

    @RequestMapping("/exportCompanyList" + WebConstant.BUSINESS_SUFFIX)
    public String exportProjectCompanyList(Pagination<TProjectCompany> paramBean, ProjectCompanyVo projectCompanyVo) throws Exception {
        if (projectCompanyVo.getUpdateDateBegin() == null) {
            projectCompanyVo.setUpdateDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (projectCompanyVo.getUpdateDateEnd() == null) {
            projectCompanyVo.setUpdateDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(projectCompanyVo);
        Pagination<ProjectCompanyExcel> list = projectCompanyService.exportProjectCompanyPageList(paramBean);
        logService.addLog(new TSysLog("招标单位管理-导出", "导出招标单位信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "招标单位信息" + String.format("%1$tY%1$tm%1$td", new Date()), ProjectCompanyExcel.class, list.getData());
        return null;
    }

    
    @RequestMapping("viewCompany" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewProjectCompany(Integer projectCompanyId) throws Exception {
        ProjectCompanyVo projectCompanyVo = projectCompanyService.viewProjectCompany(projectCompanyId);
        return this.getResultMap(true, projectCompanyVo);
    }


    @RequestMapping("addCompany" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addProjectCompany(ProjectCompanyVo projectCompanyVo) throws Exception {
        projectCompanyVo.setUpdateDate(new Date());
        boolean insert = projectCompanyService.insertSelective(projectCompanyVo);
        if (insert) {
            logService.addLog(new TSysLog("招标单位管理-新增", "新增招标单位信息【" + projectCompanyVo.getProjectCompanyName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("招标单位管理-新增", "新增招标单位信息【" + projectCompanyVo.getProjectCompanyName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!insert) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_COMPANY_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, projectCompanyVo);
    }

    @RequestMapping("updateCompany" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateProjectCompany(ProjectCompanyVo projectCompanyVo) throws Exception {
        if(projectCompanyVo.getProjectCompanyId() == null) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_COMPANY_EDIT_ID_ERROR);
        }

        boolean result = projectCompanyService.updateSelectiveById(projectCompanyVo);
        if (result) {
            logService.addLog(new TSysLog("招标单位管理-编辑", "编辑招标单位信息【" + projectCompanyVo.getProjectCompanyName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("招标单位管理-编辑", "编辑招标单位信息【" + projectCompanyVo.getProjectCompanyName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_COMPANY_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, projectCompanyVo);
    }

    @RequestMapping("delCompany" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> delProjectCompany(ProjectCompanyVo projectCompanyVo) throws Exception {
        if(projectCompanyVo.getProjectCompanyId() == null) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_COMPANY_EDIT_ID_ERROR);
        }

        boolean result = projectCompanyService.delProjectCompany(projectCompanyVo.getProjectCompanyId());
        if (result) {
            logService.addLog(new TSysLog("招标单位管理-删除", "删除招标单位【" + projectCompanyVo.getProjectCompanyName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("招标单位管理-删除", "删除招标单位【" + projectCompanyVo.getProjectCompanyName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_COMPANY_DEL_ERROR);
        }
        return this.getResultMap(true, result);
    }

}