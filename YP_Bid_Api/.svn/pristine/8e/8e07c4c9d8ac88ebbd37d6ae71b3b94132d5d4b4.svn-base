package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 拟建项目信息表
 * <p>
 * 一、项目基本信息
 * 国家编码、项目代码、项目名称、项目类型、项目单位、立项单位、立项时间
 * <p>
 * 二、审批事项公示信息
 * 审批部门、审批事项、审批结果、审批时间(PlanProject)表实体类
 *
 * @author wzq
 * @since 2020-05-30 14:46:59
 */
@Data
@TableName("t_plan_project")
@SuppressWarnings("serial")
public class PlanProjectEntity extends Model<PlanProjectEntity> {
    /**
     * 拟建项目ID
     */
    private Integer planProjectId;
    /**
     * 数据来源ID
     */
    private Integer datasourceId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目代码
     */
    private String projectCode;
    /**
     * 国家编码
     */
    private String countryCode;
    /**
     * 项目类型
     */
    private String projectType;
    /**
     * 项目单位
     */
    private String projectUnit;
    /**
     * 立项单位
     */
    private String setupUnit;
    /**
     * 立项时间
     */
    private Date setupDate;
    /**
     * 审批部门
     */
    private String examineDepart;
    /**
     * 审批事项
     */
    private String examineItems;
    /**
     * 审批结果
     */
    private String examineResult;
    /**
     * 审批时间
     */
    private Date examineDate;
    /**
     * 项目详细信息
     */
    private String projectDetail;
    /**
     * 新增时间
     */
    private Date addDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 项目阶段id
     */
    private Integer stageId;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.planProjectId;
    }
}