package com.yuepeng.web.manage.count.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.count.bean.excel.TDataCrawlerReportExcel;
import com.yuepeng.web.manage.count.bean.vo.DataCrawlerReportVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface DataCrawlerReportMapper extends AutoMapperInteger<DataCrawlerReportVo> {
    //每日爬取统计报表-分页
    List<DataCrawlerReportVo> queryDataCrawlerReportList(Pagination<DataCrawlerReportVo> paramBean, RowBounds rowBounds);
    //每日爬取统计报表 -导出
    List<TDataCrawlerReportExcel> exportDataCrawlerReportList(Pagination<DataCrawlerReportVo> paramBean, RowBounds rowBounds);
}
