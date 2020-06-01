package com.yuepeng.web.manage.dict.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TProjectKeyword;
import com.yuepeng.web.manage.dict.bean.excel.ProjectKeywordEntity;
import com.yuepeng.web.manage.dict.bean.vo.ProjectKeywordVo;

public interface IProjectKeywordService extends ISuperIntegerService<TProjectKeyword> {

    Pagination<ProjectKeywordVo> queryProjectKeywordPageList(Pagination<ProjectKeywordVo> paramBean) throws Exception;

    public Pagination<ProjectKeywordEntity> exportProjectKeywordList(Pagination<ProjectKeywordVo> paramBean) throws Exception;

    public ProjectKeywordVo queryProjectKeywordListById(Integer projectKeywordId) throws Exception;
}
