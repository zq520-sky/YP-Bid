package com.yuepeng.web.manage.log.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.log.bean.entity.TAppLogSearch;
import com.yuepeng.web.manage.log.bean.excel.CustomerSearchLogExcel;
import com.yuepeng.web.manage.log.bean.vo.AppLogSearchVo;
import com.yuepeng.web.manage.log.bean.vo.CustomerSearchLookVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TAppLogSearchMapper extends AutoMapperInteger<TAppLogSearch> {
    //客户搜索记录list
    List<AppLogSearchVo> queryAppLogSearchList(Pagination<AppLogSearchVo> paramBean, RowBounds rowBounds);
    //导出客户搜索记录
    List<CustomerSearchLogExcel> exportCustSearchLogList(Pagination<AppLogSearchVo> paramBean, RowBounds rowBounds);
    //客户搜索-查看详情  通过logSearchId查看客户搜索记录相关信息
    CustomerSearchLookVo queryCstMsgBySearchId(Integer logSearchId);
}