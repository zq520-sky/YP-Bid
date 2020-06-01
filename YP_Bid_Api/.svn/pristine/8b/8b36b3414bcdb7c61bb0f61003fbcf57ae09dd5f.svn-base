package com.yuepeng.module.controller;

import cn.hutool.core.lang.Dict;
import com.yuepeng.base.annotation.ApiLog;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.config.RUtils;
import com.yuepeng.module.entity.CaptchaEntity;
import com.yuepeng.module.service.CaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: CaptchaController
 * @package: com.yuepeng.module.controller
 * @author: wzq
 * @date: 2020/5/26 11:34
 */
@RestController
@RequestMapping("/api/captcha")
@Api(value = "短信", tags = {"短信"})
public class CaptchaController {

    private final CaptchaService captchaService;

    public CaptchaController(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @ApiLog("发送验证码")
    @PostMapping("/send")
    @ApiOperation(value = "发送验证码", notes = "发送验证码", tags = {"短信"})
    public R sendCaptcha(@RequestBody Dict dict) {
        //生成验证码
        CaptchaEntity captcha = captchaService.createCaptcha(dict);
        return RUtils.ok(captcha);
    }

}
