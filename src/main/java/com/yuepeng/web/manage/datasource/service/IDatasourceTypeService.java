package com.yuepeng.web.manage.datasource.service;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceType;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceTreeVo;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceTypeVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceTypeExcel;

import javax.xml.crypto.Data;
import java.util.List;


/**
 * 招标数据来源类型表

0：省平台
1：市平台
1：央企业招投标
2：...(DatasourceType)表服务接口
 *
 * @author wzq
 * @since 2020-05-19 08:58:58
 */
public interface IDatasourceTypeService extends ISuperIntegerService<TDatasourceType>{


    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-19 08:58:58
     * @return {@link Pagination< DatasourceTypeVo>}
     */
    Pagination<DatasourceTypeVo> queryDatasourceTypePageList(Pagination<DatasourceTypeVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-19 08:58:58
     * @return {@link Pagination< DatasourceTypeExcel>}
     */
    Pagination<DatasourceTypeExcel> exportDatasourceTypePageList(Pagination<TDatasourceType> paramBean) throws Exception;

    /**
     *
     * @param datasourceTypeId
     * @author wzq
     * @date 2020-05-19 08:58:58
     * @return {@link com.yuepeng.web.manage.datasource.bean.vo.DatasourceTypeVo}
     */
    DatasourceTypeVo viewDatasourceType(Integer datasourceTypeId) throws Exception;

    /**
     * 获取数据源类型
     * @param
     * @author wzq
     * @date 2020/5/21 9:19
     * @return {@link List< DatasourceTypeVo>}
     */
    List<DatasourceTypeVo> getDatasourceTypes() throws Exception;

    List<DatasourceTreeVo> getDatasourceTypeInfos() throws Exception;

    List<DatasourceTreeVo> getDatasourceTypeDetails() throws Exception;
}