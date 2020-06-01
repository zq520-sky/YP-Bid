package com.yuepeng.web.manage.describe.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSearch;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribeSearchEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeSearchVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TSubscribeSearchMapper extends AutoMapperInteger<TSubscribeSearch> {

    List<SubscribeSearchVo> querySubscribeSearchList(Pagination<SubscribeSearchVo> paramBean, RowBounds rowBounds)throws Exception;

    List<custSubscribeSearchEntity> exportSubscribeSearchList(Pagination<SubscribeSearchVo> paramBean, RowBounds rowBounds) throws Exception;

    SubscribeSearchVo selectSubscribeSearchListById(Integer subscribeSearchId) throws Exception;
}