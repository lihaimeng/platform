package com.yuxin.platform.zongzhi.service.impl;

import com.yuxin.platform.zongzhi.mapper.SysAttachmentsMapper;
import com.yuxin.platform.zongzhi.pojo.SysAttachments;
import com.yuxin.platform.zongzhi.pojo.SysAttachmentsExample;
import com.yuxin.platform.zongzhi.service.SysAttachmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysAttachmentsServiceImpl implements SysAttachmentsService {
    @Autowired
    private SysAttachmentsMapper SysAttachmentsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return SysAttachmentsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysAttachments record) {
        return 0;
    }

    @Override
    public int insertSelective(SysAttachments record) {
        return SysAttachmentsMapper.insertSelective(record);
    }

    @Override
    public SysAttachments selectByPrimaryKey(Integer id) {
        return SysAttachmentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysAttachments> selectByExample(SysAttachmentsExample example) {
        return SysAttachmentsMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysAttachments record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysAttachments record) {
        return SysAttachmentsMapper.updateByPrimaryKey(record);
    }

}
