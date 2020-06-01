package com.yuepeng.web.manage.dict.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TIndustrySub;
import com.yuepeng.web.manage.dict.bean.excel.IndustrySubEntity;
import com.yuepeng.web.manage.dict.bean.vo.IndustrySubVo;

import java.util.List;

public interface IIndustrySubService extends ISuperIntegerService<TIndustrySub> {

    Pagination<IndustrySubVo> queryIndustryPageList(Pagination<IndustrySubVo> paramBean) throws Exception;

    public Pagination<IndustrySubEntity> exportIndustryPageList(Pagination<IndustrySubVo> paramBean) throws Exception;

    public IndustrySubVo viewIndustry(Integer industrySubId) throws Exception;

    public List<IndustrySubVo> getIndustryType() throws Exception;
}
