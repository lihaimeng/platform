package com.yuxin.platform.zongzhi.service;


import com.yuxin.platform.zongzhi.pojo.SysAttachments;
import com.yuxin.platform.zongzhi.pojo.SysAttachmentsExample;

import java.util.List;

public interface SysAttachmentsService {

    int deleteByPrimaryKey(Integer id);

    int insert(SysAttachments record);

    int insertSelective(SysAttachments record);

    SysAttachments selectByPrimaryKey(Integer id);

    List<SysAttachments> selectByExample(SysAttachmentsExample example);

    int updateByPrimaryKeySelective(SysAttachments record);

    int updateByPrimaryKey(SysAttachments record);


}
