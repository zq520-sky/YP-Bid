package com.yuepeng.module.controller;


import com.yuepeng.module.service.IMemberPriceService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * 会员价格表(MemberPrice)表控制层
 *
 * @author wzq
 * @since 2020-05-30 15:08:40
 */
@Slf4j
@RestController
@RequestMapping("/api/memberPrice")
@Api(value = "会员价格", tags = "会员价格")
public class MemberPriceController {
    /**
     * 服务对象
     */
    @Resource
    private IMemberPriceService memberPriceService;

}