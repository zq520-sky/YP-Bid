package com.yuepeng.module.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuepeng.module.entity.SysSetEntity;
import org.apache.ibatis.annotations.Select;

public interface SysSetDao extends BaseMapper<SysSetEntity> {

    @Select("select day_num_add from t_sys_set where set_id=1")
    Integer getNum();
}
