package com.yuepeng.web.manage.planProject.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanSearchHotword;
import com.yuepeng.web.manage.planProject.bean.excel.PlanSearchHotwordEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanSearchHotwordVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TPlanSearchHotwordMapper extends AutoMapperInteger<TPlanSearchHotword> {
    List<PlanSearchHotwordVo> queryHotwordList(Pagination<PlanSearchHotwordVo> paramBean, RowBounds rowBounds) throws Exception;

    List<PlanSearchHotwordEntity> exportHotwordList(Pagination<PlanSearchHotwordVo> paramBean, RowBounds rowBounds) throws Exception;

    PlanSearchHotwordVo queryHotwordListById(Integer projectCompanyId) throws Exception;
}