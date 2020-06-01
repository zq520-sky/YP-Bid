package com.yuepeng.web.manage.collect.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.collect.bean.entity.TCompanyCollect;
import com.yuepeng.web.manage.collect.bean.excel.CompanyCollectEntity;
import com.yuepeng.web.manage.collect.bean.vo.CompanyCollectVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TCompanyCollectMapper extends AutoMapperInteger<TCompanyCollect> {

    List<CompanyCollectVo> queryCompanyList(Pagination<CompanyCollectVo> paramBean, RowBounds rowBounds)throws Exception;

    List<CompanyCollectEntity> exportCompanyList(Pagination<CompanyCollectVo> paramBean, RowBounds rowBounds) throws Exception;

    CompanyCollectVo queryCompanyListById(Integer projectCompanyId) throws Exception;
}