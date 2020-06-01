package generator;

import com.yuepeng.module.entity.SysSetEntity;

public interface TSysSetDao {
    int deleteByPrimaryKey(Integer setId);

    int insert(SysSetEntity record);

    int insertSelective(SysSetEntity record);

    SysSetEntity selectByPrimaryKey(Integer setId);

    int updateByPrimaryKeySelective(SysSetEntity record);

    int updateByPrimaryKey(SysSetEntity record);
}