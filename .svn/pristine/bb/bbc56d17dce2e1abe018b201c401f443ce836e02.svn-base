package com.yuepeng.web.manage.project.dao;

import com.yuepeng.web.manage.project.bean.entity.TProjectCompany;
import com.yuepeng.web.manage.project.bean.vo.ProjectCompanyVo;
import com.yuepeng.web.manage.project.bean.excel.ProjectCompanyExcel;
import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

/**
 * 招标单位信息表(ProjectCompany)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-22 11:01:32
 */
public interface TProjectCompanyMapper extends AutoMapperInteger<TProjectCompany>{

    List<ProjectCompanyVo> queryProjectCompanyPageList(Pagination<ProjectCompanyVo> paramBean, RowBounds rowBounds) throws Exception;

    List<ProjectCompanyExcel> exportProjectCompanyPageList(Pagination<TProjectCompany> paramBean, RowBounds rowBounds) throws Exception;

    ProjectCompanyVo viewProjectCompany(Integer projectCompanyId) throws Exception;

}