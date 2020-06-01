package com.yuepeng.web.manage.customer.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.bean.UserCacheBean;
import com.yuepeng.platform.framework.mybatis.pagination.PageContext;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.customer.bean.entity.TMember;
import com.yuepeng.web.manage.customer.bean.excel.MemberExcel;
import com.yuepeng.web.manage.customer.bean.vo.MemberVo;
import com.yuepeng.web.manage.customer.dao.TCustomerMapper;
import com.yuepeng.web.manage.customer.dao.TMemberMapper;
import com.yuepeng.web.manage.customer.service.IMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 〈功能概述〉<br>
 *
 * @className: MemberServiceImpl
 * @package: com.yuepeng.web.manage.customer.service.impl
 * @author: wzq
 * @date: 2020/5/12 9:50
 */
@Service
public class MemberServiceImpl  extends SuperServiceIntegerImpl<TMemberMapper, TMember> implements IMemberService {

    @Resource
    private TCustomerMapper customerMapper;

    @Override
    public Pagination<MemberVo> queryMemberList(Pagination<MemberVo> paramBean) throws Exception {
        Pagination<MemberVo> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<MemberVo> list = mapper.queryMemberList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public Pagination<MemberExcel> exportMemberList(Pagination<TMember> paramBean) throws Exception {
        Pagination<MemberExcel> pagination = PageContext.initialize(paramBean.getPage(), paramBean.getRows());
        List<MemberExcel> list = mapper.exportMemberList(paramBean, pagination.getRowBounds());
        pagination.setData(list);
        return pagination;
    }

    @Override
    public MemberVo viewMember(Integer memberId) throws Exception {
        return mapper.viewMember(memberId);
    }

    /**
     * 设置会员：
     *    如果之前设置过（已是会员），则更新，否则添加
     *    1. 添加会员t_member
     *    3. 更新t_customer
     * @param memberVo
     * @author wzq
     * @date 2020/5/12 13:41
     * @return {@link Boolean}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertMember(MemberVo memberVo) throws Exception {
        boolean success = false;
        UserCacheBean currentUser = CurrentUtil.getCurrentUser();
        Date currentDate = new Date();
        //设置会员
        Integer custId = memberVo.getCustId();
        TMember member = mapper.getByCustId(custId);
        //判断是否曾是会员
        if(member == null){
            //创建
            member = newMember();
            member.setCustId(memberVo.getCustId());
            member.setMemberType(memberVo.getMemberType());
            member.setUseStartTime(memberVo.getUseStartTime());
            member.setUseEndTime(memberVo.getUseEndTime());
            member.setRoleProvinceIds(memberVo.getRoleProvinceIds());
            member.setRoleProvinceNames(memberVo.getRoleProvinceNames());
            int insert = mapper.insertSelective(member);
            success = insert > 0;
        }else{
            //更新
            member.setMemberType(memberVo.getMemberType());
            member.setUseStartTime(memberVo.getUseStartTime());
            member.setUseEndTime(memberVo.getUseEndTime());
            member.setRoleProvinceIds(memberVo.getRoleProvinceIds());
            member.setRoleProvinceNames(memberVo.getRoleProvinceNames());
            member.setUpdateDate(currentDate);
            member.setUpdateUserId(currentUser.getUserId().intValue());
            int update = mapper.updateByPrimaryKeySelective(member);
            success = update > 0;
        }
        //更新t_customer member_type
        updateCustomer(memberVo, currentDate);
        return success;
    }

    private void updateCustomer(MemberVo memberVo, Date currentDate) throws Exception {
        UserCacheBean currentUser = CurrentUtil.getCurrentUser();
        TCustomer customer = new TCustomer();
        customer.setCustId(memberVo.getCustId());
        customer.setMemberType(memberVo.getMemberType());
        if(memberVo.getMemberType() == 0){
            customer.setIsMember(0);
        }
        customer.setModifyDate(currentDate);
        customer.setModifyUserId(currentUser.getUserId().intValue());
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public boolean updateMember(MemberVo memberVo) throws Exception {
        UserCacheBean currentUser = CurrentUtil.getCurrentUser();
        Date currentDate = new Date();
        memberVo.setUpdateDate(currentDate);
        memberVo.setUpdateUserId(currentUser.getUserId().intValue());
        int update = mapper.updateByPrimaryKeySelective(memberVo);
        updateCustomer(memberVo, currentDate);
        return update > 0;
    }

    private TMember newMember(){
        UserCacheBean currentUser = CurrentUtil.getCurrentUser();
        Date currentDate = new Date();
        TMember tMember = new TMember();
        tMember.setCreateDate(currentDate);
        tMember.setUpdateDate(currentDate);
        tMember.setCreateUserId(currentUser.getUserId().intValue());
        tMember.setUpdateUserId(currentUser.getUserId().intValue());
        return tMember;
    }
}
