package com.yuepeng.web.manage.log.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.entity.TDatacrawlerService;
import com.yuepeng.web.manage.log.bean.excel.DataCrawlerLogExcel;
import com.yuepeng.web.manage.log.bean.vo.DataCrawlerLogVo;
import com.yuepeng.web.manage.log.dao.DataCrawlerLogMapper;
import com.yuepeng.web.manage.log.service.DataCrawlerLogService;

import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description:
 * @Author: xtq
 * @Date: 2020/5/29 15:47
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class DataCrawlerLogServiceImpl extends SuperServiceIntegerImpl<DataCrawlerLogMapper, DataCrawlerLogVo> implements DataCrawlerLogService {


    /**
     * 分页
     * @param paramBean
     * @return
     * @throws Exception
     */
    public Pagination<DataCrawlerLogVo> queryDataCrawlerLogList(Pagination<DataCrawlerLogVo> paramBean) throws Exception {
        Pagination<DataCrawlerLogVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DataCrawlerLogVo> list = mapper.queryDataCrawlerLogList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * 导出
     * @param paramBean
     * @return
     * @throws Exception
     */
    public Pagination<DataCrawlerLogExcel> exportDataCrawlerLogList(Pagination<DataCrawlerLogVo> paramBean) throws Exception {
        Pagination<DataCrawlerLogExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DataCrawlerLogExcel> list = mapper.exportDataCrawlerLogList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * 查询所有爬虫服务
     * @return
     */
    public List<TDatacrawlerService> queryDatacrawlerServiceAll() {
        return mapper.queryDatacrawlerServiceAll();
    }
}
