package com.yuepeng.module.controller;

import com.yuepeng.base.annotation.ApiLog;
import com.yuepeng.base.annotation.Login;
import com.yuepeng.base.constants.ApiConstants;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.common.RCode;
import com.yuepeng.dispose.config.RUtils;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.module.dto.LoginDto;
import com.yuepeng.module.dto.RegisterDto;
import com.yuepeng.module.service.ILoginService;
import com.yuepeng.module.vo.CustomInfoVo;
import com.yuepeng.utils.CheckSignUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: LoginController
 * @package: com.yuepeng.module.controller
 * @author: wzq
 * @date: 2020/5/26 11:53
 */
@RestController
@Validated
@RequestMapping("/api/login")
@Api(value = "登录", tags = {"登录"})
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @Autowired
    private ApiConstants apiConstants;

    @ApiLog("登录")
    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "登录", tags = {"登录"})
    public R login(@RequestBody @Validated LoginDto loginDto) throws Exception {
        CustomInfoVo customInfoVo = loginService.login(loginDto);
        return RUtils.ok(customInfoVo);
    }

    @ApiLog("注册")
    @PostMapping("/register")
    @ApiOperation(value = "注册", notes = "注册", tags = {"登录"})
    public R register(@RequestBody @Validated RegisterDto registerDto) throws Exception {
        boolean isOvertime = registerDto.checkTimestamp(apiConstants.getRequestDelaytime());
        if(isOvertime){
            throw new RRException(RCode.REQUEST_TIME_OUT);
        }
        boolean checkSign = CheckSignUtils.checkSign(registerDto, apiConstants.getSignSalt());
        if(!checkSign){
            throw new RRException(RCode.SIGN_ERROR);
        }
        loginService.register(registerDto);
        return RUtils.ok();
    }
}
