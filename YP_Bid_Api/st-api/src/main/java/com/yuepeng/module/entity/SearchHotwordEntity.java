package com.yuepeng.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 项目搜索热词表(SearchHotword)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:11:44
 */
@Data
@SuppressWarnings("serial")
@TableName("t_search_hotword")
public class SearchHotwordEntity extends Model<SearchHotwordEntity> {
    /**
     * 热词ID
     */
    private Integer hotwordId;
    /**
     * 1：招投标项目
     * 2：拟建项目
     */
    private Integer projectType;
    /**
     * 搜索关键热词
     */
    private String hotwordName;
    /**
     * 搜索次数
     */
    private Integer searchTimes;
    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.hotwordId;
    }
}