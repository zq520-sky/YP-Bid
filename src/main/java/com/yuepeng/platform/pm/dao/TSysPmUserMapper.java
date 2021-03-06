package com.yuepeng.platform.pm.dao;

import com.yuepeng.platform.framework.mybatis.pagination.Pagination;
import com.yuepeng.platform.pm.bean.entity.TSysPmUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Description:用户Mapper
 * @author:     shenchu
 * @date:        2017年2月22日 下午9:18:02
 * Copyright (c) 2017, Samton. All rights reserved
 */
public interface TSysPmUserMapper {
	/**
	 * 
	 * @Title:        deleteByPrimaryKey 
	 * @Description:  删除用户
	 * @param:        @param userId
	 * @param:        @return    
	 * @return:       int    
	 * @author        shenchu
	 * @Date          2017年2月22日 下午9:18:46
	 */
    int deleteByPrimaryKey(Long userId);

    /**
     * 
     * @Title:        insert 
     * @Description:  新增用户
     * @param:        @param record
     * @param:        @return    
     * @return:       int    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:19:03
     */
    int insert(TSysPmUser record);

    /**
     * 
     * @Title:        insertSelective 
     * @Description:  新增用户(选择性)
     * @param:        @param record
     * @param:        @return    
     * @return:       int    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:19:24
     */
    int insertSelective(TSysPmUser record);

    /**
     * 
     * @Title:        selectByPrimaryKey 
     * @Description:  通过userID获取用户信息
     * @param:        @param userId
     * @param:        @return    
     * @return:       TSysPmUser    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:19:50
     */
    TSysPmUser selectByPrimaryKey(Long userId);

    /**
     * 
     * @Title:        updateByPrimaryKeySelective 
     * @Description:  修改用户信息(选择性)
     * @param:        @param record
     * @param:        @return    
     * @return:       int    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:20:09
     */
    int updateByPrimaryKeySelective(TSysPmUser record);

    /**
     * 
     * @Title:        updateByPrimaryKey 
     * @Description:  修改用户信息
     * @param:        @param record
     * @param:        @return    
     * @return:       int    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:20:31
     */
    int updateByPrimaryKey(TSysPmUser record);
    
    /**
     * 
     * @Title:        selectUserList 
     * @Description:  查询用户信息集合
     * @param:        @return    
     * @return:       List<TSysPmUser>    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:20:42
     */
    List<TSysPmUser> selectUserList(@Param("sysType") Integer sysType, @Param("proxyId") Integer proxyId, @Param("custId") Integer custId);

    /**
     * 
     * @Title:        selectUserListByDepartId 
     * @Description:  通过部门ID获取该部门下的用户信息
     * @param:        @param departId
     * @param:        @return    
     * @return:       List<TSysPmUser>    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:21:01
     */
    List<TSysPmUser> selectUserListByDepartId(long departId);
    
    /**
     * 
     * @Title:        queryUsers 
     * @Description:  分页查询用户信息
     * @param:        @param paramBean
     * @param:        @param rowBounds
     * @param:        @return    
     * @return:       List<TSysPmUser>    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:23:32
     */
    List<TSysPmUser> queryUsers(Pagination<TSysPmUser> paramBean,RowBounds rowBounds);

    /**
     * 
     * @Title:        batchUpdateByPrimaryKey 
     * @Description:  批量修改用户信息
     * @param:        @param list
     * @param:        @return    
     * @return:       int    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:23:49
     */
    int batchUpdateByPrimaryKey(List<TSysPmUser> list);
    
    /**
     * 
     * @Title:        getUserByLoginName 
     * @Description:  通过登录用户名获取用户信息
     * @param:        @param pmUser
     * @param:        @return    
     * @return:       TSysPmUser    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:24:05
     */
    TSysPmUser getUserByLoginName(TSysPmUser pmUser);
    
    /**
     * 
     * @Title:        getUserByLoginNamePwd 
     * @Description:  通过登录名和密码获取用户信息
     * @param:        @param pmUser
     * @param:        @return    
     * @return:       TSysPmUser    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:24:34
     */
    TSysPmUser getUserByLoginNamePwd(TSysPmUser pmUser);
    
    /**
     * 
     * @Title:        getUserIdByLoginName 
     * @Description:  通过用户名获取用户ID
     * @param:        @param loginName
     * @param:        @return    
     * @return:       Long    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:24:59
     */
    Long getUserIdByLoginName(String loginName);
    
    /**
     * 
     * @Title:        exportUserList 
     * @Description:  导出用户数据
     * @param:        @param paramBean
     * @param:        @param rowBounds
     * @param:        @return    
     * @return:       List<Map<String,Object>>    
     * @author        shenchu
     * @Date          2017年2月22日 下午9:25:14
     */
    List<Map<String, Object>> exportUserList(Pagination<TSysPmUser> paramBean,RowBounds rowBounds);

	/** 
	 * @Title:        getUsersForSelect 
	 * @Description:  获取用户
	 * @param:        @return    
	 * @return:       List<TSysPmUser>    
	 * @author        shenchu
	 * @Date          2017年3月2日 下午5:27:47 
	 */
	List<TSysPmUser> getUsersForSelect(@Param("sysType") Integer sysType, @Param("proxyId") Integer proxyId, @Param("custId") Integer custId);

	/** 
	 * @Title:        queryUserName 
	 * @Description:  查询用户信息集合，数量不超过10个
	 * @param:        @param name
	 * @param:        @return    
	 * @return:       List<Map<String,Object>>    
	 * @author        shenchu
	 * @Date          2017年3月4日 下午5:05:42 
	 */
	List<Map<String, Object>> queryUserName(@Param("name") String name, @Param("sysType") Integer sysType, @Param("proxyId") Integer proxyId, @Param("custId") Integer custId);

	/**
	 * 通过用户名称查询管理端的用户
	 * @param username
	 * @return
	 */
	TSysPmUser queryUserByUsername(String username);
}