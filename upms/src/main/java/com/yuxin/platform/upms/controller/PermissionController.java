package com.yuxin.platform.upms.controller;

import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.Permission;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.service.OrganizationService;
import com.yuxin.platform.upms.service.PermissionService;
import com.yuxin.platform.upms.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private OrganizationService organizationService;

    @Value("${pawn_url}")
    private String pawn_url;

    @Value("${zongzhi_url}")
    private String zongzhi_url;


    @RequestMapping(value = "getPermission", method = RequestMethod.POST)
    public Map<String, Object> login(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<>();
        List<Permission> list = permissionService.getPermissionByUserId(user.getUserId());
        Organization organization = organizationService.selectByPrimaryKey(user.getOrganizationId());
        List<Organization> organizations = organizationService.selectByBrevitycode(organization.getBrevitycode());
        session.setAttribute("organization", organization);
        map.put("organization", organizations);//管辖单位
        map.put("dictionaryRecord", servletContext.getAttribute("dictionaryRecord"));//字典信息
        map.put("list", list);
        map.put("user", user);
        map.put("pawn_url", pawn_url);
        map.put("zongzhi_url", zongzhi_url);
        map.put("organizationCode", organization.getBrevitycode());
        return map;
    }

    @RequestMapping(value = "getPermissionApi", method = RequestMethod.POST)
    public List<Permission> getPermissionApi(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        List<Permission> list = permissionService.getPermissionByUserId(userId);
        return list;
    }

    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public List<Permission> permissionBypid(@PathVariable Integer pid) {
        List<Permission> list = permissionService.permissionBypid(pid);
        return list;
    }

    @RequestMapping(value = "/permissionByRoleId/{roleid}", method = RequestMethod.GET)
    public List<TreeNode> permissionByRoleId(@PathVariable Integer roleid) {
        System.out.println("asd");
        List<TreeNode> list = permissionService.getPermissionByRoleId(roleid);
        return list;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Permission permission) {
        Map<String, Object> map = new HashMap<>();
        int count = permissionService.insert(permission);
        if (count > 0) {
            map.put("result", "新增成功");
        } else {
            map.put("result", "新增失败");
        }
        return map;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Permission permission) {
        Map<String, Object> map = new HashMap<>();
        int count = permissionService.update(permission);
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
        int count = permissionService.delete(id);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败,该菜单下存在子菜单");
        }
        return map;
    }

}
