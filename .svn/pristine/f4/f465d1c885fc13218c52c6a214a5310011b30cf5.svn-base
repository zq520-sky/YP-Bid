package com.yuepeng.web.manage.dict.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TProjectKeyword;
import com.yuepeng.web.manage.dict.bean.excel.ProjectKeywordEntity;
import com.yuepeng.web.manage.dict.bean.vo.ProjectKeywordVo;
import com.yuepeng.web.manage.dict.dao.TProjectKeywordMapper;
import com.yuepeng.web.manage.dict.service.IProjectKeywordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 字典管理-关键词管理Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/22 10:22
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class ProjectKeywordImpl extends SuperServiceIntegerImpl<TProjectKeywordMapper, TProjectKeyword> implements IProjectKeywordService {
    @Override
    public Pagination<ProjectKeywordVo> queryProjectKeywordPageList(Pagination<ProjectKeywordVo> paramBean) throws Exception {
        Pagination<ProjectKeywordVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectKeywordVo> list = mapper.queryProjectKeywordList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<ProjectKeywordEntity> exportProjectKeywordList(Pagination<ProjectKeywordVo> paramBean) throws Exception {
        Pagination<ProjectKeywordEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectKeywordEntity> list = mapper.exportProjectKeywordList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public ProjectKeywordVo queryProjectKeywordListById(Integer projectKeywordId) throws Exception {
        return this.mapper.selectProjectKeywordListById(projectKeywordId);
    }
}
