package com.yuepeng.web.manage.describe.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSet;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribeEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TSubscribeSetMapper extends AutoMapperInteger<TSubscribeSet> {
    int deleteByPrimaryKey(Integer subscribeSetId);

    int insert(TSubscribeSet record);

    int insertSelective(TSubscribeSet record);

    TSubscribeSet selectByPrimaryKey(Integer subscribeSetId);

    int updateByPrimaryKeySelective(TSubscribeSet record);

    int updateByPrimaryKey(TSubscribeSet record);

    List<SubscribeVo> querySubscribeSetList(Pagination<SubscribeVo> paramBean, RowBounds rowBounds)throws Exception;

    List<custSubscribeEntity> exportSubscribeSetList(Pagination<SubscribeVo> paramBean, RowBounds rowBounds) throws Exception;

    SubscribeVo selectSubscribeSetListById(Integer subscribeSetId) throws Exception;
}