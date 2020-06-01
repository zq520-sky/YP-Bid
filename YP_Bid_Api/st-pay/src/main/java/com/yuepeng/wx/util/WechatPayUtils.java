package com.yuepeng.wx.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuepeng.wx.sdk.WXPayConfig;
import com.yuepeng.wx.sdk.WXPayUtil;
import com.yuepeng.wx.vo.PayCallbackResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WechatPayUtils
 * @Description: 微信支付工具类
 * @Author: wuzhiqiang
 * @Date: 2020-03-05 16:30

 **/
public class WechatPayUtils {

    /**
     *
     * @Author: wuzhiqiang
     * @Description: 统一订单下单html
     * @Date: 2020/3/6
     * @Param iWxPayConfig:
     * @Param prepayId:
     * @return: java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<String, String> unifiedOrderHtmlBack(WXPayConfig iWxPayConfig, String prepayId) throws Exception {
        // ******************************************
        //  前端调起微信支付必要参数
        // ******************************************
        Map<String, String> result = new HashMap<>();
        String packages = "Sign=WXPay";
        Map<String, String> wxPayMap = new HashMap<>(8);
        wxPayMap.put("appid", iWxPayConfig.getAppID());
        wxPayMap.put("partnerid", iWxPayConfig.getMchID());
        wxPayMap.put("timestamp", String.valueOf(WXPayUtil.getCurrentTimestamp()));
        wxPayMap.put("prepayid", prepayId);
        wxPayMap.put("noncestr", WXPayUtil.generateNonceStr());
        wxPayMap.put("package", packages);
        // 加密串中包括 appId timeStamp nonceStr package signType 5个参数, 通过sdk WXPayUtil类加密, 注意, 此处使用MD5加密方式
        String sign = WXPayUtil.generateSignature(wxPayMap, iWxPayConfig.getKey());

        // ******************************************
        //  返回给前端调起微信支付的必要参数
        // ******************************************
        result.put("sign", sign);
        result.putAll(wxPayMap);
        return result;
    }

    /**
     *
     * @Author: wuzhiqiang
     * @Description: 解析支付回调数据
     * @Date: 2020/3/6
     * @Param request:
     * @return: com.yuepeng.wx.vo.PayCallbackResponse
     */
    public static String resolvePayCallback(HttpServletRequest request) throws Exception {
        InputStream is = request.getInputStream();
        //将InputStream转换成String
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw e;
            }
        }
        return sb.toString();
    }
}