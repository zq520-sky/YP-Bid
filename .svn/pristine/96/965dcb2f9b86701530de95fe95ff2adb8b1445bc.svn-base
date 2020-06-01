package com.yuepeng.web.manage.dict.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TIndustrySub;
import com.yuepeng.web.manage.dict.bean.excel.IndustrySubEntity;
import com.yuepeng.web.manage.dict.bean.vo.IndustrySubVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TIndustrySubMapper extends AutoMapperInteger<TIndustrySub> {
    List<IndustrySubVo> queryIndustryPageList(Pagination<IndustrySubVo> paramBean, RowBounds rowBounds) throws Exception;

    List<IndustrySubEntity> exportIndustryPageList(Pagination<IndustrySubVo> paramBean, RowBounds rowBounds) throws Exception;

    IndustrySubVo viewIndustry(Integer industrySubId) throws Exception;

    List<IndustrySubVo> getIndustryTypes() throws Exception;
}