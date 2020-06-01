package com.yuepeng.web.manage.customer.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TFeedback;
import com.yuepeng.web.manage.customer.bean.excel.FeedbackExcel;
import com.yuepeng.web.manage.customer.bean.vo.FeedbackVo;
import com.yuepeng.web.manage.customer.dao.TCustFeedbackMapper;
import com.yuepeng.web.manage.customer.service.IFeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户反馈impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/19 19:26
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service("custFeedbackServiceImpl")
public class CustFeedbackServiceImpl extends SuperServiceIntegerImpl<TCustFeedbackMapper, TFeedback> implements IFeedbackService {

    @Override
    public Pagination<FeedbackVo> queryFeedbackPageList(Pagination<FeedbackVo> paramBean) throws Exception {
        Pagination<FeedbackVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<FeedbackVo> list = mapper.queryFeedbackList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<FeedbackExcel> exportFeedbackPageList(Pagination<FeedbackVo> paramBean) throws Exception {
        Pagination<FeedbackExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<FeedbackExcel> list = mapper.exportFeedbackList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public FeedbackVo queryFeedbackPageListById(Integer feedbackId) throws Exception {
        return this.mapper.selectFeedbackListById(feedbackId);
    }
}
