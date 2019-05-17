package com.yuxin.platform.subpublic.pojo;

public class QyryZp {
    private Integer qyid;

    private Integer ryid;

    private Integer zpid;

    private String tpmc;

    private String tplx;

    private byte[] tpnr;

    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    public Integer getRyid() {
        return ryid;
    }

    public void setRyid(Integer ryid) {
        this.ryid = ryid;
    }

    public Integer getZpid() {
        return zpid;
    }

    public void setZpid(Integer zpid) {
        this.zpid = zpid;
    }

    public String getTpmc() {
        return tpmc;
    }

    public void setTpmc(String tpmc) {
        this.tpmc = tpmc == null ? null : tpmc.trim();
    }

    public String getTplx() {
        return tplx;
    }

    public void setTplx(String tplx) {
        this.tplx = tplx == null ? null : tplx.trim();
    }

    public byte[] getTpnr() {
        return tpnr;
    }

    public void setTpnr(byte[] tpnr) {
        this.tpnr = tpnr;
    }
}