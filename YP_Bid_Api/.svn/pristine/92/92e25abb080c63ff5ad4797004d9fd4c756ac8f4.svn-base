package com.yuepeng.module.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuepeng.module.dto.PageDto;
import com.yuepeng.module.entity.JpushEntity;

/**
 * 极光推送信息(Jpush)表服务接口
 *
 * @author wzq
 * @since 2020-05-28 15:50:30
 */
public interface IJpushService extends IService<JpushEntity> {


    IPage<JpushEntity> selectPages(PageDto pageDto, Integer custId);

}