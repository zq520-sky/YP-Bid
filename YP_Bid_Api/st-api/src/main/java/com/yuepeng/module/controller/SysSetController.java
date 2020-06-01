package com.yuepeng.module.controller;

import com.yuepeng.base.annotation.ApiLog;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.config.RUtils;
import com.yuepeng.module.entity.SysSetEntity;
import com.yuepeng.module.service.ISysSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 新增数量
 * @Author: ZhongShengbin
 * @Date: 2020/05/30 11:26
 * Copyright (c) 2019, Samton. All rights reserved
 */
@RestController
@RequestMapping("/api/sys")
@Api(value = "今日新增", tags = {"今日新增"})
public class SysSetController {
    private final ISysSetService sysSetService;

    @Autowired
    public SysSetController(ISysSetService sysSetService) {
        this.sysSetService = sysSetService;
    }

    @ApiLog("今日新增")
    @GetMapping("/getNum")
    @ApiOperation(value = "获取今日新增数量", tags = {"今日新增"})
    private R queryAddNum() throws Exception {
        Integer integer = sysSetService.addNums();
        return RUtils.ok(integer);
    }
}
