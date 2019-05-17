package com.yuxin.platform.upms.service;

import com.yuxin.platform.upms.pojo.Role;

import java.util.List;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
public interface RoleService {

    List<Role> getAllRole();

    Role selectByName(String name);

    int insert(Role role);

    int update(Role role);

    int delete(Integer id);

}
