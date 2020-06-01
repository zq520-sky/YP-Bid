package com.yuepeng.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuepeng.module.dto.PwdUpdateDto;
import com.yuepeng.module.entity.CustomerEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 客户信息表(Customer)表服务接口
 *
 * @author wzq
 * @since 2020-05-26 19:36:43
 */
public interface ICustomerService extends IService<CustomerEntity> {

    /**
     * 修改密码
     * @param pwdUpdateDto
     * @author wzq
     * @date 2020/5/26 19:50
     * @return {@link boolean}
     */
    boolean updatePwd(PwdUpdateDto pwdUpdateDto) throws Exception;

    /**
     *
     * @param imageFile
     * @param custId
     * @author wzq
     * @date 2020/5/28 15:08
     * @return
     */
    void updateCustHeadPic(MultipartFile imageFile, Integer custId) throws Exception;
}