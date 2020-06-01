package com.yuepeng.strategy;

import com.yuepeng.dispose.common.R;
import com.yuepeng.model.BaseModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: PayStrategy
 * @Description: 支付策略
 * @Author: wuzhiqiang
 * @Date: 2020-03-05 10:36
 **/
public interface PayStrategy {

    /**
     *
     * @Author: wuzhiqiang
     * @Description: 支付
     * @Date: 2020/3/6
     * @Param baseModel:
     * @return: com.yuepeng.dispose.common.R
     */
    R pay(BaseModel baseModel) throws Exception;

    /**
     *
     * @Author: wuzhiqiang
     * @Description: 退款
     * @Date: 2020/3/6
     * @Param baseModel:
     * @return: com.yuepeng.dispose.common.R
     */
    R refund(BaseModel baseModel) throws Exception;

    /**
     *
     * @Author: wuzhiqiang
     * @Description: 支付回调
     * @Date: 2020/3/6
     * @Param request:
     * @Param response:
     * @return: com.yuepeng.dispose.common.R
     */
    R payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     *
     * @Author: wuzhiqiang
     * @Description: 退款回调
     * @Date: 2020/3/6
     * @Param request:
     * @Param response:
     * @return: com.yuepeng.dispose.common.R
     */
    R refundNotify(HttpServletRequest request, HttpServletResponse response) throws Exception;
}