package com.yuepeng.web.manage.system.service.Impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.platform.framework.exception.ServiceException;
import com.yuepeng.platform.framework.util.BASE64DecodedMultipartFile;
import com.yuepeng.platform.framework.util.FileUtils;
import com.yuepeng.web.manage.system.bean.entity.TSysSet;
import com.yuepeng.web.manage.system.bean.vo.SysSetVo;
import com.yuepeng.web.manage.system.constants.SystemExpCodeConstant;
import com.yuepeng.web.manage.system.dao.TSysSetMapper;
import com.yuepeng.web.manage.system.service.ISysSetService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Description:
 * @Author: ZhongShengbin
 * @Date: 2020/05/27 17:10
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class SysSetServiceImpl extends SuperServiceIntegerImpl<TSysSetMapper, TSysSet> implements ISysSetService {

    @Override
    public SysSetVo querySysSetPageList() throws Exception {
        SysSetVo list = mapper.querySysPageList();
        return list;
    }

    @Override
    public boolean insertOrUpdate(SysSetVo sysSetVo) throws Exception {
        boolean result;
        if (mapper.querySysPageList() == null) {
            if(StringUtils.isBlank(sysSetVo.getFile())){
                throw new ServiceException(SystemExpCodeConstant.SYS_SET_FILE_EMPTY);
            }
            String fileStr = sysSetVo.getFile();
            MultipartFile multipartFile = BASE64DecodedMultipartFile.base64ToMultipart(fileStr);
            Map<String, String> imageData = FileUtils.imageTo(multipartFile, "syslogo");
            sysSetVo.setSysLogo(imageData.get("attachmentPath"));
            result = mapper.insertSelective(sysSetVo) > 0;
        } else {//如果已经设置
            if(StringUtils.isBlank(sysSetVo.getSysLogo()) && StringUtils.isBlank(sysSetVo.getFile())){
                throw new ServiceException(SystemExpCodeConstant.SYS_SET_FILE_EMPTY);
            }
            if(StringUtils.isBlank(sysSetVo.getSysLogo()) && StringUtils.isNotBlank(sysSetVo.getFile()) && sysSetVo.getFile().startsWith("data:image/jpeg;base64")){
                String fileStr = sysSetVo.getFile();
                MultipartFile multipartFile = BASE64DecodedMultipartFile.base64ToMultipart(fileStr);
                Map<String, String> imageData = FileUtils.imageTo(multipartFile, "syslogo");
                sysSetVo.setSysLogo(imageData.get("attachmentPath"));
            }
            result = mapper.updateByPrimaryKeySelective(sysSetVo) > 0;
        }
        return result;
    }
}
