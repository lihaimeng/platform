package com.yuxin.platform.zongzhiserver.seal.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 新印章业务显示统计页面
 *
 * @author dudong
 */
public class SubSealSydwDto {
    /**
     * 查询条件单位名称
     */
    private String dwmc;
    /**
     * 查询条件单位编码
     */
    private String dwbh;
    /**
     * 查询条件营业执照编号
     */
    /**
     * 查询条件管辖单位
     */
    private String gxdw;
    /**
     * 查询条件营业执照编号
     */
    private String yyzzbh;
    /**
     * 查询条件法人姓名
     */
    private String frxm;
    /**
     * 冗余字段
     */
    private Integer organizationId;
    /**
     * 查询条件法人证件号码
     */
    private String frzjhm;
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

    public String getGxdw() {
        return gxdw;
    }

    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    public String getYyzzbh() {
        return yyzzbh;
    }

    public void setYyzzbh(String yyzzbh) {
        this.yyzzbh = yyzzbh;
    }

    public String getFrxm() {
        return frxm;
    }

    public void setFrxm(String frxm) {
        this.frxm = frxm;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getFrzjhm() {
        return frzjhm;
    }

    public void setFrzjhm(String frzjhm) {
        this.frzjhm = frzjhm;
    }

    public Date getRegisterTimeStart() {
        return registerTimeStart;
    }

    public void setRegisterTimeStart(Date registerTimeStart) {
        this.registerTimeStart = registerTimeStart;
    }

    public Date getRegisterTimeEnd() {
        return registerTimeEnd;
    }

    public void setRegisterTimeEnd(Date registerTimeEnd) {
        this.registerTimeEnd = registerTimeEnd;
    }
}
