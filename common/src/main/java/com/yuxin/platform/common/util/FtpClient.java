package com.yuxin.platform.common.util;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * @author jyh
 * @create 2018-08-07-16:18
 */
public class FtpClient {

    public static void main(String[] args) throws FileNotFoundException {


        try {
            FileInputStream in=new FileInputStream(new File("e://Ribbon.pdf"));
            uploadFile("192.168.1.155", 21, "test", "123456", "/uploadFile",  "Ribbon.pdf", in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param url FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param path FTP服务器保存目录
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */

    public static boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) throws IOException {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);//连接FTP服务器
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            //创建路径
            try{
                ftp.makeDirectory(path);
            }catch(Exception e){
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.enterLocalPassiveMode();
            ftp.changeWorkingDirectory(path);
            boolean f= ftp.storeFile(filename, input);
           // System.out.println(f);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;  }


    }
