package com.yuepeng.web.manage.planProject.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanProject;
import com.yuepeng.web.manage.planProject.bean.excel.PlanProjectEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanProjectVo;

/**
 * @Description: 拟建项目Service
 * @Author: ZhongShengbin
 * @Date: 2020/05/27 08:55
 * Copyright (c) 2019, Samton. All rights reserved
 */
public interface IPlanProjectService extends ISuperIntegerService<TPlanProject> {

    Pagination<PlanProjectVo> queryPlanPageList(Pagination<PlanProjectVo> paramBean) throws Exception;

    public Pagination<PlanProjectEntity> exportPlanPageList(Pagination<PlanProjectVo> paramBean) throws Exception;

    public PlanProjectVo queryPlanPageListById(Integer planProjectId) throws Exception;
}
