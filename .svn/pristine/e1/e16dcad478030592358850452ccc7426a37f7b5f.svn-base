package com.yuepeng.web.manage.finance.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.finance.bean.entity.TMemberPrice;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 〈功能概述〉<br>
 *
 * @className: MemberPriceExcel
 * @package: com.yuepeng.web.manage.finance.bean.excel
 * @author: wzq
 * @date: 2020/5/14 20:10
 */
public class MemberPriceExcel extends TMemberPrice implements Serializable {

    @Excel(name = "会员类型", width = 12, replace = {"普通用户_0","省级VIP_1","高级VIP_2","项目VIP_3"})
    private Integer memberType;

    @Excel(name = "原价（元）", width = 15)
    private BigDecimal oldPrice;

    @Excel(name = "现价（元）", width = 15)
    private BigDecimal newPrice;

    @Excel(name = "时间范围（月）", width = 15)
    private Integer months;

    @Excel(name = "赠送月数（月）", width = 15)
    private Integer giveMonths;

    @Excel(name = "是否禁用", width = 10, replace = {"否_0", "是_1"})
    private Integer isForbid;

    @Excel(name = "备注", width = 50)
    private String remark;

    @Override
    public Integer getMemberType() {
        return memberType;
    }

    @Override
    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    @Override
    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    @Override
    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Override
    public BigDecimal getNewPrice() {
        return newPrice;
    }

    @Override
    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public Integer getMonths() {
        return months;
    }

    @Override
    public void setMonths(Integer months) {
        this.months = months;
    }

    @Override
    public Integer getGiveMonths() {
        return giveMonths;
    }

    @Override
    public void setGiveMonths(Integer giveMonths) {
        this.giveMonths = giveMonths;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public Integer getIsForbid() {
        return isForbid;
    }

    @Override
    public void setIsForbid(Integer isForbid) {
        this.isForbid = isForbid;
    }
}
