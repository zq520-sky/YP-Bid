package com.yuepeng.web.manage.log.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.excel.CustomerVisitLogExcel;
import com.yuepeng.web.manage.log.bean.vo.CustomerVisitLogVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerVisitLookVo;

public interface CustomerVisitLogService extends ISuperIntegerService<CustomerVisitLogVo> {
    //客户查看记录list
    Pagination<CustomerVisitLogVo> queryCstVisitLogList(Pagination<CustomerVisitLogVo> paramBean) throws Exception;
    Pagination<CustomerVisitLogExcel> exportCstVisitLogList(Pagination<CustomerVisitLogVo> paramBean) throws Exception;
    //查看 详情
    CustomerVisitLookVo queryCstMsgByVisitId(Integer visitId);
}
