package com.yuxin.platform.common.mapper;

import com.yuxin.platform.common.model.Attachments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachmentsMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByWhere(Attachments record);

    int insert(Attachments record);

    int insertSelective(Attachments record);

    Attachments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attachments record);

    int updateByPrimaryKey(Attachments record);

    int updateByTableid(Attachments record);

    Attachments getAttachment(Attachments record);

    /**
     * 通过企业id和模块名称查询企业文件
     *
     * @param record
     * @return
     */
    List<Attachments> selectAttachments(Attachments record);

}