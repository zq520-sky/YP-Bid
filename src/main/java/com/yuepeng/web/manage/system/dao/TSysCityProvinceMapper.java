package com.yuepeng.web.manage.system.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TSysCity;
import com.yuepeng.web.manage.system.bean.excel.SysCityEntity;
import com.yuepeng.web.manage.system.bean.vo.SysCityVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TSysCityProvinceMapper extends AutoMapperInteger<TSysCity> {

    List<SysCityVo> queryProvincePageList(Pagination<SysCityVo> paramBean, RowBounds rowBounds) throws Exception;

    List<SysCityEntity> exportProvincePageList(Pagination<SysCityVo> paramBean, RowBounds rowBounds) throws Exception;

    SysCityVo viewCity(Integer industrySubId) throws Exception;

    List<SysCityVo> getProvinceTypes() throws Exception;
}