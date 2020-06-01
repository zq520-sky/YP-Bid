package com.yuepeng.module.service.impl;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.lang.Validator;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.module.entity.CaptchaEntity;
import com.yuepeng.module.mapper.CaptchaDao;
import com.yuepeng.module.service.CaptchaSendService;
import com.yuepeng.module.service.CaptchaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @ClassName: CaptchaServiceImpl
 * @Description:
 * @Author: wuzhiqiang
 * @Date: 2020-03-02 11:15
 * @Copyright (c) 2020, Samton. All rights reserved
 **/
@Service("captchaService")
@DS("h2")
public class CaptchaServiceImpl extends ServiceImpl<CaptchaDao, CaptchaEntity> implements CaptchaService {

    private final CaptchaSendService captchaSendService;

    /**
     * 10分钟过期
     */
    @Value("${sms.expire.time:600}")
    private int EXPIRE;

    public CaptchaServiceImpl(CaptchaSendService captchaSendService) {
        this.captchaSendService = captchaSendService;
    }

    @Override
    public void checkCaptcha(String mobile, String captcha) {
        CaptchaEntity captchaEntity = this.getOne(new QueryWrapper<CaptchaEntity>().eq("mobile", mobile).eq("captcha", captcha).ge("expire_time", new Date()));
        if(captchaEntity == null){
            throw new RRException("验证码错误或已失效！");
        }
    }

    @Override
    public CaptchaEntity createCaptcha(Dict dict) {
        String mobile = dict.getStr("mobile");
        if (!Validator.isMobile(mobile)) {
            throw new RRException("请输入正确的手机号！");
        }
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //生成验证码
        String captcha = generateCaptcha();

        CaptchaEntity captchaEntity = this.getOne(new QueryWrapper<CaptchaEntity>().eq("mobile", mobile));
        if(captchaEntity == null){
            //保存或更新验证码
            captchaEntity = new CaptchaEntity();
            captchaEntity.setMobile(mobile);
            captchaEntity.setCaptcha(captcha);
            captchaEntity.setUpdateTime(now);
            captchaEntity.setExpireTime(expireTime);
            this.save(captchaEntity);
        }else{
            captchaEntity.setCaptcha(captcha);
            captchaEntity.setUpdateTime(now);
            captchaEntity.setExpireTime(expireTime);
            this.updateById(captchaEntity);
        }

        //调用短信发送方法
        captchaSendService.sendCaptcha(captchaEntity);

        return captchaEntity;
    }

    /**
     * 生成验证码数字组合
     * @return
     */
    private String generateCaptcha() {
        return StringUtils.leftPad(new Random().nextInt(10000) + "", 4, "0");
    }
}