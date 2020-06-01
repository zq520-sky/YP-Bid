package com.yuepeng.web.manage.planProject.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanDatasource;
import com.yuepeng.web.manage.planProject.bean.excel.PlanDatasourceEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanDatasourceVo;
import com.yuepeng.web.manage.planProject.dao.TPlanDatasourceMapper;
import com.yuepeng.web.manage.planProject.service.IPlanDatasourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 拟建项目数据来源Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/30 14:24
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class PlanDatasourceServiceImpl extends SuperServiceIntegerImpl<TPlanDatasourceMapper, TPlanDatasource> implements IPlanDatasourceService {
    @Override
    public Pagination<PlanDatasourceVo> queryPlanDatasourceList(Pagination<PlanDatasourceVo> paramBean) throws Exception {
        Pagination<PlanDatasourceVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<PlanDatasourceVo> list = mapper.queryPlanDatasourceList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<PlanDatasourceEntity> exportPlanDatasourceList(Pagination<PlanDatasourceVo> paramBean) throws Exception {
        Pagination<PlanDatasourceEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<PlanDatasourceEntity> list = mapper.exportPlanDatasourceList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public PlanDatasourceVo queryPlanDatasourceListById(Integer datasourceId) throws Exception {
        return this.mapper.viewDatasourceListById(datasourceId);
    }
}
