package com.yuepeng.web.manage.system.controller;


import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.dict.constant.IndustryExpCodeConstant;
import com.yuepeng.web.manage.system.bean.excel.SysCityEntity;
import com.yuepeng.web.manage.system.bean.vo.SysCityVo;
import com.yuepeng.web.manage.system.service.ISysCityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 行业分类设置Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/25 11:37
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/platform/")
public class SysCityController extends BaseController {

    /**
     * 服务对象
     */
    @Resource
    private ISysCityService sysCityService;

    @Resource
    private ILogService logService;

    @RequestMapping("city/queryProvinceList" + WebConstant.PAGE_SUFFIX)
    public String queryProvinceList() throws Exception {
        return "system/provinceTypeList";
    }

    @RequestMapping("city/queryCityList" + WebConstant.NO_AUTH_SUFFIX)
    public String queryCityPageList(Pagination<SysCityVo> paramBean, SysCityVo cityVo) throws Exception {
        paramBean.setSearch(cityVo);
        Pagination<SysCityVo> pageData = sysCityService.queryProvincePageList(paramBean);
        this.addAttr("pageData", pageData);
        return "system/cityList";
    }

    @RequestMapping("city/exportCity" + WebConstant.BUSINESS_SUFFIX)
    public String exportCityList(Pagination<SysCityVo> paramBean, SysCityVo sysCityVo) throws Exception {
        paramBean.setSearch(sysCityVo);
        Pagination<SysCityEntity> list = sysCityService.exportProvincePageList(paramBean);
        logService.addLog(new TSysLog("省市设置-导出", "导出省市设置！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "省市设置" + String.format("%1$tY%1$tm%1$td", new Date()), SysCityEntity.class, list.getData());
        return null;
    }


    @RequestMapping("city/viewCity" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewCity(Integer cityId) throws Exception {
        SysCityVo sysCityVo = sysCityService.viewProvince(cityId);
        return this.getResultMap(true, sysCityVo);
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/25 0025
     * @Param [industrySubVo]
     **/
    @RequestMapping("city/addCity" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addCity(SysCityVo sysCityVo) throws Exception {
        sysCityVo.setProvinceName(sysCityService.selectById(sysCityVo.getProvinceId()).getProvinceName());
        boolean insertSelective = sysCityService.insertSelective(sysCityVo);
        if (insertSelective) {
            logService.addLog(new TSysLog("省市设置-新增", "新增省市【" + sysCityVo.getCityName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("省市设置-新增", "新增省市【" + sysCityVo.getCityName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!insertSelective) {
            throw new ServiceException(IndustryExpCodeConstant.INFO_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, insertSelective);
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/25 0025
     * @Param [datasourceVo]
     **/
    @RequestMapping("city/updateCity" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateCity(SysCityVo sysCityVo) throws Exception {
        if (sysCityVo.getCityId() == null) {
            throw new ServiceException(IndustryExpCodeConstant.INFO_EDIT_ID_ERROR);
        }
        sysCityVo.setProvinceName(sysCityService.selectById(sysCityVo.getProvinceId()).getProvinceName());
        boolean result = sysCityService.updateSelectiveById(sysCityVo);
        if (result) {
            logService.addLog(new TSysLog("省市设置-编辑", "编辑省市设置【" + sysCityVo.getCityName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("省市设置-编辑", "编辑省市设置【" + sysCityVo.getCityName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(IndustryExpCodeConstant.INFO_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/25 0025
     * @Param [datasourceVo]
     **/
    @RequestMapping("city/delCity" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> delCity(@RequestParam(value = "cityId") Integer cityId) throws Exception {
        //校验主键ID
        if (cityId == null) {
            throw new ServiceException(IndustryExpCodeConstant.INFO_EDIT_ID_ERROR);
        }
        //执行删除
        boolean result = sysCityService.deleteById(cityId);
        if (result) {
            logService.addLog(new TSysLog("省市设置-删除", "删除省市成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("省市设置-删除", "删除省市失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(IndustryExpCodeConstant.INFO_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * @return java.util.Map<java.lang.String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @Author ZhongShengbin
     * @Description
     * @Date 2020/5/26 0026
     * @Param []
     **/
    @RequestMapping("city/getProvinceTypes" + WebConstant.NO_AUTH_SUFFIX)
    @ResponseBody
    public Map<String, Object> getCityTypes() throws Exception {
        List<SysCityVo> sysCityVos = sysCityService.getProvinceType();
        return this.getResultMap(sysCityVos);
    }
}
