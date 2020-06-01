package com.yuepeng.ali.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AliPayAppConfig
 * @Description: 阿里支付配置
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 15:55

 **/
@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "pay.app.ali")
public class AliPayAppConfig {

    /**appId*/
    private String appid;
    /**应用私钥*/
    private String appPrivateKey;
    /**支付宝公钥*/
    private String aliPublicKey;
    /**网关地址*/
    private String serverUrl = "https://openapi.alipay.com/gateway.do";
    private String format="json";
    private String charset = "utf-8";
    /**签名类型*/
    private String signType = "RSA2";
    /**应用公钥证书路径*/
    private String certPath;
    /**支付宝公钥证书路径*/
    private String alipayPublicCertPath;
    /**支付宝根证书路径*/
    private String rootCertPath;
    private String notifyUrl;
    private boolean withCert = false;

}