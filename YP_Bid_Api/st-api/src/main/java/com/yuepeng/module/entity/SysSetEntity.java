package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 新增累加值
 * @Author: ZhongShengbin
 * @Date: 2020/05/30 10:36
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Data
@TableName("t_sys_set")
public class SysSetEntity implements Serializable {

    private Integer dayNumAdd;

}
