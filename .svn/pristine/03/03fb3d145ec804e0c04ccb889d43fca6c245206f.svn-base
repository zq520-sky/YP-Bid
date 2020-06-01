package com.yuepeng.web.manage.datasource.dao;

import com.yuepeng.web.manage.datasource.bean.entity.TDatasourceIndustry;
import com.yuepeng.web.manage.datasource.bean.vo.DatasourceIndustryVo;
import com.yuepeng.web.manage.datasource.bean.excel.DatasourceIndustryExcel;
import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
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
中介超市(DatasourceIndustry)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-22 16:20:56
 */
public interface TDatasourceIndustryMapper extends AutoMapperInteger<TDatasourceIndustry>{

    List<DatasourceIndustryVo> queryDatasourceIndustryPageList(Pagination<DatasourceIndustryVo> paramBean, RowBounds rowBounds) throws Exception;

    List<DatasourceIndustryExcel> exportDatasourceIndustryPageList(Pagination<TDatasourceIndustry> paramBean, RowBounds rowBounds) throws Exception;

    DatasourceIndustryVo viewDatasourceIndustry(Integer datasourceIndustryId) throws Exception;

    List<Map<String, Object>> selectByDatasourceId(Integer datasourceId) throws Exception;

}