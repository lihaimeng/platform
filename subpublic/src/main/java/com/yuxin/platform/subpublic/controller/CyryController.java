/**
 * @author wj
 * <p>
 * 2018年1月31日
 */
package com.yuxin.platform.subpublic.controller;

import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.subpublic.dto.CyryDto;
import com.yuxin.platform.subpublic.pojo.Qyjbxx;
import com.yuxin.platform.subpublic.pojo.Qyryxx;
import com.yuxin.platform.subpublic.service.CyryService;
import com.yuxin.platform.subpublic.service.QyjbxxService;
import com.yuxin.platform.subpublic.vo.QyryVo;
import com.yuxin.platform.upms.pojo.Role;
import com.yuxin.platform.upms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/qyry")
//@SessionAttributes("user")
public class CyryController {

    @Autowired
    private CyryService cyryService;

    @Resource
    private QyjbxxService qyjbxxService;

    @RequestMapping(value = "/selectQyryxxs", method = RequestMethod.GET)
    public List<QyryVo> selectQyryxxs(@RequestParam Map<String, Object> map, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //List<Qyryxx> ddxxes = cyryService.selectQyryxxs(map,user);
        List<QyryVo> ddxxes = cyryService.selectQyryxxs(map, user);
        return ddxxes;
    }

    @RequestMapping(value = "/selectQyryxxsForDaily", method = RequestMethod.GET)
    public List<QyryVo> selectQyryxxsForDaily(@RequestParam Map<String, Object> map) {
        List<QyryVo> qyrys = cyryService.selectQyryxxsForDaily(map);
        return qyrys;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody CyryDto cyrydto, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();
        Qyryxx qyryxx = cyrydto.getQyryxx();
        Role role = cyrydto.getRole();
        int count = cyryService.insert(qyryxx, role, user);
        int ryid = qyryxx.getRyid();
        if (count >= 0) {
            map.put("result", "操作成功");
            map.put("resultRyid", ryid);
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody CyryDto cyrydto) {
        Map<String, Object> map = new HashMap<String, Object>();
        int count = cyryService.updateByPrimaryKeySelective(cyrydto.getQyryxx(), cyrydto.getRole());
        if (count >= 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Map<String, Object> delete(Integer id, String tableName) {
        Map<String, Object> map = new HashMap<>();
        int count = cyryService.deleteByPrimaryKey(id);
        if (count > 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }

    @RequestMapping(value = "/insertAttach", method = RequestMethod.POST)
    public Map<String, Object> insertAttach(@RequestBody Attachments attachments,HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = user.getUsername();
        int count = cyryService.insertAttach(attachments, userName);
        if (count >= 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }

    @RequestMapping(value = "/updateAttach", method = RequestMethod.POST)
    public Map<String, Object> updateAttach(@RequestBody Attachments attachments, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = user.getUsername();
        int count = cyryService.updateAttach(attachments, userName);
        if (count >= 0) {
            map.put("result", "操作成功");
        } else {
            map.put("result", "操作失败");
        }
        return map;
    }

    /**
     *同步印章系统从业人员信息
     * @return
     */
    @RequestMapping(value = "/insertCyryBySeal", method = RequestMethod.POST)
    public Map<String,Object> insertCyryBySeal(@RequestBody Qyryxx qyryxx){
        Map<String, Object> map = new HashMap<>();
        try{
            //获取企业信息
            Qyjbxx qyjbxx = qyjbxxService.selectByQybm(qyryxx.getLrdwbm());
            if(qyjbxx != null){
                qyryxx.setQyid(qyjbxx.getQyid());
                qyryxx.setLrsj(new Date());
                qyryxx.setScbz((short) 0);
                qyryxx.setCyryzt("在岗");
                qyryxx.setHylb("印章行业");
                qyryxx.setHylbdm("01801");
            }
            cyryService.insertCyryBySeal(qyryxx);
            map.put("state","success");
        }catch (Exception e){
            map.put("state","error");
        }
        return map;
    }
}
