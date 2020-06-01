package com.yuepeng.module.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: CaptchaEntity
 * @Description: 短信实体类
 * @Author: wuzhiqiang
 * @Date: 2020-03-02 11:03
 * @Copyright (c) 2020, Samton. All rights reserved
 **/
@Data
@TableName("t_captcha")
@ApiModel("短信实体")
public class CaptchaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(value="主键id", dataType = "Integer")
    private Integer id;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号码", dataType = "String")
    private String mobile;
    /**
     * 短信验证码
     */
    @ApiModelProperty(value = "验证码", dataType = "String")
    private String captcha;
    /**
     * 过期时间
     */
    @ApiModelProperty(value = "过期时间", dataType = "Date")
    private Date expireTime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", dataType = "Date")
    private Date updateTime;

}
