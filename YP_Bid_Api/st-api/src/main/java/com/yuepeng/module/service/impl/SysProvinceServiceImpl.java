package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.module.mapper.SysProvinceDao;
import com.yuepeng.module.entity.SysProvinceEntity;
import com.yuepeng.module.service.ISysProvinceService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 省字典表(SysProvince)表服务实现类
 *
 * @author wzq
 * @since 2020-05-30 15:18:47
 */
@Slf4j
@Service("sysProvinceService")
public class SysProvinceServiceImpl extends ServiceImpl<SysProvinceDao, SysProvinceEntity> implements ISysProvinceService {

}