package com.yuepeng.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuepeng.module.entity.InfotypeEntity;

/**
 * 招标信息类型信息

1：招标预告
2：招标公告
3：公告变更
4：招标答疑
5：资审结果
6：招标文件
7：中标公告(Infotype)表数据库访问层
 *
 * @author wzq
 * @since 2020-05-30 15:10:38
 */
public interface InfotypeDao extends BaseMapper<InfotypeEntity> {

}