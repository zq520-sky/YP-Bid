package com.yuepeng.web.manage.collect.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.collect.bean.entity.TProjectCollect;
import com.yuepeng.web.manage.collect.bean.excel.ProjectCollectEntity;
import com.yuepeng.web.manage.collect.bean.vo.ProjectCollectVo;
public interface IProjectCollectService extends ISuperIntegerService<TProjectCollect> {

    Pagination<ProjectCollectVo> queryCollectPageList(Pagination<ProjectCollectVo> paramBean) throws Exception;

    public Pagination<ProjectCollectEntity> exportCollectPageList(Pagination<ProjectCollectVo> paramBean) throws Exception;

    public ProjectCollectVo queryCollectPageListById(Integer subscribeSetId) throws Exception;
}
