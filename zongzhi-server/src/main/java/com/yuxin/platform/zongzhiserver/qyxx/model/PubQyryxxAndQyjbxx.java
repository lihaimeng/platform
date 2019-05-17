package com.yuxin.platform.zongzhiserver.qyxx.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pub_qyryxx")
public class PubQyryxxAndQyjbxx {
    private Integer qyid;//企业id

    private Integer ryid;//人员id

    private String hylbdm;//行业类别代码

    private String hylb;//行业类别

    private String cyrybh;//从业人员编号

    private String cyrylbdm;//从业人员类别代码

    private String cyrylbmc;//从业人员类别名称

    private String xm;//姓名

    private String qm;//全名

    private String bm;//别名

    private String xmpy;//姓名拼音

    private String gjdm;//国籍代码

    private String gj;//国籍

    private String mzdm;//民族代码

    private String minzu;//民族

    private String xbdm;//性别代码

    private String xb;//性别

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date csrq;//出生日期

    private String hyzkdm;//婚姻状况代码

    private String hyzk;//婚姻状况

    private BigDecimal shengao;//身高

    private BigDecimal tizh;//体重

    private String hjdxzqh;//户籍地行政区划

    private String hjdxzqhdm;//户籍地行政区划代码

    private String hjdxz;//户籍地详址

    private String cyzjdm;//常用证件代码

    private String cyzj;//常用证件

    private String zjhm;//证件号码

    private String zzzhm;//暂住证号码

    private String zzdz;//暂住地址

    private String gwbh;//岗位编号

    private String gwmc;//岗位名称

    private String gwzrms;//岗位责任描述

    private String shouji;//手机

    private String lxdh;//联系电话

    private String jjlxr;//紧急联系人

    private String jjlxrdh;//紧急联系人电话

    private String gzdm;//工种代码

    private String gz;//工种

    private String zhiwu;//职务

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date rzrq;//入职日期

    private String cyryztdm;//从业人员状态代码

    private String cyryzt;//从业人员状态

    private String zxr;//撤销人

    private String zxbz;//注销标志

    private Date zxsj;//撤销时间

    private Date lrsj;//录入时间

    private String lrr;//录入人

    private String lrdwbm;//录入单位编码

    private String lrdwmc;//录入单位名称

    private String hcdw;//核查单位

    private String hcr;//核查人

    private Date hcsj;//核查时间

    private String zxyy;//注销时间

    private String zkzt;//制卡状态

    private Date bcsj;//保存时间

    private Short dcbs;//导出标识 0 未导出 1已导出

    private String bz;//备注

    private Short scbz;//0 正常 1删除 2修改

    private String biduiflag;//比对标志

    private String zpwtgyy;//照片未通过原因

    private String zt;//状态

    private Date lzrq;//离职日期

    private String xxdm;//血型代码

    private String xx;//血型

    private String cylbdm;//从业人员类别代码

    private String cylb;//从业人员类别名称

    private String whcddm;//文化程度代码

    private String whcd;//文化程度

    private String yjbz;//预警代码

    private Date yjsj;//预警时间

    private String xzdxzqh;//现住地行政区划

    private String xzdxzqhdm;//现住地行政区划代码

    private Date djrq;//登记时期

    private String hjlbdm;//户籍类别代码

    private String hjlbmc;//户籍类别名称

    private String zzmmdm;//政治面貌代码

    private String zzmmmc;//政治面貌名称

    private String sbzt;//开发webservice上报时增加

    private String zyjnzsh;//

    private String kdywyzyzgzhm;//快递业务职业资格证号码

    private String sfyspk;//是否有simpass卡

    private String qymc;
    private String ssdxjgajgmc;
    private String ssdxjgajgdm;
    private String qybm;

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

    public String getHylbdm() {
        return hylbdm;
    }

    public void setHylbdm(String hylbdm) {
        this.hylbdm = hylbdm == null ? null : hylbdm.trim();
    }

    public String getHylb() {
        return hylb;
    }

    public void setHylb(String hylb) {
        this.hylb = hylb == null ? null : hylb.trim();
    }

