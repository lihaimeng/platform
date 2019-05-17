package com.yuxin.platform.upms.mapper;

import com.yuxin.platform.upms.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface UserMapper {

    List<User> selectUserList(Map<String, Object> map);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updatePwd(User record);

    List<User> selectByOrganizationId(Integer organizationId);

    List<User> userLogin(User user);

    User findByUserName(String userName);

    User selectByUserName(String userName);
}