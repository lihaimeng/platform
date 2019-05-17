package com.yuxin.platform.zongzhiserver.qyxx.controller;

import com.yuxin.platform.common.core.Result;
import com.yuxin.platform.common.core.ResultGenerator;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyryxx;
import com.yuxin.platform.zongzhiserver.qyxx.model.PubQyryxxAndQyjbxx;
import com.yuxin.platform.zongzhiserver.qyxx.service.PubQyryxxService;
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
@RequestMapping("/pub/qyryxx")
public class PubQyryxxController {
    @Resource
    private PubQyryxxService pubQyryxxService;

    @PostMapping("/add")
    public Result add(PubQyryxx pubQyryxx) {
        pubQyryxxService.save(pubQyryxx);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        pubQyryxxService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PubQyryxx pubQyryxx) {
        pubQyryxxService.update(pubQyryxx);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PubQyryxx pubQyryxx = pubQyryxxService.findById(id);
        return ResultGenerator.genSuccessResult(pubQyryxx);
    }

    @PostMapping("/list")
    public Result list(PubQyryxxAndQyjbxx pubQyryxxAndQyjbxx) {
        List<PubQyryxxAndQyjbxx> list = pubQyryxxService.getByCondition(pubQyryxxAndQyjbxx);
        return ResultGenerator.genSuccessResult(list);
    }
}
