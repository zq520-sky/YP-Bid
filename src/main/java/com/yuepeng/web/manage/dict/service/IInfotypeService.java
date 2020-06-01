package com.yuepeng.web.manage.dict.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.dict.bean.entity.TInfotype;
import com.yuepeng.web.manage.dict.bean.excel.InfotypeEntity;
import com.yuepeng.web.manage.dict.bean.vo.InfotypeVo;

public interface IInfotypeService extends ISuperIntegerService<TInfotype> {

    Pagination<InfotypeVo> queryInfoTypePageList(Pagination<InfotypeVo> paramBean) throws Exception;

    public Pagination<InfotypeEntity> exportInfoTypePageList(Pagination<InfotypeVo> paramBean) throws Exception;

    public InfotypeVo queryInfoTypePageListById(Integer infotypeId) throws Exception;
}
