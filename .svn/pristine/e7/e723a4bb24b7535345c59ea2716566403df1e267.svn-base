package com.yuepeng.web.manage.customer.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.customer.bean.entity.TCustomer;
import com.yuepeng.web.manage.customer.bean.excel.CustomerExcel;
import com.yuepeng.web.manage.customer.bean.vo.CustomerVo;
import com.yuepeng.web.manage.customer.constant.CustomerExpCodeConstant;
import com.yuepeng.web.manage.customer.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author wzq
 * @className CustomerController
 * @description 客户信息控制层
 * @date 2020/5/11 14:28
 */
@Controller
@RequestMapping("/manage/customer/info")
public class CustomerController extends BaseController {

    @Resource
    public ICustomerService customerService;

    @Resource
    private ILogService logService;

    /**
     * 客户信息管理分页
     * @param paramBean
     * @param customerVo
     * @author wzq
     * @date 2020/5/11 15:21
     * @return {@link String}
     */
    @RequestMapping("queryCustList" + WebConstant.PAGE_SUFFIX)
    public String queryCustomerInfoList(Pagination<CustomerVo> paramBean, CustomerVo customerVo) throws Exception{
        SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
        SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (customerVo.getRegisterDateBegin() == null) {
            customerVo.setRegisterDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (customerVo.getRegisterDateEnd() == null) {
            customerVo.setRegisterDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(customerVo);
        Pagination<CustomerVo> pageData = customerService.queryCustomerPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "customer/custInfoManage";
    }

    /**
     * 导出客户信息
     * @param paramBean
     * @param customerVo
     * @author wzq
     * @date 2020/5/11 16:28
     * @return {@link String}
     */
    @RequestMapping("/exportCustList" + WebConstant.BUSINESS_SUFFIX)
    public String exportFinanceInfoList(Pagination<TCustomer> paramBean, CustomerVo customerVo) throws Exception {
        SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
        SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (customerVo.getRegisterDateBegin() == null) {
            customerVo.setRegisterDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (customerVo.getRegisterDateEnd() == null) {
            customerVo.setRegisterDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(customerVo);
        Pagination<CustomerExcel> list = customerService.exportCustomerPageList(paramBean);
        logService.addLog(new TSysLog("客户信息记录-导出", "导出客户信息记录！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "客户信息记录" + String.format("%1$tY%1$tm%1$td", new Date()), CustomerExcel.class, list.getData());
        return null;
    }

    /**
     * 客户信息查看
     * @param custId
     * @author wzq
     * @date 2020/5/11 16:49
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("viewCust" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewCustomer(Integer custId) throws Exception {
        CustomerVo customerVo = customerService.viewCustomer(custId);
        return this.getResultMap(true, customerVo);
    }

    /**
     * 客户禁用/启用
     * @param tCustomer
     * @author wzq
     * @date 2020/5/11 17:04
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("disAndEnableCust" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> disableCustomer(TCustomer tCustomer) throws Exception {
        //校验主键ID
        if(tCustomer.getCustId() == null){
            throw new ServiceException(CustomerExpCodeConstant.CUST_EDIT_COLUMN_ERROR);
        }
        //执行编辑
        tCustomer.setModifyDate(new Date());
        Long userId = CurrentUtil.getCurrentUser().getUserId();
        tCustomer.setModifyUserId(userId.intValue());
        boolean result = customerService.updateSelectiveById(tCustomer);
        String headStr = tCustomer.getIsForbid() == 0 ? "启用" : "禁用";
        if (result) {
            logService.addLog(new TSysLog("客户信息管理-禁用/启用", headStr+"客户【" + tCustomer.getCustCode() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("客户信息管理-禁用/启用", headStr+"客户【" + tCustomer.getCustCode() + "】 失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(CustomerExpCodeConstant.CUST_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }

}
