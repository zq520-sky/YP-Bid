package com.yuepeng.web.manage.project.dao;

import com.yuepeng.web.manage.project.bean.entity.TProject;
import com.yuepeng.web.manage.project.bean.vo.ProjectVo;
import com.yuepeng.web.manage.project.bean.excel.ProjectExcel;
import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

/**
 * 招标项目信息表(Project)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-19 09:41:11
 */
public interface TProjectMapper extends AutoMapperInteger<TProject>{

    List<ProjectVo> queryProjectPageList(Pagination<ProjectVo> paramBean, RowBounds rowBounds) throws Exception;

    List<ProjectExcel> exportProjectPageList(Pagination<TProject> paramBean, RowBounds rowBounds) throws Exception;

    ProjectVo viewProject(Integer projectId) throws Exception;

    List<TProject> selectListByCompanyId(Integer projectCompanyId) throws Exception;
}