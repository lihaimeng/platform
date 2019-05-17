package com.yuxin.platform.zongzhiserver.seal.controller;

import com.yuxin.platform.common.core.Result;
import com.yuxin.platform.common.core.ResultGenerator;
import com.yuxin.platform.common.model.SubSealSealxx;
import com.yuxin.platform.common.model.SubSealSydw;
import com.yuxin.platform.zongzhiserver.seal.dto.ResultSubSealOrderDto;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealSealxxDto;
import com.yuxin.platform.zongzhiserver.seal.service.SubSealSealxxService;
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
@RequestMapping("/sub/seal/sealxx")
public class SubSealSealxxController {
    @Resource
    private SubSealSealxxService subSealSealxxService;

    @PostMapping("/add")
    @ApiOperation(value = "综治子系统印章信息添加接口", notes = "添加印章信息，" +
            "request:SubSealSealxx印章信息model;response:返回业务主键")
    public Result add(@RequestBody SubSealSealxx subSealSealxx) {
        subSealSealxxService.save(subSealSealxx);
        return ResultGenerator.genSuccessResult(subSealSealxx.getId());
    }

    @ApiOperation(value = "综治子系统印章信息删除接口", notes = "删除印章信息，" +
            "request:删除印章信息主键id;response:删除状态")
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        subSealSealxxService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章信息修改接口", notes = "修改印章信息，" +
            "request:SubSealSealxx印章信息model;response:更改状态")
    @PostMapping("/update")
    public Result update(SubSealSealxx subSealSealxx) {
        subSealSealxxService.update(subSealSealxx);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章信息根据主键id查询接口", notes = "主键查询印章信息，" +
            "request:印章信息主键id;response:subSealSealxx印章信息model")
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SubSealSealxx subSealSealxx = subSealSealxxService.findById(id);
        return ResultGenerator.genSuccessResult(subSealSealxx);
    }

    @PostMapping("/list")
    public List<SubSealSealxx> list(@RequestBody SubSealSealxxDto subSealSealxxDto) {
        List<SubSealSealxx> list = subSealSealxxService.selectSealSealxxByParams(subSealSealxxDto);
        return list;
    }

    @ApiOperation(value = "综治子系统印章信息接口以及对应页面查询接口",
            notes = "获取印章业务信息,页面查询条件包括：使用单位名称，印章材料，印章规格，印章中心图案，" +
                    "印章编码 ，印章类型，印章形状" +
                    "登记时间开始，登记时间结束，首次加载页面查询条件都为空；返回印章业务list")
    @PostMapping("/detialsList")
    public List<ResultSubSealOrderDto> getSealOrderDetials(@RequestBody SubSealSealxxDto subSealSealxxDto) {
        List<ResultSubSealOrderDto> list = subSealSealxxService.sealxxAndSubSealOrderDetails(subSealSealxxDto);
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
        SubSealSealxx subSealSealxx = null;
        subSealSealxx = subSealSealxxService.findById(id);
        String filename = subSealSealxx.getYmldzp();
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
