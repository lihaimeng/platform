package com.yuxin.platform.upms.service.impl;

import com.yuxin.platform.upms.mapper.UserMapper;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author jyh
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList(Map<String, Object> map) {
        String username = (String) map.get("username");
        String realname = (String) map.get("realname");
        String phone = (String) map.get("phone");
        return userMapper.selectUserList(map);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.yuxin.zhza.system.service.UserService#getAllUser()
     */
    @Override
    public List<User> getAllUser() {
        /*
         * // TODO Auto-generated method stub PageHelper.startPage(1, 2); List<User>
         * list = userMapper.getAll(); Long total = ((Page<User>) list).getTotal();
         * System.out.println(total);
         */
        return null;
    }

    @Override
    public List<User> userLogin(User user) {
        // TODO Auto-generated method stub
        List<User> list = userMapper.userLogin(user);
        return list;
    }

    @Transactional
    @Override
    public int insert(User user) {
        // TODO Auto-generated method stub
        user.setAddtime(new Date());
        return userMapper.insertSelective(user);
    }

    @Transactional
    @Override
    public int update(User user) {
        // TODO Auto-generated method stub
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    @Override
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> selectByOrganizationId(Integer organizationId) {
        // TODO Auto-generated method stub
        return userMapper.selectByOrganizationId(organizationId);
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Transactional
    @Override
    public int updatePwd(User user) {
        // TODO Auto-generated method stub
        return userMapper.updatePwd(user);
    }

}
