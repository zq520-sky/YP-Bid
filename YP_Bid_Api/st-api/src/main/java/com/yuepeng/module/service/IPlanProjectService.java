package com.yuepeng.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuepeng.module.entity.PlanProjectEntity;

/**
 * 拟建项目信息表

一、项目基本信息
国家编码、项目代码、项目名称、项目类型、项目单位、立项单位、立项时间

二、审批事项公示信息
审批部门、审批事项、审批结果、审批时间(PlanProject)表服务接口
 *
 * @author wzq
 * @since 2020-05-30 14:46:59
 */
public interface IPlanProjectService extends IService<PlanProjectEntity> {

}