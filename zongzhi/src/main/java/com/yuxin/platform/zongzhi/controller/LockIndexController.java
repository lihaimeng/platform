package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.service.IndexLockService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zzd
 * @create 2018-03-15-15:22
 */
@RestController
@RequestMapping("echart1")
@SessionAttributes("user")
public class LockIndexController {
    @Autowired
    private IndexLockService indexlockservice;

    @ApiOperation(value = "开锁行业首页", notes = "开锁数据统计", response = Object.class, httpMethod = "GET")
    @RequestMapping(value = "/getCountsOfksxx", method = RequestMethod.GET)
    public Map<String, Object> getCountsOfksxx(@RequestParam Map<String, Object> maps, @ModelAttribute("user") User user) {
        Map<String, Object> lockMap = new HashMap<String, Object>();
        //开锁类型占比情况
        List<Map<String, Object>> kslxList = indexlockservice.getCountsOfKslx(user, maps);
        //委托人数量增长情况
        List<Map<String, Object>> wtrList = indexlockservice.getCountsOfWtr(user, maps);
        //地区业务数据情况
        List<Map<String, Object>> qysjList = indexlockservice.getCountsOfOrganization(user, maps);
        //开锁企业分布情况
        List<Map<String, Object>> qyfbList = indexlockservice.getCountsOfQyfb(user, maps);
        lockMap.put("kslxList", kslxList);
        lockMap.put("wtrList", wtrList);
        lockMap.put("qysjList", qysjList);
        lockMap.put("qyfbList", qyfbList);
        return lockMap;
    }

    @ApiOperation(value = "开锁行业首页", notes = "开锁数据按时间统计", response = Object.class, httpMethod = "GET")
    @RequestMapping(value = "/getKsxxsOfdate", method = RequestMethod.GET)
    public Map<String, Object> getKsxxsOfdate(@RequestParam Map<String, Object> maps, @ModelAttribute("user") User user) {
        Map<String, Object> lockMap = new HashMap<String, Object>();
        List<Map<String, Object>> ksxxList = new ArrayList<Map<String, Object>>();
        //cxbz:查询标识 kslx：开锁类型  wtr：委托人数量 qysj：地区业务数据 qyfb：企业分布
        String cxbz = (String) maps.get("cxbz");
        if ("kslx".equals(cxbz)) {
            //开锁类型占比情况
            ksxxList = indexlockservice.getCountsOfKslx(user, maps);
        } else if ("wtr".equals(cxbz)) {
            //委托人数量增长情况
            ksxxList = indexlockservice.getCountsOfWtr(user, maps);
        } else if ("qysj".equals(cxbz)) {
            //地区业务数据情况
            ksxxList = indexlockservice.getCountsOfOrganization(user, maps);
        } else {
            //开锁企业分布情况
            ksxxList = indexlockservice.getCountsOfQyfb(user, maps);
        }
        lockMap.put("ksxxList", ksxxList);
        return lockMap;
    }
}