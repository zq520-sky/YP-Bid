package com.yuepeng.web.manage.project.service.impl;

import com.yuepeng.web.manage.project.bean.entity.TProject;
import com.yuepeng.web.manage.project.bean.vo.ProjectRangeVo;
import com.yuepeng.web.manage.project.bean.vo.ProjectVo;
import com.yuepeng.web.manage.project.bean.excel.ProjectExcel;
import com.yuepeng.web.manage.project.dao.TProjectMapper;
import com.yuepeng.web.manage.project.dao.TProjectRangeMapper;
import com.yuepeng.web.manage.project.service.IProjectService;
import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 招标项目信息表(Project)表服务实现类
 *
 * @author wzq
 * @since 2020-05-19 09:41:14
 */
@Service("projectService")
public class ProjectServiceImpl extends SuperServiceIntegerImpl<TProjectMapper, TProject> implements IProjectService {

    @Resource
    private TProjectRangeMapper projectRangeMapper;

    @Override
    public Pagination<ProjectVo> queryProjectPageList(Pagination<ProjectVo> paramBean) throws Exception {
        Pagination<ProjectVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectVo> list = mapper.queryProjectPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<ProjectExcel> exportProjectPageList(Pagination<TProject> paramBean) throws Exception {
        Pagination<ProjectExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<ProjectExcel> list = mapper.exportProjectPageList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public ProjectVo viewProject(Integer projectId) throws Exception {
        return mapper.viewProject(projectId);
    }

    @Override
    public boolean updateProjectInfo(ProjectVo projectVo) throws Exception {
        //更新project
        int updateProject = mapper.updateByPrimaryKeySelective(projectVo);

        //更新project_range
        ProjectRangeVo projectRangeVo = new ProjectRangeVo();
        projectRangeVo.setProjectId(projectVo.getProjectId());
        projectRangeVo.setDatasourceTypeId(projectVo.getDatasourceTypeId());
        projectRangeVo.setDatasourceTypeName(projectVo.getDatasourceTypeName());
        projectRangeVo.setDatasourceWebname(projectVo.getDatasourceWebname());
        projectRangeVo.setDatasourceIndustryId(projectVo.getDatasourceIndustryId());
        projectRangeVo.setDatasourceIndustryName(projectVo.getDatasourceIndustryName());
        projectRangeVo.setDatasourceInfotypeId(projectVo.getDatasourceInfotypeId());
        projectRangeVo.setDatasourceInfotypeName(projectVo.getDatasourceInfotypeName());
        projectRangeVo.setIndustryId(projectVo.getIndustryId());
        projectRangeVo.setIndustryName(projectVo.getIndustryName());
        projectRangeVo.setInfotypeId(projectVo.getInfotypeId());
        projectRangeVo.setInfotypeName(projectVo.getInfotypeName());
        projectRangeVo.setUpdateDate(new Date());
        Integer updateProjectRange = projectRangeMapper.updateByProjectIdSelective(projectRangeVo);

        return updateProject > 0 && updateProjectRange > 0;
    }

}