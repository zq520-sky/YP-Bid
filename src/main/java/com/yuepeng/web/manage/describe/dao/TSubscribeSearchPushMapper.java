package com.yuepeng.web.manage.describe.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSearchPush;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribePushEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribePushVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TSubscribeSearchPushMapper extends AutoMapperInteger<TSubscribeSearchPush> {

    List<SubscribePushVo> querySubscribePushList(Pagination<SubscribePushVo> paramBean, RowBounds rowBounds)throws Exception;

    List<custSubscribePushEntity> exportSubscribePushList(Pagination<SubscribePushVo> paramBean, RowBounds rowBounds) throws Exception;

    SubscribePushVo selectSubscribePushListById(Integer subscribeSearchId) throws Exception;
}