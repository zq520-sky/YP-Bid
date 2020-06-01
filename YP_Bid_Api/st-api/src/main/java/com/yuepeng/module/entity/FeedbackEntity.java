package com.yuepeng.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 客户反馈意见表(Feedback)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:02:51
 */
@Data
@SuppressWarnings("serial")
@TableName("t_feedback")
public class FeedbackEntity extends Model<FeedbackEntity> {
    /**
     * 反馈意见ID
     */
    private Integer feedbackId;
    /**
     * 反馈意见
     */
    private String feedbackOpinion;
    /**
     * 反馈时间
     */
    private Date feedbackTime;
    /**
     * 客户ID
     */
    private Integer custId;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.feedbackId;
    }
}