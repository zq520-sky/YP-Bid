package com.yuepeng.web.manage.describe.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSearchPush;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribePushEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribePushVo;
import com.yuepeng.web.manage.describe.dao.TSubscribeSearchPushMapper;
import com.yuepeng.web.manage.describe.service.ISubscribePushService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户订阅推送Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/19 16:19
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class SubscribePushServiceImpl extends SuperServiceIntegerImpl<TSubscribeSearchPushMapper, TSubscribeSearchPush> implements ISubscribePushService {
    @Override
    public Pagination<SubscribePushVo> querySubscribePushPageList(Pagination<SubscribePushVo> paramBean) throws Exception {
        Pagination<SubscribePushVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SubscribePushVo> list = mapper.querySubscribePushList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<custSubscribePushEntity> exportSubscribePushPageList(Pagination<SubscribePushVo> paramBean) throws Exception {
        Pagination<custSubscribePushEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<custSubscribePushEntity> list = mapper.exportSubscribePushList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public SubscribePushVo querySubscribePushPageListById(Integer searchPushId) throws Exception {
        return this.mapper.selectSubscribePushListById(searchPushId);
    }
}
