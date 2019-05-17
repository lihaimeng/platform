/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
package com.yuxin.platform.upms.service;

import com.yuxin.platform.upms.pojo.Permission;
import com.yuxin.platform.upms.vo.TreeNode;

import java.util.List;


public interface PermissionService {

    List<Permission> getPermission();

    int insert(Permission record);

    List<Permission> permissionBypid(Integer pid);

    int update(Permission record);

    int delete(Integer id);

    List<Permission> getPermissionByUserId(Integer userid);

    List<TreeNode> getPermissionByRoleId(Integer roleid);
}
