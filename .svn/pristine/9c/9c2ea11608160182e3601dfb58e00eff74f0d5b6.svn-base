package com.yuepeng.web.manage.dict.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TProjectKeyword;
import com.yuepeng.web.manage.dict.bean.excel.ProjectKeywordEntity;
import com.yuepeng.web.manage.dict.bean.vo.ProjectKeywordVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TProjectKeywordMapper extends AutoMapperInteger<TProjectKeyword> {

    List<ProjectKeywordVo> queryProjectKeywordList(Pagination<ProjectKeywordVo> paramBean, RowBounds rowBounds)throws Exception;

    List<ProjectKeywordEntity> exportProjectKeywordList(Pagination<ProjectKeywordVo> paramBean, RowBounds rowBounds) throws Exception;

    ProjectKeywordVo selectProjectKeywordListById(Integer projectKeywordId) throws Exception;
}