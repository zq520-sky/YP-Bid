package com.yuepeng.web.manage.customer.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TProjectKeywordCollect;
import com.yuepeng.web.manage.customer.bean.excel.ProjectKeywordCollectExcel;
import com.yuepeng.web.manage.customer.bean.vo.ProjectKeywordCollectVo;

/**
 * 〈功能概述〉<br>
 *
 * @className: IProjectKeywordCollectService
 * @package: com.yuepeng.web.manage.customer.service
 * @author: wzq
 * @date: 2020/5/13 16:06
 */
public interface IProjectKeywordCollectService extends ISuperIntegerService<TProjectKeywordCollect> {

    /**
     * @param paramBean
     * @return {@link Pagination < ProjectKeywordCollectVo>}
     * @author wzq
     * @date 2020/5/12 10:10
     */
    Pagination<ProjectKeywordCollectVo> queryKeywordList(Pagination<ProjectKeywordCollectVo> paramBean) throws Exception;

    /**
     * @param paramBean
     * @return {@link Pagination< ProjectKeywordCollectExcel>}
     * @author wzq
     * @date 2020/5/12 10:09
     */
    Pagination<ProjectKeywordCollectExcel> exportKeywordList(Pagination<TProjectKeywordCollect> paramBean) throws Exception;


    /**
     * @param keywordCollectId
     * @return {@link com.yuepeng.web.manage.customer.bean.vo.ProjectKeywordCollectVo}
     * @author wzq
     * @date 2020/5/12 10:11
     */
    ProjectKeywordCollectVo viewKeyword(Integer keywordCollectId) throws Exception;

}
