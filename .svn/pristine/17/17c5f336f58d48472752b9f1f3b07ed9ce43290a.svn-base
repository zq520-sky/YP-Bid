package com.yuepeng.web.manage.customer.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TFeedback;
import com.yuepeng.web.manage.customer.bean.excel.FeedbackExcel;
import com.yuepeng.web.manage.customer.bean.vo.FeedbackVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TCustFeedbackMapper extends AutoMapperInteger<TFeedback> {
    List<FeedbackVo> queryFeedbackList(Pagination<FeedbackVo> paramBean, RowBounds rowBounds)throws Exception;

    List<FeedbackExcel> exportFeedbackList(Pagination<FeedbackVo> paramBean, RowBounds rowBounds) throws Exception;

    FeedbackVo selectFeedbackListById(Integer feedbackId) throws Exception;
}