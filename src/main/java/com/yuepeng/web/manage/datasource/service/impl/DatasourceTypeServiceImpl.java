package com.yuepeng.web.manage.datasource.service.impl;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceType;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceTreeVo;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceTypeVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceTypeExcel;
import com.yuepeng.web.manage.datasource.dao.TDatasourceTypeMapper;
import com.yuepeng.web.manage.datasource.service.IDatasourceTypeService;
import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 招标数据来源类型表

0：省平台
1：市平台
1：央企业招投标
2：...(DatasourceType)表服务实现类
 *
 * @author wzq
 * @since 2020-05-19 08:58:59
 */
@Service("datasourceTypeService")
public class DatasourceTypeServiceImpl extends SuperServiceIntegerImpl<TDatasourceTypeMapper, TDatasourceType> implements IDatasourceTypeService {
    
    @Override
    public Pagination<DatasourceTypeVo> queryDatasourceTypePageList(Pagination<DatasourceTypeVo> paramBean) throws Exception {
        Pagination<DatasourceTypeVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DatasourceTypeVo> list = mapper.queryDatasourceTypePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<DatasourceTypeExcel> exportDatasourceTypePageList(Pagination<TDatasourceType> paramBean) throws Exception {
        Pagination<DatasourceTypeExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DatasourceTypeExcel> list = mapper.exportDatasourceTypePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public DatasourceTypeVo viewDatasourceType(Integer datasourceTypeId) throws Exception {
        return mapper.viewDatasourceType(datasourceTypeId);
    }

    @Override
    public List<DatasourceTypeVo> getDatasourceTypes() throws Exception {
        return mapper.selectDatasourceTypes();
    }

    @Override
    public List<DatasourceTreeVo> getDatasourceTypeInfos() throws Exception {
        return mapper.selectDatasourceTypeInfos();
    }

    @Override
    public List<DatasourceTreeVo> getDatasourceTypeDetails() throws Exception {
        return mapper.selectDatasourceTypeDetails();
    }
}