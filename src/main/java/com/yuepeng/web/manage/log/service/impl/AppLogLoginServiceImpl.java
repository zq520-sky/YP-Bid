package com.yuepeng.web.manage.log.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.entity.TAppLogLogin;
import com.yuepeng.web.manage.log.bean.excel.CustomerLoginLogExcel;
import com.yuepeng.web.manage.log.bean.vo.AppLogLoginVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerMesVo;
import com.yuepeng.web.manage.log.dao.TAppLogLoginMapper;
import com.yuepeng.web.manage.log.service.AppLogLoginService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 客户登录日志 Service
 * @Author: xtq
 * @Date: 2020/5/27 14:42
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class AppLogLoginServiceImpl extends SuperServiceIntegerImpl<TAppLogLoginMapper, TAppLogLogin> implements AppLogLoginService {

    /**
     * 客户登录日志list
     * @param paramBean
     * @return
     * @throws Exception
     */
    public Pagination<AppLogLoginVo> queryAppLogLoginList(Pagination<AppLogLoginVo> paramBean) throws Exception {
        Pagination<AppLogLoginVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<AppLogLoginVo> list = mapper.queryAppLogLoginList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * 通过id查询客户登录日志表
     * @param custId
     * @return
     */
    public CustomerMesVo findAppLogLoginById(Integer custId) {
        CustomerMesVo customerMesVo = mapper.findByLogLoginId(custId);
        return customerMesVo;
    }

    /**
     * 导出客户登录日志
     * @param paramBean
     * @return
     */
    public Pagination<CustomerLoginLogExcel> exportCustLoginLogList(Pagination<AppLogLoginVo> paramBean) {
        Pagination<CustomerLoginLogExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<CustomerLoginLogExcel> list = mapper.exportCustLoginLogList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    /**
     * 通过log_login_id查询客户登陆日志详情
     * @param logLoginId
     * @return
     */
    public AppLogLoginVo queryCstMsgByLogLoginId(Integer logLoginId) {
        return mapper.queryCstMsgByLogLoginId(logLoginId);
    }
}
