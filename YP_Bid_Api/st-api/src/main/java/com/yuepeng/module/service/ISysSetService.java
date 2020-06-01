package com.yuepeng.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuepeng.module.entity.SysSetEntity;

public interface ISysSetService extends IService<SysSetEntity> {

    Integer addNums() throws Exception;
}
