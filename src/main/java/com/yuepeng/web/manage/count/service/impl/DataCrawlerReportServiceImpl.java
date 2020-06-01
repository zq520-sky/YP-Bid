package com.yuepeng.web.manage.count.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.count.bean.entity.TDataCrawlerReport;
import com.yuepeng.web.manage.count.bean.excel.TDataCrawlerReportExcel;
import com.yuepeng.web.manage.count.bean.vo.DataCrawlerReportVo;
import com.yuepeng.web.manage.count.dao.DataCrawlerReportMapper;
import com.yuepeng.web.manage.count.service.DataCrawlerReportService;
import com.yuepeng.web.manage.log.bean.excel.CustomerLoginLogExcel;
import com.yuepeng.web.manage.log.bean.vo.AppLogLoginVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataCrawlerReportServiceImpl extends SuperServiceIntegerImpl<DataCrawlerReportMapper, DataCrawlerReportVo> implements DataCrawlerReportService {


    /**
     * 每日爬取统计报表-分页
     * @param paramBean
     * @return
     */
    public Pagination<DataCrawlerReportVo> queryDataCrawlerReportList(Pagination<DataCrawlerReportVo> paramBean) {
        Pagination<DataCrawlerReportVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DataCrawlerReportVo> list = mapper.queryDataCrawlerReportList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * 每日爬取统计报表 -导出
     * @param paramBean
     * @return
     */
    public Pagination<TDataCrawlerReportExcel> exportDataCrawlerReportList(Pagination<DataCrawlerReportVo> paramBean) {
        Pagination<TDataCrawlerReportExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<TDataCrawlerReportExcel> list = mapper.exportDataCrawlerReportList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }
}
