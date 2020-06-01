package com.yuepeng.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 招标单位信息表(ProjectCompany)表实体类
 *
 * @author wzq
 * @since 2020-05-30 14:54:07
 */
@Data
@SuppressWarnings("serial")
@TableName("t_project_company")
public class ProjectCompanyEntity extends Model<ProjectCompanyEntity> {
    /**
     * 招标单位ID
     */
    private Integer projectCompanyId;
    /**
     * 招标单位名称
     */
    private String projectCompanyName;
    /**
     * 招标项目数量
     */
    private Integer ifbAmount;
    /**
     * 投标项目数量
     */
    private Integer bidAmount;
    /**
     * 中标项目数量
     */
    private Integer sucbidAmount;
    /**
     * 备注
     */
    private String remark;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 招标单位编号
     */
    private String projectCompanyCode;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.projectCompanyId;
    }
}