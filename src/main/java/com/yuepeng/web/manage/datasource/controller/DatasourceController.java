package com.yuepeng.web.manage.datasource.controller;

import com.yuepeng.platform.common.bean.entity.TSysCity;
import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.datasource.bean.entity.TDatasource;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceExcel;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceVo;
import com.yuepeng.web.manage.datasource.constants.DatasourceTypeExpCodeConstant;
import com.yuepeng.web.manage.datasource.service.IDatasourceService;
import com.yuepeng.web.manage.finance.bean.vo.MemberPriceVo;
import com.yuepeng.web.manage.finance.constants.MemberPriceExpCodeConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 招标数据来源站点表
 * <p>
 * 1：省平台     青海省                          青海省公共资源交易网
 * 2：市平台     青海省    格尔木市      格尔木市公共资源交易网
 * 3：央企业招投标    中国化工装备招投标交易平台
 * 4：...(Datasource)表控制层
 *
 * @author wzq
 * @since 2020-05-21 09:07:49
 */
@Controller
@RequestMapping("/manage/datasource/info")
public class DatasourceController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private IDatasourceService datasourceService;

    @Resource
    private ILogService logService;

    @RequestMapping("queryInfoList" + WebConstant.PAGE_SUFFIX)
    public String queryDatasourceList() throws Exception {
        return "datasource/datasourceManage";
    }

    @RequestMapping("queryDatasourceList" + WebConstant.NO_AUTH_SUFFIX)
    public String queryDatasourcePageList(Pagination<DatasourceVo> paramBean, DatasourceVo datasourceVo) throws Exception {
        paramBean.setSearch(datasourceVo);
        Pagination<DatasourceVo> pageData = datasourceService.queryDatasourcePageList(paramBean);
        this.addAttr("pageData", pageData);
        return "datasource/datasourceList";
    }

    @RequestMapping("/exportInfoList" + WebConstant.BUSINESS_SUFFIX)
    public String exportDatasourceList(Pagination<TDatasource> paramBean, DatasourceVo datasourceVo) throws Exception {
        paramBean.setSearch(datasourceVo);
        Pagination<DatasourceExcel> list = datasourceService.exportDatasourcePageList(paramBean);
        logService.addLog(new TSysLog("来源站点管理-导出", "导出来源站点信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "来源站点信息" + String.format("%1$tY%1$tm%1$td", new Date()), DatasourceExcel.class, list.getData());
        return null;
    }


    @RequestMapping("viewInfo" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewDatasource(Integer datasourceId) throws Exception {
        DatasourceVo datasourceVo = datasourceService.viewDatasource(datasourceId);
        return this.getResultMap(true, datasourceVo);
    }

    /**
     * @param datasourceVo
     * @return {@link Map< String, Object>}
     * @author wzq
     * @date 2020/5/21 20:06
     */
    @RequestMapping("addInfo" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addDatasource(DatasourceVo datasourceVo) throws Exception {
        Date date = new Date();
        datasourceVo.setCreateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        datasourceVo.setUpdateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        datasourceVo.setCreateDate(date);
        datasourceVo.setUpdateDate(date);
        datasourceVo.setIsForbid(0);
        boolean insertSelective = datasourceService.insertSelective(datasourceVo);
        if (insertSelective) {
            logService.addLog(new TSysLog("来源站点管理-新增", "新增站点【" + datasourceVo.getDatasourceWebname() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源站点管理-新增", "新增站点【" + datasourceVo.getDatasourceWebname() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!insertSelective) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_ADD_ERROR);
        }
        return this.getResultMap(true, insertSelective);
    }

    /**
     * @param datasourceVo
     * @return {@link java.util.Map<java.lang.String,java.lang.Object>}
     * @author wzq
     * @date 2020/5/21 20:25
     */
    @RequestMapping("updateInfo" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateDatasource(DatasourceVo datasourceVo) throws Exception {
        if (datasourceVo.getDatasourceId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_EDIT_ID_ERROR);
        }
        Date date = new Date();
        datasourceVo.setUpdateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        datasourceVo.setUpdateDate(date);
        boolean result = datasourceService.insertSelective(datasourceVo);
        if (result) {
            logService.addLog(new TSysLog("来源站点管理-编辑", "编辑站点【" + datasourceVo.getDatasourceWebname() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源站点管理-编辑", "编辑站点【" + datasourceVo.getDatasourceWebname() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_EDIT_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     *
     * @param datasourceVo
     * @author wzq
     * @date 2020/5/22 9:23
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("delInfo" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> delDatasource(DatasourceVo datasourceVo) throws Exception {
        //校验主键ID
        if (datasourceVo.getDatasourceId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_EDIT_ID_ERROR);
        }
        //执行删除
        boolean result = datasourceService.deleteById(datasourceVo.getDatasourceId());
        if (result) {
            logService.addLog(new TSysLog("来源站点管理-删除", "删除站点【" + datasourceVo.getDatasourceWebname() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源站点管理-删除", "删除站点【" + datasourceVo.getDatasourceWebname() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_DEL_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     *
     * @param datasourceVo
     * @author wzq
     * @date 2020/5/22 9:23
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("disAndEnableInfo" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> disAndEnableDatasource(DatasourceVo datasourceVo) throws Exception {
        //校验主键ID
        if (datasourceVo.getDatasourceId() == null) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_EDIT_ID_ERROR);
        }
        //执行编辑
        datasourceVo.setUpdateDate(new Date());
        Long userId = CurrentUtil.getCurrentUser().getUserId();
        datasourceVo.setUpdateUserId(userId.intValue());
        boolean result = datasourceService.updateSelectiveById(datasourceVo);
        String headStr = datasourceVo.getIsForbid() == 0 ? "启用" : "禁用";
        if (result) {
            logService.addLog(new TSysLog("来源站点管理-禁用/启用", headStr+"站点【" + datasourceVo.getDatasourceWebname() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("来源站点管理-禁用/启用", headStr+"站点【" + datasourceVo.getDatasourceWebname() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(DatasourceTypeExpCodeConstant.DATASOURCE_SET_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     *
     * @param datasourceTypeId
     * @author wzq
     * @date 2020/5/27 19:49
     * @return {@link java.util.List<java.util.Map<java.lang.String,java.lang.Object>>}
     */
    @RequestMapping("/getDatasourceByTypeId" + WebConstant.NO_AUTH_SUFFIX)
    @ResponseBody
    public List<Map<String, Object>> getDatasourceByTypeId(Integer datasourceTypeId) throws Exception {
        return datasourceService.getDatasourceByTypeId(datasourceTypeId);
    }

    /**
     *
     * @param datasourceId
     * @author wzq
     * @date 2020/5/27 20:20
     * @return {@link com.yuepeng.web.manage.datasource.bean.vo.DatasourceVo}
     */
    @RequestMapping("/getDatasourceById" + WebConstant.NO_AUTH_SUFFIX)
    @ResponseBody
    public DatasourceVo getDatasourceById(Integer datasourceId) throws Exception {
        return datasourceService.viewDatasource(datasourceId);
    }
}