package com.yuepeng.web.manage.dict.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TIndustrySub;
import com.yuepeng.web.manage.dict.bean.excel.IndustrySubEntity;
import com.yuepeng.web.manage.dict.bean.vo.IndustrySubVo;
import com.yuepeng.web.manage.dict.dao.TIndustrySubMapper;
import com.yuepeng.web.manage.dict.service.IIndustrySubService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 行业分类设置Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/25 11:34
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class IndustrySubServiceImpl extends SuperServiceIntegerImpl<TIndustrySubMapper, TIndustrySub> implements IIndustrySubService {
    @Override
    public Pagination<IndustrySubVo> queryIndustryPageList(Pagination<IndustrySubVo> paramBean) throws Exception {
        Pagination<IndustrySubVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<IndustrySubVo> list = mapper.queryIndustryPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<IndustrySubEntity> exportIndustryPageList(Pagination<IndustrySubVo> paramBean) throws Exception {
        Pagination<IndustrySubEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<IndustrySubEntity> list = mapper.exportIndustryPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public IndustrySubVo viewIndustry(Integer industrySubId) throws Exception {
        return this.mapper.viewIndustry(industrySubId);
    }

    @Override
    public List<IndustrySubVo> getIndustryType() throws Exception {
        return this.mapper.getIndustryTypes();
    }
}
