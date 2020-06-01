package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 客户收藏项目表(ProjectCollect)表实体类
 *
 * @author wzq
 * @since 2020-05-30 14:52:54
 */
@Data
@SuppressWarnings("serial")
@TableName("t_project_collect")
public class ProjectCollectEntity extends Model<ProjectCollectEntity> {
    /**
     * 客户关注ID
     */
    private Integer collectId;
    /**
     * 关注项目ID
     */
    private Integer projectId;
    /**
     * 关注客户ID
     */
    private Integer custId;
    /**
     * 收藏时间
     */
    private Date collectDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.collectId;
    }
}