package com.yuepeng.web.manage.finance.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.finance.bean.entity.TOrderInvoice;
import com.yuepeng.web.manage.finance.bean.excel.OrderInvoiceExcel;
import com.yuepeng.web.manage.finance.bean.vo.OrderInvoiceVo;
import com.yuepeng.web.manage.finance.constants.InvoiceExpCodeConstant;
import com.yuepeng.web.manage.finance.service.IOrderInvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 客户发票申请表(OrderInvoice)表控制层
 *
 * @author wzq
 * @since 2020-05-15 16:40:54
 */
@Controller
@RequestMapping("/manage/finance/invoice")
public class OrderInvoiceController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private IOrderInvoiceService orderInvoiceService;
    
    @Resource
    private ILogService logService;

    private SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
    private SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 客户发票管理分页
     * @param paramBean
     * @param orderInvoiceVo
     * @author wzq
     * @date 2020/5/18 17:35
     * @return {@link String}
     */
    @RequestMapping("queryInvoiceList" + WebConstant.PAGE_SUFFIX)
    public String queryOrderInvoicePageList(Pagination<OrderInvoiceVo> paramBean, OrderInvoiceVo orderInvoiceVo) throws Exception{
        if (orderInvoiceVo.getApplyTimeBegin() == null) {
            orderInvoiceVo.setApplyTimeBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (orderInvoiceVo.getApplyTimeEnd() == null) {
            orderInvoiceVo.setApplyTimeEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(orderInvoiceVo);
        Pagination<OrderInvoiceVo> pageData = orderInvoiceService.queryOrderInvoicePageList(paramBean);
        this.addAttr("pageData", pageData);
        return "finance/orderInvoiceManage";
    }

    /**
     * 客户发票信息导出
     * @param paramBean
     * @param orderInvoiceVo
     * @author wzq
     * @date 2020/5/18 17:35
     * @return {@link String}
     */
    @RequestMapping("/exportInvoiceList" + WebConstant.BUSINESS_SUFFIX)
    public String exportOrderInvoiceList(Pagination<TOrderInvoice> paramBean, OrderInvoiceVo orderInvoiceVo) throws Exception {
        if (orderInvoiceVo.getApplyTimeBegin() == null) {
            orderInvoiceVo.setApplyTimeBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (orderInvoiceVo.getApplyTimeEnd() == null) {
            orderInvoiceVo.setApplyTimeEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(orderInvoiceVo);
        Pagination<OrderInvoiceExcel> list = orderInvoiceService.exportOrderInvoicePageList(paramBean);
        logService.addLog(new TSysLog("客户发票管理-导出", "导出客户发票信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "客户发票" + String.format("%1$tY%1$tm%1$td", new Date()), OrderInvoiceExcel.class, list.getData());
        return null;
    }

    /**
     * 
     * @param invoiceId
     * @author wzq
     * @date 2020/5/18 17:45
     * @return {@link java.util.Map<java.lang.String,java.lang.Object>}
     */
    @RequestMapping("viewInvoice" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewOrderInvoice(Integer invoiceId) throws Exception {
        OrderInvoiceVo orderInvoiceVo = orderInvoiceService.viewOrderInvoice(invoiceId);
        return this.getResultMap(true, orderInvoiceVo);
    }

    /**
     * 更新发票信息
     * @param orderInvoiceVo
     * @author wzq
     * @date 2020/5/20 16:26
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("updateInvoice" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updateInvoice(OrderInvoiceVo orderInvoiceVo) throws Exception {
        orderInvoiceVo.setUpdateDate(new Date());
        boolean result = orderInvoiceService.updateSelectiveById(orderInvoiceVo);
        if (result) {
            logService.addLog(new TSysLog("客户发票管理-编辑", "编辑发票信息【" + orderInvoiceVo.getInvoiceId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("客户发票管理-编辑", "编辑发票信息【" + orderInvoiceVo.getInvoiceId() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(InvoiceExpCodeConstant.ORDER_INVOICE_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * 开票/取消开票
     * @param orderInvoiceVo
     * @author wzq
     * @date 2020/5/20 16:31
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("setInvoice" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> setInvoice(OrderInvoiceVo orderInvoiceVo) throws Exception {
        Integer status = orderInvoiceVo.getStatus();
        orderInvoiceVo.setUpdateDate(new Date());
        boolean result = orderInvoiceService.updateSelectiveById(orderInvoiceVo);
        if (result) {
            logService.addLog(new TSysLog("客户发票管理-开票", (status==1?"开票":"取消开票")+"【" + orderInvoiceVo.getInvoiceId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("客户发票管理-开票", (status==1?"开票":"取消开票")+"【" + orderInvoiceVo.getInvoiceId() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(InvoiceExpCodeConstant.ORDER_INVOICE_EDIT_SET_ERROR);
        }
        return this.getResultMap(true, result);
    }
    
}