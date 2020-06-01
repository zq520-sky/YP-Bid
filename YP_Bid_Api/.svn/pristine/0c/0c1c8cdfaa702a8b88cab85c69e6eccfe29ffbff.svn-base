package com.yuepeng.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 招标行业大类表：
 * <p>
 * 工程建设
 * 医疗卫生
 * 环保绿化
 * 信息建设
 * 办公文教
 * 商业服务
 * 机械设备
 * 服装家电
 * 农林牧渔
 * 能源化工
 * 智能制造
 * 资源交易
 * 政府采购
 * 土地矿产
 * 产权交易
 * PPP项目
 * 其他(Industry)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:11:04
 */
@Data
@SuppressWarnings("serial")
@TableName("t_industry")
public class IndustryEntity extends Model<IndustryEntity> {
    /**
     * 招标行业大类ID
     */
    private Integer industryId;
    /**
     * 招标行业大类名称
     * 工程建设
     * 医疗卫生
     * ...
     */
    private String industryName;
    /**
     * 顺序号
     */
    private Integer orderNum;
    /**
     * 创建用户ID
     */
    private Integer createUserId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改用户ID
     */
    private Integer updateUserId;
    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.industryId;
    }
}