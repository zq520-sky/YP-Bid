package com.yuepeng.web.manage.dict.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TInfotype;
import com.yuepeng.web.manage.dict.bean.excel.InfotypeEntity;
import com.yuepeng.web.manage.dict.bean.vo.InfotypeVo;
import com.yuepeng.web.manage.dict.dao.TInfotypeMapper;
import com.yuepeng.web.manage.dict.service.IInfotypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 招标信息Impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/20 15:12
 * Copyright (c) 2019, Samton. All rights reserved
 */

@Service
public class InfoTypeServiceImpl extends SuperServiceIntegerImpl<TInfotypeMapper, TInfotype> implements IInfotypeService {
    @Override
    public Pagination<InfotypeVo> queryInfoTypePageList(Pagination<InfotypeVo> paramBean) throws Exception {
        Pagination<InfotypeVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<InfotypeVo> list = mapper.queryInfoTypeList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<InfotypeEntity> exportInfoTypePageList(Pagination<InfotypeVo> paramBean) throws Exception {
        Pagination<InfotypeEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<InfotypeEntity> list = mapper.exportInfoTypeList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public InfotypeVo queryInfoTypePageListById(Integer infotypeId) throws Exception {
        return this.mapper.selectInfoTypeListById(infotypeId);
    }
}
