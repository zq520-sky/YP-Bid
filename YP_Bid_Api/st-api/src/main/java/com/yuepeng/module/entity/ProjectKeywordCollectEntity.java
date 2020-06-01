package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 客户添加项目关键词表
 * <p>
 * 客户首次登录APP后，会出现添加订阅项目关键词，默认首页数据查询就根据客户订阅的项目关键词进行。(ProjectKeywordCollect)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:00:25
 */
@Data
@SuppressWarnings("serial")
@TableName("t_project_keyword_collect")
public class ProjectKeywordCollectEntity extends Model<ProjectKeywordCollectEntity> {
    /**
     * 客户添加项目关键词ID
     */
    private Integer keywordCollectId;
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 收藏项目关键词
     * 0：招标
     * 1：中标
     * 2：流标
     * 3：变更
     */
    private String projectKeywords;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.keywordCollectId;
    }
}