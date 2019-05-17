package com.yuxin.platform.upms.controller;

import com.yuxin.platform.upms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2018年1月8日
 */
@RestController
@RequestMapping(value = "rolePermission")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @RequestMapping(value = "insert/{roleid}/{ids}", method = RequestMethod.POST)
    public Map<String, Object> insert(@PathVariable Integer roleid, @PathVariable int[] ids) {
        Map<String, Object> map = new HashMap<>();
        int count = rolePermissionService.insert(roleid, ids);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }
}
