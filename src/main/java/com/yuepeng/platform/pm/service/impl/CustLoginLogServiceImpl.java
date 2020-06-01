package com.yuepeng.platform.pm.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.pm.bean.entity.TCustLoginLog;
import com.yuepeng.platform.pm.bean.vo.TCustLoginLogVo;
import com.yuepeng.platform.pm.dao.TCustLoginLogMapper;
import com.yuepeng.platform.pm.dao.TSysLogMapper;
import com.yuepeng.platform.pm.service.ICustLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 用户登陆日志Service接口实现类
 * @Author: zhixin
 * @Date: 2019/10/29 15:00
 * Copyright (c) 2019, Samton. All rights reserved
*/
@Service("custLoginLogService")
public class CustLoginLogServiceImpl extends SuperServiceIntegerImpl<TCustLoginLogMapper, TCustLoginLog> implements ICustLoginLogService {
    @Resource
    private TSysLogMapper logMapper;
    @Resource
    private TCustLoginLogMapper custLoginLogMapper;
    /**
     * 根据ID查看用户登陆日志
     *
     * @param logId
     * @return
     * @throws Exception
     */
    @Override
    public TCustLoginLogVo loadCustLoginLogById(Integer logId) throws Exception {
        return this.mapper.selectCustLoginLogById(logId);
    }
}
