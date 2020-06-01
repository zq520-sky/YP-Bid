package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 极光推送信息(Jpush)表实体类
 *
 * @author wzq
 * @since 2020-05-28 15:50:30
 */
@Data
@SuppressWarnings("serial")
@TableName("t_jpush")
public class JpushEntity extends Model<JpushEntity> {
    /**
     * 极光消息ID
     */
    private Integer jpushId;
    /**
     * 消息编号
     */
    private String jpushCode;
    /**
     * 消息名称
     */
    private String title;
    /**
     * 发送平台
     */
    private Integer platformType;
    /**
     * 消息内容
     */
    private String extras;
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 推送ID
     */
    private String registrationid;
    /**
     * 推送状态
     */
    private Integer jpushStatus;
    /**
     * 返回报告
     */
    private String errorMsg;
    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Object resultTime;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    private Object createTime;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.jpushId;
    }
}