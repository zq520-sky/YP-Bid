package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 招标信息类型信息
 * <p>
 * 1：招标预告
 * 2：招标公告
 * 3：公告变更
 * 4：招标答疑
 * 5：资审结果
 * 6：招标文件
 * 7：中标公告(Infotype)表实体类
 *
 * @author wzq
 * @since 2020-05-30 15:10:38
 */
@Data
@SuppressWarnings("serial")
@TableName("t_infotype")
public class InfotypeEntity extends Model<InfotypeEntity> {
    /**
     * 招标信息类型ID
     */
    private Integer infotypeId;
    /**
     * 招标信息类型名称
     */
    private String infotypeName;
    /**
     * 1：招标
     * 2：中标
     * 3：变更
     * 4：流标
     */
    private Integer classId;
    /**
     * 顺序号
     */
    private Integer orderNum;
    /**
     * 备注
     */
    private String remark;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.infotypeId;
    }
}