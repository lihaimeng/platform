package com.yuxin.platform.common.service.impl;

import com.yuxin.platform.common.mapper.AttachmentsMapper;
import com.yuxin.platform.common.model.Attachments;
import com.yuxin.platform.common.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzd
 * @Date 2018年3月8日
 * FileName: AttachmentServiceImpl.java
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentsMapper attachmentsMapper;

    @Override
    public Attachments getAttachments(Integer tableId, String mark, String tableName) {
        // TODO Auto-generated method stub
        Attachments record = new Attachments();
        if (tableId != null && tableName != null) {
            record.setTableId(tableId);
            record.setTableName(tableName);
            if (mark != null && !"".equals(mark)) {
                record.setMark(mark);
            }
            record = attachmentsMapper.getAttachment(record);
        }
        return record;
    }

    /**
     * 查询attachments对象
     *
     * @param attachments
     * @return
     */
    @Override
    public Attachments getAttachment(Attachments attachments) {
        return attachmentsMapper.getAttachment(attachments);
    }

    @Override
    public List<Attachments> selectAttachments(Attachments attachments) {
        return attachmentsMapper.selectAttachments(attachments);
    }

    @Override
    public int insertSelective(Attachments record) {
        return attachmentsMapper.insertSelective(record);
    }

    @Override
    public Attachments selectByPrimaryKey(Integer id) {
        return attachmentsMapper.selectByPrimaryKey(id);
    }
}
