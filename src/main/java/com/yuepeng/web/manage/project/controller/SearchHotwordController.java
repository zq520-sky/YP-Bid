package com.yuepeng.web.manage.project.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.collect.service.ICompanyCollectService;
import com.yuepeng.web.manage.customer.constant.CustomerExpCodeConstant;
import com.yuepeng.web.manage.project.bean.entity.TSearchHotword;
import com.yuepeng.web.manage.project.bean.excel.SearchHotwordEntity;
import com.yuepeng.web.manage.project.bean.vo.SearchHotwordVo;
import com.yuepeng.web.manage.project.constants.ProjectExpCodeConstant;
import com.yuepeng.web.manage.project.service.ISearchHotwordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 热词搜索设置Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/18 16:53
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/project/")
public class SearchHotwordController extends BaseController {

    @Resource
    private ISearchHotwordService searchHotwordService;

    @Resource
    private ILogService logService;

    /**
     * @Author ZhongShengbin
     * @Description 热词搜索分页
     * @Date 2020/5/18 0018
     * @Param [paramBean, searchHotwordVo]
     * @return java.lang.String
     **/
    @RequestMapping("hotword/queryHotwordList"+ WebConstant.PAGE_SUFFIX)
    public String queryHotwordList(Pagination<SearchHotwordVo> paramBean, SearchHotwordVo searchHotwordVo) throws Exception{
        paramBean.setSearch(searchHotwordVo);
        Pagination<SearchHotwordVo> pageData = searchHotwordService.queryHotwordPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "project/searchHotwordSet";
    }

    /**
     * @Author ZhongShengbin
     * @Description  热词导出
     * @Date 2020/5/19 0019
     * @Param [paramBean, searchHotwordVo]
     * @return java.lang.String
     **/
    @RequestMapping("hotword/exportHotwordList" + WebConstant.BUSINESS_SUFFIX)
    public String exportHotwordList(Pagination<SearchHotwordVo> paramBean, SearchHotwordVo searchHotwordVo) throws Exception {
        paramBean.setSearch(searchHotwordVo);
        Pagination<SearchHotwordEntity> list = searchHotwordService.exportHotwordPageList(paramBean);
        logService.addLog(new TSysLog("热词搜索设置-导出", "导出热词搜索设置信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response,"热词搜索设置" + String.format("%1$tY%1$tm%1$td", new Date()), SearchHotwordEntity.class, list.getData());
        return null;
    }

    /**
     * @Author ZhongShengbin
     * @Description 热词搜索设置查看
     * @Date 2020/5/18 0018
     * @Param [hotwordId]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("hotword/viewHotword" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewHotWord(Integer hotwordId) throws Exception {
        SearchHotwordVo searchHotwordVo = searchHotwordService.queryHotwordPageListById(hotwordId);
        return this.getResultMap(true, searchHotwordVo);
    }

    /**
     * @Author ZhongShengbin
     * @Description 编辑
     * @Date 2020/5/19 0019
     * @Param [searchHotwordVo]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("hotword/updateHotword" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String,Object> updateHotWord(TSearchHotword tSearchHotword) throws Exception{
        if(tSearchHotword.getHotwordId() == null){
            throw new ServiceException(CustomerExpCodeConstant.CUST_EDIT_COLUMN_ERROR);
        }
        boolean result = searchHotwordService.updateSelectiveById(tSearchHotword);
        if(result){
            if (result) {
                logService.addLog(new TSysLog("搜索热词设置-编辑", "编辑热词信息【" + tSearchHotword.getHotwordName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("搜索热词设置-编辑", "编辑热词信息【" + tSearchHotword.getHotwordName() + "】失败 ！", PmStateConstant.LOG_PLATFORM));
            }
            if(!result){
                throw new ServiceException(CustomerExpCodeConstant.CUST_EDIT_COLUMN_ERROR);
            }
        }
        return this.getResultMap(true,result);
    }

    /**
     * @Author ZhongShengbin
     * @Description   删除搜索热词
     * @Date 2020/5/19 0019
     * @Param [tSearchHotword]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("hotword/delHotword" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String,Object> deleteHotWord(@RequestParam(value = "hotwordId",required = true) Integer hotwordId) throws Exception{
        boolean result = searchHotwordService.deleteById(hotwordId);
        if(result){
            if (result) {
                logService.addLog(new TSysLog("搜索热词设置-删除", "删除热词信息成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("搜索热词设置-删除", "删除热词信息失败 ！", PmStateConstant.LOG_PLATFORM));
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
    @RequestMapping("hotword/addHotword" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addKeyWord(TSearchHotword tSearchHotword) throws Exception {
        tSearchHotword.setCreateDate(new Date());
        boolean result = searchHotwordService.insertSelective(tSearchHotword);
        if (result) {
            logService.addLog(new TSysLog("搜索热词-新增", "新增搜索热词【" + tSearchHotword.getHotwordName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("搜索热词-新增", "新增搜索热词【" + tSearchHotword.getHotwordName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }
}
