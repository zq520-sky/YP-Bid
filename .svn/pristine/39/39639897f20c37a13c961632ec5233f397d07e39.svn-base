package com.yuepeng.web.manage.customer.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.customer.bean.excel.CustomerExcel;
import com.yuepeng.web.manage.customer.bean.vo.CustomerVo;

import java.util.List;

public interface TCustomerMapper extends AutoMapperInteger<TCustomer> {

    /**
     *
     * @param paramBean
     * @param rowBounds
     * @author wzq
     * @date 2020/5/11 16:19
     * @return {@link java.util.List<com.yuepeng.web.manage.customer.bean.vo.CustomerVo>}
     */
    List<CustomerVo> queryCustomerPageList(Pagination<CustomerVo> paramBean, RowBounds rowBounds) throws Exception;

    /**
     *
     * @param paramBean
     * @param rowBounds
     * @author wzq
     * @date 2020/5/11 16:18
     * @return {@link List< CustomerExcel>}
     */
    List<CustomerExcel> exportCustomerPageList(Pagination<TCustomer> paramBean, RowBounds rowBounds) throws Exception;

    /**
     *
     * @param custId
     * @author wzq
     * @date 2020/5/11 16:18
     * @return {@link CustomerVo}
     */
    CustomerVo viewCustomer(Integer custId) throws Exception;
}