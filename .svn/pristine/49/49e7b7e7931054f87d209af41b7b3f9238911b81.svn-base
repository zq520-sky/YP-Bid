package com.yuepeng.web.manage.collect.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.collect.bean.entity.TProjectCollect;
import com.yuepeng.web.manage.collect.bean.excel.ProjectCollectEntity;
import com.yuepeng.web.manage.collect.bean.vo.ProjectCollectVo;
import com.yuepeng.web.manage.collect.dao.TProjectCollectMapper;
import com.yuepeng.web.manage.collect.service.IProjectCollectService;
import com.yuepeng.web.manage.describe.bean.vo.SubscribeVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户收藏实现
 * @Author: ZhongShengbin
 * @Date: 2020/05/18 09:57
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class ProjectCollectImpl extends SuperServiceIntegerImpl<TProjectCollectMapper, TProjectCollect> implements IProjectCollectService {
    /**
     * @Author ZhongShengbin
     * @Description //TODO 客户收藏信息分页
     * @Date 2020/5/18 0018
            * @Param [paramBean]
            * @return com.yuepeng.platform.framework.mybatis.pagination.Pagination<com.yuepeng.web.manage.collect.bean.vo.ProjectCollectVo>
     **/
    @Override
    public Pagination<ProjectCollectVo> queryCollectPageList(Pagination<ProjectCollectVo> paramBean) throws Exception {
        Pagination<ProjectCollectVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectCollectVo> list = mapper.queryCollectList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 导出客户收藏信息
     * @Date 2020/5/18 0018
     * @Param [paramBean]
     * @return com.yuepeng.platform.framework.mybatis.pagination.Pagination<com.yuepeng.web.manage.collect.bean.excel.ProjectCollectEntity>
     **/
    @Override
    public Pagination<ProjectCollectEntity> exportCollectPageList(Pagination<ProjectCollectVo> paramBean) throws Exception {
        Pagination<ProjectCollectEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectCollectEntity> list = mapper.exportCollectList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * @Author ZhongShengbin
     * @Description //TODO 查看客户收藏信息
     * @Date 2020/5/18 0018
     * @Param [collectId]
     * @return com.yuepeng.web.manage.collect.bean.vo.ProjectCollectVo
     **/
    @Override
    public ProjectCollectVo queryCollectPageListById(Integer collectId) throws Exception {
        return this.mapper.selectCollectListById(collectId);
    }
}
