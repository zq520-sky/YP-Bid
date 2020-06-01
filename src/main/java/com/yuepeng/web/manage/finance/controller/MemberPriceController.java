package com.yuepeng.web.manage.finance.controller;

import com.yuepeng.platform.framework.base.BaseController;
import com.yuepeng.platform.framework.constant.WebConstant;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.framework.util.CurrentUtil;
import com.yuepeng.platform.pm.bean.entity.TSysLog;
import com.yuepeng.platform.pm.constant.PmStateConstant;
import com.yuepeng.platform.pm.service.ILogService;
import com.yuepeng.web.manage.finance.bean.entity.TMemberPrice;
import com.yuepeng.web.manage.finance.bean.excel.MemberPriceExcel;
import com.yuepeng.web.manage.finance.bean.vo.MemberPriceVo;
import com.yuepeng.web.manage.finance.constants.MemberPriceExpCodeConstant;
import com.yuepeng.web.manage.finance.service.IMemberPriceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * 会员价格表(MemberPrice)表控制层
 *
 * @author wzq
 * @since 2020-05-15 16:39:16
 */
@Controller
@RequestMapping("/manage/finance/price/combo")
public class MemberPriceController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private IMemberPriceService memberPriceService;
    
    @Resource
    private ILogService logService;

    /**
     * 价格套餐管理分页
     * @param paramBean
     * @param memberPriceVo
     * @author wzq
     * @date 2020/5/18 13:50
     * @return {@link String}
     */
    @RequestMapping("queryPriceList" + WebConstant.PAGE_SUFFIX)
    public String queryMemberPricePageList(Pagination<MemberPriceVo> paramBean, MemberPriceVo memberPriceVo) throws Exception{
        paramBean.setSearch(memberPriceVo);
        Pagination<MemberPriceVo> pageData = memberPriceService.queryMemberPricePageList(paramBean);
        this.addAttr("pageData", pageData);
        return "finance/memberPriceManage";
    }

    /**
     * 价格套餐信息导出
     * @param paramBean
     * @param memberPriceVo
     * @author wzq
     * @date 2020/5/18 13:51
     * @return {@link String}
     */
    @RequestMapping("/exportPriceList" + WebConstant.BUSINESS_SUFFIX)
    public String exportMemberPriceList(Pagination<TMemberPrice> paramBean, MemberPriceVo memberPriceVo) throws Exception {
        paramBean.setSearch(memberPriceVo);
        Pagination<MemberPriceExcel> list = memberPriceService.exportMemberPricePageList(paramBean);
        logService.addLog(new TSysLog("价格套餐管理-导出", "导出价格套餐信息！", PmStateConstant.LOG_PLATFORM));
        this.export(response, "价格套餐" + String.format("%1$tY%1$tm%1$td", new Date()), MemberPriceExcel.class, list.getData());
        return null;
    }

    /**
     * 
     * @param priceId
     * @author wzq
     * @date 2020/5/18 13:51
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("viewPrice" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> viewMemberPrice(Integer priceId) throws Exception {
        MemberPriceVo memberPriceVo = memberPriceService.viewMemberPrice(priceId);
        return this.getResultMap(true, memberPriceVo);
    }

    /**
     * 更新价格套餐
     * @param memberPriceVo
     * @author wzq
     * @date 2020/5/18 15:30
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("updatePrice" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> updatePrice(MemberPriceVo memberPriceVo) throws Exception{
        //校验主键ID
        if(memberPriceVo.getPriceId() == null){
            throw new ServiceException(MemberPriceExpCodeConstant.PRICE_EDIT_ID_ERROR);
        }
        memberPriceVo.setUpdateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        memberPriceVo.setUpdateDate(new Date());
        boolean result = memberPriceService.updateSelectiveById(memberPriceVo);
        if (result) {
            logService.addLog(new TSysLog("价格套餐管理-编辑", "编辑套餐【" + memberPriceVo.getPriceId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("价格套餐管理-编辑", "编辑套餐【" + memberPriceVo.getPriceId() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(MemberPriceExpCodeConstant.PRICE_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     * 
     * @param memberPriceVo
     * @author wzq
     * @date 2020/5/18 15:49
     * @return {@link java.util.Map<java.lang.String,java.lang.Object>}
     */
    @RequestMapping("addPrice" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> addPrice(MemberPriceVo memberPriceVo) throws Exception{
        Date date = new Date();
        memberPriceVo.setUpdateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        memberPriceVo.setCreateUserId(CurrentUtil.getCurrentUser().getUserId().intValue());
        memberPriceVo.setUpdateDate(date);
        memberPriceVo.setCreateDate(date);
        memberPriceVo.setIsForbid(0);
        boolean result = memberPriceService.insertSelective(memberPriceVo);
        if (result) {
            logService.addLog(new TSysLog("价格套餐管理-新增", "新增套餐【" + memberPriceVo.getPriceId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("价格套餐管理-新增", "新增套餐【" + memberPriceVo.getPriceId() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(MemberPriceExpCodeConstant.PRICE_EDIT_COLUMN_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     *
     * @param memberPriceVo
     * @author wzq
     * @date 2020/5/18 14:50
     * @return {@link Map< String, Object>}
     */
    @RequestMapping("disAndEnablePrice" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> disAndEnablePrice(MemberPriceVo memberPriceVo) throws Exception {
        //校验主键ID
        if(memberPriceVo.getPriceId() == null){
            throw new ServiceException(MemberPriceExpCodeConstant.PRICE_EDIT_ID_ERROR);
        }
        //执行编辑
        memberPriceVo.setUpdateDate(new Date());
        Long userId = CurrentUtil.getCurrentUser().getUserId();
        memberPriceVo.setUpdateUserId(userId.intValue());
        boolean result = memberPriceService.updateSelectiveById(memberPriceVo);
        String headStr = memberPriceVo.getIsForbid() == 0 ? "启用" : "禁用";
        if (result) {
            logService.addLog(new TSysLog("价格套餐管理-禁用/启用", headStr+"套餐【" + memberPriceVo.getPriceId() + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("价格套餐管理-禁用/启用", headStr+"套餐【" + memberPriceVo.getPriceId() + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(MemberPriceExpCodeConstant.PRICE_EDIT_SET_ERROR);
        }
        return this.getResultMap(true, result);
    }

    /**
     *
     * @param priceId
     * @author wzq
     * @date 2020/5/18 14:55
     * @return {@link java.util.Map<java.lang.String,java.lang.Object>}
     */
    @RequestMapping("delPrice" + WebConstant.BUSINESS_SUFFIX)
    @ResponseBody
    public Map<String, Object> delPrice(Integer priceId) throws Exception {
        //校验主键ID
        if(priceId == null){
            throw new ServiceException(MemberPriceExpCodeConstant.PRICE_EDIT_ID_ERROR);
        }
        //执行删除
        boolean result = memberPriceService.deleteById(priceId);
        if (result) {
            logService.addLog(new TSysLog("价格套餐管理-删除", "删除套餐【" + priceId + "】成功 ！", PmStateConstant.LOG_PLATFORM));
        } else {
            logService.addLog(new TSysLog("价格套餐管理-删除", "删除套餐【" + priceId + "】失败！", PmStateConstant.LOG_PLATFORM));
        }
        if (!result) {
            throw new ServiceException(MemberPriceExpCodeConstant.PRICE_DEL_ERROR);
        }
        return this.getResultMap(true, result);
    }
    
}