package com.yuepeng.web.manage.customer.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TFeedback;
import com.yuepeng.web.manage.customer.bean.excel.FeedbackExcel;
import com.yuepeng.web.manage.customer.bean.vo.FeedbackVo;

public interface IFeedbackService extends ISuperIntegerService<TFeedback> {
    Pagination<FeedbackVo> queryFeedbackPageList(Pagination<FeedbackVo> paramBean) throws Exception;

    public Pagination<FeedbackExcel> exportFeedbackPageList(Pagination<FeedbackVo> paramBean) throws Exception;

    public FeedbackVo queryFeedbackPageListById(Integer feedbackId) throws Exception;
}
