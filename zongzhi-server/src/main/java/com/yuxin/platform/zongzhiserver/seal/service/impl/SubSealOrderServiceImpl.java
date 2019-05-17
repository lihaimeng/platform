package com.yuxin.platform.zongzhiserver.seal.service.impl;

import com.yuxin.platform.common.core.AbstractService;
import com.yuxin.platform.common.dto.SubSealOrderRequestDto;
import com.yuxin.platform.common.mapper.AttachmentsMapper;
import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.common.model.SubSealOrder;
import com.yuxin.platform.common.model.SubSealSealxx;
import com.yuxin.platform.common.service.AttachmentService;
import com.yuxin.platform.common.util.Base64Util;
import com.yuxin.platform.common.util.GenerateUploadFilePath;
import com.yuxin.platform.zongzhiserver.seal.dto.SubSealOrderDto;
import com.yuxin.platform.zongzhiserver.seal.mapper.SubSealOrderMapper;
import com.yuxin.platform.zongzhiserver.seal.service.SubSealOrderService;
import com.yuxin.platform.zongzhiserver.seal.service.SubSealSealxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by jyh on 2018/05/14.
 */
@Service
@Transactional
public class SubSealOrderServiceImpl extends AbstractService<SubSealOrder> implements SubSealOrderService {
    @Resource
    private SubSealOrderMapper subSealOrderMapper;
    @Resource
    private SubSealSealxxService subSealSealxxService;
    @Autowired
    private AttachmentService attachmentService;
    @Override
    public List<SubSealOrder> selectSealOrderByParams(SubSealOrderDto subSealOrderDto) {
        if (subSealOrderDto.getGxdw() == null || subSealOrderDto.getGxdw() == "") {
            subSealOrderDto.setGxdw("");
        }
        if (subSealOrderDto.getGxdw().indexOf("00") != -1) {
            String brevitycode = subSealOrderDto.getGxdw().substring(0, 4);
            subSealOrderDto.setGxdw(brevitycode);
        }
        return subSealOrderMapper.selectSealOrderByParams(subSealOrderDto);
    }

    @Override
    public List<SubSealOrder> SelectSealxxDetails(String ddh) {
        return subSealOrderMapper.SelectSealxxDetails(ddh);
    }

    @Override
    public int addSealOlder(SubSealOrderRequestDto request) throws Exception {
        List<SubSealOrder> list = subSealOrderMapper.SelectSealxxDetails(request.getSubSealOrder().getDdh());
        if (list != null && list.size() > 0) {
            return 0;
        }
        String path = GenerateUploadFilePath.generatePath("seal", "subSealOrder");
        // Attachments attachments = new Attachments();
        if (request.getSubSealOrder().getJbrzp() != null && request.getSubSealOrder().getJbrzp().length() > 0) {
            String jbrzpName = GenerateUploadFilePath.generatePicName("jbrzp", "jpg");
            System.out.println("jbrzpName:" + jbrzpName);
            String realPathName = path + jbrzpName;//新生成带路径的经办人图片名称
            File fileEmpty = new File("");
            String fileName = fileEmpty.getCanonicalPath() + File.separator + "uploadFile" + File.separator + realPathName;
            Base64Util.GenerateImage(request.getSubSealOrder().getJbrzp(), fileName);
            request.getSubSealOrder().setJbrzp(realPathName);
            System.out.println("realPathName:" + realPathName);
          /*  attachments.setFileName(jbrzpName);
            attachments.setRealPath(realPathName);
            attachments.setMark("jbrzp");
            attachments.setFileType("jpg");*/
        }
        int flag = this.save(request.getSubSealOrder());

       /* attachments.setTableId(request.getSubSealOrder().getId());
        attachments.setTableName("subSealOrder");
        attachments.setCreater("admin");
        attachmentService.insertSelective(attachments);*/
        if (request.getSealxxList() != null && request.getSealxxList().size() > 0) {
            subSealSealxxService.addSubSealSealxx(request.getSealxxList());
        }
        if (flag > 0) return 1;
        return 0;
    }


}
