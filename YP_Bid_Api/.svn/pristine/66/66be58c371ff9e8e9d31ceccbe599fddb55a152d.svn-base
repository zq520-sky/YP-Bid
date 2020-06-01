package com.yuepeng.module.controller;


import com.yuepeng.base.annotation.ApiLog;
import com.yuepeng.base.annotation.Login;
import com.yuepeng.base.constants.ApiConstants;
import com.yuepeng.dispose.annotation.IgnorReponseAdvice;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.common.RCode;
import com.yuepeng.dispose.config.RUtils;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.module.dto.PwdUpdateDto;
import com.yuepeng.module.entity.CustomerEntity;
import com.yuepeng.module.service.ICustomerService;
import com.yuepeng.utils.CheckSignUtils;
import com.yuepeng.utils.FileUtils;
import com.yuepeng.utils.RTProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

/**
 * 客户信息表(Customer)表控制层
 *
 * @author wzq
 * @since 2020-05-26 19:36:43
 */
@Slf4j
@RestController
@Validated
@RequestMapping("/api/customer")
@Api(value = "客户信息", tags = "客户信息")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ApiConstants apiConstants;

    @ApiLog("修改密码")
    @PostMapping("/pwd/update")
    @ApiOperation(value = "修改密码", notes = "修改密码", tags = {"客户信息"})
    public R updatePwd(@Validated @RequestBody PwdUpdateDto pwdUpdateDto) throws Exception {
        boolean isOvertime = pwdUpdateDto.checkTimestamp(apiConstants.getRequestDelaytime());
        if(isOvertime){
            throw new RRException(RCode.REQUEST_TIME_OUT);
        }
        boolean checkSign = CheckSignUtils.checkSign(pwdUpdateDto, apiConstants.getSignSalt());
        if(!checkSign){
            throw new RRException(RCode.SIGN_ERROR);
        }
        customerService.updatePwd(pwdUpdateDto);
        return RUtils.ok();
    }

    @Login
    @IgnorReponseAdvice
    @ApiLog("获取客户头像")
    @GetMapping("/getCustHeadPic")
    @ApiOperation(value = "获取客户头像", notes = "获取客户头像", tags = {"客户信息"})
    public R getCustHeadPic(@ApiIgnore @RequestAttribute(RTProperties.USER_KEY) Integer custId, HttpServletResponse response){
        CustomerEntity customerEntity = customerService.getById(custId);
        if(customerEntity == null || StringUtils.isBlank(customerEntity.getHeadImg())){
            return RUtils.fail();
        }
        FileUtils.downloadImage(customerEntity.getHeadImg(), response);
        return RUtils.ok();
    }

    @Login
    @ApiLog("修改客户头像")
    @PostMapping("/updateCustPic")
    @ApiOperation(value = "修改客户头像", tags = {"客户信息"})
    public R updateCustPic(@RequestParam("file") MultipartFile imageFile, @ApiIgnore @RequestAttribute(RTProperties.USER_KEY) Integer custId) throws Exception {
        customerService.updateCustHeadPic(imageFile, custId);
        return RUtils.ok();
    }
}