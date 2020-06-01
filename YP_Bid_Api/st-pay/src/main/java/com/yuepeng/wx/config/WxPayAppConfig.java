package com.yuepeng.wx.config;

import com.yuepeng.wx.sdk.IWXPayDomain;
import com.yuepeng.wx.sdk.WXPayConfig;
import com.yuepeng.wx.sdk.WXPayConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @ClassName: WxPayAppConfig
 * @Description: 微信app支付配置
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 11:09

 **/
@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "pay.app.wx")
public class WxPayAppConfig extends WXPayConfig {

    /**
     * appID
     */
    private String appID;

    /**
     * 商户号
     */
    private String mchID;

    /**
     * API 密钥
     */
    private String key;

    /**
     * API证书绝对路径 (本项目放在了 resources/cert/wxpay/apiclient_cert.p12")
     */
    private String certPath = "cert/apiclient_cert.p12";

    /**
     * HTTP(S) 连接超时时间，单位毫秒
     */
    private int httpConnectTimeoutMs = 6000;

    /**
     * HTTP(S) 读数据超时时间，单位毫秒
     */
    private int httpReadTimeoutMs = 8000;

    /**
     * 微信支付异步通知地址
     */
    private String payNotifyUrl;

    /**
     * 微信退款异步通知地址
     */
    private String refundNotifyUrl = "";

    @Override
    public InputStream getCertStream() {
        InputStream certStream = getClass().getClassLoader().getResourceAsStream(certPath);
        return certStream;
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }
            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
    }
}