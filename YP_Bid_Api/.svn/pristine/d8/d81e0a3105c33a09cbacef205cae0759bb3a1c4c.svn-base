package com.yuepeng.module.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.module.entity.CaptchaEntity;
import com.yuepeng.module.service.CaptchaSendService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @ClassName: SmsCaptchaSendServiceImpl
 * @Description:
 * @Author: wuzhiqiang
 * @Date: 2020-03-02 11:26
 * @Copyright (c) 2020, Samton. All rights reserved
 **/
@Service
@ConditionalOnProperty(name="sms.send.enable", havingValue = "true")
@ConfigurationProperties(prefix = "sms.send")
@Getter
@Setter
public class SmsCaptchaSendServiceImpl implements CaptchaSendService {

    private String url;
    private String name;
    private String password;

    @Override
    public void sendCaptcha(CaptchaEntity captchaEntity) {
        String captcha = captchaEntity.getCaptcha();
        String mobile = captchaEntity.getMobile();
        String content = "【招标无忧】您的验证码是："+captcha+"，有效期10分钟，请忽泄露给别人。如非本人操作，请忽略本短信！";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", name);
        paramMap.put("password", password);
        paramMap.put("mobile",mobile);
        paramMap.put("content",content);
        String result = HttpUtil.post(url,paramMap);
        if(StrUtil.isEmpty(result)||result.length()<10){
            throw new RRException("验证码发送失败");
        }
    }

}