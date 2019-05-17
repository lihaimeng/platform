package com.yuxin.platform.common.service;


import com.yuxin.platform.common.model.Attachments;

import java.util.List;

/**
 * 附件相关操作Service
 *
 * @param tableId
 * @param mark
 * @param tableName 2018年3月8日
 * @author zzd
 */
public interface AttachmentService {
    Attachments getAttachments(Integer tableId, String mark, String tableName);

    /**
     * 查询attachments对象
     *
     * @param attachments
     * @return
     */
    Attachments getAttachment(Attachments attachments);

    /**
     * 通过企业id和模块名称查询企业文件
     *
     * @param attachments
     * @return
     */
    List<Attachments> selectAttachments(Attachments attachments);

    int insertSelective(Attachments record);

    Attachments selectByPrimaryKey(Integer id);
}
