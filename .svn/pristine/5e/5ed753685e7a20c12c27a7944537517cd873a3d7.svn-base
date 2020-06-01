package com.yuepeng.web.manage.customer.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.customer.bean.excel.CustomerExcel;
import com.yuepeng.web.manage.customer.bean.vo.CustomerVo;

/**
 * @author wzq
 * @className CustomerService
 * @description
 * @date 2020/5/11 14:29
 */
public interface ICustomerService extends ISuperIntegerService<TCustomer> {

    /**
     * 客户信息管理分页
     * @param paramBean
     * @author wzq
     * @date 2020/5/11 15:26
     * @return {@link Pagination< CustomerVo>}
     */
    Pagination<CustomerVo> queryCustomerPageList(Pagination<CustomerVo> paramBean) throws Exception;

    /**
     * 客户信息管理导出
     * @param paramBean
     * @author wzq
     * @date 2020/5/11 15:27
     * @return {@link Pagination< CustomerExcel>}
     */
    Pagination<CustomerExcel> exportCustomerPageList(Pagination<TCustomer> paramBean) throws Exception;

    /**
     * 获取客户信息
     * @param custId
     * @author wzq
     * @date 2020/5/11 16:50
     * @return {@link CustomerVo}
     */
    CustomerVo viewCustomer(Integer custId) throws Exception;

}
