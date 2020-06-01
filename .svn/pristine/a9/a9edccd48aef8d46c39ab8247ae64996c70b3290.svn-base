package com.yuepeng.web.manage.datasource.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.datasource.bean.entity.TDatacrawlerSet;
import com.yuepeng.web.manage.datasource.bean.excel.DatacrawlerExcel;
import com.yuepeng.web.manage.datasource.bean.vo.DatacrawlerSetVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TDatacrawlerSetMapper extends AutoMapperInteger<TDatacrawlerSet> {
    List<DatacrawlerSetVo> queryCrawPageList(Pagination<DatacrawlerSetVo> paramBean, RowBounds rowBounds) throws Exception;

    List<DatacrawlerExcel> exportCrawPageList(Pagination<DatacrawlerSetVo> paramBean, RowBounds rowBounds) throws Exception;

    DatacrawlerSetVo viewCraw(Integer industrySubId) throws Exception;

    List<DatacrawlerSetVo> getCrawTypes() throws Exception;
}