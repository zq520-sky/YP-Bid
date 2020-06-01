package com.yuepeng.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuepeng.module.entity.PlanProjectEntity;

/**
 * 拟建项目信息表

一、项目基本信息
国家编码、项目代码、项目名称、项目类型、项目单位、立项单位、立项时间

二、审批事项公示信息
审批部门、审批事项、审批结果、审批时间(PlanProject)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-30 14:46:59
 */
public interface PlanProjectDao extends BaseMapper<PlanProjectEntity> {

}