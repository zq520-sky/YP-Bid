package com.yuepeng.web.manage.count.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.count.bean.entity.TDataCrawlerReport;
import com.yuepeng.web.manage.count.bean.excel.TDataCrawlerReportExcel;
import com.yuepeng.web.manage.count.bean.vo.DataCrawlerReportVo;

public interface DataCrawlerReportService extends ISuperIntegerService<DataCrawlerReportVo> {
    //每日爬取统计报表-分页
    Pagination<DataCrawlerReportVo> queryDataCrawlerReportList(Pagination<DataCrawlerReportVo> paramBean);
    //每日爬取统计报表 -导出
    Pagination<TDataCrawlerReportExcel> exportDataCrawlerReportList(Pagination<DataCrawlerReportVo> paramBean);
}
