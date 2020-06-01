package com.yuepeng.web.manage.datasource.bean.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceType;
import java.io.Serializable;
/**
 * DatasourceTypeExcel
 *
 * @author wzq
 * @since 2020-05-19 08:59:02
 */
public class DatasourceTypeExcel extends TDatasourceType implements Serializable{
    @Excel(name = "数据来源类型名称", width = 20)
    private String datasourceTypeName;

    @Excel(name = "备注", width = 35)
    private String remark;

    @Override
    public String getDatasourceTypeName() {
        return datasourceTypeName;
    }

    @Override
    public void setDatasourceTypeName(String datasourceTypeName) {
        this.datasourceTypeName = datasourceTypeName;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }
}