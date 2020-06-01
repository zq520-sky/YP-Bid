package com.yuepeng.web.manage.describe.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSearch;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribeSearchEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeSearchVo;
import com.yuepeng.web.manage.describe.dao.TSubscribeSearchMapper;
import com.yuepeng.web.manage.describe.service.ISubscribeSearchService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户订阅查收Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/19 14:01
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class SubscribeSearchServiceImpl extends SuperServiceIntegerImpl<TSubscribeSearchMapper,TSubscribeSearch> implements ISubscribeSearchService {
    @Override
    public Pagination<SubscribeSearchVo> querySubscribeSearchPageList(Pagination<SubscribeSearchVo> paramBean) throws Exception {
        Pagination<SubscribeSearchVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SubscribeSearchVo> list = mapper.querySubscribeSearchList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<custSubscribeSearchEntity> exportSubscribeSearchPageList(Pagination<SubscribeSearchVo> paramBean) throws Exception {
        Pagination<custSubscribeSearchEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<custSubscribeSearchEntity> list = mapper.exportSubscribeSearchList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public SubscribeSearchVo querySubscribeSearchPageListById(Integer subscribeSearchId) throws Exception {
        return this.mapper.selectSubscribeSearchListById(subscribeSearchId);
    }
}
