package com.yuepeng.web.manage.project.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.project.bean.entity.TProject;
import com.yuepeng.web.manage.project.bean.excel.ProjectExcel;
import com.yuepeng.web.manage.project.bean.vo.ProjectVo;
import com.yuepeng.web.manage.project.constants.ProjectExpCodeConstant;
import com.yuepeng.web.manage.project.service.IProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 招标项目信息表(Project)表控制层
 *
 * @author wzq
 * @since 2020-05-19 09:41:14
 */
@Controller
@RequestMapping("/manage/project/info")
public class ProjectController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private IProjectService projectService;

    @Resource
    private ILogService logService;

    private SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
    private SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 项目信息管理分页
     *
     * @param paramBean
     * @param projectVo
     * @return {@link String}
     * @author wzq
     * @date 2020/5/19 10:56
     */
    @RequestMapping("queryProjectInfoList" + WebConstant.PAGE_SUFFIX)
    public String queryProjectPageList(Pagination<ProjectVo> paramBean, ProjectVo projectVo) throws Exception {
        if(projectVo.getSearchType() == null){
            projectVo.setSearchType(1);
        }
        if (projectVo.getAddDateBegin() == null) {
            projectVo.setAddDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (projectVo.getAddDateEnd() == null) {
            projectVo.setAddDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(projectVo);
        Pagination<ProjectVo> pageData = projectService.queryProjectPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "project/projectManage";
    }

    /**
     * 项目信息导出
     *
     * @param paramBean
     * @param projectVo
     * @return {@link String}
     * @author wzq
     * @date 2020/5/19 10:57
     */
    @RequestMapping("/exportProjectInfoList" + WebConstant.BUSINESS_SUFFIX)
    public String exportProjectList(Pagination<TProject> paramBean, ProjectVo projectVo) throws Exception {
        paramBean.setSearch(projectVo);
        Pagination<ProjectExcel> list = projectService.exportProjectPageList(paramBean);
        logService.addLog(new TSysLog("项目信息管理-导出", "导出项目信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "项目信息" + String.format("%1$tY%1$tm%1$td", new Date()), ProjectExcel.class, list.getData());
        return null;
    }


    @RequestMapping("viewProjectInfo" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewProject(Integer projectId) throws Exception {
        ProjectVo projectVo = projectService.viewProject(projectId);
        return this.getResultMap(true, projectVo);
    }

    @RequestMapping("delProjectInfo" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> delProject(ProjectVo projectVo) throws Exception {
        //校验主键ID
        if (projectVo.getProjectId() == null) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_EDIT_ID_ERROR);
        }
        //执行删除
        boolean result = projectService.deleteById(projectVo.getProjectId());
        if (result) {
            logService.addLog(new TSysLog("项目信息管理-删除", "删除项目信息【" + projectVo.getProjectCode() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("项目信息管理-删除", "删除项目信息【" + projectVo.getProjectCode() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_DEL_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * 编辑详情
     * @param projectVo
     * @author wzq
     * @date 2020/5/20 11:50
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("updateDetail" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateDetail(ProjectVo projectVo) throws Exception {
        //校验主键ID
        if (projectVo.getProjectId() == null) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_EDIT_ID_ERROR);
        }
        //执行
        boolean result = projectService.updateSelectiveById(projectVo);
        if (result) {
            logService.addLog(new TSysLog("项目信息管理-编辑详情", "编辑项目详情【" + projectVo.getProjectCode() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("项目信息管理-编辑详情", "编辑项目详情【" + projectVo.getProjectCode() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * 编辑项目信息
     * @param projectVo
     * @author wzq
     * @date 2020/5/20 11:50
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("updateProjectInfo" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateProjectInfo(ProjectVo projectVo) throws Exception {
        //校验主键ID
        if (projectVo.getProjectId() == null) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_EDIT_ID_ERROR);
        }
        //执行
        boolean result = projectService.updateProjectInfo(projectVo);
        if (result) {
            logService.addLog(new TSysLog("项目信息管理-编辑详情", "编辑项目详情【" + projectVo.getProjectCode() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("项目信息管理-编辑详情", "编辑项目详情【" + projectVo.getProjectCode() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }

}