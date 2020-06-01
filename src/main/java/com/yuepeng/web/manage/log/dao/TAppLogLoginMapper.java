package com.yuepeng.web.manage.log.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.entity.TAppLogLogin;
import com.yuepeng.web.manage.log.bean.excel.CustomerLoginLogExcel;
import com.yuepeng.web.manage.log.bean.vo.AppLogLoginVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerMesVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;


public interface TAppLogLoginMapper extends AutoMapperInteger<TAppLogLogin> {
    //查询客户登录日志表
    List<AppLogLoginVo> queryAppLogLoginList(Pagination<AppLogLoginVo> paramBean, RowBounds rowBounds) throws Exception;
    //通过id查询客户登录日志表
    CustomerMesVo findByLogLoginId(Integer custId);
    //导出客户登录日志
    List<CustomerLoginLogExcel> exportCustLoginLogList(Pagination<AppLogLoginVo> paramBean, RowBounds rowBounds);
    //通过log_login_id查询客户登陆日志详情
    AppLogLoginVo queryCstMsgByLogLoginId(Integer logLoginId);
}