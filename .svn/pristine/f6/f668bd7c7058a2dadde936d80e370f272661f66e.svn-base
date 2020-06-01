package com.yuepeng.web.manage.datasource.service;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceIndustry;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceIndustryVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceIndustryExcel;

import java.util.List;
import java.util.Map;


/**
 * 招标数据源行业类型

重庆市公共资源交易网：
工程招投标
产权交易
机电设备
土地及矿业权
政府采购
碳排放权交易
其他采购
排污权交易
中介超市(DatasourceIndustry)表服务接口
 *
 * @author wzq
 * @since 2020-05-22 16:20:57
 */
public interface IDatasourceIndustryService extends ISuperIntegerService<TDatasourceIndustry>{


    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-22 16:20:57
     * @return {@link Pagination< DatasourceIndustryVo>}
     */
    Pagination<DatasourceIndustryVo> queryDatasourceIndustryPageList(Pagination<DatasourceIndustryVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-22 16:20:57
     * @return {@link Pagination< DatasourceIndustryExcel>}
     */
    Pagination<DatasourceIndustryExcel> exportDatasourceIndustryPageList(Pagination<TDatasourceIndustry> paramBean) throws Exception;

    /**
     *
     * @param datasourceIndustryId
     * @author wzq
     * @date 2020-05-22 16:20:57
     * @return {@link com.yuepeng.web.manage.datasource.bean.vo.DatasourceIndustryVo}
     */
    DatasourceIndustryVo viewDatasourceIndustry(Integer datasourceIndustryId) throws Exception;

    /**
     *
     * @param datasourceIndustryId
     * @author wzq
     * @date 2020/5/22 17:06
     * @return {@link boolean}
     */
    boolean deleteDatasourceIndustryById(Integer datasourceIndustryId) throws Exception;

    /**
     *
     * @param datasourceId
     * @author wzq
     * @date 2020/5/28 10:06
     * @return {@link java.util.Map<java.lang.String,java.lang.Object>}
     */
    List<Map<String, Object>> getDatasourceIndustryByDatasourceId(Integer datasourceId) throws Exception;
}