package com.yuxin.platform.subpublic.controller;

import com.yuxin.platform.subpublic.pojo.Jfsbxx;
import com.yuxin.platform.subpublic.service.JfsbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/jfsbxx")
public class JfsbxxController {

    @Autowired
    private JfsbxxService jfsbxxService;

    @RequestMapping(value = "/selectJfsbxx", method = RequestMethod.GET)
    public List<Jfsbxx> selectJfsbxx(@RequestParam("qyid") Integer qyid) {
        List<Jfsbxx> jfsbxxes = jfsbxxService.selectJfsbxx(qyid);
        return jfsbxxes;
    }

    @RequestMapping(value = "/insertJfsbxx", method = RequestMethod.POST)
    public int insertJfsbxx(@RequestBody Jfsbxx jfsbxx) {
        int i = jfsbxxService.insertSelective(jfsbxx);
        return i;
    }

    @RequestMapping(value = "/updateJfsbxx", method = RequestMethod.POST)
    public int updateJfsbxx(@RequestBody Jfsbxx jfsbxx) {
        int i = jfsbxxService.updateByPrimaryKeySelective(jfsbxx);
        return i;
    }


}
