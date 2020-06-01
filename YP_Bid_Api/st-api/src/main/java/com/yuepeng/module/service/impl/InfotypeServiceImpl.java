package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.module.mapper.InfotypeDao;
import com.yuepeng.module.entity.InfotypeEntity;
import com.yuepeng.module.service.IInfotypeService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 招标信息类型信息

1：招标预告
2：招标公告
3：公告变更
4：招标答疑
5：资审结果
6：招标文件
7：中标公告(Infotype)表服务实现类
 *
 * @author wzq
 * @since 2020-05-30 15:10:38
 */
@Slf4j
@Service("infotypeService")
public class InfotypeServiceImpl extends ServiceImpl<InfotypeDao, InfotypeEntity> implements IInfotypeService {

}