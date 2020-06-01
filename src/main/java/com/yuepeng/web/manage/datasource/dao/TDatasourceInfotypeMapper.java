package com.yuepeng.web.manage.datasource.dao;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceInfotype;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceInfotypeVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceInfotypeExcel;
import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
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
中介超市(DatasourceInfotype)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-22 17:09:30
 */
public interface TDatasourceInfotypeMapper extends AutoMapperInteger<TDatasourceInfotype>{

    List<DatasourceInfotypeVo> queryDatasourceInfotypePageList(Pagination<DatasourceInfotypeVo> paramBean, RowBounds rowBounds) throws Exception;

    List<DatasourceInfotypeExcel> exportDatasourceInfotypePageList(Pagination<TDatasourceInfotype> paramBean, RowBounds rowBounds) throws Exception;

    DatasourceInfotypeVo viewDatasourceInfotype(Integer datasourceInfotypeId) throws Exception;

    List<TDatasourceInfotype> selectListByDatasourceIndustryId(Integer datasourceIndustryId) throws Exception;
}