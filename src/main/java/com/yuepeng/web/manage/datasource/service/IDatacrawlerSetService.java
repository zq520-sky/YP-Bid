package com.yuepeng.web.manage.datasource.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.datasource.bean.entity.TDatacrawlerSet;
import com.yuepeng.web.manage.datasource.bean.excel.DatacrawlerExcel;
import com.yuepeng.web.manage.datasource.bean.vo.DatacrawlerSetVo;

import java.util.List;

public interface IDatacrawlerSetService extends ISuperIntegerService<TDatacrawlerSet> {

    Pagination<DatacrawlerSetVo> queryCrawPageList(Pagination<DatacrawlerSetVo> paramBean) throws Exception;

    public Pagination<DatacrawlerExcel> exportCrawPageList(Pagination<DatacrawlerSetVo> paramBean) throws Exception;

    public DatacrawlerSetVo viewCraw(Integer datacrawlerSetId) throws Exception;

    public List<DatacrawlerSetVo> getCrawType() throws Exception;
}
