package com.yuxin.platform.upms.service.impl;

import com.yuxin.platform.upms.mapper.RoleMapper;
import com.yuxin.platform.upms.pojo.Role;
import com.yuxin.platform.upms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        // TODO Auto-generated method stub
        return roleMapper.getAllRole();
    }

    @Override
    public Role selectByName(String name) {
        return roleMapper.selectByName(name);
    }

    @Transactional
    @Override
    public int insert(Role role) {
        // TODO Auto-generated method stub
        role.setAddtime(new Date());
        return roleMapper.insertSelective(role);
    }

    @Transactional
    @Override
    public int update(Role role) {
        // TODO Auto-generated method stub
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Transactional
    @Override
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return roleMapper.deleteByPrimaryKey(id);
    }

}
