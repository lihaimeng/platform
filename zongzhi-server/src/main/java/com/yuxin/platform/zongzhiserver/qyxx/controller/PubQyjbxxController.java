package com.yuxin.platform.zongzhiserver.qyxx.controller;

import com.yuxin.platform.common.core.Result;
import com.yuxin.platform.common.core.ResultGenerator;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyjbxx;
import com.yuxin.platform.zongzhiserver.qyxx.service.PubQyjbxxService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jyh on 2018/07/05.
 */
@RestController
@RequestMapping("/pub/qyjbxx")
public class PubQyjbxxController {
    @Resource
    private PubQyjbxxService pubQyjbxxService;

    @PostMapping("/add")
    public Result add(PubQyjbxx pubQyjbxx) {
        pubQyjbxxService.save(pubQyjbxx);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        pubQyjbxxService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PubQyjbxx pubQyjbxx) {
        pubQyjbxxService.update(pubQyjbxx);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PubQyjbxx pubQyjbxx = pubQyjbxxService.findById(id);
        return ResultGenerator.genSuccessResult(pubQyjbxx);
    }

    @PostMapping("/list")
    public Result list(PubQyjbxx pubQyjbxx) {
        List<PubQyjbxx> list = pubQyjbxxService.getByCondition(pubQyjbxx);
        return ResultGenerator.genSuccessResult(list);
    }
}
