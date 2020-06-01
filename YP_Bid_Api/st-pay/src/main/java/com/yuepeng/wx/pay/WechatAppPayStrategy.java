package com.yuepeng.wx.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.config.RUtils;
import com.yuepeng.model.BaseModel;
import com.yuepeng.strategy.PayStrategy;
import com.yuepeng.wx.config.WxPayAppConfig;
import com.yuepeng.wx.exception.WechatPayException;
import com.yuepeng.wx.sdk.WXPay;
import com.yuepeng.wx.sdk.WXPayConstants;
import com.yuepeng.wx.sdk.WXPayUtil;
import com.yuepeng.wx.util.WechatPayUtils;
import com.yuepeng.wx.util.WxDecodeUtil;
import com.yuepeng.wx.vo.PayCallbackResponse;
import com.yuepeng.wx.vo.RefundCallbackResponse;
import com.yuepeng.wx.vo.SecretResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName: WechatPayStrategy
 * @Description: 微信支付
 * @Author: wuzhiqiang
 * @Date: 2020-03-05 15:01

 **/
@Component
@Slf4j
public class WechatAppPayStrategy implements PayStrategy {

    public final WxPayAppConfig wxPayAppConfig;

    private WXPay wxPay;

    @Autowired
    public WechatAppPayStrategy(WxPayAppConfig wxPayAppConfig) throws Exception {
        wxPay = new WXPay(wxPayAppConfig);
        this.wxPayAppConfig = wxPayAppConfig;
    }

    @Override
    public R pay(BaseModel baseModel) throws Exception {
        Object notifyUrl = baseModel.getFieldValueByName("notify_url", baseModel);
        Map<String, String> params = baseModel.toMap();
        if(null == notifyUrl){
            params.put("notify_url", wxPayAppConfig.getPayNotifyUrl());
        }
        Map<String, String> response = wxPay.unifiedOrder(params);
        log.info("微信支付下单成功,订单信息：{}, 返回值 response={}", baseModel.toMap(), response);
        String returnCode = response.get("return_code");
        if (!WXPayConstants.SUCCESS.equals(returnCode)) {
            throw new WechatPayException(response.get("return_msg"));
        }
        String resultCode = response.get("result_code");
        if (!WXPayConstants.SUCCESS.equals(resultCode)) {
            throw new WechatPayException(response.get("err_code_des"));
        }
        String prepay_id = response.get("prepay_id");
        if (prepay_id == null) {
            throw new WechatPayException("prepay_id is null");
        }
        Map<String, String> orderHtmlBack = WechatPayUtils.unifiedOrderHtmlBack(wxPayAppConfig, prepay_id);
        return RUtils.ok(orderHtmlBack);
    }

    @Override
    public R refund(BaseModel baseModel) throws Exception {
        Map<String, String> response = wxPay.refund(baseModel.toMap());
        log.info("微信退款调用成功, 返回值 response={}", response);
        String returnCode = response.get("return_code");
        if (!WXPayConstants.SUCCESS.equals(returnCode)) {
            throw new WechatPayException(response.get("return_msg"));
        }
        String resultCode = response.get("result_code");
        if (!WXPayConstants.SUCCESS.equals(resultCode)) {
            throw new WechatPayException(response.get("err_code_des"));
        }
        return RUtils.ok();
    }

    @Override
    public R payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String notifyData = WechatPayUtils.resolvePayCallback(request);
        Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData);
        log.info("wechat payNotify, response: {}", notifyData);
        if (!wxPay.isPayResultNotifySignatureValid(notifyMap)) {
            log.error("微信支付回调通知签名错误, 回调信息：{}", notifyData);
            return RUtils.fail();
        }
        String jsonStr = JSONObject.toJSONString(notifyMap);
        PayCallbackResponse payCallbackResponse = JSON.parseObject(jsonStr, PayCallbackResponse.class);
        return RUtils.ok(payCallbackResponse);
    }

    @Override
    public R refundNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String notifyData = WechatPayUtils.resolvePayCallback(request);
        Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData);
        log.info("wechat refundNotify, response: {}", notifyData);
        String jsonStr = JSONObject.toJSONString(notifyMap);
        RefundCallbackResponse refundCallbackResponse = JSON.parseObject(jsonStr, RefundCallbackResponse.class);
        if (WXPayConstants.SUCCESS.equals(refundCallbackResponse.getReturn_code())) {
            String req_info = refundCallbackResponse.getReq_info();
            WxDecodeUtil wxDecodeUtil = new WxDecodeUtil(wxPayAppConfig.getKey());
            String decryptData = wxDecodeUtil.decryptData(req_info);
            Map<String, String> reqMap = WXPayUtil.xmlToMap(decryptData);
            SecretResponse secretResponse = JSON.parseObject(JSONObject.toJSONString(reqMap), SecretResponse.class);
            refundCallbackResponse.setSecretResponse(secretResponse);
        }
        return RUtils.ok(refundCallbackResponse);
    }


}