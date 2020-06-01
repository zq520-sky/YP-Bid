package com.yuepeng.web.manage.finance.controller;

import com.yuepeng.web.manage.finance.bean.entity.TOrder;
import com.yuepeng.web.manage.finance.bean.vo.OrderVo;
import com.yuepeng.web.manage.finance.bean.excel.OrderExcel;
import com.yuepeng.web.manage.finance.service.IOrderService;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.pm.service.ILogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 客户支付订单(Order)表控制层
 *
 * @author wzq
 * @since 2020-05-18 08:42:21
 */
@Controller
@RequestMapping("/manage/finance/order")
public class OrderController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private IOrderService orderService;
    
    @Resource
    private ILogService logService;

    private SimpleDateFormat sdfBegin = new SimpleDateFormat("yyyy-MM-01");
    private SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 订单管理分页
     * @param paramBean
     * @param orderVo
     * @author wzq
     * @date 2020/5/18 8:50
     * @return {@link String}
     */
    @RequestMapping("queryOrderList" + WebConstant.PAGE_SUFFIX)
    public String queryOrderPageList(Pagination<OrderVo> paramBean, OrderVo orderVo) throws Exception{
        if (orderVo.getOrderDateBegin() == null) {
            orderVo.setOrderDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (orderVo.getOrderDateEnd() == null) {
            orderVo.setOrderDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(orderVo);
        Pagination<OrderVo> pageData = orderService.queryOrderPageList(paramBean);
        this.addAttr("pageData", pageData);
        return "finance/orderManage";
    }

    /**
     * 订单信息导出
     * @param paramBean
     * @param orderVo
     * @author wzq
     * @date 2020/5/18 10:38
     * @return {@link String}
     */
    @RequestMapping("/exportOrderList" + WebConstant.BUSINESS_SUFFIX)
    public String exportOrderList(Pagination<TOrder> paramBean, OrderVo orderVo) throws Exception {
        if (orderVo.getOrderDateBegin() == null) {
            orderVo.setOrderDateBegin(sdfParse.parse(sdfBegin.format(System.currentTimeMillis()) + " 00:00:00"));
        }
        if (orderVo.getOrderDateEnd() == null) {
            orderVo.setOrderDateEnd(sdfParse.parse(sdfEnd.format(System.currentTimeMillis()) + " 23:59:59"));
        }
        paramBean.setSearch(orderVo);
        Pagination<OrderExcel> list = orderService.exportOrderPageList(paramBean);
        logService.addLog(new TSysLog("客户订单管理-导出", "导出客户订单信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "客户订单信息" + String.format("%1$tY%1$tm%1$td", new Date()), OrderExcel.class, list.getData());
        return null;
    }

    
    @RequestMapping("viewOrder" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewOrder(Integer orderId) throws Exception {
        OrderVo orderVo = orderService.viewOrder(orderId);
        return this.getResultMap(true, orderVo);
    }
    
    
}