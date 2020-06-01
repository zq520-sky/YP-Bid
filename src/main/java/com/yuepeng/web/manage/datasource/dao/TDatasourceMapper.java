package com.yuepeng.web.manage.datasource.dao;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasource;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceExcel;
import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
import java.util.List;
import java.util.Map;

/**
 * 招标数据来源站点表

1：省平台     青海省                          青海省公共资源交易网
2：市平台     青海省    格尔木市      格尔木市公共资源交易网
3：央企业招投标    中国化工装备招投标交易平台
4：...(Datasource)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-21 09:07:46
 */
public interface TDatasourceMapper extends AutoMapperInteger<TDatasource>{

    List<DatasourceVo> queryDatasourcePageList(Pagination<DatasourceVo> paramBean, RowBounds rowBounds) throws Exception;

    List<DatasourceExcel> exportDatasourcePageList(Pagination<TDatasource> paramBean, RowBounds rowBounds) throws Exception;

    DatasourceVo viewDatasource(Integer datasourceId) throws Exception;

    List<Map<String, Object>> selectDatasourceByTypeId(Integer datasourceTypeId) throws Exception;

}