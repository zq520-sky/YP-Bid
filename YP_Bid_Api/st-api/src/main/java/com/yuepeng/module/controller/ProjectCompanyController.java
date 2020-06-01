package com.yuepeng.module.controller;


import com.yuepeng.module.service.IProjectCompanyService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 招标单位信息表(ProjectCompany)表控制层
 *
 * @author wzq
 * @since 2020-05-30 14:54:07
 */
@Slf4j
@RestController
@RequestMapping("/api/projectCompany")
@Api(value = "招标单位信息", tags = "招标单位信息")
public class ProjectCompanyController {
    /**
     * 服务对象
     */
    @Resource
    private IProjectCompanyService projectCompanyService;

}