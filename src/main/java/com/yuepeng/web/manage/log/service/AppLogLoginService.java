package com.yuepeng.web.manage.log.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.entity.TAppLogLogin;
import com.yuepeng.web.manage.log.bean.excel.CustomerLoginLogExcel;
import com.yuepeng.web.manage.log.bean.vo.AppLogLoginVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerMesVo;

public interface AppLogLoginService extends ISuperIntegerService<TAppLogLogin> {

    //客户登录日志list
    public Pagination<AppLogLoginVo> queryAppLogLoginList(Pagination<AppLogLoginVo> paramBean) throws Exception;
    //通过id查询客户登录日志表
    CustomerMesVo findAppLogLoginById(Integer custId);
    //导出客户登录日志
    Pagination<CustomerLoginLogExcel> exportCustLoginLogList(Pagination<AppLogLoginVo> paramBean);
    //通过log_login_id查询客户登陆日志详情
    AppLogLoginVo queryCstMsgByLogLoginId(Integer logLoginId);
}
