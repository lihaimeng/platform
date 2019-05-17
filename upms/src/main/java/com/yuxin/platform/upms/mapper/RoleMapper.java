package com.yuxin.platform.upms.mapper;

import com.yuxin.platform.upms.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface RoleMapper {

    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRole();

    Role selectByName(String name);

}