package com.yuepeng.web.manage.system.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TMemberRole;
import com.yuepeng.web.manage.system.bean.excel.MemberRoleEntity;
import com.yuepeng.web.manage.system.bean.vo.MemberRoleVo;
import com.yuepeng.web.manage.system.dao.TMemberRoleMapper;
import com.yuepeng.web.manage.system.service.IMemberRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 会员权限impl
 * @Author: ZhongShengbin
 * @Date: 2020/05/24 12:59
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class MemberRoleServiceImpl extends SuperServiceIntegerImpl<TMemberRoleMapper, TMemberRole> implements IMemberRoleService {
    @Override
    public Pagination<MemberRoleVo> queryMemberRoleList(Pagination<MemberRoleVo> paramBean) throws Exception {
        Pagination<MemberRoleVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<MemberRoleVo> list = mapper.queryMemberRoleList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<MemberRoleEntity> exportMemberRoleList(Pagination<MemberRoleVo> paramBean) throws Exception {
        Pagination<MemberRoleEntity> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<MemberRoleEntity> list = mapper.exportMemberRoleList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public MemberRoleVo queryMemberRoleListById(Integer memberRoleId) throws Exception {
        return this.mapper.selectMemberRoleById(memberRoleId);
    }
}
