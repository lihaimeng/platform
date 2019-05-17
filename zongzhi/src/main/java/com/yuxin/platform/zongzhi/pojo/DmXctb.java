package com.yuxin.platform.zongzhi.pojo;

import java.util.Date;

public class DmXctb {
    private Integer tbid;//通报ID

    private String bt;//标题

    private Date fbsj;//发布时间

    private String fbnr;//发布内容

    private String fbr;//发布人

    private String fbdwbm;//发布单位编码

    private String fbdw;//发布单位

    private Date jzrq;//截止日期

    private String gqbs;//过期标识

    private String sxhylbdm;//所选行业类别代码

    private String sxhylbmc;//所选行业类别名称

    private Long ytbid;//原通报ID

    private String sbzt;//

    public Integer getTbid() {
        return tbid;
    }

    public void setTbid(Integer tbid) {
        this.tbid = tbid;
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt == null ? null : bt.trim();
    }

    public Date getFbsj() {
        return fbsj;
    }

    public void setFbsj(Date fbsj) {
        this.fbsj = fbsj;
    }

    public String getFbnr() {
        return fbnr;
    }

    public void setFbnr(String fbnr) {
        this.fbnr = fbnr == null ? null : fbnr.trim();
    }

    public String getFbr() {
        return fbr;
    }

    public void setFbr(String fbr) {
        this.fbr = fbr == null ? null : fbr.trim();
    }

    public String getFbdwbm() {
        return fbdwbm;
    }

    public void setFbdwbm(String fbdwbm) {
        this.fbdwbm = fbdwbm == null ? null : fbdwbm.trim();
    }

    public String getFbdw() {
        return fbdw;
    }

    public void setFbdw(String fbdw) {
        this.fbdw = fbdw == null ? null : fbdw.trim();
    }

    public Date getJzrq() {
        return jzrq;
    }

    public void setJzrq(Date jzrq) {
        this.jzrq = jzrq;
    }

    public String getGqbs() {
        return gqbs;
    }

    public void setGqbs(String gqbs) {
        this.gqbs = gqbs == null ? null : gqbs.trim();
    }

    public String getSxhylbdm() {
        return sxhylbdm;
    }

    public void setSxhylbdm(String sxhylbdm) {
        this.sxhylbdm = sxhylbdm == null ? null : sxhylbdm.trim();
    }

    public String getSxhylbmc() {
        return sxhylbmc;
    }

    public void setSxhylbmc(String sxhylbmc) {
        this.sxhylbmc = sxhylbmc == null ? null : sxhylbmc.trim();
    }

    public Long getYtbid() {
        return ytbid;
    }

    public void setYtbid(Long ytbid) {
        this.ytbid = ytbid;
    }

    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt == null ? null : sbzt.trim();
    }

    @Override
    public String toString() {
        return "DmXctb{" +
                "tbid=" + tbid +
                ", bt='" + bt + '\'' +
                ", fbsj=" + fbsj +
                ", fbnr='" + fbnr + '\'' +
                ", fbr='" + fbr + '\'' +
                ", fbdwbm='" + fbdwbm + '\'' +
                ", fbdw='" + fbdw + '\'' +
                ", jzrq=" + jzrq +
                ", gqbs='" + gqbs + '\'' +
                ", sxhylbdm='" + sxhylbdm + '\'' +
                ", sxhylbmc='" + sxhylbmc + '\'' +
                ", ytbid=" + ytbid +
                ", sbzt='" + sbzt + '\'' +
                '}';
    }
}