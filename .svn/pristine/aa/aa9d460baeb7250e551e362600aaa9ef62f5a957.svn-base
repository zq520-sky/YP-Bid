package com.yuepeng.web.manage.customer.dao;

import com.yuepeng.platform.common.dao.AutoMapperInteger;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TMember;
import com.yuepeng.web.manage.customer.bean.excel.MemberExcel;
import com.yuepeng.web.manage.customer.bean.vo.MemberVo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author wzq
 */
public interface TMemberMapper extends AutoMapperInteger<TMember> {

    /**
     * 会员信息分页
     * @param paramBean
     * @param rowBounds
     * @author wzq
     * @date 2020/5/12 10:17
     * @return {@link List< MemberVo>}
     */
    List<MemberVo> queryMemberList(Pagination<MemberVo> paramBean, RowBounds rowBounds) throws Exception;

    /**
     * 导出会员信息
     * @param paramBean
     * @param rowBounds
     * @author wzq
     * @date 2020/5/12 10:17
     * @return {@link List< MemberExcel>}
     */
    List<MemberExcel> exportMemberList(Pagination<TMember> paramBean, RowBounds rowBounds) throws Exception;

    /**
     * 查看会员信息
     * @param memberId
     * @author wzq
     * @date 2020/5/12 10:17
     * @return {@link MemberVo}
     */
    MemberVo viewMember(Integer memberId) throws Exception;

    /**
     * 获取会员信息
     * @param custId
     * @author wzq
     * @date 2020/5/12 12:00
     * @return {@link TMember}
     */
    TMember getByCustId(Integer custId) throws Exception;

}