package com.yuepeng.web.manage.project.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.project.bean.entity.TSearchHotword;
import com.yuepeng.web.manage.project.bean.excel.SearchHotwordEntity;
import com.yuepeng.web.manage.project.bean.vo.SearchHotwordVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TSearchHotwordMapper extends AutoMapperInteger<TSearchHotword> {
    List<SearchHotwordVo> queryHotwordList(Pagination<SearchHotwordVo> paramBean, RowBounds rowBounds)throws Exception;

    List<SearchHotwordEntity> exportHotwordList(Pagination<SearchHotwordVo> paramBean, RowBounds rowBounds) throws Exception;

    SearchHotwordVo queryHotwordListById(Integer projectCompanyId) throws Exception;
}