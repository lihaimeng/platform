package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.common.core.SystemLog;
import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.service.IndexService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * 综治首页查询控制器
 *
 * @author wj
 */
@RestController
@RequestMapping("/index")
@SessionAttributes("user")
public class IndexController {
    @Autowired
    private IndexService indexService;

    @ApiOperation(value = "综治首页接口", notes = "不需要传参数，直接请求。返回数据：countLockCompany:统计锁业单位数量；countLockCompanyStaff：统计锁业单位人员数量；" +
            "countLockCompany:统计印章单位数量；countLockCompanyStaff：统计印章单位人员数量；roleName：角色；organizationName:部门名称；" +
            "organizationParentName：所属行政区域；xctgs：协查通告List集合（5条数据）；kyqk：可疑情况List集合（5条数据）,countSeal:印章业务数量," +
            "countLock:锁业业务数量",
            response = Map.class, httpMethod = "GET")
    @RequestMapping("/countMsg")
    @SystemLog(description = "首页统计")
    public Map<String, Object> countMsg(@ModelAttribute("user") User user) {
        Map<String, Object> map = new HashMap<>();
        int countLockCompany = indexService.countLockCompany();
        int countLockCompanyStaff = indexService.countLockCompanyStaff();
        int countSealCompany = indexService.countSealCompany();
        int countSealCompanyStaff = indexService.countSealCompanyStaff();
        Map<String, Object> userMsg = indexService.getUserMsg(user);
        int countSeal = indexService.countSeal();
        int countSealByDay = indexService.countSealByDay();
        int countLock = indexService.countLock();
        int countLockByDay = indexService.countLockByDay();
        map.put("countLockByDay", countLockByDay);
        map.put("countSealByDay", countSealByDay);
        map.put("countLock", countLock);
        map.put("countSeal", countSeal);
        map.put("countLockCompany", countLockCompany);
        map.put("countLockCompanyStaff", countLockCompanyStaff);
        map.put("countSealCompany", countSealCompany);
        map.put("countSealCompanyStaff", countSealCompanyStaff);
        map.put("roleName", userMsg.get("roleName"));
        map.put("organizationName", userMsg.get("organizationName"));
        map.put("organizationParentName", userMsg.get("organizationParentName"));
        map.put("xctgs", userMsg.get("xctg"));
        map.put("kyqk", userMsg.get("kyqk"));
        return map;
    }
}
