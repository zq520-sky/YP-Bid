package com.yuepeng.web.manage.finance.service.impl;

import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.web.manage.finance.bean.entity.TOrderInvoice;
import com.yuepeng.web.manage.finance.bean.vo.OrderInvoiceVo;
import com.yuepeng.web.manage.finance.bean.excel.OrderInvoiceExcel;
import com.yuepeng.web.manage.finance.dao.TOrderInvoiceMapper;
import com.yuepeng.web.manage.finance.service.IOrderInvoiceService;
import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户发票申请表(OrderInvoice)表服务实现类
 *
 * @author wzq
 * @since 2020-05-15 16:40:54
 */
@Service("orderInvoiceService")
public class OrderInvoiceServiceImpl extends SuperServiceIntegerImpl<TOrderInvoiceMapper, TOrderInvoice> implements IOrderInvoiceService {
    
    @Override
    public Pagination<OrderInvoiceVo> queryOrderInvoicePageList(Pagination<OrderInvoiceVo> paramBean) throws Exception {
        Pagination<OrderInvoiceVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<OrderInvoiceVo> list = mapper.queryOrderInvoicePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<OrderInvoiceExcel> exportOrderInvoicePageList(Pagination<TOrderInvoice> paramBean) throws Exception {
        Pagination<OrderInvoiceExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<OrderInvoiceExcel> list = mapper.exportOrderInvoicePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public OrderInvoiceVo viewOrderInvoice(Integer invoiceId) throws Exception {
        return mapper.viewOrderInvoice(invoiceId);
    }
    
}