package com.yuepeng.module.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.module.entity.CaptchaEntity;
import com.yuepeng.module.service.CaptchaSendService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AliCaptchaSendServiceImpl
 * @Description: 阿里短信发送服务
 * @Author: wuzhiqiang
 * @Date: 2020-03-02 11:42
 * @Copyright (c) 2020, Samton. All rights reserved
 **/
@Slf4j
@Getter
@Setter
@Service
@ConditionalOnProperty(name="sms.ali.enable", havingValue = "true")
@ConfigurationProperties(prefix = "sms.ali")
public class AliCaptchaSendServiceImpl implements CaptchaSendService {

    private static final String SUCCESS = "OK";

    private String accessKeyId;
    private String accessSecret;
    private String domain;
    private String regionId;
    private String templateCode;
    private String signName;

    @Override
    public void sendCaptcha(CaptchaEntity captchaEntity) {
        log.info("=========start send msg==============");
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.GET);
        request.setDomain(domain);
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "default");
        request.putQueryParameter("PhoneNumbers", captchaEntity.getMobile());
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);

        Map<String, String> params = new HashMap<>();
        params.put("code", captchaEntity.getCaptcha());
        request.putQueryParameter("TemplateParam", JSON.toJSONString(params));

        try {
            CommonResponse response = client.getCommonResponse(request);
            String repCode = (String) JSON.parseObject(response.getData(), Map.class).get("Code");
            if(SUCCESS.equals(repCode)){
                log.info("================send msg success============");
            }else{
                log.error("send short message error, mobile: {}， response：{}", captchaEntity.getMobile(), response.getData());
                throw new RRException("验证码发送失败！");
            }
        }catch (ServerException e){
            log.error("1 send short message error, mobile: {}", captchaEntity.getMobile(), e);
            throw new RRException("验证码发送失败！");
        }catch (ClientException e) {
            log.error("2 send short message error, mobile: {}", captchaEntity.getMobile(), e);
            throw new RRException("验证码发送失败！");
        }
    }

}