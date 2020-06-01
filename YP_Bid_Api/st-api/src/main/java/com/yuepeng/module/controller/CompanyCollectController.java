package com.yuepeng.module.controller;


import com.yuepeng.module.service.ICompanyCollectService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户收藏招标单位表(CompanyCollect)表控制层
 *
 * @author wzq
 * @since 2020-05-30 14:56:55
 */
@Slf4j
@RestController
@RequestMapping("/api/companyCollect")
@Api(value = "客户收藏招标单位", tags = "客户收藏招标单位")
public class CompanyCollectController {
    /**
     * 服务对象
     */
    @Resource
    private ICompanyCollectService companyCollectService;

}