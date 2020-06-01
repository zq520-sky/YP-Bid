package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.module.mapper.PlanProjectCollectDao;
import com.yuepeng.module.entity.PlanProjectCollectEntity;
import com.yuepeng.module.service.IPlanProjectCollectService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 客户收藏拟建项目表(PlanProjectCollect)表服务实现类
 *
 * @author wzq
 * @since 2020-05-30 15:03:42
 */
@Slf4j
@Service("planProjectCollectService")
public class PlanProjectCollectServiceImpl extends ServiceImpl<PlanProjectCollectDao, PlanProjectCollectEntity> implements IPlanProjectCollectService {

}