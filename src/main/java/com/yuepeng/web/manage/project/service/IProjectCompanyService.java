package com.yuepeng.web.manage.project.service;

import com.yuepeng.web.manage.project.bean.entity.TProjectCompany;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.web.manage.project.bean.vo.ProjectCompanyVo;
import com.yuepeng.web.manage.project.bean.excel.ProjectCompanyExcel;


/**
 * 招标单位信息表(ProjectCompany)表服务接口
 *
 * @author wzq
 * @since 2020-05-22 11:01:33
 */
public interface IProjectCompanyService extends ISuperIntegerService<TProjectCompany>{


    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-22 11:01:33
     * @return {@link Pagination< ProjectCompanyVo>}
     */
    Pagination<ProjectCompanyVo> queryProjectCompanyPageList(Pagination<ProjectCompanyVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020-05-22 11:01:33
     * @return {@link Pagination< ProjectCompanyExcel>}
     */
    Pagination<ProjectCompanyExcel> exportProjectCompanyPageList(Pagination<TProjectCompany> paramBean) throws Exception;

    /**
     *
     * @param projectCompanyId
     * @author wzq
     * @date 2020-05-22 11:01:33
     * @return {@link com.yuepeng.web.manage.project.bean.vo.ProjectCompanyVo}
     */
    ProjectCompanyVo viewProjectCompany(Integer projectCompanyId) throws Exception;

    /**
     * 删除招标单位
     * @param projectCompanyId
     * @author wzq
     * @date 2020/5/22 13:39
     * @return {@link boolean}
     */
    boolean delProjectCompany(Integer projectCompanyId) throws Exception;
}