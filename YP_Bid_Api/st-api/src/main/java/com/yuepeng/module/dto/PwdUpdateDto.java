package com.yuepeng.module.dto;

import com.yuepeng.annotations.CheckField;
import com.yuepeng.valid.anno.Mobile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 〈功能概述〉<br>
 *
 * @className: PwdUpdateDto
 * @package: com.yuepeng.module.dto
 * @author: wzq
 * @date: 2020/5/26 19:46
 */
@Data
@Api("密码信息实体")
public class PwdUpdateDto extends BaseDto{

    /**手机号*/
    @NotNull
    @CheckField
    @Mobile(message = "请输入正确的手机号！")
    @ApiModelProperty(name = "mobile", value = "电话号码", example = "18720918640")
    private String mobile;

    /**密码*/
    @NotBlank
    @CheckField
    @ApiModelProperty(name = "password", value = "登录密码", example = "123123")
    private String password;

    /**验证码*/
    @NotBlank
    @CheckField
    @ApiModelProperty(name = "captcha", value = "验证码", example = "353276")
    private String captcha;
}
