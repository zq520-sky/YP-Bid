package com.yuepeng.module.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.base.constants.ApiConstants;
import com.yuepeng.dispose.common.RCode;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.module.dto.PwdUpdateDto;
import com.yuepeng.module.entity.CustomerEntity;
import com.yuepeng.module.mapper.CustomerDao;
import com.yuepeng.module.service.CaptchaService;
import com.yuepeng.module.service.FileService;
import com.yuepeng.module.service.ICustomerService;
import com.yuepeng.utils.PasswordEncryptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 客户信息表(Customer)表服务实现类
 *
 * @author wzq
 * @since 2020-05-26 19:36:43
 */
@Slf4j
@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements ICustomerService {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private FileService fileService;

    @Override
    public boolean updatePwd(PwdUpdateDto pwdUpdateDto) throws Exception {
        CustomerEntity customer = baseMapper.selectOne(Wrappers.<CustomerEntity>lambdaQuery().eq(CustomerEntity::getMobile, pwdUpdateDto.getMobile()));
        if(customer != null && customer.getIsForbid() == 1){
            throw new RRException(RCode.CUSTOMER_FORBIDED);
        }
        captchaService.checkCaptcha(pwdUpdateDto.getMobile(), pwdUpdateDto.getCaptcha());
        String passwordSalt = ApiConstants.PWD_SALT;
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor(passwordSalt, PasswordEncryptor.SHA_256);
        String pwd = passwordEncryptor.encode(pwdUpdateDto.getPassword());
        boolean update = new LambdaUpdateChainWrapper<CustomerEntity>(this.getBaseMapper()).eq(CustomerEntity::getMobile, pwdUpdateDto.getMobile())
                .set(CustomerEntity::getPassword, pwd)
                .update();
        return update;
    }

    @Override
    public void updateCustHeadPic(MultipartFile imageFile, Integer custId) throws Exception {
        CustomerEntity customer = baseMapper.selectById(custId);
        if(customer == null){
            throw new RRException("未找到该账号信息！");
        }
        String accessUrl = "";
        if (imageFile != null) {
            accessUrl = fileService.upload(imageFile, "head");
            String oldUrl = customer.getHeadImg();
            //历史头像清理
            if (StrUtil.isNotEmpty(oldUrl)) {
                fileService.moveBak(oldUrl);
            }
            customer.setHeadImg(accessUrl);
        }
        customer.setModifyDate(new Date());
        baseMapper.updateById(customer);
    }
}