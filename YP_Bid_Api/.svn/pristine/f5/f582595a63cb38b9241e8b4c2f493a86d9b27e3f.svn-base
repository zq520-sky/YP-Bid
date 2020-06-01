package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 省字典表(SysProvince)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:18:47
 */
@Data
@SuppressWarnings("serial")
@TableName("t_sys_province")
public class SysProvinceEntity extends Model<SysProvinceEntity> {
    /**
     * 省份ID
     */
    private Integer provinceId;
    /**
     * 省份名称
     */
    private String provinceName;
    /**
     * 省份简称
     */
    private String provinceShort;
    /**
     * 省份拼音
     */
    private String provinceAbbr;
    /**
     * 顺序号
     */
    private Integer orderNum;
    /**
     * 地区ID
     */
    private Long areaId;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.provinceId;
    }
}