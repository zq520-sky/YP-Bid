package com.yuepeng.web.manage.datasource.controller;

import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceIndustry;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceIndustryVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceIndustryExcel;
import com.yuepeng.web.manage.datasource.constants.DatasourceTypeExpCodeConstant;
import com.yuepeng.web.manage.datasource.service.IDatasourceIndustryService;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.pm.service.ILogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 招标数据源行业类型
    重庆市公共资源交易网：
    工程招投标
    产权交易
    机电设备
    土地及矿业权
    政府采购
    碳排放权交易
    其他采购
    排污权交易
    中介超市(DatasourceIndustry)表控制层
 *
 * @author wzq
 * @since 2020-05-22 16:20:57
 */
@Controller
@RequestMapping("/manage/datasource/industry")
public class DatasourceIndustryController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private IDatasourceIndustryService datasourceIndustryService;
    
    @Resource
    private ILogService logService;

    @RequestMapping("queryInfoList" + WebConstant.PAGE_SUFFIX)
    public String queryDatasourceList() throws Exception {
        return "datasource/datasourceIndustryManage";
    }

    @RequestMapping("queryIndustryList" + WebConstant.NO_AUTH_SUFFIX)
    public String queryDatasourceIndustryPageList(Pagination<DatasourceIndustryVo> paramBean, DatasourceIndustryVo datasourceIndustryVo) throws Exception{
        paramBean.setSearch(datasourceIndustryVo);
        Pagination<DatasourceIndustryVo> pageData = datasourceIndustryService.queryDatasourceIndustryPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "datasource/datasourceIndustryList";
    }

    @RequestMapping("/exportIndustryList" + WebConstant.BUSINESS_SUFFIX)
    public String exportDatasourceIndustryList(Pagination<TDatasourceIndustry> paramBean, DatasourceIndustryVo datasourceIndustryVo) throws Exception {
        paramBean.setSearch(datasourceIndustryVo);
        Pagination<DatasourceIndustryExcel> list = datasourceIndustryService.exportDatasourceIndustryPageList(paramBean);
        logService.addLog(new TSysLog("来源行业类型-导出", "导出来源行业类型！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "来源行业类型" + String.format("%1$tY%1$tm%1$td", new Date()), DatasourceIndustryExcel.class, list.getData());
        return null;
    }

    
    @RequestMapping("viewIndustry" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewDatasourceIndustry(Integer datasourceIndustryId) throws Exception {
        DatasourceIndustryVo datasourceIndustryVo = datasourceIndustryService.viewDatasourceIndustry(datasourceIndustryId);
        return this.getResultMap(true, datasourceIndustryVo);
    }

    @RequestMapping("addIndustry" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addDatasourceIndustry(DatasourceIndustryVo datasourceIndustryVo) throws Exception {
        Date date = new Date();
        datasourceIndustryVo.setCreateDate(date);
        datasourceIndustryVo.setCreateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        datasourceIndustryVo.setUpdateDate(date);
        datasourceIndustryVo.setUpdateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        boolean result = datasourceIndustryService.insertSelective(datasourceIndustryVo);
        if (result) {
            logService.addLog(new TSysLog("来源行业类型管理-新增", "新增行业类型【" + datasourceIndustryVo.getDatasourceIndustryName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源行业类型管理-新增", "新增行业类型【" + datasourceIndustryVo.getDatasourceIndustryName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INDUSTRY_ADD_ERROR);
        }
        return this.getResultMap(true, result);
    }

    @RequestMapping("updateIndustry" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateDatasourceIndustry(DatasourceIndustryVo datasourceIndustryVo) throws Exception {
        if (datasourceIndustryVo.getDatasourceIndustryId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INDUSTRY_EDIT_ID_ERROR);
        }
        datasourceIndustryVo.setUpdateDate(new Date());
        datasourceIndustryVo.setUpdateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        boolean result = datasourceIndustryService.updateSelectiveById(datasourceIndustryVo);
        if (result) {
            logService.addLog(new TSysLog("来源行业类型管理-编辑", "编辑行业类型【" + datasourceIndustryVo.getDatasourceIndustryName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源行业类型管理-编辑", "编辑行业类型【" + datasourceIndustryVo.getDatasourceIndustryName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INDUSTRY_EDIT_ERROR);
        }
        return this.getResultMap(true, result);
    }

    @RequestMapping("delIndustry" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> delDatasourceIndustry(DatasourceIndustryVo datasourceIndustryVo) throws Exception {
        if (datasourceIndustryVo.getDatasourceIndustryId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INDUSTRY_EDIT_ID_ERROR);
        }
        boolean result = datasourceIndustryService.deleteDatasourceIndustryById(datasourceIndustryVo.getDatasourceIndustryId());
        if (result) {
            logService.addLog(new TSysLog("来源行业类型管理-删除", "删除行业类型【" + datasourceIndustryVo.getDatasourceIndustryName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源行业类型管理-删除", "删除行业类型【" + datasourceIndustryVo.getDatasourceIndustryName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INDUSTRY_DEL_ERROR);
        }
        return this.getResultMap(true, result);
    }

    @RequestMapping("getDatasourceIndustryByDatasourceId" + WebConstant.NO_AUTH_SUFFIX)
    @ResponseBody
    public List<Map<String, Object>> getDatasourceIndustryByDatasourceId(Integer datasourceId) throws Exception {
        return datasourceIndustryService.getDatasourceIndustryByDatasourceId(datasourceId);
    }
}