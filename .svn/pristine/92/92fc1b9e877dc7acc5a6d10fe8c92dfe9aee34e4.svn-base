package com.yuepeng.web.manage.project.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.collect.bean.excel.CompanyCollectEntity;
import com.yuepeng.web.manage.collect.bean.vo.CompanyCollectVo;
import com.yuepeng.web.manage.collect.service.ICompanyCollectService;
import com.yuepeng.web.manage.project.bean.entity.TSearchHotword;
import com.yuepeng.web.manage.project.bean.excel.SearchHotwordEntity;
import com.yuepeng.web.manage.project.bean.vo.SearchHotwordVo;
import com.yuepeng.web.manage.project.dao.TSearchHotwordMapper;
import com.yuepeng.web.manage.project.service.ISearchHotwordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 搜索热词实现类
 * @Author: ZhongShengbin
 * @Date: 2020/05/18 16:33
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class SearchHotwordImpl extends SuperServiceIntegerImpl<TSearchHotwordMapper, TSearchHotword> implements ISearchHotwordService {

    /**
     * @Author ZhongShengbin
     * @Description //TODO 热词设置分页
     * @Date 2020/5/18 0018
     * @Param [paramBean]
     * @return com.yuepeng.platform.framework.mybatis.pagination.Pagination<com.yuepeng.web.manage.project.bean.vo.SearchHotwordVo>
     **/
    @Override
    public Pagination<SearchHotwordVo> queryHotwordPageList(Pagination<SearchHotwordVo> paramBean) throws Exception {
        Pagination<SearchHotwordVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SearchHotwordVo> list = mapper.queryHotwordList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 热词设置导出
     * @Date 2020/5/18 0018
     * @Param [paramBean]
     * @return com.yuepeng.platform.framework.mybatis.pagination.Pagination<com.yuepeng.web.manage.project.bean.excel.SearchHotwordEntity>
     **/
    @Override
    public Pagination<SearchHotwordEntity> exportHotwordPageList(Pagination<SearchHotwordVo> paramBean) throws Exception {
        Pagination<SearchHotwordEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SearchHotwordEntity> list = mapper.exportHotwordList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 热词设置查看
     * @Date 2020/5/18 0018
     * @Param [projectCompanyId]
     * @return com.yuepeng.web.manage.project.bean.vo.SearchHotwordVo
     **/
    @Override
    public SearchHotwordVo queryHotwordPageListById(Integer projectCompanyId) throws Exception {
        return this.mapper.queryHotwordListById(projectCompanyId);
    }
}
