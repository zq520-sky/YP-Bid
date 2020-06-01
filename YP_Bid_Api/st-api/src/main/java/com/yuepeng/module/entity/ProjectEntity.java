package com.yuepeng.module.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 招标项目信息表(Project)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:05:21
 */
@Data
@SuppressWarnings("serial")
@TableName("t_project")
public class ProjectEntity extends Model<ProjectEntity> {
    /**
     * 项目信息ID
     */
    private Integer projectId;
    /**
     * 项目名称
     */
    private String projectTitle;
    /**
     * 项目编号
     */
    private String projectCode;
    /**
     * 招标金额(预算)
     */
    private BigDecimal projectMoney;
    /**
     * 招标单位ID
     */
    private Integer projectCompanyId;
    /**
     * 招标单位名称
     */
    private String projectCompanyName;
    /**
     * 项目详细信息
     */
    private String projectDetail;
    /**
     * 项目发布日期
     */
    private Date releaseDate;
    /**
     * 所属省份ID
     */
    private Integer provinceId;
    /**
     * 所属城市ID
     */
    private Integer cityId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 新增时间
     */
    private Object addDate;
    /**
     * 修改时间
     */
    private Object updateDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.projectId;
    }
}