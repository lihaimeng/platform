package com.yuxin.platform.zongzhiserver.seal.service.impl;

import com.yuxin.platform.common.core.AbstractService;
import com.yuxin.platform.common.mapper.AttachmentsMapper;
import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.common.model.SubSealSydw;
import com.yuxin.platform.common.util.Base64Util;
import com.yuxin.platform.common.util.GenerateUploadFilePath;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealSydwDto;
import com.yuxin.platform.zongzhiserver.seal.mapper.SubSealSydwMapper;
import com.yuxin.platform.zongzhiserver.seal.service.SubSealSydwService;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by jyh on 2018/05/14.
 */
@Service
@Transactional
public class SubSealSydwServiceImpl extends AbstractService<SubSealSydw> implements SubSealSydwService {
    @Resource
    private SubSealSydwMapper subSealSydwMapper;
    @Resource
    private AttachmentsMapper attachmentsMapper;

    @Override
    public List<SubSealSydw> selectSealSydwByParams(SubSealSydwDto subSealSydwDto) {
        return subSealSydwMapper.selectSealSydwByParams(subSealSydwDto);
    }

    @Override
    public int addSubSealSydw(SubSealSydw subSealSydw) throws Exception {
        SubSealSydwDto subSealSydwDto = new SubSealSydwDto();
        subSealSydwDto.setDwbh(subSealSydw.getDwbh());
        List<SubSealSydw> list = subSealSydwMapper.selectSealSydwByParams(subSealSydwDto);
        if (list != null && list.size() > 0) {
            return 0;
        }
        String path = GenerateUploadFilePath.generatePath("seal", "subSealSydw");
        if (subSealSydw.getFrzp() != null && subSealSydw.getFrzp().length() > 0) {
            String frzpName = GenerateUploadFilePath.generatePicName("frzp", "jpg");
            String realPathName = path + frzpName;//新生成带路径的法人图片名称
            File fileEmpty = new File("");
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(subSealSydw.getFrzp(), fileName);
            subSealSydw.setFrzp(realPathName);
        }
        if (subSealSydw.getYyzzzp() != null && subSealSydw.getYyzzzp().length() > 0) {
            String yyzzzpName = GenerateUploadFilePath.generatePicName("yyzzzp", "jpg");
            String realPathName = path + yyzzzpName;//新生成带路径的营业执照图片名称
            File fileEmpty = new File("");
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(subSealSydw.getYyzzzp(), fileName);
            subSealSydw.setYyzzzp(realPathName);
        }

        int flag = this.save(subSealSydw);
        if (flag > 0) {
            return 1;
        }
        return 0;
    }


}
