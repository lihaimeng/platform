package com.yuxin.platform.zongzhiserver.seal.controller;

import com.yuxin.platform.common.core.Result;
import com.yuxin.platform.common.core.ResultGenerator;
import com.yuxin.platform.common.dto.SubSealOrderRequestDto;
import com.yuxin.platform.common.model.SubSealOrder;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealOrderDto;
import com.yuxin.platform.zongzhiserver.seal.service.SubSealOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by jyh on 2018/05/14.
 */
@RestController
@RequestMapping("/sub/seal/order")
public class SubSealOrderController {
    @Resource
    private SubSealOrderService subSealOrderService;

    @ApiOperation(value = "综治子系统印章业务添加接口", notes = "添加印章业务信息，" +
            "request:SubSealOrder印章业务model;response:返回业务主键")
    @PostMapping("/add")
    public Result add(@RequestBody SubSealOrder subSealOrder) {
        int id = subSealOrderService.save(subSealOrder);
        return ResultGenerator.genSuccessResult(subSealOrder.getId());
    }


    @PostMapping("/addSealOlder")
    public Result addSealOrder(@RequestBody SubSealOrderRequestDto request) throws Exception {
        subSealOrderService.addSealOlder(request);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章业务删除接口", notes = "删除印章业务信息，" +
            "request:删除印章业务主键id;response:删除状态")
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        subSealOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章业务修改接口", notes = "修改印章业务信息，" +
            "request:SubSealOrder印章业务model;response:更改状态")
    @PostMapping("/update")
    public Result update(SubSealOrder subSealOrder) {
        subSealOrderService.update(subSealOrder);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章业务根据主键id查询接口", notes = "主键查询印章业务信息，" +
            "request:印章业务主键id;response:SubSealOrder印章业务model")
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SubSealOrder subSealOrder = subSealOrderService.findById(id);
        return ResultGenerator.genSuccessResult(subSealOrder);
    }

    @ApiOperation(value = "综治子系统印章业务接口以及对应页面查询接口",
            notes = "获取印章业务信息,页面查询条件包括：管辖单位(传code)，使用单位名称，制作单位名称，经办人姓名" +
                    "登记时间开始，登记时间结束，首次加载页面查询条件都为空；返回印章业务list")
    @PostMapping("/list")
    public List<SubSealOrder> list(@RequestBody SubSealOrderDto subSealOrderDto) {
        List<SubSealOrder> list = subSealOrderService.selectSealOrderByParams(subSealOrderDto);
        return list;
    }

    @ApiOperation(value = "综治子系统印章业务关联印章信息接口",
            notes = "获取印章业务信息与对应印章信息，request：none; response:返回与之对应的印章信息list")
    @PostMapping("/sealxxList")
    public List<SubSealOrder> SelectSealxxDetails(String ddh) {
        System.out.println(ddh);
        List<SubSealOrder> list = subSealOrderService.SelectSealxxDetails(ddh);
        return list;
    }

    /**
     * 图片预览
     *
     * @param response
     * @param id
     * @throws IOException
     */
    @RequestMapping(value = "images")
    public void images(HttpServletResponse response, Integer id) throws IOException {
        SubSealOrder subSealOrder = null;
        subSealOrder = subSealOrderService.findById(id);
        String filename = subSealOrder.getJbrzp();
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imagePath = courseFile + File.separator + "uploadFile";
        if (filename != null && !"".equals(filename)) {
            File file = new File(imagePath + File.separator + filename);
            FileInputStream inputStream = new FileInputStream(
                    imagePath + File.separator + filename);
            System.out.println("文件长度" + file.length());
            byte[] data = new byte[(int) file.length()];
            inputStream.read(data);
            response.setContentType("image/png");
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            inputStream.close();
            stream.close();
        }

    }
}
