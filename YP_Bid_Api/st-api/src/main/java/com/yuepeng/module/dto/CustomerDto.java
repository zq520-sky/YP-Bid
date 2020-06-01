package com.yuepeng.module.dto;

import io.swagger.annotations.Api;
import lombok.Data;

/**
 * 〈功能概述〉<br>
 *
 * @className: CustomerDto
 * @package: com.yuepeng.module.dto
 * @author: wzq
 * @date: 2020/5/26 19:40
 */
@Data
@Api("客户信息实体")
public class CustomerDto {

    private String mobile;

    private String pwd;

    private String captcha;
}
