package com.yuepeng.platform.pm.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.pm.bean.entity.TCustLoginLog;
import com.yuepeng.platform.pm.bean.vo.TCustLoginLogVo;

/**
 * @Description: 用户登陆日志Service接口
 * @Author: zhixin
 * @Date: 2019/10/29 14:59
 * Copyright (c) 2019, Samton. All rights reserved
*/
public interface ICustLoginLogService extends ISuperIntegerService<TCustLoginLog> {
    /**
     * 根据ID查询用户登陆日志
     * @param logId
     * @return
     * @throws Exception
     */
    public TCustLoginLogVo loadCustLoginLogById(Integer logId) throws Exception;

}
