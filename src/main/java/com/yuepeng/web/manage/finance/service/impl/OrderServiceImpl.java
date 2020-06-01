package com.yuepeng.web.manage.finance.service.impl;

import com.yuepeng.web.manage.finance.bean.entity.TOrder;
import com.yuepeng.web.manage.finance.bean.vo.OrderVo;
import com.yuepeng.web.manage.finance.bean.excel.OrderExcel;
import com.yuepeng.web.manage.finance.dao.TOrderMapper;
import com.yuepeng.web.manage.finance.service.IOrderService;
import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户支付订单(Order)表服务实现类
 *
 * @author wzq
 * @since 2020-05-15 16:47:59
 */
@Service("orderService")
public class OrderServiceImpl extends SuperServiceIntegerImpl<TOrderMapper, TOrder> implements IOrderService {
    
    @Override
    public Pagination<OrderVo> queryOrderPageList(Pagination<OrderVo> paramBean) throws Exception {
        Pagination<OrderVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<OrderVo> list = mapper.queryOrderPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<OrderExcel> exportOrderPageList(Pagination<TOrder> paramBean) throws Exception {
        Pagination<OrderExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<OrderExcel> list = mapper.exportOrderPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public OrderVo viewOrder(Integer orderId) throws Exception {
        return mapper.viewOrder(orderId);
    }
    
}