package com.yuepeng.web.manage.customer.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.customer.bean.excel.CustomerExcel;
import com.yuepeng.web.manage.customer.bean.vo.CustomerVo;
import com.yuepeng.web.manage.customer.dao.TCustomerMapper;
import com.yuepeng.web.manage.customer.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzq
 * @className CustomerServiceImpl
 * @description
 * @date 2020/5/11 14:30
 */
@Service
public class CustomerServiceImpl extends SuperServiceIntegerImpl<TCustomerMapper, TCustomer> implements ICustomerService {

    @Override
    public Pagination<CustomerVo> queryCustomerPageList(Pagination<CustomerVo> paramBean) throws Exception {
        Pagination<CustomerVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<CustomerVo> list = mapper.queryCustomerPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<CustomerExcel> exportCustomerPageList(Pagination<TCustomer> paramBean) throws Exception {
        Pagination<CustomerExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<CustomerExcel> list = mapper.exportCustomerPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public CustomerVo viewCustomer(Integer custId) throws Exception {
        return mapper.viewCustomer(custId);
    }
}
