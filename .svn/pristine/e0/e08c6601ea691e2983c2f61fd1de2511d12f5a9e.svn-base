package com.yuepeng.web.manage.system.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.system.bean.entity.TSysCity;
import com.yuepeng.web.manage.system.bean.excel.SysCityEntity;
import com.yuepeng.web.manage.system.bean.vo.SysCityVo;

import java.util.List;

public interface ISysCityService extends ISuperIntegerService<TSysCity> {

    Pagination<SysCityVo> queryProvincePageList(Pagination<SysCityVo> paramBean) throws Exception;

    public Pagination<SysCityEntity> exportProvincePageList(Pagination<SysCityVo> paramBean) throws Exception;

    public SysCityVo viewProvince(Integer cityId) throws Exception;

    public List<SysCityVo> getProvinceType() throws Exception;
}
