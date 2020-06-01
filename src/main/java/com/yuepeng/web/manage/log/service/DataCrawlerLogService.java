package com.yuepeng.web.manage.log.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.log.bean.entity.TDatacrawlerService;
import com.yuepeng.web.manage.log.bean.excel.CustomerVisitLogExcel;
import com.yuepeng.web.manage.log.bean.excel.DataCrawlerLogExcel;
import com.yuepeng.web.manage.log.bean.vo.CustomerVisitLogVo;
import com.yuepeng.web.manage.log.bean.vo.DataCrawlerLogVo;

import java.util.List;

public interface DataCrawlerLogService extends ISuperIntegerService<DataCrawlerLogVo> {
    //分页list
    Pagination<DataCrawlerLogVo> queryDataCrawlerLogList(Pagination<DataCrawlerLogVo> paramBean) throws Exception;
    Pagination<DataCrawlerLogExcel> exportDataCrawlerLogList(Pagination<DataCrawlerLogVo> paramBean) throws Exception;

    //查询所有爬虫服务
    List<TDatacrawlerService> queryDatacrawlerServiceAll();
}
