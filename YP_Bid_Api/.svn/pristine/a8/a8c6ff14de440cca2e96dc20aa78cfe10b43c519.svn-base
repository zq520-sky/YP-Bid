package com.yuepeng.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 会员权限表(MemberRole)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:09:11
 */
@Data
@SuppressWarnings("serial")
@TableName("t_member_role")
public class MemberRoleEntity extends Model<MemberRoleEntity> {
    /**
     * 会员权限ID
     */
    private Integer memberRoleId;
    /**
     * 会员类型
     * 0：普通用户
     * 1：省级VIP
     * 2：高级VIP
     * 3：项目VIP
     */
    private Integer memberType;
    /**
     * 全文搜索
     * 0：不支付
     * 1：无限制
     */
    private Integer isTextsearch;
    /**
     * 项目查看(条/日)
     */
    private Integer readProjectNum;
    /**
     * 商机订阅(条/日)
     */
    private Integer subscribeNum;
    /**
     * 商机收藏(条/日)
     */
    private Integer collectNum;
    /**
     * 商机推荐(条/日)
     */
    private Integer recommendNum;
    /**
     * 拟建项目(条/日)
     */
    private Integer planProjectNum;
    /**
     * 高级项目(条/日)
     */
    private Integer advancedNum;
    /**
     * 备注
     */
    private String remark;
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
        return this.memberRoleId;
    }
}