package com.yuepeng.web.manage.log.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.entity.TDatacrawlerService;
import com.yuepeng.web.manage.log.bean.excel.DataCrawlerLogExcel;
import com.yuepeng.web.manage.log.bean.vo.DataCrawlerLogVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface DataCrawlerLogMapper extends AutoMapperInteger<DataCrawlerLogVo> {

    //分页查询
    List<DataCrawlerLogVo> queryDataCrawlerLogList(Pagination<DataCrawlerLogVo> paramBean, RowBounds rowBounds) throws Exception;

    //导出
    List<DataCrawlerLogExcel> exportDataCrawlerLogList(Pagination<DataCrawlerLogVo> paramBean, RowBounds rowBounds);

    //查询所有服务名称
    List<TDatacrawlerService> queryDatacrawlerServiceAll();

}
