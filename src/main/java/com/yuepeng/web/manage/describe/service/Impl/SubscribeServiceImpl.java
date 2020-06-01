package com.yuepeng.web.manage.describe.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSet;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribeEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeVo;
import com.yuepeng.web.manage.describe.dao.TSubscribeSetMapper;
import com.yuepeng.web.manage.describe.service.ISubscribeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户订阅Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/17 14:20
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class SubscribeServiceImpl extends SuperServiceIntegerImpl<TSubscribeSetMapper,TSubscribeSet> implements ISubscribeService {
    @Override
    public Pagination<SubscribeVo> querySubscribePageList(Pagination<SubscribeVo> paramBean) throws Exception {
        Pagination<SubscribeVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SubscribeVo> list = mapper.querySubscribeSetList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<custSubscribeEntity> exportSubscribePageList(Pagination<SubscribeVo> paramBean) throws Exception {
        Pagination<custSubscribeEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<custSubscribeEntity> list = mapper.exportSubscribeSetList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public SubscribeVo querySubscribePageListById(Integer subscribeSetId) throws Exception {
        return this.mapper.selectSubscribeSetListById(subscribeSetId);
    }
}
