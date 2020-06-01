package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.module.mapper.MemberPriceDao;
import com.yuepeng.module.entity.MemberPriceEntity;
import com.yuepeng.module.service.IMemberPriceService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 会员价格表(MemberPrice)表服务实现类
 *
 * @author wzq
 * @since 2020-05-30 15:08:40
 */
@Slf4j
@Service("memberPriceService")
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceDao, MemberPriceEntity> implements IMemberPriceService {

}