    public String getCyrybh() {
        return cyrybh;
    }

    public void setCyrybh(String cyrybh) {
        this.cyrybh = cyrybh == null ? null : cyrybh.trim();
    }

    public String getCyrylbdm() {
        return cyrylbdm;
    }

    public void setCyrylbdm(String cyrylbdm) {
        this.cyrylbdm = cyrylbdm == null ? null : cyrylbdm.trim();
    }

    public String getCyrylbmc() {
        return cyrylbmc;
    }

    public void setCyrylbmc(String cyrylbmc) {
        this.cyrylbmc = cyrylbmc == null ? null : cyrylbmc.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getQm() {
        return qm;
    }

    public void setQm(String qm) {
        this.qm = qm == null ? null : qm.trim();
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm == null ? null : bm.trim();
    }

    public String getXmpy() {
        return xmpy;
    }

    public void setXmpy(String xmpy) {
        this.xmpy = xmpy == null ? null : xmpy.trim();
    }

    public String getGjdm() {
        return gjdm;
    }

    public void setGjdm(String gjdm) {
        this.gjdm = gjdm == null ? null : gjdm.trim();
    }

    public String getGj() {
        return gj;
    }

    public void setGj(String gj) {
        this.gj = gj == null ? null : gj.trim();
    }

    public String getMzdm() {
        return mzdm;
    }

    public void setMzdm(String mzdm) {
        this.mzdm = mzdm == null ? null : mzdm.trim();
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu == null ? null : minzu.trim();
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

    public String getHyzkdm() {
        return hyzkdm;
    }

    public void setHyzkdm(String hyzkdm) {
        this.hyzkdm = hyzkdm == null ? null : hyzkdm.trim();
    }

    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk == null ? null : hyzk.trim();
    }

    public BigDecimal getShengao() {
        return shengao;
    }

    public void setShengao(BigDecimal shengao) {
        this.shengao = shengao;
    }

    public BigDecimal getTizh() {
        return tizh;
    }

    public void setTizh(BigDecimal tizh) {
        this.tizh = tizh;
    }

    public String getHjdxzqh() {
        return hjdxzqh;
    }

    public void setHjdxzqh(String hjdxzqh) {
        this.hjdxzqh = hjdxzqh == null ? null : hjdxzqh.trim();
    }

    public String getHjdxzqhdm() {
        return hjdxzqhdm;
    }

    public void setHjdxzqhdm(String hjdxzqhdm) {
        this.hjdxzqhdm = hjdxzqhdm == null ? null : hjdxzqhdm.trim();
    }

    public String getHjdxz() {
        return hjdxz;
    }

    public void setHjdxz(String hjdxz) {
        this.hjdxz = hjdxz == null ? null : hjdxz.trim();
    }

    public String getCyzjdm() {
        return cyzjdm;
    }

    public void setCyzjdm(String cyzjdm) {
        this.cyzjdm = cyzjdm == null ? null : cyzjdm.trim();
    }

    public String getCyzj() {
        return cyzj;
    }

    public void setCyzj(String cyzj) {
        this.cyzj = cyzj == null ? null : cyzj.trim();
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm == null ? null : zjhm.trim();
    }

    public String getZzzhm() {
        return zzzhm;
    }

    public void setZzzhm(String zzzhm) {
        this.zzzhm = zzzhm == null ? null : zzzhm.trim();
    }

    public String getZzdz() {
        return zzdz;
    }

    public void setZzdz(String zzdz) {
        this.zzdz = zzdz == null ? null : zzdz.trim();
    }

    public String getGwbh() {
        return gwbh;
    }

    public void setGwbh(String gwbh) {
        this.gwbh = gwbh == null ? null : gwbh.trim();
    }

    public String getGwmc() {
        return gwmc;
    }

    public void setGwmc(String gwmc) {
        this.gwmc = gwmc == null ? null : gwmc.trim();
    }

    public String getGwzrms() {
        return gwzrms;
    }

    public void setGwzrms(String gwzrms) {
        this.gwzrms = gwzrms == null ? null : gwzrms.trim();
    }

    public String getShouji() {
        return shouji;
    }

    public void setShouji(String shouji) {
        this.shouji = shouji == null ? null : shouji.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getJjlxr() {
        return jjlxr;
    }

    public void setJjlxr(String jjlxr) {
        this.jjlxr = jjlxr == null ? null : jjlxr.trim();
    }

    public String getJjlxrdh() {
        return jjlxrdh;
    }

    public void setJjlxrdh(String jjlxrdh) {
        this.jjlxrdh = jjlxrdh == null ? null : jjlxrdh.trim();
    }

    public String getGzdm() {
        return gzdm;
    }

    public void setGzdm(String gzdm) {
        this.gzdm = gzdm == null ? null : gzdm.trim();
    }

    public String getGz() {
        return gz;
    }

    public void setGz(String gz) {
        this.gz = gz == null ? null : gz.trim();
    }

    public String getZhiwu() {
        return zhiwu;
    }

    public void setZhiwu(String zhiwu) {
        this.zhiwu = zhiwu == null ? null : zhiwu.trim();
    }

    public Date getRzrq() {
        return rzrq;
    }

    public void setRzrq(Date rzrq) {
        this.rzrq = rzrq;
    }

    public String getCyryztdm() {
        return cyryztdm;
    }

    public void setCyryztdm(String cyryztdm) {
        this.cyryztdm = cyryztdm == null ? null : cyryztdm.trim();
    }

    public String getCyryzt() {
        return cyryzt;
    }

    public void setCyryzt(String cyryzt) {
        this.cyryzt = cyryzt == null ? null : cyryzt.trim();
    }

    public String getZxr() {
        return zxr;
    }

    public void setZxr(String zxr) {
        this.zxr = zxr == null ? null : zxr.trim();
    }

    public String getZxbz() {
        return zxbz;
    }

    public void setZxbz(String zxbz) {
        this.zxbz = zxbz == null ? null : zxbz.trim();
    }

    public Date getZxsj() {
        return zxsj;
    }

    public void setZxsj(Date zxsj) {
        this.zxsj = zxsj;
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr == null ? null : lrr.trim();
    }

    public String getLrdwbm() {
        return lrdwbm;
    }

    public void setLrdwbm(String lrdwbm) {
        this.lrdwbm = lrdwbm == null ? null : lrdwbm.trim();
    }

    public String getLrdwmc() {
        return lrdwmc;
    }

    public void setLrdwmc(String lrdwmc) {
        this.lrdwmc = lrdwmc == null ? null : lrdwmc.trim();
    }

    public String getHcdw() {
        return hcdw;
    }

    public void setHcdw(String hcdw) {
        this.hcdw = hcdw == null ? null : hcdw.trim();
    }

    public String getHcr() {
        return hcr;
    }

    public void setHcr(String hcr) {
        this.hcr = hcr == null ? null : hcr.trim();
    }

    public Date getHcsj() {
        return hcsj;
    }

    public void setHcsj(Date hcsj) {
        this.hcsj = hcsj;
    }

    public String getZxyy() {
        return zxyy;
    }

    public void setZxyy(String zxyy) {
        this.zxyy = zxyy == null ? null : zxyy.trim();
    }

    public String getZkzt() {
        return zkzt;
    }

    public void setZkzt(String zkzt) {
        this.zkzt = zkzt == null ? null : zkzt.trim();
    }

    public Date getBcsj() {
        return bcsj;
    }

    public void setBcsj(Date bcsj) {
        this.bcsj = bcsj;
    }

    public Short getDcbs() {
        return dcbs;
    }

    public void setDcbs(Short dcbs) {
        this.dcbs = dcbs;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Short getScbz() {
        return scbz;
    }

    public void setScbz(Short scbz) {
        this.scbz = scbz;
    }

    public String getBiduiflag() {
        return biduiflag;
    }

    public void setBiduiflag(String biduiflag) {
        this.biduiflag = biduiflag == null ? null : biduiflag.trim();
    }

    public String getZpwtgyy() {
        return zpwtgyy;
    }

    public void setZpwtgyy(String zpwtgyy) {
        this.zpwtgyy = zpwtgyy == null ? null : zpwtgyy.trim();
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }

    public Date getLzrq() {
        return lzrq;
    }

    public void setLzrq(Date lzrq) {
        this.lzrq = lzrq;
    }

    public String getXxdm() {
        return xxdm;
    }

    public void setXxdm(String xxdm) {
        this.xxdm = xxdm == null ? null : xxdm.trim();
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx == null ? null : xx.trim();
    }

    public String getCylbdm() {
        return cylbdm;
    }

    public void setCylbdm(String cylbdm) {
        this.cylbdm = cylbdm == null ? null : cylbdm.trim();
    }

    public String getCylb() {
        return cylb;
    }

    public void setCylb(String cylb) {
        this.cylb = cylb == null ? null : cylb.trim();
    }

    public String getWhcddm() {
        return whcddm;
    }

    public void setWhcddm(String whcddm) {
        this.whcddm = whcddm == null ? null : whcddm.trim();
    }

    public String getWhcd() {
        return whcd;
    }

    public void setWhcd(String whcd) {
        this.whcd = whcd == null ? null : whcd.trim();
    }

    public String getYjbz() {
        return yjbz;
    }

    public void setYjbz(String yjbz) {
        this.yjbz = yjbz == null ? null : yjbz.trim();
    }

    public Date getYjsj() {
        return yjsj;
    }

    public void setYjsj(Date yjsj) {
        this.yjsj = yjsj;
    }

    public String getXzdxzqh() {
        return xzdxzqh;
    }

    public void setXzdxzqh(String xzdxzqh) {
        this.xzdxzqh = xzdxzqh == null ? null : xzdxzqh.trim();
    }

    public String getXzdxzqhdm() {
        return xzdxzqhdm;
    }

    public void setXzdxzqhdm(String xzdxzqhdm) {
        this.xzdxzqhdm = xzdxzqhdm == null ? null : xzdxzqhdm.trim();
    }

    public Date getDjrq() {
        return djrq;
    }

    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    public String getHjlbdm() {
        return hjlbdm;
    }

    public void setHjlbdm(String hjlbdm) {
        this.hjlbdm = hjlbdm == null ? null : hjlbdm.trim();
    }

    public String getHjlbmc() {
        return hjlbmc;
    }

    public void setHjlbmc(String hjlbmc) {
        this.hjlbmc = hjlbmc == null ? null : hjlbmc.trim();
    }

    public String getZzmmdm() {
        return zzmmdm;
    }

    public void setZzmmdm(String zzmmdm) {
        this.zzmmdm = zzmmdm == null ? null : zzmmdm.trim();
    }

    public String getZzmmmc() {
        return zzmmmc;
    }

    public void setZzmmmc(String zzmmmc) {
        this.zzmmmc = zzmmmc == null ? null : zzmmmc.trim();
    }

    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt == null ? null : sbzt.trim();
    }

    public String getZyjnzsh() {
        return zyjnzsh;
    }

    public void setZyjnzsh(String zyjnzsh) {
        this.zyjnzsh = zyjnzsh == null ? null : zyjnzsh.trim();
    }

    public String getKdywyzyzgzhm() {
        return kdywyzyzgzhm;
    }

    public void setKdywyzyzgzhm(String kdywyzyzgzhm) {
        this.kdywyzyzgzhm = kdywyzyzgzhm == null ? null : kdywyzyzgzhm.trim();
    }

    public String getSfyspk() {
        return sfyspk;
    }

    public void setSfyspk(String sfyspk) {
        this.sfyspk = sfyspk == null ? null : sfyspk.trim();
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getSsdxjgajgmc() {
        return ssdxjgajgmc;
    }

    public void setSsdxjgajgmc(String ssdxjgajgmc) {
        this.ssdxjgajgmc = ssdxjgajgmc;
    }

    public String getSsdxjgajgdm() {
        return ssdxjgajgdm;
    }

    public void setSsdxjgajgdm(String ssdxjgajgdm) {
        this.ssdxjgajgdm = ssdxjgajgdm;
    }

    public String getQybm() {
        return qybm;
    }

    public void setQybm(String qybm) {
        this.qybm = qybm;
    }
}