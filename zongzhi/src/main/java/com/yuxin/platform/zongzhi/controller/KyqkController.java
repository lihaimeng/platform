package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.pojo.Kyqk;
import com.yuxin.platform.zongzhi.pojo.KyqkHt;
import com.yuxin.platform.zongzhi.service.KyqkService;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyjbxx;
import com.yuxin.platform.zongzhiserver.qyxx.service.PubQyjbxxService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xk on 2018/3/1.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/zzkyqk")
public class KyqkController {

    @Autowired
    private KyqkService kyqkService;

    @Resource
    private PubQyjbxxService pubQyjbxxService;

    @ApiOperation(value = "可疑情况查询", notes = "根据条件查询可疑情况数据", response = Object.class, httpMethod = "POST")
    @RequestMapping(value = "/selectKyqkListHt", method = RequestMethod.POST)
    public List<KyqkHt> selectKyqkListHt(@ApiParam("可疑情况map") @RequestParam Map<String, Object> map) {
        List<KyqkHt> kyqkList = kyqkService.selectKyqkListHt(map);
        return kyqkList;
    }

    @ApiOperation(value = "可疑情况处理", notes = "可疑情况数据处理", response = Object.class, httpMethod = "POST")
    @RequestMapping(value = "/updateKyqkHt", method = RequestMethod.POST)
    public Map<String, Object> updateKyqkHt(@ApiParam("可疑情况对象") @RequestBody Kyqk kyqk, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = (User) session.getAttribute("user");
        String jjrxm = user.getRealname();
        String jjrgh = user.getQyrybm();
        kyqk.setJjrgh(jjrgh);
        kyqk.setJjrxm(jjrxm);
        kyqk.setClzt("已处理");
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        kyqk.setJjsj(df.format(day));
        int count = kyqkService.updateKyqkHt(kyqk);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }


    //    企业端
    @ApiOperation(value = "企业端可疑情况查询", notes = "根据条件查询可疑情况数据", response = Object.class, httpMethod = "POST")
    @RequestMapping(value = "/selectKyqkList", method = RequestMethod.POST)
    public List<Kyqk> selectKyqkList(@ApiParam("可疑情况map") @RequestParam Map<String, Object> map) {
        List<Kyqk> kyqkList = kyqkService.selectKyqkList(map);
        return kyqkList;
    }

    @ApiOperation(value = "企业端可疑情况上报", notes = "新增可疑情况", response = Object.class, httpMethod = "POST")
    @RequestMapping(value = "/insertKyqk", method = RequestMethod.POST)
    public Map<String, Object> insertKyqk(@ApiParam("可疑情况对象") @RequestBody Kyqk kyqk, HttpSession session) {
        User user = (User)session.getAttribute("user");
        PubQyjbxx pubQyjbxx = pubQyjbxxService.findBy("qybm", user.getQyrybm());
        kyqk.setQyid(pubQyjbxx.getQyid());
        kyqk.setQymc(pubQyjbxx.getQymc());
        kyqk.setHylb(pubQyjbxx.getHylb());
        kyqk.setGxdwmc(pubQyjbxx.getGxdwmc());
        kyqk.setGxdwbm(pubQyjbxx.getGxdwbm());
        Map<String, Object> map = new HashMap<String, Object>();
        kyqk.setScbz((short) 0);
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        kyqk.setTbsj(df.format(day));
        int count = kyqkService.insertKyqk(kyqk);
        if (count >= 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }

    @ApiOperation(value = "企业端可疑情况删除", notes = "删除可疑情况", response = Object.class, httpMethod = "POST")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map<String, Object> delete(@ApiParam("可疑情况ID") Integer kyqkid) {
        Map<String, Object> map = new HashMap<>();
        int count = kyqkService.deleteByPrimaryKey(kyqkid);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }

    // 公安端
    @ApiOperation(value = "公安端可疑情况查询", notes = "根据条件查询可疑情况数据", response = Object.class, httpMethod = "POST")
    @RequestMapping(value = "/selectKyqkLists", method = RequestMethod.POST)
    public List<Kyqk> selectKyqkLists(@ApiParam("可疑情况map") @RequestBody User user) {
        List<Kyqk> kyqkList = kyqkService.selectKyqkLists(user);
        return kyqkList;
    }

}
