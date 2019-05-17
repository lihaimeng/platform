package com.yuxin.platform.zongzhiserver.seal.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 新印章业务显示统计页面
 *
 * @author dudong
 */
public class SubSealSealxxDto {

    /**
     * 查询条件使用单位名称
     */
    private String sydwmc;

    /**
     * 查询条件印章编码
     */
    private String yzbm;
    /**
     * 查询条件印章类型
     */
    private String yzlx;
    /**
     * 查询条件印章材料
     */
    private String yzcl;
    /**
     * 查询条件印章规格
     */
    private String yzgg;
    /**
     * 查询条件中心图案
     */
    private String zxta;
    /**
     * 查询条件印章形状
     */
    private String yzxz;
    /**
     * 冗余字段
     */
    private Integer organizationId;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 查询条件时间开始
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date registerTimeStart;
    /**
     * 查询条件时间结束
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date registerTimeEnd;

    public Date getRegisterTimeEnd() {
        return registerTimeEnd;
    }

    public void setRegisterTimeEnd(Date registerTimeEnd) {
        this.registerTimeEnd = registerTimeEnd;
    }


    public String getSydwmc() {

        return sydwmc;
    }

    public void setSydwmc(String sydwmc) {
        this.sydwmc = sydwmc;
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    public String getYzlx() {
        return yzlx;
    }

    public void setYzlx(String yzlx) {
        this.yzlx = yzlx;
    }

    public String getYzcl() {
        return yzcl;
    }

    public void setYzcl(String yzcl) {
        this.yzcl = yzcl;
    }

    public String getYzgg() {
        return yzgg;
    }

    public void setYzgg(String yzgg) {
        this.yzgg = yzgg;
    }

    public String getZxta() {
        return zxta;
    }

    public void setZxta(String zxta) {
        this.zxta = zxta;
    }

    public String getYzxz() {
        return yzxz;
    }

    public void setYzxz(String yzxz) {
        this.yzxz = yzxz;
    }

    public Date getRegisterTimeStart() {
        return registerTimeStart;
    }

    public void setRegisterTimeStart(Date registerTimeStart) {
        this.registerTimeStart = registerTimeStart;
    }
}
