package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.upms.pojo.Organization;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.pojo.SysOrganization;
import com.yuxin.platform.zongzhi.service.SysOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sysOrganization")
@SessionAttributes("user")
public class SysOrganizationControlller {
    @Autowired
    private SysOrganizationService sysOrganizationService;

    @RequestMapping(value = "/selectByPrimaryKey/{tbid}", method = RequestMethod.GET)
    public SysOrganization selectByPrimaryKey(@ModelAttribute("user") User user) {
        System.out.println("进入查询SysOrganizationService，user：" + user);
        SysOrganization sysOrganization = sysOrganizationService.selectByPrimaryKey(user.getOrganizationId());
        System.out.println("sysOrganization：" + sysOrganization);
        return sysOrganization;
    }

    @RequestMapping(value = "/getDominions")
    public List<Organization> getDominions(@ModelAttribute("user") User user) {
        List<Organization> organizations = sysOrganizationService.selectByBrevitycode(user.getOrganizationId());
        return organizations;
    }
}
