package com.yuepeng.module.service;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuepeng.module.entity.CaptchaEntity;

/**
 * @ClassName: CaptchaService
 * @Description: 短信发送接口
 * @Author: wuzhiqiang
 * @Date: 2020-03-02 11:03
 * @Copyright (c) 2020, Samton. All rights reserved
 **/
public interface CaptchaService extends IService<CaptchaEntity> {

    /**
     * 校验验证码
     * @param mobile
     * @return
     */
    void checkCaptcha(String mobile, String captcha);


    /**
     * 生成验证码
     * @param dict
     * @return
     */
    CaptchaEntity createCaptcha(Dict dict);

}