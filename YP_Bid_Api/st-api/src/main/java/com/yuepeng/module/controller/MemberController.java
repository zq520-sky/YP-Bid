package com.yuepeng.module.controller;


import com.yuepeng.module.service.IMemberService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * 会员信息(Member)表控制层
 *
 * @author wzq
 * @since 2020-05-30 15:08:12
 */
@Slf4j
@RestController
@RequestMapping("/api/member")
@Api(value = "会员信息", tags = "会员信息")
public class MemberController {
    /**
     * 服务对象
     */
    @Resource
    private IMemberService memberService;

}