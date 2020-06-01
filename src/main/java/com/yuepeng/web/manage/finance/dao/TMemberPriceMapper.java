package com.yuepeng.web.manage.finance.dao;

import com.yuepeng.web.manage.finance.bean.entity.TMemberPrice;
import com.yuepeng.web.manage.finance.bean.vo.MemberPriceVo;
import com.yuepeng.web.manage.finance.bean.excel.MemberPriceExcel;
import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

/**
 * 会员价格表(MemberPrice)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-15 16:46:31
 */
public interface TMemberPriceMapper extends AutoMapperInteger<TMemberPrice>{

    List<MemberPriceVo> queryMemberPricePageList(Pagination<MemberPriceVo> paramBean, RowBounds rowBounds) throws Exception;

    List<MemberPriceExcel> exportMemberPricePageList(Pagination<TMemberPrice> paramBean, RowBounds rowBounds) throws Exception;

    MemberPriceVo viewMemberPrice(Integer priceId) throws Exception;

}