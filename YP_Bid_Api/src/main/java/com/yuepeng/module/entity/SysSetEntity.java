package com.yuepeng.module.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * t_sys_set
 * @author 
 */
@Data
public class SysSetEntity implements Serializable {
    /**
     * 系统设置ID
     */
    private Integer setId;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 系统名称
     */
    private String sysName;

    /**
     * 系统LOGO
     */
    private String sysLogo;

    /**
     * 每日新增累加值
     */
    private Integer dayNumAdd;

    private static final long serialVersionUID = 1L;
}