package com.yuxin.platform.zongzhiserver.lock.service.impl;

import com.yuxin.platform.common.core.AbstractService;
import com.yuxin.platform.common.mapper.AttachmentsMapper;
import com.yuxin.platform.common.model.SubLockOrder;
import com.yuxin.platform.common.util.Base64Util;
import com.yuxin.platform.common.util.FtpClient;
import com.yuxin.platform.common.util.GenerateUploadFilePath;
import com.yuxin.platform.zongzhiserver.lock.dto.SubLockOrderDto;
import com.yuxin.platform.zongzhiserver.lock.mapper.SubLockOrderMapper;
import com.yuxin.platform.zongzhiserver.lock.service.SubLockOrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;


/**
 * Created by jyh on 2018/05/31.
 */
@Service
@Transactional
public class SubLockOrderServiceImpl extends AbstractService<SubLockOrder> implements SubLockOrderService {
    @Resource
    private SubLockOrderMapper subLockOrderMapper;

    @Resource
    private AttachmentsMapper attachmentsMapper;

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
    public int addLockOrder(SubLockOrder subLockOrder) throws Exception {
        SubLockOrderDto subLockOrderDto = new SubLockOrderDto();
        subLockOrderDto.setDdh(subLockOrder.getDdh());
        subLockOrderDto.setGxdw("");
        List<SubLockOrder> list = subLockOrderMapper.searchList(subLockOrderDto);
        if (list != null && list.size() > 0) {
            return -1;
        }
        String path = GenerateUploadFilePath.generatePath("lock", "subLockOrder");
        File fileEmpty = new File("");
        if (subLockOrder.getKsrzp() != null && subLockOrder.getKsrzp().length() > 0) {
            String ksrzpName = GenerateUploadFilePath.generatePicName("ksrzp", "jpg");
            String realPathName = path + ksrzpName;//新生成带路径的开锁人图片名称
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(subLockOrder.getKsrzp(), fileName);
            subLockOrder.setKsrzp(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        if (subLockOrder.getKszp() != null && subLockOrder.getKszp().length() > 0) {
            String kszpName = GenerateUploadFilePath.generatePicName("kszp", "jpg");
            String realPathName = path + kszpName;//新生成带路径的开锁图片名称
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(subLockOrder.getKszp(), fileName);
            subLockOrder.setKszp(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        if (subLockOrder.getWtrzp() != null && subLockOrder.getWtrzp().length() > 0) {
            String wtrzpName = GenerateUploadFilePath.generatePicName("wtrzp", "jpg");
            String realPathName = path + wtrzpName;//新生成带路径的委托人图片名称
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(subLockOrder.getWtrzp(), fileName);
            subLockOrder.setWtrzp(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        if (subLockOrder.getZmclzp() != null && subLockOrder.getZmclzp().length() > 0) {
            String zmclzpName = GenerateUploadFilePath.generatePicName("zmclzp", "jpg");
            String realPathName = path + zmclzpName;//新生成带路径的证明材料图片名称
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(subLockOrder.getZmclzp(), fileName);
            subLockOrder.setZmclzp(realPathName);
            if (ftpopen){
                FileInputStream in=new FileInputStream(new File(fileName));
                FtpClient.uploadFile(ftpaddres,ftpport,ftpuser,ftppwd,ftpdir,realPathName,in);
            }
        }
        int flag = this.insert(subLockOrder);
        if (flag > 0) {
            return 0;
        }
        return 0;
    }

    @Transactional
    @Override
    public int insert(SubLockOrder subLockOrder) {
        // TODO Auto-generated method stub
        return subLockOrderMapper.insertSelective(subLockOrder);
    }


    @Override
    public List<SubLockOrder> searchList(SubLockOrderDto subLockOrderDto) {
        /*if (subLockOrderDto.getGxdw() == null || subLockOrderDto.getGxdw() == "") {
            subLockOrderDto.setGxdw("");
        }
        if (subLockOrderDto.getGxdw().indexOf("00") != -1) {
            String brevitycode = subLockOrderDto.getGxdw().substring(0, 4);
            subLockOrderDto.setGxdw(brevitycode);
        }*/


        if (subLockOrderDto.getGxdw() == null || subLockOrderDto.getGxdw() == "") {
            subLockOrderDto.setGxdw(subLockOrderDto.getOrganizationCode());
        } else {
            String brevitycode = subLockOrderDto.getGxdw();
            for (int i = 0; i < brevitycode.length() + 1; i++) {
                if (brevitycode.endsWith("00")) {
                    brevitycode = brevitycode.substring(0, brevitycode.length() - 2);
                }
            }
            subLockOrderDto.setGxdw(brevitycode);
        }
        return subLockOrderMapper.searchList(subLockOrderDto);
    }
}
