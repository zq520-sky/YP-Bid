package com.yuepeng.web.manage.finance.dao;

import com.yuepeng.web.manage.finance.bean.entity.TOrder;
import com.yuepeng.web.manage.finance.bean.vo.OrderVo;
import com.yuepeng.web.manage.finance.bean.excel.OrderExcel;
import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

/**
 * 客户支付订单(Order)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-15 16:47:36
 */
public interface TOrderMapper extends AutoMapperInteger<TOrder>{

    List<OrderVo> queryOrderPageList(Pagination<OrderVo> paramBean, RowBounds rowBounds) throws Exception;

    List<OrderExcel> exportOrderPageList(Pagination<TOrder> paramBean, RowBounds rowBounds) throws Exception;

    OrderVo viewOrder(Integer orderId) throws Exception;

}