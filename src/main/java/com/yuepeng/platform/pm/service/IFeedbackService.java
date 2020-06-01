package com.yuepeng.platform.pm.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.pm.bean.entity.TFeedback;
import com.yuepeng.platform.pm.bean.vo.TFeedbackVo;

/**
 * @Description: 意见反馈Service接口
 * @Author: zhixin
 * @Date: 2019/10/28 14:59
 * Copyright (c) 2019, Samton. All rights reserved
*/
public interface IFeedbackService extends ISuperIntegerService<TFeedback> {
    /**
     * 根据ID查询意见反馈信息
     * @param feedbackId
     * @return
     * @throws Exception
     */
    public TFeedbackVo loadFeedbackById(Integer feedbackId) throws Exception;
    /**
     * 删除
     * @param feedback
     * @return
     * @throws Exception
     */
    public Integer delFeedback(TFeedback feedback) throws Exception;
}
