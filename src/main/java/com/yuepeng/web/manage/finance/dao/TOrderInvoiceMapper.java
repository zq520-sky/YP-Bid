package com.yuepeng.web.manage.finance.dao;

import com.yuepeng.web.manage.finance.bean.entity.TOrderInvoice;
import com.yuepeng.web.manage.finance.bean.vo.OrderInvoiceVo;
import com.yuepeng.web.manage.finance.bean.excel.OrderInvoiceExcel;
import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

/**
 * 客户发票申请表(OrderInvoice)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-15 16:45:58
 */
public interface TOrderInvoiceMapper extends AutoMapperInteger<TOrderInvoice>{

    List<OrderInvoiceVo> queryOrderInvoicePageList(Pagination<OrderInvoiceVo> paramBean, RowBounds rowBounds) throws Exception;

    List<OrderInvoiceExcel> exportOrderInvoicePageList(Pagination<TOrderInvoice> paramBean, RowBounds rowBounds) throws Exception;

    OrderInvoiceVo viewOrderInvoice(Integer invoiceId) throws Exception;

}