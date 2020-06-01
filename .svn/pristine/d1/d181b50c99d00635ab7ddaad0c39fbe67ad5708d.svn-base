package com.yuepeng.web.manage.planProject.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanDatasource;
import com.yuepeng.web.manage.planProject.bean.excel.PlanDatasourceEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanDatasourceVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TPlanDatasourceMapper extends AutoMapperInteger<TPlanDatasource> {
    List<PlanDatasourceVo> queryPlanDatasourceList(Pagination<PlanDatasourceVo> paramBean, RowBounds rowBounds) throws Exception;

    List<PlanDatasourceEntity> exportPlanDatasourceList(Pagination<PlanDatasourceVo> paramBean, RowBounds rowBounds) throws Exception;

    PlanDatasourceVo viewDatasourceListById(Integer datasourceId) throws Exception;
}