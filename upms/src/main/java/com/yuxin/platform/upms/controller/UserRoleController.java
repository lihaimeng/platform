package com.yuxin.platform.upms.controller;

import com.yuxin.platform.upms.pojo.UserRole;
import com.yuxin.platform.upms.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2018年1月8日
 */
@RestController
@RequestMapping(value = "/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService usRoleService;


    @RequestMapping(value = "updateUserRole", method = RequestMethod.POST)
    public Map<String, Object> updateUserRole(@RequestBody UserRole userRole) {
        Map<String, Object> map = new HashMap<>();
        int count = usRoleService.insertSelective(userRole);
        if (count > 0) {
            map.put("result", "修改成功");
            System.out.println("操作成功");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }

    /**
     * 获取用户角色
     * @param userId
     * @return
     */
    @PostMapping(value = "getUserRole")
    public UserRole getUserRole(@RequestParam Integer userId) {
        return usRoleService.selectByUserId(userId);
    }

}
