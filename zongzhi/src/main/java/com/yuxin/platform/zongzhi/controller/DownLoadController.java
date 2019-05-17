package com.yuxin.platform.zongzhi.controller;

import com.yuxin.platform.zongzhi.pojo.SysAttachments;
import com.yuxin.platform.zongzhi.service.SysAttachmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dmxctb")
public class DownLoadController {

    @Autowired
    private SysAttachmentsService SysAttachmentsService;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String downloadFile(HttpServletResponse response, int id) {
        System.out.println("进入文件下载:" + id);

        SysAttachments sysAttachments = SysAttachmentsService.selectByPrimaryKey(id);
        System.out.println("sysAttachments 信息" + sysAttachments);

        //String fileName = "my.txt";// 设置文件名，根据业务需要替换成要下载的文件名
        String fileName = sysAttachments.getFileName();// 设置文件名，根据业务需要替换成要下载的文件名

        if (fileName != null) {
            //设置文件路径
            String realPath = sysAttachments.getRealPath();
            //String realPath = "D:\\myfile\\";

            File file = new File(realPath);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
