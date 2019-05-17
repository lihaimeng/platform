package com.yuxin.platform.zongzhiserver.seal.controller;

import com.yuxin.platform.common.core.Result;
import com.yuxin.platform.common.core.ResultGenerator;
import com.yuxin.platform.common.model.SubSealOrder;
import com.yuxin.platform.common.model.SubSealSydw;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealSydwDto;
import com.yuxin.platform.zongzhiserver.seal.service.SubSealSydwService;
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
@RequestMapping("/sub/seal/sydw")
public class SubSealSydwController {
    @Resource
    private SubSealSydwService subSealSydwService;

    @ApiOperation(value = "综治子系统印章使用单位添加接口", notes = "添加印章使用单位信息，" +
            "request:SubSealSydwRequestDto包括印章使用单位model和对应附件信息frzpFile(法人照片)" +
            "yyzzzpFile(营业执照照片);response:返回成功或者失败")
    @PostMapping("/add")
    public Result add(@RequestBody SubSealSydw subSealSydw) {
        subSealSydwService.save(subSealSydw);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章使用单位添加接口", notes = "添加印章使用单位信息，" +
            "request:SubSealSydwRequestDto包括印章使用单位model和对应附件信息frzpFile(法人照片)" +
            "yyzzzpFile(营业执照照片);response:返回成功或者失败")
    @PostMapping("/addSubSealSydw")
    public Result addSubSealSydw(@RequestBody SubSealSydw subSealSydw) throws Exception {
        subSealSydwService.addSubSealSydw(subSealSydw);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章使用单位删除接口", notes = "删除印章使用单位信息，" +
            "request:删除印章业务主键id;response:删除状态")
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        subSealSydwService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章使用单位修改接口", notes = "修改印章使用单位信息，" +
            "request:SubSealSydw印章使用单位model;response:更改状态")
    @PostMapping("/update")
    public Result update(SubSealSydw subSealSydw) {
        subSealSydwService.update(subSealSydw);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统印章使用单位根据主键id查询接口", notes = "主键查询印章使用单位信息，" +
            "request:印章业务主键id;response:SubSealSydw印章使用单位model")
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SubSealSydw subSealSydw = subSealSydwService.findById(id);
        return ResultGenerator.genSuccessResult(subSealSydw);
    }

    @ApiOperation(value = "综治子系统印章使用单位接口以及对应页面查询接口",
            notes = "获取印章使用单位信息,页面查询条件包括：管辖单位(传code)，单位名称，营业执照编号，营业执照编号" +
                    "法人证件号码 ,登记时间开始，登记时间结束，首次加载页面查询条件都为空；返回印章业务list")
    @PostMapping("/list")
    public List<SubSealSydw> list(@RequestBody SubSealSydwDto subSealSydwDto) {
        List<SubSealSydw> list = subSealSydwService.selectSealSydwByParams(subSealSydwDto);
        return list;
    }

    /**
     * 图片预览
     *
     * @param response
     * @param name
     * @throws IOException
     */
    @RequestMapping(value = "images")
    public void images(HttpServletResponse response, String name) throws IOException {
        SubSealSydw subSealSydw = null;
        String subName = name.substring(0, 2);
        int id = Integer.parseInt(name.substring(2).trim());
        subSealSydw = subSealSydwService.findById(id);
        String filename = "";
        if ("yy".equals(subName)) {
            filename = subSealSydw.getYyzzzp();
        }
        if ("fr".equals(subName)) {
            filename = subSealSydw.getFrzp();
        }
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
