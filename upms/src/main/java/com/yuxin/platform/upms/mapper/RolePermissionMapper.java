package com.yuxin.platform.upms.mapper;

import com.yuxin.platform.upms.pojo.RolePermission;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface RolePermissionMapper {

    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    int deleteByRoleId(Integer roleid);
}