package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.zongzhi.pojo.SubZhzaQyjbxx;
import com.yuxin.platform.zongzhi.service.SubZhzaQyjbxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 综治企业基本信息
 *
 * @author WJ
 */
@RequestMapping("/qyjbxx")
@RestController
public class SubZhzaQyjbxxController {

    @Autowired
    private SubZhzaQyjbxxService subZhzaQyjbxxService;

    /**
     * 获取综治所有企业基本信息
     *
     * @return
     */
    @RequestMapping(value = "/selectSubZhzaQyjbxx")
    public List<SubZhzaQyjbxx> selectSubZhzaQyjbxx() {
        return subZhzaQyjbxxService.selectSubZhzaQyjbxx();
    }

    @RequestMapping(value = "/selectByParams")
    public List<SubZhzaQyjbxx> selectByParams(@RequestBody SubZhzaQyjbxx subZhzaQyjbxx) {
        return subZhzaQyjbxxService.selectSubZhzaQyjbxxByParams(subZhzaQyjbxx);
    }

}
