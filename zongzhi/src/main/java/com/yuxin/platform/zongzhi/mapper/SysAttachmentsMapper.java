package com.yuxin.platform.zongzhi.mapper;

import com.yuxin.platform.zongzhi.pojo.SysAttachments;
import com.yuxin.platform.zongzhi.pojo.SysAttachmentsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysAttachmentsMapper {
    int countByExample(SysAttachmentsExample example);

    int deleteByExample(SysAttachmentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAttachments record);

    int insertSelective(SysAttachments record);

    List<SysAttachments> selectByExample(SysAttachmentsExample example);

    SysAttachments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAttachments record, @Param("example") SysAttachmentsExample example);

    int updateByExample(@Param("record") SysAttachments record, @Param("example") SysAttachmentsExample example);

    int updateByPrimaryKeySelective(SysAttachments record);

    int updateByPrimaryKey(SysAttachments record);


}