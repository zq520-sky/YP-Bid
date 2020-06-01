package com.yuepeng.web.manage.project.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.project.bean.entity.TSearchHotword;
import com.yuepeng.web.manage.project.bean.excel.SearchHotwordEntity;
import com.yuepeng.web.manage.project.bean.vo.SearchHotwordVo;

public interface ISearchHotwordService extends ISuperIntegerService<TSearchHotword> {
    Pagination<SearchHotwordVo> queryHotwordPageList(Pagination<SearchHotwordVo> paramBean) throws Exception;

    public Pagination<SearchHotwordEntity> exportHotwordPageList(Pagination<SearchHotwordVo> paramBean) throws Exception;

    public SearchHotwordVo queryHotwordPageListById(Integer projectCompanyId) throws Exception;
}
