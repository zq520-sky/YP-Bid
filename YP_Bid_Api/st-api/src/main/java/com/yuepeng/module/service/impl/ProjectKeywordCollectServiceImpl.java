package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.module.mapper.ProjectKeywordCollectDao;
import com.yuepeng.module.entity.ProjectKeywordCollectEntity;
import com.yuepeng.module.service.IProjectKeywordCollectService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 客户添加项目关键词表

客户首次登录APP后，会出现添加订阅项目关键词，默认首页数据查询就根据客户订阅的项目关键词进行。(ProjectKeywordCollect)表服务实现类
 *
 * @author wzq
 * @since 2020-05-30 15:00:25
 */
@Slf4j
@Service("projectKeywordCollectService")
public class ProjectKeywordCollectServiceImpl extends ServiceImpl<ProjectKeywordCollectDao, ProjectKeywordCollectEntity> implements IProjectKeywordCollectService {

}