package com.yuxin.platform.common.util;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public class GenerateUploadFilePath {

    /**
     * 自动生成上传文件路径
     *
     * @param modelName 模块名称
     * @param tableName 实体（表）名称
     * @return
     */
    public static String generatePath(String modelName, String tableName) throws Exception {
        File files = new File("");
        String path1 = files.getCanonicalPath() + File.separator + "uploadFile" + File.separator;
        String path2 = modelName + "_uploadFile" + File.separator;
        String path3 = tableName + "_uploadFile" + File.separator;
        String path = path1 + path2 + path3;
        String path4 = path2 + path3;
        File file = new File(path);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        System.out.println("新生成路径：" + path);
        return path4;
    }

    /**
     * 自动生成上传图片的名称
     *
     * @param suffName 前缀
     * @param type     图片类型(jpg,png......)
     * @return
     */
    public static String generatePicName(String suffName, String type) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String name = suffName + uuid + "." + type;
        return name;
    }
}
