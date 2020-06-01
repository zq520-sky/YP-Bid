package com.yuepeng.web.manage.customer.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.customer.bean.entity.TProjectKeywordCollect;
import com.yuepeng.web.manage.customer.bean.excel.ProjectKeywordCollectExcel;
import com.yuepeng.web.manage.customer.bean.vo.ProjectKeywordCollectVo;
import com.yuepeng.web.manage.customer.service.IProjectKeywordCollectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 * 客户项目关键词控制层
 *
 * @className: ProjectKeywordCollectController
 * @package: com.yuepeng.web.manage.customer.controller
 * @author: wzq
 * @date: 2020/5/13 16:24
 */
@Controller
@RequestMapping("/manage/customer/keyword")
public class ProjectKeywordCollectController extends BaseController {

    @Resource
    private IProjectKeywordCollectService projectKeywordCollectService;

    @Resource
    private ILogService logService;

    /**
     * 客户项目关键词分页
     *
     * @param paramBean
     * @param projectKeywordCollectVo
     * @return {@link String}
     * @author wzq
     * @date 2020/5/13 16:28
     */
    @RequestMapping("/queryKeywordList" + WebConstant.PAGE_SUFFIX)
    public String queryMemberList(Pagination<ProjectKeywordCollectVo> paramBean, ProjectKeywordCollectVo projectKeywordCollectVo) throws Exception {
        paramBean.setSearch(projectKeywordCollectVo);
        Pagination<ProjectKeywordCollectVo> pageData = projectKeywordCollectService.queryKeywordList(paramBean);
        this.addAttr("pageData", pageData);
        return "customer/projectKeywordManage";
    }

    /**
     * 导出客户项目关键词信息
     *
     * @param paramBean
     * @param projectKeywordCollectVo
     * @return {@link String}
     * @author wzq
     * @date 2020/5/13 16:31
     */
    @RequestMapping("/exportKeywordList" + WebConstant.BUSINESS_SUFFIX)
    public String exportMemberList(Pagination<TProjectKeywordCollect> paramBean, ProjectKeywordCollectVo projectKeywordCollectVo) throws Exception {
        paramBean.setSearch(projectKeywordCollectVo);
        Pagination<ProjectKeywordCollectExcel> list = projectKeywordCollectService.exportKeywordList(paramBean);
        logService.addLog(new TSysLog("客户项目关键词-导出", "导出客户项目关键词！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "客户项目关键词" + String.format("%1$tY%1$tm%1$td", new Date()), ProjectKeywordCollectExcel.class, list.getData());
        return null;
    }

    /**
     * 查看客户项目关键词信息
     *
     * @param keywordCollectId
     * @return {@link Map< String, Object>}
     * @author wzq
     * @date 2020/5/13 16:31
     */
    @RequestMapping("/viewKeyword" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewKeyword(Integer keywordCollectId) throws Exception {
        ProjectKeywordCollectVo projectKeywordCollectVo = projectKeywordCollectService.viewKeyword(keywordCollectId);
        return this.getResultMap(true, projectKeywordCollectVo);
    }
}
