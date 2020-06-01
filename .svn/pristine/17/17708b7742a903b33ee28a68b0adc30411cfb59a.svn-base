package com.yuepeng.web.manage.finance.service.impl;

import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.web.manage.finance.bean.entity.TMemberPrice;
import com.yuepeng.web.manage.finance.bean.vo.MemberPriceVo;
import com.yuepeng.web.manage.finance.bean.excel.MemberPriceExcel;
import com.yuepeng.web.manage.finance.dao.TMemberPriceMapper;
import com.yuepeng.web.manage.finance.service.IMemberPriceService;
import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员价格表(MemberPrice)表服务实现类
 *
 * @author wzq
 * @since 2020-05-15 16:11:22
 */
@Service("memberPriceService")
public class MemberPriceServiceImpl extends SuperServiceIntegerImpl<TMemberPriceMapper, TMemberPrice> implements IMemberPriceService {
    
    @Override
    public Pagination<MemberPriceVo> queryMemberPricePageList(Pagination<MemberPriceVo> paramBean) throws Exception {
        Pagination<MemberPriceVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<MemberPriceVo> list = mapper.queryMemberPricePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<MemberPriceExcel> exportMemberPricePageList(Pagination<TMemberPrice> paramBean) throws Exception {
        Pagination<MemberPriceExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<MemberPriceExcel> list = mapper.exportMemberPricePageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public MemberPriceVo viewMemberPrice(Integer priceId) throws Exception {
        return mapper.viewMemberPrice(priceId);
    }
    
}