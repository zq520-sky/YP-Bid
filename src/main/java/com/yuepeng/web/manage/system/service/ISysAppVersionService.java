package com.yuepeng.web.manage.system.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TSysAppVersion;
import com.yuepeng.web.manage.system.bean.excel.SysAppVersionEntity;
import com.yuepeng.web.manage.system.bean.vo.SysAppVersionVo;

public interface ISysAppVersionService extends ISuperIntegerService<TSysAppVersion> {

    Pagination<SysAppVersionVo> queryVersionPageList(Pagination<SysAppVersionVo> paramBean) throws Exception;

    public Pagination<SysAppVersionEntity> exportVersionPageList(Pagination<SysAppVersionVo> paramBean) throws Exception;

    public SysAppVersionVo queryVersionPageListById(Integer versionId) throws Exception;
}
