package com.yuepeng.module.controller;


import com.yuepeng.module.service.IOrderService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户支付订单(Order)表控制层
 *
 * @author wzq
 * @since 2020-05-30 15:06:28
 */
@Slf4j
@RestController
@RequestMapping("/api/order")
@Api(value = "客户支付订单", tags = "客户支付订单")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private IOrderService orderService;

}