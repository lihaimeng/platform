package com.yuxin.platform.common.controller;

import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.common.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;

/**
 * @author jyh
 * @create 2018-03-07-11:34
 */
@RestController
@RequestMapping("common")
public class AttachmentController {

    @Value("filePath")
    private String filePath;

    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    public HashMap upload(Attachments attachment, MultipartFile jarFile) {
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        try {
            String uploadedFileName = jarFile.getOriginalFilename();
            String fileName = System.currentTimeMillis() + jarFile.getOriginalFilename();
            String prefixStr = uploadedFileName.substring(uploadedFileName.lastIndexOf(".") + 1);
            String destFileName = courseFile + File.separator + "uploaded" + File.separator + fileName;

            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            jarFile.transferTo(destFile);

            attachment.setRealPath(destFileName);
            attachment.setFileType(prefixStr);
            attachment.setFileName(jarFile.getOriginalFilename());
            int len = attachmentService.insertSelective(attachment);
            if (len > 0) {
                hashMap.put("state", "OK");
                hashMap.put("filename", jarFile.getOriginalFilename());
                hashMap.put("newname", fileName);
                hashMap.put("file_type", prefixStr);
                hashMap.put("modelType", attachment.getTableName());
                hashMap.put("real_path", destFileName);
                return hashMap;
            }
        } catch (UnsupportedEncodingException e) {
            hashMap.put("state", "error");
            return hashMap;
        } catch (IOException e) {
            hashMap.put("state", "error");
            return hashMap;
        }
        return hashMap;
    }


    /**
     * 新增操作时的图片预览
     *
     * @param response
     * @param filename
     * @throws IOException
     */
    @RequestMapping(value = "images")
    public void images(HttpServletResponse response, String filename) throws IOException {
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String imagePath = courseFile + File.separator + "uploaded";
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

    /**
     * 修改、详情操作时的图片预览
     *
     * @param response
     * @param tableId
     * @param mark
     * @param tableName
     * @throws IOException
     */
    @RequestMapping(value = "/previeAndLoad")
    public void imagePreview(HttpServletResponse response, Integer tableId, String mark, String tableName) throws IOException {
        Attachments attachments = attachmentService.getAttachments(tableId, mark, tableName);
        String realPath = attachments.getRealPath();
        File file = new File(realPath);
        FileInputStream inputStream = new FileInputStream(
                realPath);
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

    /**
     * 附件下载
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/attachmentDownload")
    public void attachmentDownload(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String tableId = request.getParameter("tableId");
        String tableName = request.getParameter("tableName");
        String mark = request.getParameter("mark");
        Attachments attachments = new Attachments();
        attachments.setTableId(Integer.parseInt(tableId));
        attachments.setTableName(tableName);
        attachments.setMark(mark);
        try {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            attachments = attachmentService.getAttachment(attachments);
            if (attachments != null) {
                String realPath = attachments.getRealPath();
                String fileName = attachments.getFileName();
                if (realPath != null) {
                    File file = new File(realPath);
                    if (file.exists()) {
                        //response.setContentType("application/force-stream");
                        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
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
                        } catch (Exception e) {
                            response.getOutputStream().write("<b>下载异常，请<a href='javascript:history.back();'>返回</a></b>".getBytes());
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
            }
            response.getOutputStream().write("<b>该企业没有相应的文件信息！<a href='javascript:history.back();'>返回</a></b>".getBytes());
        } catch (Exception e) {
            response.getOutputStream().write("<b>页面异常，请<a href='javascript:history.back();'>返回</a></b>".getBytes());
        }

    }

    /**
     * 附件上传（单个文件版）
     *
     * @param file
     * @return 文件名称与上传状态码
     * @throws IOException
     */
    @RequestMapping(value = "/attachmentUpload")
    public HashMap attachmentUpload(@RequestParam("file") MultipartFile file) {

        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap hashMap = new HashMap();
        try {
            String uploadedFileName = file.getOriginalFilename();
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String prefixStr = uploadedFileName.substring(uploadedFileName.lastIndexOf(".") + 1);

            String destFileName = courseFile + File.separator + "uploaded" + File.separator + fileName;

            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);

            hashMap.put("state", "OK");
            hashMap.put("filename", file.getOriginalFilename());
            hashMap.put("newname", fileName);
            hashMap.put("file_type", prefixStr);
            hashMap.put("real_path", destFileName);


            return hashMap;
        } catch (FileNotFoundException e) {
            hashMap.put("state", "error");
            return hashMap;
        } catch (IOException e) {
            hashMap.put("state", "error");
            return hashMap;
        }
    }

}
