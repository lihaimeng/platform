package com.yuxin.platform.subpublic.controller;

import com.yuxin.platform.subpublic.pojo.Bldsjksb;
import com.yuxin.platform.subpublic.service.BldsjksbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bldsjksb")
public class BldsjksbController {

    @Autowired
    private BldsjksbService bldsjksbService;

    @RequestMapping(value = "/selectBldsjksb", method = RequestMethod.GET)
    public List<Bldsjksb> selectBldsjksb(@RequestParam("qyid") Integer qyid) {
        List<Bldsjksb> bldsjksbes = bldsjksbService.selectBldsjksb(qyid);
        return bldsjksbes;
    }

    @RequestMapping(value = "/insertBldsjksb", method = RequestMethod.POST)
    public int insertBldsjksb(@RequestBody Bldsjksb bldsjksb) {
        int i = bldsjksbService.insertSelective(bldsjksb);
        return i;
    }

    @RequestMapping(value = "/updateBldsjksb", method = RequestMethod.POST)
    public int updateBldsjksb(@RequestBody Bldsjksb bldsjksb) {
        int i = bldsjksbService.updateByPrimaryKeySelective(bldsjksb);
        return i;
    }
}
