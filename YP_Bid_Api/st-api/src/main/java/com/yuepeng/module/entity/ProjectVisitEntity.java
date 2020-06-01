package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 客户访问项目记录表(ProjectVisit)表实体类
 *
 * @author wzq
 * @since 2020-05-30 14:58:50
 */
@Data
@SuppressWarnings("serial")
@TableName("t_project_visit")
public class ProjectVisitEntity extends Model<ProjectVisitEntity> {
    /**
     * 客户访问ID
     */
    private Integer visitId;
    /**
     * 访问项目ID
     */
    private Integer projectId;
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 访问时间
     */
    private Date visitDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.visitId;
    }
}