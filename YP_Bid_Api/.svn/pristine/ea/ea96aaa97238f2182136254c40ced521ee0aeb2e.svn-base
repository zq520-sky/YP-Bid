package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.module.dto.PageDto;
import com.yuepeng.module.mapper.JpushDao;
import com.yuepeng.module.entity.JpushEntity;
import com.yuepeng.module.service.IJpushService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 极光推送信息(Jpush)表服务实现类
 *
 * @author wzq
 * @since 2020-05-28 15:50:30
 */
@Slf4j
@Service("jpushService")
public class JpushServiceImpl extends ServiceImpl<JpushDao, JpushEntity> implements IJpushService {


    @Override
    public IPage<JpushEntity> selectPages(PageDto pageDto, Integer custId) {
        Page<JpushEntity> page = new Page<>(pageDto.getPage(), pageDto.getPageSize());
        IPage<JpushEntity> jpushEntityPage = baseMapper.selectPage(page, Wrappers.<JpushEntity>lambdaQuery().eq(JpushEntity::getCustId, custId));
        return jpushEntityPage;
    }

}