package com.yuepeng.web.manage.log.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.entity.TAppLogSearch;
import com.yuepeng.web.manage.log.bean.excel.CustomerSearchLogExcel;
import com.yuepeng.web.manage.log.bean.vo.AppLogSearchVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerMesVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerSearchLookVo;

public interface AppLogSearchService extends ISuperIntegerService<TAppLogSearch> {

    //客户搜索记录list
    Pagination<AppLogSearchVo> queryAppLogSearchList(Pagination<AppLogSearchVo> paramBean) throws Exception;
    //通过编号custCode查询客户搜索记录表
    CustomerMesVo findAppLogSearchById(Integer custId);
    //导出客户搜索记录
    Pagination<CustomerSearchLogExcel> exportCustSearchLogList(Pagination<AppLogSearchVo> paramBean);
    //通过logSearchId查看客户搜索记录相关信息
    public CustomerSearchLookVo queryCstMsgBySearchId(Integer logSearchId);

}
