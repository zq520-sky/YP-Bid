package com.yuepeng.web.manage.describe.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSearchPush;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribePushEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribePushVo;

public interface ISubscribePushService extends ISuperIntegerService<TSubscribeSearchPush> {
    Pagination<SubscribePushVo> querySubscribePushPageList(Pagination<SubscribePushVo> paramBean) throws Exception;

    public Pagination<custSubscribePushEntity> exportSubscribePushPageList(Pagination<SubscribePushVo> paramBean) throws Exception;

    public SubscribePushVo querySubscribePushPageListById(Integer searchPushId) throws Exception;
}
