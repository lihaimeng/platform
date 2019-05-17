package com.yuxin.platform.zongzhi.pojo;

import java.util.Date;

public class SysAttachments {
    private Integer id;

    private String tableName;

    private Integer tableId;

    private String fileType;

    private String fileName;

    private String realPath;

    private String mark;

    private String creater;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath == null ? null : realPath.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "SysAttachments{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", tableId=" + tableId +
                ", fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", realPath='" + realPath + '\'' +
                ", mark='" + mark + '\'' +
                ", creater='" + creater + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}