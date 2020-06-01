package com.yuepeng.web.manage.customer.service;

import com.yuepeng.platform.common.service.ISuperIntegerService;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.web.manage.customer.bean.entity.TMember;
import com.yuepeng.web.manage.customer.bean.excel.MemberExcel;
import com.yuepeng.web.manage.customer.bean.vo.MemberVo;

/**
 * 〈功能概述〉<br>
 *
 * @className: IMemberService
 * @package: com.yuepeng.web.manage.customer.service
 * @author: wzq
 * @date: 2020/5/12 9:50
 */
public interface IMemberService extends ISuperIntegerService<TMember> {

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020/5/12 10:10
     * @return {@link Pagination< MemberVo>}
     */
    Pagination<MemberVo> queryMemberList(Pagination<MemberVo> paramBean) throws Exception;

    /**
     *
     * @param paramBean
     * @author wzq
     * @date 2020/5/12 10:09
     * @return {@link Pagination< MemberExcel>}
     */
    Pagination<MemberExcel> exportMemberList(Pagination<TMember> paramBean) throws Exception;


    /**
     *
     * @param memberId
     * @author wzq
     * @date 2020/5/12 10:11
     * @return {@link com.yuepeng.web.manage.customer.bean.vo.MemberVo}
     */
    MemberVo viewMember(Integer memberId) throws Exception;

    /**
     * 设置会员
     * @param memberVo
     * @author wzq
     * @date 2020/5/12 11:04
     * @return {@link Boolean}
     */
    Boolean insertMember(MemberVo memberVo) throws Exception;

    /**
     * 修改会员信息
     * @param memberVo
     * @author wzq
     * @date 2020/5/12 11:04
     * @return {@link boolean}
     */
    boolean updateMember(MemberVo memberVo) throws Exception;

}
