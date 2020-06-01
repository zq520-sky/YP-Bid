package com.yuepeng.web.manage.customer.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TProjectKeywordCollect;
import com.yuepeng.web.manage.customer.bean.excel.ProjectKeywordCollectExcel;
import com.yuepeng.web.manage.customer.bean.vo.ProjectKeywordCollectVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author wzq
 */
public interface TProjectKeywordCollectMapper extends AutoMapperInteger<TProjectKeywordCollect> {

    /**
     * @param paramBean
     * @param rowBounds
     * @return {@link List< ProjectKeywordCollectVo>}
     * @author wzq
     * @date 2020/5/13 16:14
     */
    List<ProjectKeywordCollectVo> queryKeywordList(Pagination<ProjectKeywordCollectVo> paramBean, RowBounds rowBounds) throws Exception;

    /**
     * @param paramBean
     * @param rowBounds
     * @return {@link java.util.List<com.yuepeng.web.manage.customer.bean.excel.ProjectKeywordCollectExcel>}
     * @author wzq
     * @date 2020/5/13 16:14
     */
    List<ProjectKeywordCollectExcel> exportKeywordList(Pagination<TProjectKeywordCollect> paramBean, RowBounds rowBounds) throws Exception;

    /**
     * @param keywordCollectId
     * @return {@link ProjectKeywordCollectVo}
     * @author wzq
     * @date 2020/5/13 16:14
     */
    ProjectKeywordCollectVo viewKeyword(Integer keywordCollectId) throws Exception;

}
