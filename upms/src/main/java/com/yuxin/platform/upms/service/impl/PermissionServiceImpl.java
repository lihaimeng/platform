package com.yuxin.platform.upms.service.impl;

import com.yuxin.platform.upms.mapper.PermissionMapper;
import com.yuxin.platform.upms.pojo.Permission;
import com.yuxin.platform.upms.service.PermissionService;
import com.yuxin.platform.upms.vo.State;
import com.yuxin.platform.upms.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermission() {
        // TODO Auto-generated method stub
        return permissionMapper.getPermission();
    }

    @Transactional
    @Override
    public int insert(Permission record) {
        // TODO Auto-generated method stub
        record.setAddtime(new Date());
        return permissionMapper.insertSelective(record);
    }

    @Override
    public List<Permission> permissionBypid(Integer pid) {
        // TODO Auto-generated method stub
        return permissionMapper.permissionBypid(pid);
    }

    @Transactional
    @Override
    public int update(Permission record) {
        // TODO Auto-generated method stub
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int delete(Integer id) {
        // TODO Auto-generated method stub
        List<Permission> list = permissionMapper.permissionBypid(id);
        if (list.size() > 0) {
            return 0;
        }
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public List<Permission> getPermissionByUserId(Integer userid) {
        // TODO Auto-generated method stub
        return permissionMapper.getPermissionByUserId(userid);
    }

    @Override
    public List<TreeNode> getPermissionByRoleId(Integer roleid) {
        // TODO Auto-generated method stub
        List<Permission> listAll = permissionMapper.getPermission();
        List<Permission> listRole = permissionMapper.getPermissionByRoleId(roleid);
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = null;
        for (Permission permission : listAll) {
            node = new TreeNode();
            node.setId(permission.getPermissionId());
            node.setText(permission.getName());
            node.setPid(permission.getPid());
            node.setState(new State(true));
            for (Permission permission2 : listRole) {
                if (permission.getPermissionId().equals(permission2.getPermissionId())) {
                    node.setState(new State(true, true));
                }
            }
            list.add(node);
        }
        return list;
    }

}
