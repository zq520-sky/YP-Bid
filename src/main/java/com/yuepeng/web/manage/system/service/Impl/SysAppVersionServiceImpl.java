package com.yuepeng.web.manage.system.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TSysAppVersion;
import com.yuepeng.web.manage.system.bean.excel.SysAppVersionEntity;
import com.yuepeng.web.manage.system.bean.vo.SysAppVersionVo;
import com.yuepeng.web.manage.system.dao.TSysAppVersionMapper;
import com.yuepeng.web.manage.system.service.ISysAppVersionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 版本控制
 * @Author: ZhongShengbin
 * @Date: 2020/05/22 15:42
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class SysAppVersionServiceImpl extends SuperServiceIntegerImpl<TSysAppVersionMapper, TSysAppVersion> implements ISysAppVersionService {
    @Override
    public Pagination<SysAppVersionVo> queryVersionPageList(Pagination<SysAppVersionVo> paramBean) throws Exception {
        Pagination<SysAppVersionVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SysAppVersionVo> list = mapper.queryVersionList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<SysAppVersionEntity> exportVersionPageList(Pagination<SysAppVersionVo> paramBean) throws Exception {
        Pagination<SysAppVersionEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<SysAppVersionEntity> list = mapper.exportVersionList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public SysAppVersionVo queryVersionPageListById(Integer versionId) throws Exception {
        return this.mapper.selectVersionListById(versionId);
    }
}
