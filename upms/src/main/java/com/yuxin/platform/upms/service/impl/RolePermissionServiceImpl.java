package com.yuxin.platform.upms.service.impl;

import com.yuxin.platform.upms.mapper.RolePermissionMapper;
import com.yuxin.platform.upms.pojo.RolePermission;
import com.yuxin.platform.upms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author jyh
 * <p>
 * 2018年1月8日
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Transactional
    @Override
    public int insert(Integer roleid, int[] ids) {
        // TODO Auto-generated method stub
        rolePermissionMapper.deleteByRoleId(roleid);
        RolePermission rp = null;
        int count = 0;
        for (int i = 0; i < ids.length; i++) {
            rp = new RolePermission();
            rp.setRoleId(roleid);
            rp.setPermissionId(ids[i]);
            count = rolePermissionMapper.insertSelective(rp);
        }
        return count;
    }

}
