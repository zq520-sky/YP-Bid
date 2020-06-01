package com.yuepeng.web.manage.customer.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.customer.bean.entity.TMember;
import com.yuepeng.web.manage.customer.bean.excel.MemberExcel;
import com.yuepeng.web.manage.customer.bean.vo.MemberVo;
import com.yuepeng.web.manage.customer.constant.CustomerExpCodeConstant;
import com.yuepeng.web.manage.customer.service.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @className: MemberController
 * @package: com.yuepeng.web.manage.customer.controller
 * @author: wzq
 * @date: 2020/5/12 9:53
 */
@Controller
@RequestMapping("/manage/customer/member")
public class MemberController extends BaseController {

    @Resource
    private IMemberService memberService;

    @Resource
    private ILogService logService;

    /**
     * 会员信息管理分页
     *
     * @param paramBean
     * @param memberVo
     * @return {@link String}
     * @author wzq
     * @date 2020/5/12 10:14
     */
    @RequestMapping("/queryMemberList" + WebConstant.PAGE_SUFFIX)
    public String queryMemberList(Pagination<MemberVo> paramBean, MemberVo memberVo) throws Exception {
        SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
        SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (memberVo.getCreateDateBegin() == null) {
            memberVo.setCreateDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (memberVo.getCreateDateEnd() == null) {
            memberVo.setCreateDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(memberVo);
        Pagination<MemberVo> pageData = memberService.queryMemberList(paramBean);
        this.addAttr("pageData", pageData);
        return "customer/memberManage";
    }

    /**
     * 导出会员信息
     *
     * @param paramBean
     * @param memberVo
     * @return {@link String}
     * @author wzq
     * @date 2020/5/12 10:14
     */
    @RequestMapping("/exportMemberList" + WebConstant.BUSINESS_SUFFIX)
    public String exportMemberList(Pagination<TMember> paramBean, MemberVo memberVo) throws Exception {
        SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
        SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (memberVo.getCreateDateBegin() == null) {
            memberVo.setCreateDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (memberVo.getCreateDateEnd() == null) {
            memberVo.setCreateDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(memberVo);
        Pagination<MemberExcel> list = memberService.exportMemberList(paramBean);
        logService.addLog(new TSysLog("会员信息记录-导出", "导出会员信息记录！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "会员信息记录" + String.format("%1$tY%1$tm%1$td", new Date()), MemberExcel.class, list.getData());
        return null;
    }

    /**
     * 查看会员信息
     *
     * @param memberId
     * @return {@link Map< String, Object>}
     * @author wzq
     * @date 2020/5/12 10:14
     */
    @RequestMapping("/viewMember" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewMember(Integer memberId) throws Exception {
        MemberVo memberVo = memberService.viewMember(memberId);
        return this.getResultMap(true, memberVo);
    }

    /**
     * 设置会员
     *
     * @param memberVo
     * @return {@link Map< String, Object>}
     * @author wzq
     * @date 2020/5/12 11:00
     */
    @RequestMapping("setMember" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> setMember(MemberVo memberVo) throws Exception {
        //校验主键ID
        if (memberVo.getCustId() == null) {
            throw new ServiceException(CustomerExpCodeConstant.MEMBER_SET_ERROR);
        }
        //执行编辑
        boolean result = memberService.insertMember(memberVo);
        if (result) {
            logService.addLog(new TSysLog("客户信息管理-编辑", "设置会员【" + memberVo.getCustCode() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("客户信息管理-编辑", "设置会员【" + memberVo.getCustCode() + "】 失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(CustomerExpCodeConstant.MEMBER_SET_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * 更新会员信息
     *
     * @param memberVo
     * @return {@link Map< String, Object>}
     * @author wzq
     * @date 2020/5/12 11:09
     */
    @RequestMapping("updateMember" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateMember(MemberVo memberVo) throws Exception {
        //校验主键ID
        if (memberVo.getCustId() == null || memberVo.getMemberId() == null) {
            throw new ServiceException(CustomerExpCodeConstant.MEMBER_EDIT_ERROR);
        }
        //执行编辑
        boolean result = memberService.updateMember(memberVo);
        if (result) {
            logService.addLog(new TSysLog("会员信息管理-编辑", "编辑会员信息【" + memberVo.getCustCode() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("会员信息管理-编辑", "编辑会员信息【" + memberVo.getCustCode() + "】 失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(CustomerExpCodeConstant.MEMBER_EDIT_ERROR);
        }
        return this.getResultMap(true, result);
    }

}
