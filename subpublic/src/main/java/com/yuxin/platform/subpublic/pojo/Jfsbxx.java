package com.yuxin.platform.subpublic.pojo;

/**
 * 技防设备信息
 */
public class Jfsbxx {
    /**
     * 企业id
     */
    private Integer qyid;
    /**
     * 技防设备信息id
     */
    private Integer jfsbxxid;
    /**
     * 设备名称
     */
    private String sbmc;
    /**
     * 规格型号
     */
    private String ggxh;
    /**
     * 种类
     */
    private String zl;
    /**
     * 数量
     */
    private String sl;

    /**
     * 状态
     */
    private String zt;

    public Integer getJfsbxxid() {
        return jfsbxxid;
    }

    public void setJfsbxxid(Integer jfsbxxid) {
        this.jfsbxxid = jfsbxxid;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    public String getSbmc() {
        return sbmc;
    }

    public void setSbmc(String sbmc) {
        this.sbmc = sbmc == null ? null : sbmc.trim();
    }

    public String getGgxh() {
        return ggxh;
    }

    public void setGgxh(String ggxh) {
        this.ggxh = ggxh == null ? null : ggxh.trim();
    }

    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl == null ? null : zl.trim();
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl == null ? null : sl.trim();
    }
}