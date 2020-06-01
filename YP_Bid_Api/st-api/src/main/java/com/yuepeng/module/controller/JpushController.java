package com.yuepeng.module.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuepeng.base.annotation.ApiLog;
import com.yuepeng.base.annotation.Login;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.config.RUtils;
import com.yuepeng.module.dto.PageDto;
import com.yuepeng.module.entity.JpushEntity;
import com.yuepeng.module.service.IJpushService;
import com.yuepeng.utils.RTProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * 极光推送信息(Jpush)表控制层
 *
 * @author wzq
 * @since 2020-05-28 15:50:30
 */
@RestController
@RequestMapping("/api/jpush")
@Api(value = "极光推送信息", tags = "极光推送信息")
public class JpushController {
    /**
     * 服务对象
     */
    @Resource
    private IJpushService jpushService;

    @Login
    @ApiLog("获取消息列表")
    @PostMapping("/list")
    @ApiOperation(value = "获取消息列表", notes = "获取消息列表", tags = {"极光推送信息"})
    public R list(@RequestBody @Validated PageDto pageDto, @ApiIgnore @RequestAttribute(RTProperties.USER_KEY) Integer custId){
        IPage<JpushEntity> jpushPages = jpushService.selectPages(pageDto, custId);
        return RUtils.ok(jpushPages);
    }


}