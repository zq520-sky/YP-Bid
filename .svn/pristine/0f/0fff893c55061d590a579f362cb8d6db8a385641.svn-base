package com.yuepeng.web.manage.describe.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSet;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribeEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeVo;

public interface ISubscribeService extends ISuperIntegerService<TSubscribeSet> {

    Pagination<SubscribeVo> querySubscribePageList(Pagination<SubscribeVo> paramBean) throws Exception;

    public Pagination<custSubscribeEntity> exportSubscribePageList(Pagination<SubscribeVo> paramBean) throws Exception;

    public SubscribeVo querySubscribePageListById(Integer subscribeSetId) throws Exception;
}
