package com.yuepeng.web.manage.planProject.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanDatasource;
import com.yuepeng.web.manage.planProject.bean.excel.PlanDatasourceEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanDatasourceVo;

public interface IPlanDatasourceService extends ISuperIntegerService<TPlanDatasource> {

    Pagination<PlanDatasourceVo> queryPlanDatasourceList(Pagination<PlanDatasourceVo> paramBean) throws Exception;

    public Pagination<PlanDatasourceEntity> exportPlanDatasourceList(Pagination<PlanDatasourceVo> paramBean) throws Exception;

    public PlanDatasourceVo queryPlanDatasourceListById(Integer datasourceId) throws Exception;
}
