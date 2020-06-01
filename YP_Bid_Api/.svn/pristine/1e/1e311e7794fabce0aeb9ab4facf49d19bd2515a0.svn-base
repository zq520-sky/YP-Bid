package com.yuepeng.module.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @ClassName: PageDto
 * @Description:
 * @Author: wuzhiqiang
 * @Date: 2020-04-10 16:08
 **/
@Data
@ApiModel("分页实体")
public class PageDto {

    @Min(value = 1L)
    @ApiModelProperty(name = "page", value = "当前页码", example = "1")
    private Integer page = 1;
    @Min(value = 1L)
    @ApiModelProperty(name = "pageSize", value = "每页的数据条数", example = "10")
    private Integer pageSize = 10;

}