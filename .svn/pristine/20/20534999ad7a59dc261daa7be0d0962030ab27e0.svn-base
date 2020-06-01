package com.yuepeng.web.manage.dict.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TInfotype;
import com.yuepeng.web.manage.dict.bean.excel.InfotypeEntity;
import com.yuepeng.web.manage.dict.bean.vo.InfotypeVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TInfotypeMapper extends AutoMapperInteger<TInfotype> {
    List<InfotypeVo> queryInfoTypeList(Pagination<InfotypeVo> paramBean, RowBounds rowBounds)throws Exception;

    List<InfotypeEntity> exportInfoTypeList(Pagination<InfotypeVo> paramBean, RowBounds rowBounds) throws Exception;

    InfotypeVo selectInfoTypeListById(Integer subscribeSearchId) throws Exception;
}