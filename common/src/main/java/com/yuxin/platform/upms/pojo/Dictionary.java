package com.yuxin.platform.upms.pojo;

import java.util.Date;

/**
 * @author zzd
 * <p>
 * 2018年3月11日
 */
public class Dictionary {
    //主键
    private Integer dictId;
    //父ID
    private String pdictId;
    //编码
    private String dicCode;
    //名称
    private String dicName;
    //类型 0 -条目 1 -词条
    private String dicType;
    //英文名称
    private String dicEngname;
    //备注
    private String dicNote;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //是否有效 1-有效 0-无效
    private String isvalidate;
    //是否显示
    private String display;
    //排列顺序
    private Integer orderby;


    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getPdictId() {
        return pdictId;
    }

    public void setPdictId(String pdictId) {
        this.pdictId = pdictId;
    }

    public String getDicCode() {
        return dicCode;
    }

    public void setDicCode(String dicCode) {
        this.dicCode = dicCode;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getDicEngname() {
        return dicEngname;
    }

    public void setDicEngname(String dicEngname) {
        this.dicEngname = dicEngname;
    }

    public String getDicNote() {
        return dicNote;
    }

    public void setDicNote(String dicNote) {
        this.dicNote = dicNote;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(String isvalidate) {
        this.isvalidate = isvalidate;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }
}