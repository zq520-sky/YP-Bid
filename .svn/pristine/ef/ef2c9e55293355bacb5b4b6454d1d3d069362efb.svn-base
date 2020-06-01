package com.yuepeng.web.manage.system.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TMemberRole;
import com.yuepeng.web.manage.system.bean.excel.MemberRoleEntity;
import com.yuepeng.web.manage.system.bean.vo.MemberRoleVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TMemberRoleMapper extends AutoMapperInteger<TMemberRole> {
    List<MemberRoleVo> queryMemberRoleList(Pagination<MemberRoleVo> paramBean, RowBounds rowBounds) throws Exception;

    List<MemberRoleEntity> exportMemberRoleList(Pagination<MemberRoleVo> paramBean, RowBounds rowBounds) throws Exception;

    MemberRoleVo selectMemberRoleById(Integer memberRoleId) throws Exception;
}