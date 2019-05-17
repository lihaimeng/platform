package com.yuxin.platform.zongzhiserver.lock.service.impl;

import com.yuxin.platform.common.util.Base64Util;
import com.yuxin.platform.common.util.GenerateUploadFilePath;
import com.yuxin.platform.common.util.FtpClient;
import com.yuxin.platform.zongzhiserver.lock.dto.SdLockSmithDto;
import com.yuxin.platform.zongzhiserver.lock.mapper.SdLockSmithMapper;
import com.yuxin.platform.zongzhiserver.lock.model.SdLockSmith;
import com.yuxin.platform.zongzhiserver.lock.service.SdLockSmithService;
import com.yuxin.platform.common.core.AbstractService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;


/**
 * Created by jyh on 2018/08/02.
 */
@Service
@Transactional
public class SdLockSmithServiceImpl implements SdLockSmithService {
    @Resource
    private SdLockSmithMapper sdLocksmithMapper;

    @Value("${ftpopen}")
    private  boolean  ftpopen;

    @Value("${ftpaddres}")
    private  String ftpaddres;

    @Value("${ftpport}")
    private  int ftpport;

    @Value("${ftpuser}")
    private  String ftpuser;

    @Value("${ftppwd}")
    private  String ftppwd;

    @Value("${ftpdir}")
    private  String ftpdir;

    @Override
    public int addSdLockSmith(SdLockSmith sdLockSmith) throws Exception {

        SdLockSmith getsdLockSmith=sdLocksmithMapper.findSdLocksmithByIdcard(sdLockSmith.getIdcard());
        if(getsdLockSmith!=null){
            return 0;
        }
        String path = GenerateUploadFilePath.generatePath("SDlock", "sdLockSmith");
        File fileEmpty = new File("");
        if (sdLockSmith.getLocksmithphoto() != null && sdLockSmith.getLocksmithphoto().length() > 0) {
            String locksmithName = GenerateUploadFilePath.generatePicName("locksmith", "jpg");
            String realPathName = path + locksmithName;
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(sdLockSmith.getLocksmithphoto(), fileName);
            sdLockSmith.setLocksmithphoto(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        if (sdLockSmith.getIdcardphoto() != null && sdLockSmith.getIdcardphoto().length() > 0) {
            String idcardName = GenerateUploadFilePath.generatePicName("idcard", "jpg");
            String realPathName = path + idcardName;
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(sdLockSmith.getIdcardphoto(), fileName);
            sdLockSmith.setIdcardphoto(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        if (sdLockSmith.getWorkphoto() != null && sdLockSmith.getWorkphoto().length() > 0) {
            String workName = GenerateUploadFilePath.generatePicName("work", "jpg");
            String realPathName = path + workName;
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(sdLockSmith.getWorkphoto(), fileName);
            sdLockSmith.setWorkphoto(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        if (sdLockSmith.getBusinessphoto() != null && sdLockSmith.getBusinessphoto().length() > 0) {
            String bussinessName = GenerateUploadFilePath.generatePicName("bussiness", "jpg");
            String realPathName = path + bussinessName;
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(sdLockSmith.getBusinessphoto(), fileName);
            sdLockSmith.setBusinessphoto(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        if (sdLockSmith.getHandcardphoto() != null && sdLockSmith.getHandcardphoto().length() > 0) {
            String handcardName = GenerateUploadFilePath.generatePicName("handcard", "jpg");
            String realPathName = path + handcardName;
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(sdLockSmith.getHandcardphoto(), fileName);
            sdLockSmith.setHandcardphoto(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        sdLocksmithMapper.insertSelective(sdLockSmith);
        return 1;
    }

    @Override
    public List<SdLockSmith> findSdLockSmithList(SdLockSmithDto sdLockSmithDto) {
        if (sdLockSmithDto.getGxdw() == null || sdLockSmithDto.getGxdw() == "") {
            sdLockSmithDto.setGxdw(sdLockSmithDto.getOrganizationCode());
        } else {
            String brevitycode = sdLockSmithDto.getGxdw();
            for (int i = 0; i < brevitycode.length() + 1; i++) {
                if (brevitycode.endsWith("00")) {
                    brevitycode = brevitycode.substring(0, brevitycode.length() - 2);
                }
            }
            sdLockSmithDto.setGxdw(brevitycode);
        }
        return sdLocksmithMapper.findSdLockSmithList(sdLockSmithDto);
    }

    @Override
    public SdLockSmith findSdLockSmithById(int id) {
        return sdLocksmithMapper.findSdLockSmithById(id);
    }
}

