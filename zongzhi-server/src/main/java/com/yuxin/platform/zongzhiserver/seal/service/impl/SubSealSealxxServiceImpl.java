package com.yuxin.platform.zongzhiserver.seal.service.impl;

import com.yuxin.platform.common.core.AbstractService;
import com.yuxin.platform.common.model.SubSealSealxx;
import com.yuxin.platform.common.util.Base64Util;
import com.yuxin.platform.common.util.GenerateUploadFilePath;
import com.yuxin.platform.zongzhiserver.seal.dto.ResultSubSealOrderDto;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealSealxxDto;
import com.yuxin.platform.zongzhiserver.seal.mapper.SubSealSealxxMapper;
import com.yuxin.platform.zongzhiserver.seal.service.SubSealSealxxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;


/**
 * Created by jyh on 2018/05/14.
 */
@Service
@Transactional
public class SubSealSealxxServiceImpl extends AbstractService<SubSealSealxx> implements SubSealSealxxService {
    @Resource
    private SubSealSealxxMapper subSealSealxxMapper;

    @Override
    public List<SubSealSealxx> selectSealSealxxByParams(SubSealSealxxDto subSealSealxxDto) {
        return subSealSealxxMapper.selectSealSealxxByParams(subSealSealxxDto);
    }

    @Override
    public List<ResultSubSealOrderDto> sealxxAndSubSealOrderDetails(SubSealSealxxDto subSealSealxxDto) {
        return subSealSealxxMapper.sealxxAndSubSealOrderDetails(subSealSealxxDto);
    }


    @Override
    public int addSubSealSealxx(List<SubSealSealxx> subSealSealxxList) throws Exception {
        for (SubSealSealxx subSealSealxx : subSealSealxxList) {
            if (subSealSealxx.getYmldzp() != null && subSealSealxx.getYmldzp().length() > 0) {
                String path = GenerateUploadFilePath.generatePath("seal", "subSealXx");
                String ymldzpName = GenerateUploadFilePath.generatePicName("ymldzp", "jpg");
                String realPathName = path + ymldzpName;//新生成带路径的图片名称
                File fileEmpty = new File("");
                String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
                Base64Util.GenerateImage(subSealSealxx.getYmldzp(), fileName);
                subSealSealxx.setYmldzp(realPathName);
                this.save(subSealSealxx);
            }
        }
        return 0;
    }


}

