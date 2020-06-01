package com.yuepeng.web.manage.planProject.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.planProject.bean.entity.TPlanSearchHotword;
import com.yuepeng.web.manage.planProject.bean.excel.PlanSearchHotwordEntity;
import com.yuepeng.web.manage.planProject.bean.vo.PlanSearchHotwordVo;
import com.yuepeng.web.manage.planProject.dao.TPlanSearchHotwordMapper;
import com.yuepeng.web.manage.planProject.service.IPlanSearchHotwordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 搜索热词实现类
 * @Author: ZhongShengbin
 * @Date: 2020/05/18 16:33
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class PlanSearchHotwordImpl extends SuperServiceIntegerImpl<TPlanSearchHotwordMapper, TPlanSearchHotword> implements IPlanSearchHotwordService {


    @Override
    public Pagination<PlanSearchHotwordVo> queryHotwordPageList(Pagination<PlanSearchHotwordVo> paramBean) throws Exception {
        Pagination<PlanSearchHotwordVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<PlanSearchHotwordVo> list = mapper.queryHotwordList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<PlanSearchHotwordEntity> exportHotwordPageList(Pagination<PlanSearchHotwordVo> paramBean) throws Exception {
        Pagination<PlanSearchHotwordEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<PlanSearchHotwordEntity> list = mapper.exportHotwordList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public PlanSearchHotwordVo queryHotwordPageListById(Integer hotwordId) throws Exception {
        return this.mapper.queryHotwordListById(hotwordId);
    }
}
