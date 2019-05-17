package com.yuxin.platform.zongzhi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Xk on 2018/3/1.
 */
public class Kyqk {
    private Integer kyqkid;//可疑情况id

    private Integer qyid;//企业id

    private String qymc;//企业名称

    private String hylb;//行业类别

    private String gxdwmc;//管辖单位名称

    private String gxdwbm;//管辖单位编码

    private String kyqklx;//可疑情况类型

    private String tbrbh;//填报人编号

    private String tbnr;//填报内容

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private String tbsj;//填报时间

    private String tbrxm;//填报人姓名

    private String ydxxms;//疑点详细描述

    private String jjrgh;//接警人工号

    private String jjrxm;//接警人姓名

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private String jjsj;//接警时间

    private String jjcljg;//接警处理结果

    private Short scbz;//0 正常 1删除 2修改

    private String clzt;//处理状态

    public Integer getKyqkid() {
        return kyqkid;
    }

    public void setKyqkid(Integer kyqkid) {
        this.kyqkid = kyqkid;
    }

    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    public String getKyqklx() {
        return kyqklx;
    }

    public void setKyqklx(String kyqklx) {
        this.kyqklx = kyqklx;
    }

    public String getTbrbh() {
        return tbrbh;
    }

    public void setTbrbh(String tbrbh) {
        this.tbrbh = tbrbh;
    }

    public String getTbnr() {
        return tbnr;
    }

    public void setTbnr(String tbnr) {
        this.tbnr = tbnr;
    }

    public String getTbsj() {
        return tbsj;
    }

    public void setTbsj(String tbsj) {
        this.tbsj = tbsj;
    }

    public String getTbrxm() {
        return tbrxm;
    }

    public void setTbrxm(String tbrxm) {
        this.tbrxm = tbrxm;
    }

    public String getYdxxms() {
        return ydxxms;
    }

    public void setYdxxms(String ydxxms) {
        this.ydxxms = ydxxms;
    }

    public String getJjrgh() {
        return jjrgh;
    }

    public void setJjrgh(String jjrgh) {
        this.jjrgh = jjrgh;
    }

    public String getJjrxm() {
        return jjrxm;
    }

    public void setJjrxm(String jjrxm) {
        this.jjrxm = jjrxm;
    }

    public String getJjsj() {
        return jjsj;
    }

    public void setJjsj(String jjsj) {
        this.jjsj = jjsj;
    }

    public String getJjcljg() {
        return jjcljg;
    }

    public void setJjcljg(String jjcljg) {
        this.jjcljg = jjcljg;
    }

    public Short getScbz() {
        return scbz;
    }

    public void setScbz(Short scbz) {
        this.scbz = scbz;
    }

    public String getClzt() {
        return clzt;
    }

    public void setClzt(String clzt) {
        this.clzt = clzt;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getHylb() {
        return hylb;
    }

    public void setHylb(String hylb) {
        this.hylb = hylb;
    }

    public String getGxdwmc() {
        return gxdwmc;
    }

    public void setGxdwmc(String gxdwmc) {
        this.gxdwmc = gxdwmc;
    }

    public String getGxdwbm() {
        return gxdwbm;
    }

    public void setGxdwbm(String gxdwbm) {
        this.gxdwbm = gxdwbm;
    }
}
