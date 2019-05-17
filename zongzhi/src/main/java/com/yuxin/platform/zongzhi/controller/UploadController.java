package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.zongzhi.pojo.SysAttachments;
import com.yuxin.platform.zongzhi.service.DmXctbService;
import com.yuxin.platform.zongzhi.service.SysAttachmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/dmxctb")
public class UploadController {
    @Value("${imagePath}")
    private String imagePath;

    @Autowired
    private SysAttachmentsService SysAttachmentsService;

    @Autowired
    private DmXctbService dmXctbService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(int state, @RequestParam("file") MultipartFile file, Model m) {
        System.out.println("进入上传 state:" + state);
        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            System.out.println("文件名：" + fileName);

            //String destFileName=req.getServletContext().getRealPath("")+"uploaded"+File.separator+fileName;
            String destFileName = imagePath + "uploaded" + File.separator + fileName;

            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);

            m.addAttribute("fileName", fileName);
            System.out.println("fileName:" + destFile);


            if (state == 0) { //状态0新增页面的文件上传，新增连接
                SysAttachments SysAttachments = new SysAttachments();
                SysAttachments.setFileName(fileName);
                SysAttachments.setTableName("dm_xctb");
                SysAttachments.setTableId(dmXctbService.selectLastid(1).getTbid());
                SysAttachments.setCreateDate(new Date());
                SysAttachments.setRealPath(imagePath + "uploaded" + File.separator);
                SysAttachmentsService.insertSelective(SysAttachments);
            } else {  //修改页面的上传，新增的TableId为前台修改页面传来的tableid
                SysAttachments SysAttachments = new SysAttachments();
                SysAttachments.setFileName(fileName);
                SysAttachments.setTableName("dm_xctb");
                SysAttachments.setTableId(state);
                SysAttachments.setCreateDate(new Date());
                SysAttachments.setRealPath(imagePath + "uploaded" + File.separator);
                SysAttachmentsService.insertSelective(SysAttachments);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "ok";
    }
}