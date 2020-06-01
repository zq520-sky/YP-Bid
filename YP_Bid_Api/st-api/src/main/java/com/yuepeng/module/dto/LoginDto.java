package com.yuepeng.module.dto;

import com.yuepeng.module.enums.LoginTypeEnums;
import com.yuepeng.valid.anno.Mobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 〈功能概述〉<br>
 *
 * @className: LoginDto
 * @package: com.yuepeng.module.dto
 * @author: wzq
 * @date: 2020/5/26 11:54
 */
@Data
@ApiModel("登录实体")
public class LoginDto {

    /**手机号*/
    @NotNull
    @Mobile(message = "请输入正确的手机号！")
    @ApiModelProperty(name = "mobile", value = "电话号码", example = "18720918640")
    private String mobile;
    /**密码*/
    @NotBlank
    @ApiModelProperty(name = "password", value = "登录密码", example = "123123")
    private String password;
    /**验证码*/
    @NotBlank
    @ApiModelProperty(name = "captcha", value = "验证码", example = "353276")
    private String captcha;
    /**登录类型*/
    @NotNull
    @ApiModelProperty(name = "loginType", value = "登录类型（PWD、CAPTCHA）", example = "CAPTCHA")
    private LoginTypeEnums loginType;
}
