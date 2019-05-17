package com.yuxin.platform.subpublic.controller;

import com.yuxin.platform.subpublic.pojo.Baryxx;
import com.yuxin.platform.subpublic.service.BaryxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/baryxx")
public class BaryxxController {
    @Autowired
    private BaryxxService baryxxService;

    @RequestMapping(value = "/selectByQyid", method = RequestMethod.GET)
    public List<Baryxx> selectByQyid(@RequestParam("qyid") Integer qyid) {
        List<Baryxx> baryxxes = baryxxService.selectByQyid(qyid);
        return baryxxes;
    }

    @RequestMapping(value = "/insertBaryxx", method = RequestMethod.POST)
    public int insertBaryxx(@RequestBody Baryxx baryxx) {
        int i = baryxxService.insertSelective(baryxx);
        return i;
    }

    @RequestMapping(value = "/updateBaryxx", method = RequestMethod.POST)
    public int updateBaryxx(@RequestBody Baryxx baryxx) {
        int i = baryxxService.updateByPrimaryKeySelective(baryxx);
        return i;
    }
}
