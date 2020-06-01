package com.yuepeng.module.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户收藏招标单位表(CompanyCollect)表实体类
 *
 * @author wzq
 * @since 2020-05-30 14:56:55
 */
@Data
@SuppressWarnings("serial")
@TableName("t_company_collect")
public class CompanyCollectEntity extends Model<CompanyCollectEntity> {
    /**
     * 客户收藏招标单位ID
     */
    private Integer collectId;
    /**
     * 招标单位ID
     */
    private Integer projectCompanyId;
    /**
     * 客户ID
     */
    private Integer custId;
    /**
     * 收藏时间
     */
    private Date collectDate;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.collectId;
    }
}