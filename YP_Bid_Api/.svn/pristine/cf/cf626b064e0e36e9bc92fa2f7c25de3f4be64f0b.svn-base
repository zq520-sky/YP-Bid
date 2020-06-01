package com.yuepeng.module.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 会员价格表(MemberPrice)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:08:40
 */
@Data
@SuppressWarnings("serial")
@TableName("t_member_price")
public class MemberPriceEntity extends Model<MemberPriceEntity> {
    /**
     * 会员价格ID
     */
    private Integer priceId;
    /**
     * 会员类型
     * 0：普通用户
     * 1：省级VIP
     * 2：高级VIP
     * 3：项目VIP
     */
    private Integer memberType;
    /**
     * 原价
     */
    private BigDecimal oldPrice;
    /**
     * 现价
     */
    private BigDecimal newPrice;
    /**
     * 时间范围(月)
     */
    private Integer months;
    /**
     * 赠送时间(月)
     */
    private Integer giveMonths;
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
     * 是否禁用：0-否，1-是
     */
    private Integer isForbid;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.priceId;
    }
}