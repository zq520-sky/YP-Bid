package com.yuepeng.web.manage.system.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.system.bean.entity.TSysAppVersion;
import com.yuepeng.web.manage.system.bean.excel.SysAppVersionEntity;
import com.yuepeng.web.manage.system.bean.vo.SysAppVersionVo;
import com.yuepeng.web.manage.system.constants.SystemExpCodeConstant;
import com.yuepeng.web.manage.system.service.ISysAppVersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.PreUpdate;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 版本控制
 * @Author: ZhongShengbin
 * @Date: 2020/05/22 15:57
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/platform/")
public class SysAppVersionController extends BaseController {

    @Resource
    private ISysAppVersionService sysAppVersionService;

    @Resource
    private ILogService logService;

    /**
     * @return java.lang.String
     * @Author ZhongShengbin
     * @Description 版本信息分頁
     * @Date 2020/5/18 0018
     * @Param [paramBean, searchHotwordVo]
     **/
    @RequestMapping("version/queryVersionList" + WebConstant.PAGE_SUFFIX)
    public String queryHotwordList(Pagination<SysAppVersionVo> paramBean, SysAppVersionVo searchHotwordVo) throws Exception {
        paramBean.setSearch(searchHotwordVo);
        Pagination<SysAppVersionVo> pageData = sysAppVersionService.queryVersionPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "system/systemVersion";
    }

    /**
     * @return java.lang.String
     * @Author ZhongShengbin
     * @Description 版本信息导出
     * @Date 2020/5/19 0019
     * @Param [paramBean, searchHotwordVo]
     **/
    @RequestMapping("version/exportVersionList" + WebConstant.BUSINESS_SUFFIX)
    public String exportHotwordList(Pagination<SysAppVersionVo> paramBean, SysAppVersionVo searchHotwordVo) throws Exception {
        paramBean.setSearch(searchHotwordVo);
        Pagination<SysAppVersionEntity> list = sysAppVersionService.exportVersionPageList(paramBean);
        logService.addLog(new TSysLog("系统版本-导出", "导出系统版本信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "系统版本" + String.format("%1$tY%1$tm%1$td", new Date()), SysAppVersionEntity.class, list.getData());
        return null;
    }

    /**
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @Author ZhongShengbin
     * @Description 版本信息查看
     * @Date 2020/5/18 0018
     * @Param [hotwordId]
     **/
    @RequestMapping("version/viewVersionList" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewHotWord(Integer versionId) throws Exception {
        SysAppVersionVo sysAppVersionVo = sysAppVersionService.queryVersionPageListById(versionId);
        return this.getResultMap(true, sysAppVersionVo);
    }

    /**
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @Author ZhongShengbin
     * @Description 编辑
     * @Date 2020/5/19 0019
     * @Param [searchHotwordVo]
     **/
    @RequestMapping("version/updateVersion" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateHotWord(TSysAppVersion sysAppVersion) throws Exception {
        if (sysAppVersion.getVersionId() == null) {
            throw new ServiceException(SystemExpCodeConstant.VERSION_EDIT_COLUMN_ERROR);
        }
        boolean result = sysAppVersionService.updateSelectiveById(sysAppVersion);
        if (result) {
            if (result) {
                logService.addLog(new TSysLog("版本信息-编辑", "编辑版本信息【" + sysAppVersion.getVersionId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("版本信息-编辑", "编辑版本信息【" + sysAppVersion.getVersionId() + "】失败 ！", PmStateConstant.LOG_PLATFORM));
            }
            if (!result) {
                throw new ServiceException(SystemExpCodeConstant.VERSION_EDIT_COLUMN_ERROR);
            }
        }
        return this.getResultMap(true, result);
    }

    /**
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @Author ZhongShengbin
     * @Description 删除版本信息
     * @Date 2020/5/19 0019
     * @Param [tSearchHotword]
     **/
    @RequestMapping("version/delVersion" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> deleteHotWord(@RequestParam(value = "versionId", required = true) Integer versionId) throws Exception {
        boolean result = sysAppVersionService.deleteById(versionId);
        if (result) {
            if (result) {
                logService.addLog(new TSysLog("版本信息-删除", "删除版本信息成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("版本信息-删除", "删除版本信息失败 ！", PmStateConstant.LOG_PLATFORM));
            }
            if (!result) {
                throw new ServiceException(SystemExpCodeConstant.VERSION_EDIT_COLUMN_ERROR);
            }
        }
        return this.getResultMap(true, result);
    }

    /**
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @Author ZhongShengbin
     * @Description 新增
     * @Date 2020/5/21 0021
     * @Param [memberPriceVo]
     **/
    @RequestMapping("version/addVersion" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addKeyWord(SysAppVersionVo sysAppVersionVo) throws Exception {
        sysAppVersionVo.setPublishTime(new Date());
        boolean result = sysAppVersionService.insertSelective(sysAppVersionVo);
        if (result) {
            logService.addLog(new TSysLog("版本信息-新增", "新增版本信息【" + sysAppVersionVo.getVersionId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("版本信息-新增", "新增版本信息【" + sysAppVersionVo.getVersionId() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(SystemExpCodeConstant.VERSION_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }
}
