package com.yuepeng.web.manage.system.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TSysCity;
import com.yuepeng.web.manage.system.bean.excel.SysCityEntity;
import com.yuepeng.web.manage.system.bean.vo.SysCityVo;
import com.yuepeng.web.manage.system.dao.TSysCityProvinceMapper;
import com.yuepeng.web.manage.system.service.ISysCityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 省市设置Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/26 11:30
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class SysCityServiceImpl extends SuperServiceIntegerImpl<TSysCityProvinceMapper, TSysCity> implements ISysCityService {
    @Override
    public Pagination<SysCityVo> queryProvincePageList(Pagination<SysCityVo> paramBean) throws Exception {
        Pagination<SysCityVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SysCityVo> list = mapper.queryProvincePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<SysCityEntity> exportProvincePageList(Pagination<SysCityVo> paramBean) throws Exception {
        Pagination<SysCityEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SysCityEntity> list = mapper.exportProvincePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public SysCityVo viewProvince(Integer cityId) throws Exception {
        return this.mapper.viewCity(cityId);
    }

    @Override
    public List<SysCityVo> getProvinceType() throws Exception {
        return this.mapper.getProvinceTypes();
    }
}
