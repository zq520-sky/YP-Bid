package com.yuepeng.web.manage.log.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.excel.CustomerVisitLogExcel;
import com.yuepeng.web.manage.log.bean.vo.CustomerVisitLogVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerVisitLookVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CustomerVisitLogMapper extends AutoMapperInteger<CustomerVisitLogVo> {

    //客户查看记录 list
    List<CustomerVisitLogVo> queryCstVisitLogList(Pagination<CustomerVisitLogVo> paramBean, RowBounds rowBounds) throws Exception;
    //导出客户查看记录 list
    List<CustomerVisitLogExcel> exportCstVisitLogList(Pagination<CustomerVisitLogVo> paramBean, RowBounds rowBounds);
    //客户查看记录-查看详情  通过客户id visitId查询相关信息
    CustomerVisitLookVo queryCstMsgByVisitId(Integer visitId);
}
