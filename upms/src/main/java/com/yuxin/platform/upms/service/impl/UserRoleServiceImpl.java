package com.yuxin.platform.upms.service.impl;

import com.yuxin.platform.upms.mapper.UserRoleMapper;
import com.yuxin.platform.upms.pojo.UserRole;
import com.yuxin.platform.upms.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author jyh
 * <p>
 * 2018年1月8日
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Transactional
    @Override
    public int insertSelective(UserRole record) {
        // TODO Auto-generated method stub
        userRoleMapper.deleteByUserId(record.getUserId());
        return userRoleMapper.insert(record);
    }

    @Override
    public UserRole selectByUserId(Integer userId) {
        return userRoleMapper.selectByUserId(userId);
    }
}
