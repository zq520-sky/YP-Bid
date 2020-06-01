package com.yuepeng.web.manage.datasource.service;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasource;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceExcel;

import java.util.List;
import java.util.Map;


/**
 * 招标数据来源站点表

1：省平台     青海省                          青海省公共资源交易网
2：市平台     青海省    格尔木市      格尔木市公共资源交易网
3：央企业招投标    中国化工装备招投标交易平台
4：...(Datasource)表服务接口
 *
 * @author wzq
 * @since 2020-05-21 09:07:49
 */
public interface IDatasourceService extends ISuperIntegerService<TDatasource>{


    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-21 09:07:49
     * @return {@link Pagination< DatasourceVo>}
     */
    Pagination<DatasourceVo> queryDatasourcePageList(Pagination<DatasourceVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-21 09:07:49
     * @return {@link Pagination< DatasourceExcel>}
     */
    Pagination<DatasourceExcel> exportDatasourcePageList(Pagination<TDatasource> paramBean) throws Exception;

    /**
     *
     * @param datasourceId
     * @author wzq
     * @date 2020-05-21 09:07:49
     * @return {@link com.yuepeng.web.manage.datasource.bean.vo.DatasourceVo}
     */
    DatasourceVo viewDatasource(Integer datasourceId) throws Exception;

    /**
     *
     * @param datasourceTypeId
     * @author wzq
     * @date 2020/5/27 19:48
     * @return {@link java.util.List<java.util.Map<java.lang.String,java.lang.Object>>}
     */
    List<Map<String, Object>> getDatasourceByTypeId(Integer datasourceTypeId) throws Exception;

}