package com.yuepeng.web.manage.finance.service;

import com.yuepeng.web.manage.finance.bean.entity.TOrder;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.finance.bean.vo.OrderVo;
import com.yuepeng.web.manage.finance.bean.excel.OrderExcel;


/**
 * 客户支付订单(Order)表服务接口
 *
 * @author wzq
 * @since 2020-05-15 16:48:12
 */
public interface IOrderService extends ISuperIntegerService<TOrder>{


    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-15 16:48:12
     * @return {@link Pagination< OrderVo>}
     */
    Pagination<OrderVo> queryOrderPageList(Pagination<OrderVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-15 16:48:12
     * @return {@link Pagination< OrderExcel>}
     */
    Pagination<OrderExcel> exportOrderPageList(Pagination<TOrder> paramBean) throws Exception;

    /**
     *
     * @param orderId
     * @author wzq
     * @date 2020-05-15 16:48:12
     * @return {@link com.yuepeng.web.manage.finance.bean.vo.OrderVo}
     */
    OrderVo viewOrder(Integer orderId) throws Exception;
}