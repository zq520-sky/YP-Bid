package com.yuepeng.web.manage.finance.service;

import com.yuepeng.web.manage.finance.bean.entity.TMemberPrice;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.finance.bean.vo.MemberPriceVo;
import com.yuepeng.web.manage.finance.bean.excel.MemberPriceExcel;


/**
 * 会员价格表(MemberPrice)表服务接口
 *
 * @author wzq
 * @since 2020-05-15 16:11:22
 */
public interface IMemberPriceService extends ISuperIntegerService<TMemberPrice>{


    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-15 16:11:22
     * @return {@link Pagination< MemberPriceVo>}
     */
    Pagination<MemberPriceVo> queryMemberPricePageList(Pagination<MemberPriceVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-15 16:11:22
     * @return {@link Pagination< MemberPriceExcel>}
     */
    Pagination<MemberPriceExcel> exportMemberPricePageList(Pagination<TMemberPrice> paramBean) throws Exception;

    /**
     *
     * @param priceId
     * @author wzq
     * @date 2020-05-15 16:11:22
     * @return {@link com.yuepeng.web.manage.finance.bean.vo.MemberPriceVo}
     */
    MemberPriceVo viewMemberPrice(Integer priceId) throws Exception;
}