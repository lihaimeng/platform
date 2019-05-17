package com.yuxin.platform.subpublic.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//保安人员信息
public class Baryxx {
    private Integer qyid;//企业id

    private Integer baryid;//保安人员id

    private String xm;//姓名

    private String xbdm;//性别代码

    private String xb;//性别

    private Date csrq;//出生日期

    private String gmsfhm;//身份证号

    private String hjdxzqhdm;//户籍地行政区划代码

    private String hjdxzqh;//户籍地行政区划

    private String hjdxz;//户籍地详址

    private String balxbm;//保安类型编码

    private String balx;//保安类型

    private String fzjg;//发证机构

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date sgrq;//上岗日期

    private String lzyy;//离职原因

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date lzrq;//离职日期

    private String bz;//备注

    private String zt;//状态

    private String lrr;//录入人

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date lrsj;//录入时间

    private String jg;//籍贯

    private String lxfs;//联系方式

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs;
    }

    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    public Integer getBaryid() {
        return baryid;
    }

    public void setBaryid(Integer baryid) {
        this.baryid = baryid;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getXbdm() {
        return xbdm;
    }

    public void setXbdm(String xbdm) {
        this.xbdm = xbdm == null ? null : xbdm.trim();
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getGmsfhm() {
        return gmsfhm;
    }

    public void setGmsfhm(String gmsfhm) {
        this.gmsfhm = gmsfhm == null ? null : gmsfhm.trim();
    }

    public String getHjdxzqhdm() {
        return hjdxzqhdm;
    }

    public void setHjdxzqhdm(String hjdxzqhdm) {
        this.hjdxzqhdm = hjdxzqhdm == null ? null : hjdxzqhdm.trim();
    }

    public String getHjdxzqh() {
        return hjdxzqh;
    }

    public void setHjdxzqh(String hjdxzqh) {
        this.hjdxzqh = hjdxzqh == null ? null : hjdxzqh.trim();
    }

    public String getHjdxz() {
        return hjdxz;
    }

    public void setHjdxz(String hjdxz) {
        this.hjdxz = hjdxz == null ? null : hjdxz.trim();
    }

    public String getBalxbm() {
        return balxbm;
    }

    public void setBalxbm(String balxbm) {
        this.balxbm = balxbm == null ? null : balxbm.trim();
    }

    public String getBalx() {
        return balx;
    }

    public void setBalx(String balx) {
        this.balx = balx == null ? null : balx.trim();
    }

    public String getFzjg() {
        return fzjg;
    }

    public void setFzjg(String fzjg) {
        this.fzjg = fzjg == null ? null : fzjg.trim();
    }

    public Date getSgrq() {
        return sgrq;
    }

    public void setSgrq(Date sgrq) {
        this.sgrq = sgrq;
    }

    public String getLzyy() {
        return lzyy;
    }

    public void setLzyy(String lzyy) {
        this.lzyy = lzyy == null ? null : lzyy.trim();
    }

    public Date getLzrq() {
        return lzrq;
    }

    public void setLzrq(Date lzrq) {
        this.lzrq = lzrq;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr == null ? null : lrr.trim();
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }
}