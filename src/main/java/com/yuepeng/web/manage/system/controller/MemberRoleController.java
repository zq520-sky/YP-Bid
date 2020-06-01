package com.yuepeng.web.manage.system.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.system.bean.entity.TMemberRole;
import com.yuepeng.web.manage.system.bean.excel.MemberRoleEntity;
import com.yuepeng.web.manage.system.bean.excel.SysAppVersionEntity;
import com.yuepeng.web.manage.system.bean.vo.MemberRoleVo;
import com.yuepeng.web.manage.system.constants.SystemExpCodeConstant;
import com.yuepeng.web.manage.system.service.IMemberRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 会员角色Controller
 * @Author: ZhongShengbin
 * @Date: 2020/05/24 14:28
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Controller
@RequestMapping("/manage/platform/")
public class MemberRoleController extends BaseController {

    @Resource
    private IMemberRoleService memberRoleService;

    @Resource
    private ILogService logService;

    /**
     * @return java.lang.String
     * @Author ZhongShengbin
     * @Description 会员权限分頁
     * @Date 2020/5/18 0018
     * @Param [paramBean, searchHotwordVo]
     **/
    @RequestMapping("memberRole/queryMemberRoleList" + WebConstant.PAGE_SUFFIX)
    public String queryMemberRoleList(Pagination<MemberRoleVo> paramBean, MemberRoleVo searchHotwordVo) throws Exception {
        paramBean.setSearch(searchHotwordVo);
        Pagination<MemberRoleVo> pageData = memberRoleService.queryMemberRoleList(paramBean);
        this.addAttr("pageData", pageData);
        return "system/memberRole";
    }

    /**
     * @return java.lang.String
     * @Author ZhongShengbin
     * @Description 会员权限导出
     * @Date 2020/5/19 0019
     * @Param [paramBean, searchHotwordVo]
     **/
    @RequestMapping("memberRole/exportMemberRoleList" + WebConstant.BUSINESS_SUFFIX)
    public String exportMemberRoleList(Pagination<MemberRoleVo> paramBean, MemberRoleVo memberRoleVo) throws Exception {
        paramBean.setSearch(memberRoleVo);
        Pagination<MemberRoleEntity> list = memberRoleService.exportMemberRoleList(paramBean);
        logService.addLog(new TSysLog("会员权限-导出", "导出会员权限信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "会员权限" + String.format("%1$tY%1$tm%1$td", new Date()), MemberRoleEntity.class, list.getData());
        return null;
    }

    /**
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @Author ZhongShengbin
     * @Description 会员权限查看
     * @Date 2020/5/18 0018
     * @Param [hotwordId]
     **/
    @RequestMapping("memberRole/viewMemberRoleList" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewMemberRole(Integer memberRoleId) throws Exception {
        MemberRoleVo memberRoleVo = memberRoleService.queryMemberRoleListById(memberRoleId);
        return this.getResultMap(true, memberRoleVo);
    }

    /**
     * @return java.util.Map<java.lang.String   ,   java.lang.Object>
     * @Author ZhongShengbin
     * @Description 编辑
     * @Date 2020/5/19 0019
     * @Param [searchHotwordVo]
     **/
    @RequestMapping("memberRole/updateMemberRole" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateMemberRole(TMemberRole memberRole) throws Exception {
        if (memberRole.getMemberRoleId() == null) {
            throw new ServiceException(SystemExpCodeConstant.VERSION_EDIT_COLUMN_ERROR);
        }
        boolean result = memberRoleService.updateSelectiveById(memberRole);
        if (result) {
            if (result) {
                logService.addLog(new TSysLog("会员权限-编辑", "编辑会员权限信息【" + memberRole.getMemberRoleId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
            } else {
                logService.addLog(new TSysLog("会员权限-编辑", "编辑会员权限信息【" + memberRole.getMemberRoleId() + "】失败 ！", PmStateConstant.LOG_PLATFORM));
            }
            if (!result) {
                throw new ServiceException(SystemExpCodeConstant.VERSION_EDIT_COLUMN_ERROR);
            }
        }
        return this.getResultMap(true, result);
    }
}
