package com.yuepeng.web.manage.dict.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.customer.constant.CustomerExpCodeConstant;
import com.yuepeng.web.manage.dict.bean.entity.TProjectKeyword;
import com.yuepeng.web.manage.dict.bean.excel.ProjectKeywordEntity;
import com.yuepeng.web.manage.dict.bean.vo.ProjectKeywordVo;
import com.yuepeng.web.manage.dict.constant.InfoTypeExpCodeConstant;
import com.yuepeng.web.manage.dict.service.IProjectKeywordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 字典管理-关键词管理Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/22 10:34
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/dict/")
public class ProjectKeywordController extends BaseController {

    @Resource
    private IProjectKeywordService iProjectKeywordService;

    @Resource
    private ILogService logService;

    /**
     * @Author ZhongShengbin
     * @Description 项目关键词分页
     * @Date 2020/5/18 0018
     * @Param [paramBean, searchHotwordVo]
     * @return java.lang.String
     **/
    @RequestMapping("keyword/queryKeyWordList"+ WebConstant.PAGE_SUFFIX)
    public String queryKeyWordList(Pagination<ProjectKeywordVo> paramBean, ProjectKeywordVo projectKeywordVo) throws Exception{
        paramBean.setSearch(projectKeywordVo);
        Pagination<ProjectKeywordVo> pageData = iProjectKeywordService.queryProjectKeywordPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "dictInfoType/projectKeyword";
    }

    /**
     * @Author ZhongShengbin
     * @Description  项目关键词导出
     * @Date 2020/5/19 0019
     * @Param [paramBean, searchHotwordVo]
     * @return java.lang.String
     **/
    @RequestMapping("keyword/exportKeyWordList" + WebConstant.BUSINESS_SUFFIX)
    public String exportKeyWordList(Pagination<ProjectKeywordVo> paramBean, ProjectKeywordVo searchHotwordVo) throws Exception {
        paramBean.setSearch(searchHotwordVo);
        Pagination<ProjectKeywordEntity> list = iProjectKeywordService.exportProjectKeywordList(paramBean);
        logService.addLog(new TSysLog("项目关键词-导出", "导出项目关键词信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response,"项目关键词设置" + String.format("%1$tY%1$tm%1$td", new Date()), ProjectKeywordEntity.class, list.getData());
        return null;
    }

    /**
     * @Author ZhongShengbin
     * @Description 项目关键词查看
     * @Date 2020/5/18 0018
     * @Param [hotwordId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("keyword/viewKeyWordList" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewKeyWord(Integer projectKeywordId) throws Exception {
        ProjectKeywordVo searchHotwordVo = iProjectKeywordService.queryProjectKeywordListById(projectKeywordId);
        return this.getResultMap(true, searchHotwordVo);
    }

    /**
     * @Author ZhongShengbin
     * @Description 编辑
     * @Date 2020/5/19 0019
     * @Param [searchHotwordVo]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("keyword/updateKeyWord" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String,Object> updateKeyWord(TProjectKeyword tProjectKeyword) throws Exception{
        if(tProjectKeyword.getProjectKeywordId() == null){
            throw new ServiceException(CustomerExpCodeConstant.CUST_EDIT_COLUMN_ERROR);
        }
        Long userId = CurrentUtil.getCurrentUser().getUserId();
        tProjectKeyword.setUpdateDate(new Date());
        tProjectKeyword.setUpdateUserId(userId.intValue());
        boolean result = iProjectKeywordService.updateSelectiveById(tProjectKeyword);
        if(result){
            if (result) {
                logService.addLog(new TSysLog("项目关键词-编辑", "编辑项目关键词信息【" + tProjectKeyword.getProjectKeyword() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("项目关键词-编辑", "编辑关键词信息【" + tProjectKeyword.getProjectKeyword() + "】失败 ！", PmStateConstant.LOG_PLATFORM));
            }
            if(!result){
                throw new ServiceException(CustomerExpCodeConstant.CUST_EDIT_COLUMN_ERROR);
            }
        }
        return this.getResultMap(true,result);
    }

    /**
     * @Author ZhongShengbin
     * @Description   删除项目关键词
     * @Date 2020/5/19 0019
     * @Param [tSearchHotword]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("keyword/delKeyWord" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String,Object> deleteKeyWord(@RequestParam(value = "projectKeywordId",required = true) Integer projectKeywordId) throws Exception{
        boolean result = iProjectKeywordService.deleteById(projectKeywordId);
        if(result){
            if (result) {
                logService.addLog(new TSysLog("项目关键词-删除", "删除热词信息成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("项目关键词-删除", "删除热词信息失败 ！", PmStateConstant.LOG_PLATFORM));
            }
            if(!result){
                throw new ServiceException(CustomerExpCodeConstant.CUST_EDIT_COLUMN_ERROR);
            }
        }
        return this.getResultMap(true,result);
    }


    /**
     * @Author ZhongShengbin
     * @Description  新增
     * @Date 2020/5/21 0021
     * @Param [memberPriceVo]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("keyword/addKeyWord" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addKeyWord(ProjectKeywordVo projectKeywordVo) throws Exception{
        Long userId = CurrentUtil.getCurrentUser().getUserId();
        projectKeywordVo.setCreateDate(new Date());
        projectKeywordVo.setCreateUserId(userId.intValue());
        projectKeywordVo.setUpdateDate(new Date());
        projectKeywordVo.setUpdateUserId(userId.intValue());
        boolean result = iProjectKeywordService.insertSelective(projectKeywordVo);
        if (result) {
            logService.addLog(new TSysLog("项目关键词-新增", "新增项目关键词【" + projectKeywordVo.getProjectKeyword() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("项目关键词-新增", "新增项目关键词【" + projectKeywordVo.getProjectKeyword() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(InfoTypeExpCodeConstant.INFO_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }
}
