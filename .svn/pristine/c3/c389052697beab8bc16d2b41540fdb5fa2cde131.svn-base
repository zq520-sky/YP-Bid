package com.yuepeng.web.manage.datasource.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.datasource.bean.excel.DatacrawlerExcel;
import com.yuepeng.web.manage.datasource.bean.vo.DatacrawlerSetVo;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceVo;
import com.yuepeng.web.manage.datasource.constants.DatasourceTypeExpCodeConstant;
import com.yuepeng.web.manage.datasource.service.IDatacrawlerService;
import com.yuepeng.web.manage.datasource.service.IDatacrawlerSetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 爬虫爬取Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/28 09:48
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/datasource/")
public class DatacrawlerSetController extends BaseController {

    /**
     * 服务对象
     */
    @Resource
    private IDatacrawlerSetService datacrawlerSetService;

    @Resource
    private IDatacrawlerService datacrawlerService;

    @Resource
    private ILogService logService;

    @RequestMapping("craw/queryServiceList" + WebConstant.PAGE_SUFFIX)
    public String queryCrawList() throws Exception {
        return "datasource/datacrawType";
    }

    @RequestMapping("craw/queryCrawList" + WebConstant.NO_AUTH_SUFFIX)
    public String queryCrawPageList(Pagination<DatacrawlerSetVo> paramBean, DatacrawlerSetVo datacrawlerSetVo) throws Exception {
        paramBean.setSearch(datacrawlerSetVo);
        Pagination<DatacrawlerSetVo> pageData = datacrawlerSetService.queryCrawPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "datasource/datacrawList";
    }

    @RequestMapping("craw/exportCraw" + WebConstant.BUSINESS_SUFFIX)
    public String exportCrawList(Pagination<DatacrawlerSetVo> paramBean, DatacrawlerSetVo datacrawlerSetVo) throws Exception {
        paramBean.setSearch(datacrawlerSetVo);
        Pagination<DatacrawlerExcel> list = datacrawlerSetService.exportCrawPageList(paramBean);
        logService.addLog(new TSysLog("爬取规则设置-导出", "导出爬取规则设置！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "爬取规则设置" + String.format("%1$tY%1$tm%1$td", new Date()), DatacrawlerExcel.class, list.getData());
        return null;
    }


    @RequestMapping("craw/viewCraw" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewCraw(Integer datacrawlerSetId) throws Exception {
        DatacrawlerSetVo datacrawlerSetVo = datacrawlerSetService.viewCraw(datacrawlerSetId);
        return this.getResultMap(true, datacrawlerSetVo);
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/25 0025
     * @Param [industrySubVo]
     **/
    @RequestMapping("craw/addCraw" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addCraw(DatacrawlerSetVo datacrawlerSetVo) throws Exception {
        boolean insertSelective = datacrawlerSetService.insertSelective(datacrawlerSetVo);
        if (insertSelective) {
            logService.addLog(new TSysLog("爬取规则设置-新增", "新增爬取规则【" + datacrawlerSetVo.getDatacrawlerSetId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("爬取规则设置-新增", "新增爬取规则【" + datacrawlerSetVo.getDatacrawlerSetId() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!insertSelective) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_ADD_ERROR);
        }
        return this.getResultMap(true, insertSelective);
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/25 0025
     * @Param [datasourceVo]
     **/
    @RequestMapping("craw/updateCraw" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateCraw(DatacrawlerSetVo datacrawlerSetVo) throws Exception {
        if (datacrawlerSetVo.getDatacrawlerSetId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_CRAW_EDIR_ERROR);
        }
        boolean result = datacrawlerSetService.updateSelectiveById(datacrawlerSetVo);
        if (result) {
            logService.addLog(new TSysLog("爬取规则-编辑", "编辑爬取规则成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("爬取规则-编辑", "编辑爬取规则失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_CRAW_EDIR_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/25 0025
     * @Param [datasourceVo]
     **/
    @RequestMapping("craw/delCraw" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> delCraw(@RequestParam(value = "datacrawlerSetId") Integer datacrawlerSetId) throws Exception {
        //校验主键ID
        if (datacrawlerSetId == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_CRAW_DEL_ERROR);
        }
        //执行删除
        boolean result = datacrawlerSetService.deleteById(datacrawlerSetId);
        if (result) {
            logService.addLog(new TSysLog("爬取规则-删除", "删除省市成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("爬取规则-删除", "删除省市失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_CRAW_DEL_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/26 0026
     * @Param []
     **/
    @RequestMapping("craw/getCrawTypes" + WebConstant.NO_AUTH_SUFFIX)
    @ResponseBody
    public Map<String, Object> getCrawTypes() throws Exception {
        List<DatacrawlerSetVo> datacrawlerSetVoList = datacrawlerSetService.getCrawType();
        return this.getResultMap(datacrawlerSetVoList);
    }

    /**
     * @return {@link Map< String, Object>}
     * @author zsb
     * @date 2020/5/22 9:23
     */
    @RequestMapping("craw/bidCraw" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> disAndEnableDatasource(DatacrawlerSetVo datacrawlerSetVo) throws Exception {
        //校验主键ID
        if (datacrawlerSetVo.getDatacrawlerSetId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_SET_ERROR);
        }
        //执行编辑
        boolean result = datacrawlerSetService.updateSelectiveById(datacrawlerSetVo);
        String headStr = datacrawlerSetVo.getIsForbid() == 0 ? "启用" : "禁用";
        if (result) {
            logService.addLog(new TSysLog("来源站点管理-禁用/启用", headStr + "站点【" + datacrawlerSetVo.getDatasourceWebname() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源站点管理-禁用/启用", headStr + "站点【" + datacrawlerSetVo.getDatasourceWebname() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_SET_ERROR);
        }
        return this.getResultMap(true, result);
    }
}
