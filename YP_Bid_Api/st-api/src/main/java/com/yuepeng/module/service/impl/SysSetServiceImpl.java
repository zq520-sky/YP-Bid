package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.module.entity.SysSetEntity;
import com.yuepeng.module.mapper.SysSetDao;
import com.yuepeng.module.service.ISysSetService;
import org.springframework.stereotype.Service;

/**
 * @Description: 新增值
 * @Author: ZhongShengbin
 * @Date: 2020/05/30 11:09
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service("sysSetService")
public class SysSetServiceImpl extends ServiceImpl<SysSetDao, SysSetEntity> implements ISysSetService {
    @Override
    public Integer addNums() throws Exception {
        Integer num = baseMapper.getNum();
        return num;
    }
}
