package com.yuepeng.web.manage.customer.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TProjectKeywordCollect;
import com.yuepeng.web.manage.customer.bean.excel.ProjectKeywordCollectExcel;
import com.yuepeng.web.manage.customer.bean.vo.ProjectKeywordCollectVo;
import com.yuepeng.web.manage.customer.dao.TProjectKeywordCollectMapper;
import com.yuepeng.web.manage.customer.service.IProjectKeywordCollectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈功能概述〉<br>
 *
 * @className: ProjectKeywordCollectServiceImpl
 * @package: com.yuepeng.web.manage.customer.service.impl
 * @author: wzq
 * @date: 2020/5/13 16:11
 */
@Service
public class ProjectKeywordCollectServiceImpl extends SuperServiceIntegerImpl<TProjectKeywordCollectMapper, TProjectKeywordCollect> implements IProjectKeywordCollectService {

    @Override
    public Pagination<ProjectKeywordCollectVo> queryKeywordList(Pagination<ProjectKeywordCollectVo> paramBean) throws Exception {
        Pagination<ProjectKeywordCollectVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectKeywordCollectVo> list = mapper.queryKeywordList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<ProjectKeywordCollectExcel> exportKeywordList(Pagination<TProjectKeywordCollect> paramBean) throws Exception {
        Pagination<ProjectKeywordCollectExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectKeywordCollectExcel> list = mapper.exportKeywordList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public ProjectKeywordCollectVo viewKeyword(Integer keywordCollectId) throws Exception {
        return mapper.viewKeyword(keywordCollectId);
    }
}
