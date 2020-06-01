package com.yuepeng.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * 客户信息表(Customer)表实体类
 *
 * @author wzq
 * @since 2020-05-26 17:01:52
 */
@Data
@TableName("t_customer")
@SuppressWarnings("serial")
public class CustomerEntity extends Model<CustomerEntity> {
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 客户编号，7位长度：1000001起始
     */
    private String custCode;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别（0-未知；1-男；2-女）
     */
    private Integer sex;
    /**
     * 所在省份
     */
    private Integer provinceId;
    /**
     * 所在城市
     */
    private Integer cityId;
    /**
     * 是否会员
     * 0：否
     * 1：是
     */
    private Integer isMember;
    /**
     * 是否禁用（0-正常；1-已禁用）
     */
    private Integer isForbid;
    /**
     * 会员类型
     * 会员类型：
     * 0：普通用户
     * 1：省级VIP
     * 2：高级VIP
     * 3：项目VIP
     */
    private Integer memberType;
    /**
     * 绑定微信
     */
    private String wechat;
    /**
     * 绑定QQ
     */
    private String qq;
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * 注册时间
     */
    private Date registerDate;
    /**
     * 极光用户ID
     */
    private String jpushId;
    /**
     * 创建人ID
     */
    private Integer createUserId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人ID
     */
    private Integer modifyUserId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.custId;
    }
}