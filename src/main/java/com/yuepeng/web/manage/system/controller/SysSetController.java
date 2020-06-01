package com.yuepeng.web.manage.system.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.system.bean.vo.SysSetVo;
import com.yuepeng.web.manage.system.constants.SystemExpCodeConstant;
import com.yuepeng.web.manage.system.service.ISysSetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/manage/system/")
public class SysSetController extends BaseController {

    @Resource
    private ISysSetService sysSetService;

    @Resource
    private ILogService logService;

    @RequestMapping("info/querySysList" + WebConstant.PAGE_SUFFIX)
    public String queryPlanList() throws Exception {
        SysSetVo sysSetVo = sysSetService.querySysSetPageList();
        this.addAttr("data", sysSetVo);
        return "system/sysSetting";
    }

    /**
     * @Description:
     * @Author: ZhongShengbin
     * @Date: 2020/05/27 17:16
     * Copyright (c) 2019, Samton. All rights reserved
     */
    @RequestMapping("info/addSys" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addPlan(SysSetVo sysSetVo) throws Exception {
        //如果还没有设置
        boolean result;
        result = sysSetService.insertOrUpdate(sysSetVo);
        if (result) {
            logService.addLog(new TSysLog("系统设置-设置", "设置系统信息【" + sysSetVo.getSysName() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("系统设置-设置", "设置系统信息【" + sysSetVo.getSysName() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(SystemExpCodeConstant.SYS_COMPANY_ADD_ERROR);
        }
        return this.getResultMap(true, result);
    }
}
