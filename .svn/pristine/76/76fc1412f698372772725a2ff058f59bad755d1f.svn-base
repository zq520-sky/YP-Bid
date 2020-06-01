package com.yuepeng.web.manage.system.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TMemberRole;
import com.yuepeng.web.manage.system.bean.excel.MemberRoleEntity;
import com.yuepeng.web.manage.system.bean.vo.MemberRoleVo;

public interface IMemberRoleService extends ISuperIntegerService<TMemberRole> {

    Pagination<MemberRoleVo> queryMemberRoleList(Pagination<MemberRoleVo> paramBean) throws Exception;

    public Pagination<MemberRoleEntity> exportMemberRoleList(Pagination<MemberRoleVo> paramBean) throws Exception;

    public MemberRoleVo queryMemberRoleListById(Integer memberRoleId) throws Exception;
}
