package com.yuepeng.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 会员信息(Member)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:08:12
 */
@Data
@SuppressWarnings("serial")
@TableName("t_member")
public class MemberEntity extends Model<MemberEntity> {
    /**
     * 会员ID
     */
    private Integer memberId;
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 会员类型：
     * 1：省级VIP
     * 2：高级VIP
     * 3：项目VIP
     */
    private Integer memberType;
    /**
     * 权限区域(省份ID，逗号隔开)
     */
    private String roleProvinceIds;
    /**
     * 权限区域名称集合
     */
    private String roleProvinceNames;
    /**
     * 会员开始时间
     */
    private Date useStartTime;
    /**
     * 会员结束时间
     */
    private Date useEndTime;
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
        return this.memberId;
    }
}