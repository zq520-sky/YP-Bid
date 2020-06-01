package com.yuepeng.module.controller;


import com.yuepeng.module.service.IProjectCollectService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户收藏项目表(ProjectCollect)表控制层
 *
 * @author wzq
 * @since 2020-05-30 14:52:54
 */
@Slf4j
@RestController
@RequestMapping("/api/projectCollect")
@Api(value = "客户收藏项目", tags = "客户收藏项目")
public class ProjectCollectController {
    /**
     * 服务对象
     */
    @Resource
    private IProjectCollectService projectCollectService;

}