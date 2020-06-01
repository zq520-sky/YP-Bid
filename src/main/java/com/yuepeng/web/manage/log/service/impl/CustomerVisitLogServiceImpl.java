package com.yuepeng.web.manage.log.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.log.bean.excel.CustomerVisitLogExcel;
import com.yuepeng.web.manage.log.bean.vo.CustomerVisitLogVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerVisitLookVo;
import com.yuepeng.web.manage.log.dao.CustomerVisitLogMapper;
import com.yuepeng.web.manage.log.service.CustomerVisitLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户查看记录 Service
 * @Author: xtq
 * @Date: 2020/5/28 14:24
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class CustomerVisitLogServiceImpl extends SuperServiceIntegerImpl<CustomerVisitLogMapper, CustomerVisitLogVo> implements CustomerVisitLogService {

    /**
     * 客户查看记录 list
     * @param paramBean
     * @return
     */
    public Pagination<CustomerVisitLogVo> queryCstVisitLogList(Pagination<CustomerVisitLogVo> paramBean) throws Exception {
        Pagination<CustomerVisitLogVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<CustomerVisitLogVo> list = mapper.queryCstVisitLogList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * 客户查看记录-导出
     * @param paramBean
     * @return
     * @throws Exception
     */
    public Pagination<CustomerVisitLogExcel> exportCstVisitLogList(Pagination<CustomerVisitLogVo> paramBean) throws Exception {
        Pagination<CustomerVisitLogExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<CustomerVisitLogExcel> list = mapper.exportCstVisitLogList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * 查看详情
     * @param visitId
     * @return
     */
    public CustomerVisitLookVo queryCstMsgByVisitId(Integer visitId) {
        CustomerVisitLookVo resCustomerVisitLookVo = mapper.queryCstMsgByVisitId(visitId);
        return resCustomerVisitLookVo;
    }


}
