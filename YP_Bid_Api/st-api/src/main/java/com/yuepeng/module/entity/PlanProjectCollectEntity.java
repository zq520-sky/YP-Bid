package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 客户收藏拟建项目表(PlanProjectCollect)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:03:42
 */
@Data
@SuppressWarnings("serial")
@TableName("t_plan_project_collect")
public class PlanProjectCollectEntity extends Model<PlanProjectCollectEntity> {
    /**
     * 客户关注ID
     */
    private Integer collectId;
    /**
     * 拟建项目ID
     */
    private Integer planProjectId;
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