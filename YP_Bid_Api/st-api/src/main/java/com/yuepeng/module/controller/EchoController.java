package com.yuepeng.module.controller;

import com.yuepeng.base.annotation.ApiLog;
import com.yuepeng.base.config.JwtConfig;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.config.RUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(value = "服务测试", tags = {"服务测试"})
public class EchoController {

    @Autowired
    private JwtConfig jwtUtils;

    @ApiLog("测试服务")
    @GetMapping("/echo")
    @ApiOperation(value = "启动服务", notes = "判断服务是否启动成功", tags = {"服务测试"})
    public R echo(){
        return RUtils.ok("service starting...");
    }

    @ApiLog("获取token")
    @GetMapping("/token")
    @ApiOperation(value = "获取token", notes = "获取token", tags = {"服务测试"})
    public R login (@ApiParam(name = "userName", value = "用户名", required = true) @RequestParam("userName") String userName){
        Map<String,Object> result = new HashMap<>() ;
        // 省略数据源校验
        String token = jwtUtils.generateToken(userName) ;
        if (!StringUtils.isEmpty(token)) {
            result.put("token",token);
        }
        result.put("userName",userName) ;
        return RUtils.ok(result);
    }
}
