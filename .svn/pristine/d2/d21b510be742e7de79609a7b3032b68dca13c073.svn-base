package com.yuepeng.web.manage.project.service;

import com.yuepeng.web.manage.project.bean.entity.TProject;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.project.bean.vo.ProjectVo;
import com.yuepeng.web.manage.project.bean.excel.ProjectExcel;


/**
 * 招标项目信息表(Project)表服务接口
 *
 * @author wzq
 * @since 2020-05-19 09:41:14
 */
public interface IProjectService extends ISuperIntegerService<TProject>{

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-19 09:41:14
     * @return {@link Pagination< ProjectVo>}
     */
    Pagination<ProjectVo> queryProjectPageList(Pagination<ProjectVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-19 09:41:14
     * @return {@link Pagination< ProjectExcel>}
     */
    Pagination<ProjectExcel> exportProjectPageList(Pagination<TProject> paramBean) throws Exception;

    /**
     *
     * @param projectId
     * @author wzq
     * @date 2020-05-19 09:41:14
     * @return {@link com.yuepeng.web.manage.project.bean.vo.ProjectVo}
     */
    ProjectVo viewProject(Integer projectId) throws Exception;

    /**
     * 更新项目信息
     * @param projectVo
     * @author wzq
     * @date 2020/5/20 13:42
     * @return {@link boolean}
     */
    boolean updateProjectInfo(ProjectVo projectVo) throws Exception;
}