package com.yuepeng.web.manage.planProject.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanProject;
import com.yuepeng.web.manage.planProject.bean.excel.PlanProjectEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanProjectVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TPlanProjectMapper extends AutoMapperInteger<TPlanProject> {
    List<PlanProjectVo> queryPlanList(Pagination<PlanProjectVo> paramBean, RowBounds rowBounds) throws Exception;

    List<PlanProjectEntity> exportPlanSearchList(Pagination<PlanProjectVo> paramBean, RowBounds rowBounds) throws Exception;

    PlanProjectVo selectPlanSearchListById(Integer planProjectId) throws Exception;
}