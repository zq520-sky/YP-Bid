package com.yuepeng.web.manage.datasource.service;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceInfotype;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceInfotypeVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceInfotypeExcel;


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
中介超市(DatasourceInfotype)表服务接口
 *
 * @author wzq
 * @since 2020-05-22 17:09:32
 */
public interface IDatasourceInfotypeService extends ISuperIntegerService<TDatasourceInfotype>{


    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-22 17:09:32
     * @return {@link Pagination< DatasourceInfotypeVo>}
     */
    Pagination<DatasourceInfotypeVo> queryDatasourceInfotypePageList(Pagination<DatasourceInfotypeVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-22 17:09:32
     * @return {@link Pagination< DatasourceInfotypeExcel>}
     */
    Pagination<DatasourceInfotypeExcel> exportDatasourceInfotypePageList(Pagination<TDatasourceInfotype> paramBean) throws Exception;

    /**
     *
     * @param datasourceInfotypeId
     * @author wzq
     * @date 2020-05-22 17:09:32
     * @return {@link com.yuepeng.web.manage.datasource.bean.vo.DatasourceInfotypeVo}
     */
    DatasourceInfotypeVo viewDatasourceInfotype(Integer datasourceInfotypeId) throws Exception;

}