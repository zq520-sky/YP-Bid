package com.yuepeng.module.dto;

import com.yuepeng.annotations.CheckField;
import com.yuepeng.valid.anno.Mobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 〈功能概述〉<br>
 *
 * @className: RegisterDto
 * @package: com.yuepeng.module.dto
 * @author: wzq
 * @date: 2020/5/26 17:52
 */
@Data
@ApiModel("注册实体")
public class RegisterDto extends BaseDto{

    @NotBlank
    @CheckField
    @Mobile(message = "请输入正确的手机号！")
    @ApiModelProperty(name = "mobile", value = "电话号码", example = "13792098212")
    private String mobile;

    @NotBlank
    @CheckField
    @ApiModelProperty(name = "captcha", value = "验证码", example = "353276")
    private String captcha;

    @NotBlank
    @CheckField
    @Length(min = 6, max = 16)
    @ApiModelProperty(name = "password", value = "登录密码", example = "123123")
    private String password;
}
