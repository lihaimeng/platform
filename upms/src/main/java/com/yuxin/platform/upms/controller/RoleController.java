/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
package com.yuxin.platform.upms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yuxin.platform.upms.pojo.Role;
import com.yuxin.platform.upms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/roleList", method = RequestMethod.GET)
    public List<Role> roleList() throws Exception {
        List<Role> roles = roleService.getAllRole();
        return roles;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Role role) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Role role1 = roleService.selectByName(role.getName());
        if (role1 != null) {
            map.put("result", "角色名称已存在");
        } else {
            int count = roleService.insert(role);
            if (count > 0) {
                map.put("result", "新增成功");
            } else {
                map.put("result", "新增失败");
            }
        }
        return map;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Role role) throws Exception {
        Map<String, Object> map = new HashMap<>();
        int count = roleService.update(role);
        if (count > 0) {
            map.put("result", "修改成功");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Map<String, Object> delete(@PathVariable Integer id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        int count = roleService.delete(id);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }
}
