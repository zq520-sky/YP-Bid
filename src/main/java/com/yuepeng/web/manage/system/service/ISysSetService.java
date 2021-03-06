package com.yuepeng.web.manage.system.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.system.bean.entity.TSysSet;
import com.yuepeng.web.manage.system.bean.vo.SysSetVo;

public interface ISysSetService extends ISuperIntegerService<TSysSet> {
    SysSetVo querySysSetPageList() throws Exception;

    boolean insertOrUpdate(SysSetVo sysSetVo) throws Exception;
}
