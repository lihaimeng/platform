package com.yuxin.platform.zongzhiserver.lock.controller;
import com.yuxin.platform.common.core.Result;;
import com.yuxin.platform.common.core.ResultGenerator;
import com.yuxin.platform.common.model.SubLockOrder;
import com.yuxin.platform.zongzhiserver.lock.dto.SdLockSmithDto;
import com.yuxin.platform.zongzhiserver.lock.model.SdLockSmith;
import com.yuxin.platform.zongzhiserver.lock.service.SdLockSmithService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * Created by jyh on 2018/08/02.
 */
@RestController
@RequestMapping("/sd/lock/smith")
public class SdLockSmithController {
    @Resource
    private SdLockSmithService sdLockSmithService;

//    @PostMapping("/add")
//    public Result add(SdLockSmith sdLockSmith) {
//        sdLockSmithService.save(sdLockSmith);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        sdLockSmithService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(SdLockSmith sdLockSmith) {
//        sdLockSmithService.update(sdLockSmith);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        SdLockSmith sdLockSmith = sdLockSmithService.findById(id);
//        return ResultGenerator.genSuccessResult(sdLockSmith);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<SdLockSmith> list = sdLockSmithService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

    @ApiOperation(value = "添加锁匠信息接口", notes = "添加锁匠信息,返回失败或成功")
    @PostMapping("/addSdLockSmith")
    public Result addLockOrder(@RequestBody SdLockSmith sdLockSmith) throws Exception {
        int returnInt=sdLockSmithService.addSdLockSmith(sdLockSmith);
        if(returnInt==0){
            return ResultGenerator.genFailResult("该身份证号码已经存在，请重新输入。");
        }else{
            return ResultGenerator.genSuccessResult();
        }

    }

    @PostMapping("/findSdLockSmithList")
    public List<SdLockSmith> findSdLockSmithList(@RequestBody SdLockSmithDto sdLockSmithDto) {

        List<SdLockSmith> list = sdLockSmithService.findSdLockSmithList(sdLockSmithDto);
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
        SdLockSmith sdLockSmith = null;
        String filename = "";
        String subName = name.substring(0, 2);
        int id = Integer.parseInt(name.substring(2).trim());
        sdLockSmith = sdLockSmithService.findSdLockSmithById(id);
        if ("ic".equals(subName)) {
            filename =sdLockSmith.getIdcardphoto();
        }
        if ("bu".equals(subName)) {
            filename = sdLockSmith.getBusinessphoto();
        }
        if ("wo".equals(subName)) {
            filename = sdLockSmith.getWorkphoto();
        }
        if ("hc".equals(subName)) {
            filename =sdLockSmith.getHandcardphoto();
        }
        if ("ls".equals(subName)) {
            filename =sdLockSmith.getLocksmithphoto();
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
