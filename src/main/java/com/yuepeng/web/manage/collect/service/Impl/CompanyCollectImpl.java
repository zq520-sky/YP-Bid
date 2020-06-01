package com.yuepeng.web.manage.collect.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.collect.bean.entity.TCompanyCollect;
import com.yuepeng.web.manage.collect.bean.excel.CompanyCollectEntity;
import com.yuepeng.web.manage.collect.bean.vo.CompanyCollectVo;
import com.yuepeng.web.manage.collect.dao.TCompanyCollectMapper;
import com.yuepeng.web.manage.collect.service.ICompanyCollectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 收藏企业IMpl
 * @Author: ZhongShengbin
 * @Date: 2020/05/18 14:57
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class CompanyCollectImpl extends SuperServiceIntegerImpl<TCompanyCollectMapper, TCompanyCollect> implements ICompanyCollectService {

    /**
     * @Author ZhongShengbin
     * @Description //TODO 客户收藏企业分页
     * @Date 2020/5/18 0018
     * @Param [paramBean]
     * @return com.yuepeng.platform.framework.mybatis.pagination.Pagination<com.yuepeng.web.manage.collect.bean.vo.CompanyCollectVo>
     **/
    @Override
    public Pagination<CompanyCollectVo> queryCompanyPageList(Pagination<CompanyCollectVo> paramBean) throws Exception {
        Pagination<CompanyCollectVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<CompanyCollectVo> list = mapper.queryCompanyList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 客户收藏企业导出
     * @Date 2020/5/18 0018
     * @Param [paramBean]
     * @return com.yuepeng.platform.framework.mybatis.pagination.Pagination<com.yuepeng.web.manage.collect.bean.excel.CompanyCollectEntity>
     **/
    @Override
    public Pagination<CompanyCollectEntity> exportCompanyPageList(Pagination<CompanyCollectVo> paramBean) throws Exception {
        Pagination<CompanyCollectEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<CompanyCollectEntity> list = mapper.exportCompanyList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 客户收藏企业查看
     * @Date 2020/5/18 0018
     * @Param [projectCompanyId]
     * @return com.yuepeng.web.manage.collect.bean.vo.CompanyCollectVo
     **/
    @Override
    public CompanyCollectVo queryCompanyPageListById(Integer projectCompanyId) throws Exception {
        return this.mapper.queryCompanyListById(projectCompanyId);
    }
}
