package com.yuepeng.module.controller;


import com.yuepeng.module.service.IProjectKeywordCollectService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户添加项目关键词表
 * <p>
 * 客户首次登录APP后，会出现添加订阅项目关键词，默认首页数据查询就根据客户订阅的项目关键词进行。(ProjectKeywordCollect)表控制层
 *
 * @author wzq
 * @since 2020-05-30 15:00:25
 */
@Slf4j
@RestController
@RequestMapping("/api/projectKeywordCollect")
@Api(value = "客户项目关键词", tags = "客户项目关键词")
public class ProjectKeywordCollectController {
    /**
     * 服务对象
     */
    @Resource
    private IProjectKeywordCollectService projectKeywordCollectService;

}