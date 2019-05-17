package com.yuxin.platform.upms.controller;

import com.yuxin.platform.common.core.SystemLog;
import com.yuxin.platform.upms.dto.PasswordDto;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.pojo.UserRole;
import com.yuxin.platform.upms.service.UserRoleService;
import com.yuxin.platform.upms.service.UserService;
import com.yuxin.platform.upms.util.CipherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jyh
 * <p>
 * 2017年12月27日
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService usRoleService;


    @RequestMapping(value = "selectUserList", method = RequestMethod.GET)
    public List<User> selectUserList(@RequestParam Map<String, Object> map) {
        List<User> userList = userService.selectUserList(map);
        return userList;
    }

    @RequestMapping(value = "userlist", method = RequestMethod.GET)
    public List<User> name() {
        System.out.println("jyh");
        List<User> userList = userService.getAllUser();
        return userList;

    }

    @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
    public List<User> organizationBypid(@PathVariable Integer organizationId) {
        List<User> userlist = userService.selectByOrganizationId(organizationId);
        return userlist;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody User user) {
        user.setPassword(CipherUtil.generatePassword(user.getPassword()));
        Map<String, Object> map = new HashMap<>();
        int count = userService.insert(user);
        if (count > 0) {
            map.put("result", "新增成功");
        } else {
            map.put("result", "新增失败");
        }
        return map;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody User user) {
        if (user.getPassword() != null) {
            user.setPassword(CipherUtil.generatePassword(user.getPassword()));
        }
        Map<String, Object> map = new HashMap<>();
        int count = userService.update(user);
        if (count > 0) {
            map.put("result", "修改成功");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }

    @RequestMapping(value = "resetPwd/{userId}", method = RequestMethod.POST)
    public Map<String, Object> resetPwd(@PathVariable Integer userId) {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        System.out.println(userId);
        String initPwd = "123456";
        user.setUserId(userId);
        user.setPassword(CipherUtil.generatePassword(initPwd));
        int count = userService.updatePwd(user);
        if (count > 0) {
            map.put("result", "重置密码成功");
        } else {
            map.put("result", "重置密码失败");
        }
        return map;
    }

    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    public Map<String, Object> updatePwd(@RequestBody PasswordDto passwordDto, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User user = (User) session.getAttribute("user");
        if (CipherUtil.generatePassword(passwordDto.getOldPwd()).equals((user.getPassword()))) {
            user.setPassword(CipherUtil.generatePassword(passwordDto.getNewPwd()));
            userService.updatePwd(user);
            map.put("result", "密码修改成功");
        } else {
            map.put("result", "旧密码不正确");
        }
        return map;
    }


    @RequestMapping(value = "userlogin", method = RequestMethod.POST)
    @SystemLog(description = "用户登录")
    public Map<String, Object> login(HttpSession session, User user) {
        System.out.println("login");
        Map<String, Object> map = new HashMap<>();
        user.setPassword(CipherUtil.generatePassword(user.getPassword()));
        List<User> list = userService.userLogin(user);
        if (list.size() > 0) {
            map.put("code", 1);
            session.setAttribute("user", list.get(0));
        } else {
            map.put("code", 10101);
        }
        return map;
    }

    @RequestMapping(value = "userloginApi", method = RequestMethod.POST)
    public List<User> loginApi(@RequestBody User user) {
        System.out.println("login");
        Map<String, Object> map = new HashMap<>();
        user.setPassword(CipherUtil.generatePassword(user.getPassword()));
        List<User> list = userService.userLogin(user);
        return list;
    }

    @RequestMapping(value = "updateUserRole", method = RequestMethod.POST)
    public Map<String, Object> updateUserRole(@RequestBody UserRole userRole) {
        Map<String, Object> map = new HashMap<>();
        int count = usRoleService.insertSelective(userRole);
        if (count > 0) {
            map.put("result", "修改成功");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        int count = userService.delete(id);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }
}
