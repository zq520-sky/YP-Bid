package com.yuepeng.web.manage.system.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TSysAppVersion;
import com.yuepeng.web.manage.system.bean.excel.SysAppVersionEntity;
import com.yuepeng.web.manage.system.bean.vo.SysAppVersionVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TSysAppVersionMapper extends AutoMapperInteger<TSysAppVersion> {

    List<SysAppVersionVo> queryVersionList(Pagination<SysAppVersionVo> paramBean, RowBounds rowBounds) throws Exception;

    List<SysAppVersionEntity> exportVersionList(Pagination<SysAppVersionVo> paramBean, RowBounds rowBounds) throws Exception;

    SysAppVersionVo selectVersionListById(Integer versionId) throws Exception;
}