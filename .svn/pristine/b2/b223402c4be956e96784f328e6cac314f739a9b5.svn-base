package com.yuepeng.web.manage.datasource.service.impl;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceInfotype;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceInfotypeVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceInfotypeExcel;
import com.yuepeng.web.manage.datasource.dao.TDatasourceInfotypeMapper;
import com.yuepeng.web.manage.datasource.service.IDatasourceInfotypeService;
import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 招标数据源信息类型表

重庆市公共资源交易网：
1、工程招投标：招标计划、招标公告划、邀标信息划、答疑补遗划、中标候选人公示划、中标结果公告划、合同履行情况划、相关公示公告

2、产权交易：交易公告、变更补充公告、成交公示
机电设备
土地及矿业权
政府采购
碳排放权交易
其他采购
排污权交易
中介超市(DatasourceInfotype)表服务实现类
 *
 * @author wzq
 * @since 2020-05-22 17:09:32
 */
@Service("datasourceInfotypeService")
public class DatasourceInfotypeServiceImpl extends SuperServiceIntegerImpl<TDatasourceInfotypeMapper, TDatasourceInfotype> implements IDatasourceInfotypeService {
    
    @Override
    public Pagination<DatasourceInfotypeVo> queryDatasourceInfotypePageList(Pagination<DatasourceInfotypeVo> paramBean) throws Exception {
        Pagination<DatasourceInfotypeVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DatasourceInfotypeVo> list = mapper.queryDatasourceInfotypePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<DatasourceInfotypeExcel> exportDatasourceInfotypePageList(Pagination<TDatasourceInfotype> paramBean) throws Exception {
        Pagination<DatasourceInfotypeExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DatasourceInfotypeExcel> list = mapper.exportDatasourceInfotypePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public DatasourceInfotypeVo viewDatasourceInfotype(Integer datasourceInfotypeId) throws Exception {
        return mapper.viewDatasourceInfotype(datasourceInfotypeId);
    }
    
}