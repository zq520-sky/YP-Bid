package com.yuepeng.web.manage.finance.service;

import com.yuepeng.web.manage.finance.bean.entity.TOrderInvoice;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.finance.bean.vo.OrderInvoiceVo;
import com.yuepeng.web.manage.finance.bean.excel.OrderInvoiceExcel;


/**
 * 客户发票申请表(OrderInvoice)表服务接口
 *
 * @author wzq
 * @since 2020-05-15 16:40:54
 */
public interface IOrderInvoiceService extends ISuperIntegerService<TOrderInvoice>{


    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-15 16:40:54
     * @return {@link Pagination< OrderInvoiceVo>}
     */
    Pagination<OrderInvoiceVo> queryOrderInvoicePageList(Pagination<OrderInvoiceVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-15 16:40:54
     * @return {@link Pagination< OrderInvoiceExcel>}
     */
    Pagination<OrderInvoiceExcel> exportOrderInvoicePageList(Pagination<TOrderInvoice> paramBean) throws Exception;

    /**
     *
     * @param invoiceId
     * @author wzq
     * @date 2020-05-15 16:40:54
     * @return {@link com.yuepeng.web.manage.finance.bean.vo.OrderInvoiceVo}
     */
    OrderInvoiceVo viewOrderInvoice(Integer invoiceId) throws Exception;
}