package com.yuepeng.module.dto;

import com.yuepeng.annotations.CheckField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 〈功能概述〉<br>
 *
 * @className: BaseDto
 * @package: com.yuepeng.module.dto
 * @author: wzq
 * @date: 2020/5/26 17:54
 */
@Data
@ApiModel
public class BaseDto {

    /**时间戳*/
    @NotNull
    @CheckField
    @ApiModelProperty(name = "timestamp", value = "时间戳", example = "1585827553151")
    private Long timestamp;
    /**签名*/
    @NotNull
    @ApiModelProperty(name = "sign", value = "签名")
    private String sign;

    /**
     * 判断时间是否过时，防止为之前的请求
     * @param delay 允许的时间差，单位毫秒
     * @author wzq
     * @date 2020/5/29 11:07
     * @return {@link boolean}
     */
    public boolean checkTimestamp(long delay){
        long time = System.currentTimeMillis() -timestamp;
        return time > delay;
    }

}
