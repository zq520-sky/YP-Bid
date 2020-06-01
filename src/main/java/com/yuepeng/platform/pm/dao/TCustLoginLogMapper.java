package com.yuepeng.platform.pm.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.pm.bean.entity.TCustLoginLog;
import com.yuepeng.platform.pm.bean.vo.TCustLoginLogVo;

public interface TCustLoginLogMapper extends AutoMapperInteger<TCustLoginLog>{
        /**
         *通过ID查询用户登陆日志
         * @param logId
         * @return
         * @throws Exception
         */
        TCustLoginLogVo selectCustLoginLogById(Integer logId) throws Exception;
}