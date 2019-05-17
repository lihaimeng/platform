package com.yuxin.platform.upms.mapper;

import com.yuxin.platform.upms.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> getPermission();

    List<Permission> permissionBypid(Integer pid);

    List<Permission> getPermissionByUserId(Integer userid);

    List<Permission> getPermissionByRoleId(Integer roleid);


}