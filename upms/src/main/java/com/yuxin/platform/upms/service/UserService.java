package com.yuxin.platform.upms.service;

import com.yuxin.platform.upms.pojo.User;

import java.util.List;
import java.util.Map;


/**
 * @author jyh
 */
public interface UserService {

    List<User> selectUserList(Map<String, Object> map);

    List<User> getAllUser();

    List<User> userLogin(User user);

    int insert(User user);

    int update(User user);

    int updatePwd(User user);

    int delete(Integer id);

    List<User> selectByOrganizationId(Integer organizationId);

    User findByUserName(String userName);
}
