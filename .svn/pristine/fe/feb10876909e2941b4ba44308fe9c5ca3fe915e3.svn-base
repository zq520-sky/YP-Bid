package com.yuepeng.web.manage.describe.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.describe.bean.entity.TSubscribeSearch;
import com.yuepeng.web.manage.describe.bean.excel.custSubscribeSearchEntity;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeSearchVo;

public interface ISubscribeSearchService extends ISuperIntegerService<TSubscribeSearch> {

    Pagination<SubscribeSearchVo> querySubscribeSearchPageList(Pagination<SubscribeSearchVo> paramBean) throws Exception;

    public Pagination<custSubscribeSearchEntity> exportSubscribeSearchPageList(Pagination<SubscribeSearchVo> paramBean) throws Exception;

    public SubscribeSearchVo querySubscribeSearchPageListById(Integer subscribeSearchId) throws Exception;
}
