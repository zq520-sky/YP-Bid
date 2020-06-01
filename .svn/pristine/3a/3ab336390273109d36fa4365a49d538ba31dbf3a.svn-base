package com.yuepeng.web.manage.planProject.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanProject;
import com.yuepeng.web.manage.planProject.bean.excel.PlanProjectEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanProjectVo;
import com.yuepeng.web.manage.planProject.dao.TPlanProjectMapper;
import com.yuepeng.web.manage.planProject.service.IPlanProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 拟建项目Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/27 09:42
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class PlanProjectServiceImpl extends SuperServiceIntegerImpl<TPlanProjectMapper, TPlanProject> implements IPlanProjectService {
    @Override
    public Pagination<PlanProjectVo> queryPlanPageList(Pagination<PlanProjectVo> paramBean) throws Exception {
        Pagination<PlanProjectVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<PlanProjectVo> list = mapper.queryPlanList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<PlanProjectEntity> exportPlanPageList(Pagination<PlanProjectVo> paramBean) throws Exception {
        Pagination<PlanProjectEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<PlanProjectEntity> list = mapper.exportPlanSearchList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public PlanProjectVo queryPlanPageListById(Integer planProjectId) throws Exception {
        return this.mapper.selectPlanSearchListById(planProjectId);
    }
}
