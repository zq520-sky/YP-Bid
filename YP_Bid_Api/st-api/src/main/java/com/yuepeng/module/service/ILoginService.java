package com.yuepeng.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuepeng.module.dto.LoginDto;
import com.yuepeng.module.dto.RegisterDto;
import com.yuepeng.module.entity.CustomerEntity;
import com.yuepeng.module.vo.CustomInfoVo;

/**
 * 〈功能概述〉<br>
 *
 * @className: LoginService
 * @package: com.yuepeng.module.service
 * @author: wzq
 * @date: 2020/5/26 16:35
 */
public interface ILoginService extends IService<CustomerEntity> {


    /**
     * 登录
     * @param loginDTO
     * @author wzq
     * @date 2020/5/26 17:05
     * @return {@link CustomInfoVo}
     */
    CustomInfoVo login(LoginDto loginDTO) throws Exception;

    /**
     * 注册
     * @param registerDto
     * @author wzq
     * @date 2020/5/26 19:06
     * @return
     */
    void register(RegisterDto registerDto) throws Exception;
}
