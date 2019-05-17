package com.yuxin.platform.upms.mapper;

import com.yuxin.platform.upms.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userRoleId);

    /**
     * 通过userid来查询userRole对象
     *
     * @param userId
     * @return
     */
    UserRole selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    int deleteByUserId(Integer userid);
}