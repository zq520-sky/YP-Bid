package com.yuepeng.web.manage.collect.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.collect.bean.entity.TCompanyCollect;
import com.yuepeng.web.manage.collect.bean.excel.CompanyCollectEntity;
import com.yuepeng.web.manage.collect.bean.vo.CompanyCollectVo;

public interface ICompanyCollectService extends ISuperIntegerService<TCompanyCollect> {

    Pagination<CompanyCollectVo> queryCompanyPageList(Pagination<CompanyCollectVo> paramBean) throws Exception;

    public Pagination<CompanyCollectEntity> exportCompanyPageList(Pagination<CompanyCollectVo> paramBean) throws Exception;

    public CompanyCollectVo queryCompanyPageListById(Integer projectCompanyId) throws Exception;
}
