package com.yuepeng.module.controller;


import com.yuepeng.module.service.IProjectService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 招标项目信息表(Project)表控制层
 *
 * @author wzq
 * @since 2020-05-30 15:05:21
 */
@Slf4j
@RestController
@RequestMapping("/api/project")
@Api(value = "招标项目信息", tags = "招标项目信息")
public class ProjectController {
    /**
     * 服务对象
     */
    @Resource
    private IProjectService projectService;

}