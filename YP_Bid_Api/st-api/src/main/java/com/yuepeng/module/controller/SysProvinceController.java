package com.yuepeng.module.controller;


import com.yuepeng.module.service.ISysProvinceService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 省字典表(SysProvince)表控制层
 *
 * @author wzq
 * @since 2020-05-30 15:18:47
 */
@Slf4j
@RestController
@RequestMapping("/api/sysProvince")
@Api(value = "省", tags = "省")
public class SysProvinceController {
    /**
     * 服务对象
     */
    @Resource
    private ISysProvinceService sysProvinceService;

}