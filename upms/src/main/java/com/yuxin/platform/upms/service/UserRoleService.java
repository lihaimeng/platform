package com.yuxin.platform.upms.service;


import com.yuxin.platform.upms.pojo.UserRole;

public interface UserRoleService {

    int insertSelective(UserRole record);

    /**
     * 获取用户角色
     * @param userId
     * @return
     */
    UserRole selectByUserId(Integer userId);

}
