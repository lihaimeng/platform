/**
 * @author jyh
 * <p>
 * 2018年1月4日
 */
package com.yuxin.platform.upms.controller;

import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.upms.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @SuppressWarnings("null")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public List<Organization> organizationBypid(@PathVariable Integer pid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Organization> organization = new ArrayList<>();
        if (pid == -2) {
            organization.add(organizationService.selectByPrimaryKey(user.getOrganizationId()));
        } else {
            organization = organizationService.organizationBypid(pid);
        }
        return organization;
    }


    /**
     * 根据id数组查询下属机构信息
     **/
    @RequestMapping(value = "/selectUnderOrgidarr", method = RequestMethod.POST)
    public Map selectUnderOrgidarr(@RequestParam("idarr") List<Integer> idarr) {
        Map map = new HashMap();
        for (int id : idarr) {
            List<Organization> organizations = organizationService.organizationBypid(id);
            map.put(id, organizations);
        }
        return map;
    }

    /**
     * 根据查询机构信息
     **/
    @RequestMapping(value = "/selectByOrgid/{id}", method = RequestMethod.GET)
    public Organization selectByOrgid(@PathVariable Integer id) {
        Organization sysOrganization = organizationService.selectByPrimaryKey(id);
        return sysOrganization;
    }

    /**
     * 根据id数组查询机构信息
     **/
    @RequestMapping(value = "/selectByOrgidarr", method = RequestMethod.POST)
    public List<Organization> selectByOrgidarr(@RequestParam("idarr") List<Integer> idarr) {
        List<Organization> organizations = new ArrayList<>();
        for (int id : idarr) {
            Organization sysOrganization = organizationService.selectByPrimaryKey(id);
            organizations.add(sysOrganization);
        }
        return organizations;
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody Organization organization, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        User user = (User) session.getAttribute("user");
        int count = organizationService.insert(organization, user);
        if (count > 0) {
            map.put("result", "新增成功");
        } else if (count == -1) {
            map.put("result", "该机构信息已存在！");
        } else if (count == -2) {
            map.put("result", "该机构编码有误，请输入符合该区域编码！");
        } else if (count == -3) {
            map.put("result", "请点击所在区域进行新增操作！");
        } else {
            map.put("result", "新增失败");
        }
        return map;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Organization organization) {
        Map<String, Object> map = new HashMap<>();
        int count = organizationService.update(organization);
        if (count == 1) {
            map.put("result", "修改成功");
        } else if (count < 0) {
            map.put("result", "该组织信息已存在!");
        } else {
            map.put("result", "修改失败");
        }
        return map;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Map<String, Object> delete(@PathVariable String id) {
        Map<String, Object> map = new HashMap<>();
        int count = organizationService.delete(Integer.parseInt(id));
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败,该机构下存在子机构");
        }
        return map;
    }

    /**
     * 根据id查询所属机构下面所有单位
     **/

    @RequestMapping(value = "/selectUnderOrgbyid", method = RequestMethod.POST)
    public List<Organization> selectUnderOrgbyid(@RequestParam("orgid") Integer orgid) {
        List<Organization> sysOrganization = organizationService.selectUnderOrgbyid(orgid);
        return sysOrganization;
    }
}
