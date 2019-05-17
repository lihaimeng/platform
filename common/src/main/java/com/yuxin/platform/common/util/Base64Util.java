package com.yuxin.platform.common.util;

import org.apache.tomcat.util.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @author jyh
 * @create 2018-06-01-10:12
 */
public class Base64Util {

/*    public static void main(String[] args) {
        File file = new File("D:\\uploadFile\\subSealUpload\\sealOrderFile\\");
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        String newPath = "D:\\uploadFile\\subSealUpload\\sealOrderFile\\";
        String picPath = "D:1.jpg";
        String json = TestBase64.GenerateString(picPath);
        System.out.println("图片编码转字符串输出：" + json);
        TestBase64.GenerateImage(json, newPath + "newPic.jpg");
      *//*  String compressStr = Base64Utils.encode(ZipUtil.compress(json));
        System.out.println("压缩yyyy："+compressStr);*//*
     *//*  String deCompressStr = ZipUtil.decompress(Base64Utils.decode(compressStr));
        System.out.println("解压jjjj："+deCompressStr);*//*
    }*/

    /**
     * 加载本地文件,并转换为byte数组
     *
     * @return
     */
    public static byte[] loadFile(String picPath) {
        File file = new File(picPath);

        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        byte[] data = null;

        try {
            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream((int) file.length());

            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            data = baos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    fis = null;
                }

                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("解压前大小：" + data.length);
        return data;
    }

    public static String GenerateString(String picPath) {
        byte[] data = loadFile(picPath);
        //     System.out.println("解压后大小：" + data.length);
        String json = new String(Base64.encodeBase64(data));
        return json;
    }
    /**
     * 对byte[]进行压缩
     *
     * @param
     * @return 压缩后的数据
     */
    public static byte[] compress(byte[] data) {
        //   System.out.println("before:" + data.length);

        GZIPOutputStream gzip = null;
        ByteArrayOutputStream baos = null;
        byte[] newData = null;

        try {
            baos = new ByteArrayOutputStream();
            gzip = new GZIPOutputStream(baos);

            gzip.write(data);
            gzip.finish();
            gzip.flush();

            newData = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                gzip.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //       System.out.println("after:" + newData.length);
        return newData;
    }

    //编码转换图片
    public static boolean GenerateImage(String imgStr, String addr) {   //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) //图像数据为空
            return false;
        try {
            //Base64解码
            byte[] b = Base64.decodeBase64(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            String imgFilePath = addr;//新生成的图片地址
            OutputStream out = new FileOutputStream(addr);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

