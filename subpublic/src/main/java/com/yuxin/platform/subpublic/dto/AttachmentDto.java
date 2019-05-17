package com.yuxin.platform.subpublic.dto;

import java.util.List;

/**
 * 附件dto对象
 *
 * @author wj
 */
public class AttachmentDto {
    /**
     * 企业id
     */
    private Integer qyid;
    /**
     * 模块名称
     */
    private String mkmc;
    /**
     * 文件对象（文件名，文件类型，文件路径，文件标志）
     */
    private List<FileDto> fileDtoList;

    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    public String getMkmc() {
        return mkmc;
    }

    public void setMkmc(String mkmc) {
        this.mkmc = mkmc;
    }

    public List<FileDto> getFileDtoList() {
        return fileDtoList;
    }

    public void setFileDtoList(List<FileDto> fileDtoList) {
        this.fileDtoList = fileDtoList;
    }
}
