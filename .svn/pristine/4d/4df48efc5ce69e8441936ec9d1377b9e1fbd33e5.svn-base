package com.yuepeng.web.manage.datasource.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.datasource.bean.entity.TDatacrawlerSet;
import com.yuepeng.web.manage.datasource.bean.excel.DatacrawlerExcel;
import com.yuepeng.web.manage.datasource.bean.vo.DatacrawlerSetVo;
import com.yuepeng.web.manage.datasource.dao.TDatacrawlerSetMapper;
import com.yuepeng.web.manage.datasource.service.IDatacrawlerSetService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 爬取规则Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/28 10:12
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class DatacrawSetServiceImpl extends SuperServiceIntegerImpl<TDatacrawlerSetMapper, TDatacrawlerSet> implements IDatacrawlerSetService {
    @Override
    public Pagination<DatacrawlerSetVo> queryCrawPageList(Pagination<DatacrawlerSetVo> paramBean) throws Exception {
        Pagination<DatacrawlerSetVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DatacrawlerSetVo> list = mapper.queryCrawPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<DatacrawlerExcel> exportCrawPageList(Pagination<DatacrawlerSetVo> paramBean) throws Exception {
        Pagination<DatacrawlerExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<DatacrawlerExcel> list = mapper.exportCrawPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public DatacrawlerSetVo viewCraw(Integer datacrawlerSetId) throws Exception {
        return this.mapper.viewCraw(datacrawlerSetId);
    }

    @Override
    public List<DatacrawlerSetVo> getCrawType() throws Exception {
        return this.mapper.getCrawTypes();
    }
}
