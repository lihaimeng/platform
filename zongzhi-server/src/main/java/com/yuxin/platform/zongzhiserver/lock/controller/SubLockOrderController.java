package com.yuxin.platform.zongzhiserver.lock.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuxin.platform.common.core.Result;
import com.yuxin.platform.common.core.ResultGenerator;
import com.yuxin.platform.common.model.SubLockOrder;
import com.yuxin.platform.common.model.SubSealOrder;
import com.yuxin.platform.zongzhiserver.lock.dto.SubLockOrderDto;
import com.yuxin.platform.zongzhiserver.lock.service.SubLockOrderService;
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
 * Created by jyh on 2018/05/31.
 */
@RestController
@RequestMapping("/sub/lock/order")
public class SubLockOrderController {
    @Resource
    private SubLockOrderService subLockOrderService;

    @ApiOperation(value = "综治子系统锁业业务信息添加以及批量处理文件上传", notes = "添加锁业业务信息，" +
            "request:SubLockOrderRequestDto，锁业业务信息实体：SubLockOrder;锁业业务信息附件：" +
            "由锁业信息附件组成的List， response:返回成功或者失败")
    @PostMapping("/add")
    public Result add(@RequestBody SubLockOrder subLockOrder) {
        subLockOrderService.insert(subLockOrder);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "综治子系统锁业业务信息添加以及批量处理文件上传", notes = "添加锁业业务信息，" +
            "request:SubLockOrderRequestDto，锁业业务信息实体：SubLockOrder;锁业业务信息附件：" +
            "由锁业信息附件组成的对象， response:返回成功或者失败")
    @PostMapping("/addLockOrder")
    public Result addLockOrder(@RequestBody SubLockOrder subLockOrder) throws Exception {
        int returnInt=subLockOrderService.addLockOrder(subLockOrder);
        if(returnInt==-1){
            return ResultGenerator.genFailResult("错误信息：订单号码已经存在。");
        }else{
            return ResultGenerator.genSuccessResult();
        }

    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        subLockOrderService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SubLockOrder subLockOrder) {
        subLockOrderService.update(subLockOrder);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SubLockOrder subLockOrder = subLockOrderService.findById(id);
        return ResultGenerator.genSuccessResult(subLockOrder);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SubLockOrder> list = subLockOrderService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/searchList")
    public List<SubLockOrder> searchList(@RequestBody SubLockOrderDto subLockOrderDto) {

        List<SubLockOrder> list = subLockOrderService.searchList(subLockOrderDto);
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
        SubLockOrder subLockOrder = null;
        String filename = "";
        String subName = name.substring(0, 2);
        int id = Integer.parseInt(name.substring(2).trim());
        subLockOrder = subLockOrderService.findById(id);
        if ("kr".equals(subName)) {
            filename =subLockOrder.getKszp();
        }
        if ("ks".equals(subName)) {
            filename = subLockOrder.getKsrzp();
        }
        if ("wt".equals(subName)) {
            filename = subLockOrder.getWtrzp();
        }
        if ("zm".equals(subName)) {
            filename =subLockOrder.getZmclzp();
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
