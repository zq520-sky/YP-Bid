package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.base.config.JwtConfig;
import com.yuepeng.base.constants.ApiConstants;
import com.yuepeng.dispose.common.RCode;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.module.dto.LoginDto;
import com.yuepeng.module.dto.RegisterDto;
import com.yuepeng.module.entity.CustomerEntity;
import com.yuepeng.module.enums.LoginTypeEnums;
import com.yuepeng.module.mapper.CustomerDao;
import com.yuepeng.module.service.CaptchaService;
import com.yuepeng.module.service.ILoginService;
import com.yuepeng.module.vo.CustomInfoVo;
import com.yuepeng.utils.PasswordEncryptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * 〈功能概述〉<br>
 *
 * @className: LoginServiceImpl
 * @package: com.yuepeng.module.service.impl
 * @author: wzq
 * @date: 2020/5/26 17:06
 */
@Service
public class LoginServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements ILoginService {

    @Autowired
    private JwtConfig jwtUtils;

    @Autowired
    private CaptchaService captchaService;

    private static final String INIT_CUST_CODE = "1000000";

    @Override
    public CustomInfoVo login(LoginDto loginDto) throws Exception {
        CustomerEntity customer = baseMapper.selectOne(Wrappers.<CustomerEntity>lambdaQuery().eq(CustomerEntity::getMobile, loginDto.getMobile()));
        if(null == customer){
            throw new RRException(RCode.CUSTOMER_NOT_EXIST);
        }
        if(null != customer && customer.getIsForbid() == 1){
            throw new RRException(RCode.CUSTOMER_FORBIDED);
        }

        //登录验证
        LoginTypeEnums loginType = loginDto.getLoginType();
        if(LoginTypeEnums.PWD.equals(loginType)){
            String passwordSalt = ApiConstants.PWD_SALT;
            PasswordEncryptor passwordEncryptor = new PasswordEncryptor(passwordSalt, PasswordEncryptor.SHA_256);
            String pwd = passwordEncryptor.encode(loginDto.getPassword());
            if(!customer.getPassword().equalsIgnoreCase(pwd)){
                throw new RRException(RCode.CUSTOMER_PWD_ERROR);
            }
        }else if(LoginTypeEnums.CAPTCHA.equals(loginType)){
            captchaService.checkCaptcha(loginDto.getMobile(), loginDto.getCaptcha());
        }

        //生成token
        String token = jwtUtils.generateToken(String.valueOf(customer.getCustId()));
        CustomInfoVo customInfoVo = new CustomInfoVo();
        BeanUtils.copyProperties(customer, customInfoVo);
        customInfoVo.setToken(token);
        return customInfoVo;
    }

    @Override
    public void register(RegisterDto registerDto) throws Exception {
        captchaService.checkCaptcha(registerDto.getMobile(), registerDto.getCaptcha());
        CustomerEntity customerEntity = baseMapper.selectOne(Wrappers.<CustomerEntity>lambdaQuery().eq(CustomerEntity::getMobile, registerDto.getMobile()));
        if(customerEntity != null){
            throw new RRException(RCode.CUSTOMER_EXISTED);
        }

        //注册
        synchronized (LoginServiceImpl.class){
            CustomerEntity customer = newCustomer();
            String custCode = getCustCode();
            customer.setCustCode(custCode);
            customer.setMobile(registerDto.getMobile());
            String passwordSalt = ApiConstants.PWD_SALT;
            PasswordEncryptor passwordEncryptor = new PasswordEncryptor(passwordSalt, PasswordEncryptor.SHA_256);
            String pwd = passwordEncryptor.encode(registerDto.getPassword());
            customer.setPassword(pwd);
            //用户刚注册设置一个默认的头像
            customer.setHeadImg("");
            baseMapper.insert(customer);
        }
    }

    private CustomerEntity newCustomer(){
        CustomerEntity newCustomer = new CustomerEntity();
        Date date = new Date();
        newCustomer.setSex(0);
        newCustomer.setIsMember(0);
        newCustomer.setIsForbid(0);
        newCustomer.setMemberType(0);
        newCustomer.setRegisterDate(date);
        newCustomer.setCreateUserId(1);
        newCustomer.setModifyUserId(1);
        newCustomer.setCreateDate(date);
        newCustomer.setModifyDate(date);
        newCustomer.setRegisterDate(date);
        return newCustomer;
    }

    private String getCustCode(){
        String lastestCustCode = "";
        CustomerEntity customerEntity = baseMapper.selectList(Wrappers.<CustomerEntity>lambdaQuery().orderByDesc(CustomerEntity::getCustId)).get(0);
        if(customerEntity == null){
            lastestCustCode = INIT_CUST_CODE;
        }else{
            lastestCustCode = customerEntity.getCustCode();
        }
        Integer custCode = Integer.parseInt(lastestCustCode);
        return String.valueOf(custCode+1);
    }
}
