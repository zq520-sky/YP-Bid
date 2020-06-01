package com.yuepeng.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * 客户订阅设置表(SubscribeSet)表实体类
 *
 * @author wzq
 * @since 2020-05-30 14:45:15
 */
@Data
@TableName("t_subscribe_set")
@SuppressWarnings("serial")
public class SubscribeSetEntity extends Model<SubscribeSetEntity> {
    /**
     * 订阅设置ID
     */
    private Integer subscribeSetId;
    /**
     * 搜索类型
     * 0：标题搜索
     * 1：全文搜索
     */
    private Integer serarchType;
    /**
     * 关键词
     */
    private String keyWords;
    /**
     * 商机省份ID集合
     */
    private String provinceIds;
    /**
     * 商机城市ID集合
     */
    private String cityIds;
    /**
     * 商机区域(名称集合)
     */
    private String areaNames;
    /**
     * 招标信息类型ID集合
     * 1：招标预告
     * 2：招标公告
     * 3：公告变更
     * 4：招标答疑
     * 5：资审结果
     * 6：招标文件
     * 7：中标公告
     */
    private String infotypeIds;
    /**
     * 招标信息类型名称
     */
    private String infotypeNames;
    /**
     * 订阅时间
     */
    private Date subscribeSetTime;
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 创建时间
     */
    private Date createDate;
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
        return this.subscribeSetId;
    }
}