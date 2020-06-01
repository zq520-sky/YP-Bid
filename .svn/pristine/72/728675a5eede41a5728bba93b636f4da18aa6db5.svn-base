package com.yuepeng.web.manage.planProject.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanSearchHotword;
import com.yuepeng.web.manage.planProject.bean.excel.PlanSearchHotwordEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanSearchHotwordVo;

public interface IPlanSearchHotwordService extends ISuperIntegerService<TPlanSearchHotword> {
    Pagination<PlanSearchHotwordVo> queryHotwordPageList(Pagination<PlanSearchHotwordVo> paramBean) throws Exception;

    public Pagination<PlanSearchHotwordEntity> exportHotwordPageList(Pagination<PlanSearchHotwordVo> paramBean) throws Exception;

    public PlanSearchHotwordVo queryHotwordPageListById(Integer hotwordId) throws Exception;
}
