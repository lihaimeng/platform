package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.upms.pojo.User;
import com.yuxin.platform.zongzhi.pojo.DmXctb;
import com.yuxin.platform.zongzhi.pojo.DmXctbExample;
import com.yuxin.platform.zongzhi.service.DmXctbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dmxctb")
@SessionAttributes("user")
public class DmXctbController {
    @Autowired
    private DmXctbService dmXctbService;

    @RequestMapping(value = "/selectByPrimaryKey/{tbid}", method = RequestMethod.GET)
    public DmXctb selectByPrimaryKey(@PathVariable Integer tbid) {
        DmXctb dmXctb = dmXctbService.selectByPrimaryKey(tbid);
        return dmXctb;
    }

    @RequestMapping(value = "/selectList", method = RequestMethod.GET)
    public List<DmXctb> selectList() {
        DmXctbExample DmXctbExample = new DmXctbExample();
        DmXctbExample.setOrderByClause("tbid desc");
        List<DmXctb> dmXctblist = dmXctbService.selectByExample(DmXctbExample);
        return dmXctblist;
    }

    @RequestMapping(value = "/selectByExample", method = RequestMethod.POST)
    public List<DmXctb> selectByExample(@RequestBody DmXctb record, int state) {
        DmXctbExample DmXctbExample = new DmXctbExample();
        DmXctbExample.setOrderByClause("tbid desc");
        DmXctbExample.Criteria criteria = DmXctbExample.createCriteria();

        if (state == 0) {
            if (record.getSxhylbmc() != null && record.getSxhylbmc() != "") {
                criteria.andSxhylbmcLike("%" + record.getSxhylbmc() + "%");
            }
            if (record.getFbdw() != null && record.getFbdw() != "") {
                criteria.andFbdwLike("%" + record.getFbdw() + "%");
            }
            if (record.getFbr() != null && record.getFbr() != "") {
                criteria.andFbrLike("%" + record.getFbr() + "%");
            }
        } else if (state == 1) {
            criteria.andSxhylbmcLike("%典当行业%");
            if (record.getBt() != null && record.getBt() != "") {
                criteria.andBtLike("%" + record.getBt() + "%");
            }
        } else {
            criteria.andSxhylbmcLike("%典当行业%");
        }

        if (record.getFbsj() != null) {
            criteria.andFbsjGreaterThan(record.getFbsj());
        }
        if (record.getJzrq() != null) {
            criteria.andFbsjLessThan(record.getJzrq());
        }


        List<DmXctb> DmXctb = dmXctbService.selectByExample(DmXctbExample);

        return DmXctb;
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody DmXctb record, @ModelAttribute("user") User user) {
        record.setFbr(user.getRealname());
        record.setFbdw(user.getOrganizationName());
        dmXctbService.insertSelective(record);
        return dmXctbService.selectLastid(1).getTbid();
    }


    @RequestMapping(value = "/deleteByPrimaryKey/{tbid}", method = RequestMethod.GET)
    public int deleteByPrimaryKey(@PathVariable Integer tbid) {
        return dmXctbService.deleteByPrimaryKey(tbid);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.POST)
    public int updateByPrimaryKey(@RequestBody DmXctb record) {
        return dmXctbService.updateByPrimaryKey(record);
    }


}
