package com.yuepeng.web.manage.project.service.impl;

import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.web.manage.project.bean.entity.TProject;
import com.yuepeng.web.manage.project.bean.entity.TProjectCompany;
import com.yuepeng.web.manage.project.bean.vo.ProjectCompanyVo;
import com.yuepeng.web.manage.project.bean.excel.ProjectCompanyExcel;
import com.yuepeng.web.manage.project.constants.ProjectExpCodeConstant;
import com.yuepeng.web.manage.project.dao.TProjectCompanyMapper;
import com.yuepeng.web.manage.project.dao.TProjectMapper;
import com.yuepeng.web.manage.project.service.IProjectCompanyService;
import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.web.manage.project.service.IProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 招标单位信息表(ProjectCompany)表服务实现类
 *
 * @author wzq
 * @since 2020-05-22 11:01:33
 */
@Service("projectCompanyService")
public class ProjectCompanyServiceImpl extends SuperServiceIntegerImpl<TProjectCompanyMapper, TProjectCompany> implements IProjectCompanyService {

    @Resource
    private TProjectMapper projectMapper;

    @Override
    public Pagination<ProjectCompanyVo> queryProjectCompanyPageList(Pagination<ProjectCompanyVo> paramBean) throws Exception {
        Pagination<ProjectCompanyVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectCompanyVo> list = mapper.queryProjectCompanyPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<ProjectCompanyExcel> exportProjectCompanyPageList(Pagination<TProjectCompany> paramBean) throws Exception {
        Pagination<ProjectCompanyExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectCompanyExcel> list = mapper.exportProjectCompanyPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public ProjectCompanyVo viewProjectCompany(Integer projectCompanyId) throws Exception {
        return mapper.viewProjectCompany(projectCompanyId);
    }

    @Override
    public boolean delProjectCompany(Integer projectCompanyId) throws Exception {
        List<TProject> tProjects = projectMapper.selectListByCompanyId(projectCompanyId);
        if(!tProjects.isEmpty()){
            throw new ServiceException(ProjectExpCodeConstant.PROJECT_COMPANY_DEL_NOT_ALLOW);
        }
        int delete = mapper.deleteByPrimaryKey(projectCompanyId);
        return delete > 0;
    }
}