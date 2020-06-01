package com.yuepeng.web.manage.datasource.controller;

import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceInfotype;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceIndustryVo;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceInfotypeVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceInfotypeExcel;
import com.yuepeng.web.manage.datasource.constants.DatasourceTypeExpCodeConstant;
import com.yuepeng.web.manage.datasource.service.IDatasourceInfotypeService;
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
import java.util.Map;

/**
 * 招标数据源信息类型表

重庆市公共资源交易网：
1、工程招投标：招标计划、招标公告划、邀标信息划、答疑补遗划、中标候选人公示划、中标结果公告划、合同履行情况划、相关公示公告

2、产权交易：交易公告、变更补充公告、成交公示
机电设备
土地及矿业权
政府采购
碳排放权交易
其他采购
排污权交易
中介超市(DatasourceInfotype)表控制层
 *
 * @author wzq
 * @since 2020-05-22 17:09:32
 */
@Controller
@RequestMapping("/manage/datasource/infoType")
public class DatasourceInfotypeController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private IDatasourceInfotypeService datasourceInfotypeService;
    
    @Resource
    private ILogService logService;

    @RequestMapping("queryInfoList" + WebConstant.PAGE_SUFFIX)
    public String queryDatasourceList() throws Exception {
        return "datasource/datasourceInfotypeManage";
    }

    @RequestMapping("queryInfoTypeList" + WebConstant.NO_AUTH_SUFFIX)
    public String queryDatasourceInfotypePageList(Pagination<DatasourceInfotypeVo> paramBean, DatasourceInfotypeVo datasourceInfotypeVo) throws Exception{
        paramBean.setSearch(datasourceInfotypeVo);
        Pagination<DatasourceInfotypeVo> pageData = datasourceInfotypeService.queryDatasourceInfotypePageList(paramBean);
        this.addAttr("pageData", pageData);
        this.addAttr("datasourceInfotypeVo", datasourceInfotypeVo);
        return "datasource/datasourceInfotypeList";
    }

    @RequestMapping("/exportInfoTypeList" + WebConstant.BUSINESS_SUFFIX)
    public String exportDatasourceInfotypeList(Pagination<TDatasourceInfotype> paramBean, DatasourceInfotypeVo datasourceInfotypeVo) throws Exception {
        paramBean.setSearch(datasourceInfotypeVo);
        Pagination<DatasourceInfotypeExcel> list = datasourceInfotypeService.exportDatasourceInfotypePageList(paramBean);
        logService.addLog(new TSysLog("来源行业类型管理-导出", "导出来源行业类型！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "来源行业类型" + String.format("%1$tY%1$tm%1$td", new Date()), DatasourceInfotypeExcel.class, list.getData());
        return null;
    }

    
    @RequestMapping("viewInfoType" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewDatasourceInfotype(Integer datasourceInfotypeId) throws Exception {
        DatasourceInfotypeVo datasourceInfotypeVo = datasourceInfotypeService.viewDatasourceInfotype(datasourceInfotypeId);
        return this.getResultMap(true, datasourceInfotypeVo);
    }

    @RequestMapping("addInfoType" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addDatasourceInfoType(DatasourceInfotypeVo datasourceInfotypeVo) throws Exception {
        Date date = new Date();
        datasourceInfotypeVo.setCreateDate(date);
        datasourceInfotypeVo.setCreateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        datasourceInfotypeVo.setUpdateDate(date);
        datasourceInfotypeVo.setUpdateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        boolean result = datasourceInfotypeService.insertSelective(datasourceInfotypeVo);
        if (result) {
            logService.addLog(new TSysLog("来源行业类型管理-新增", "新增行业类型【" + datasourceInfotypeVo.getDatasourceInfotypeName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源行业类型管理-新增", "新增行业类型【" + datasourceInfotypeVo.getDatasourceInfotypeName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INDUSTRY_ADD_ERROR);
        }
        return this.getResultMap(true, result);
    }

    @RequestMapping("updateInfoType" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateDatasourceInfotype(DatasourceInfotypeVo datasourceInfotypeVo) throws Exception {
        if (datasourceInfotypeVo.getDatasourceInfotypeId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INFOTYPE_EDIT_ID_ERROR);
        }
        datasourceInfotypeVo.setUpdateDate(new Date());
        datasourceInfotypeVo.setUpdateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        boolean result = datasourceInfotypeService.updateSelectiveById(datasourceInfotypeVo);
        if (result) {
            logService.addLog(new TSysLog("来源信息类型管理-编辑", "编辑来源信息类型【" + datasourceInfotypeVo.getDatasourceInfotypeName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源信息类型管理-编辑", "编辑来源信息类型【" + datasourceInfotypeVo.getDatasourceInfotypeName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INFOTYPE_EDIT_ERROR);
        }
        return this.getResultMap(true, result);
    }

    @RequestMapping("delInfoType" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> delDatasourceInfotype(DatasourceInfotypeVo datasourceInfotypeVo) throws Exception {
        if (datasourceInfotypeVo.getDatasourceInfotypeId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INFOTYPE_EDIT_ID_ERROR);
        }
        boolean result = datasourceInfotypeService.deleteById(datasourceInfotypeVo.getDatasourceInfotypeId());
        if (result) {
            logService.addLog(new TSysLog("来源信息类型管理-删除", "删除信息类型【" + datasourceInfotypeVo.getDatasourceInfotypeName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源信息类型管理-删除", "删除信息类型【" + datasourceInfotypeVo.getDatasourceInfotypeName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_INDUSTRY_DEL_ERROR);
        }
        return this.getResultMap(true, result);
    }
    
}