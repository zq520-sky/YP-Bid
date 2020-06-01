package com.yuepeng.module.controller;


import com.yuepeng.module.service.IProjectVisitService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户访问项目记录表(ProjectVisit)表控制层
 *
 * @author wzq
 * @since 2020-05-30 14:58:50
 */
@Slf4j
@RestController
@RequestMapping("/api/projectVisit")
@Api(value = "客户访问项目记录", tags = "客户访问项目记录")
public class ProjectVisitController {
    /**
     * 服务对象
     */
    @Resource
    private IProjectVisitService projectVisitService;

}