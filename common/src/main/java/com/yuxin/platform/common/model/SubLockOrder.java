package com.yuxin.platform.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sub_lock_order")
public class SubLockOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ksrxm;

    private String ksrzjlx;

    private String ksrzjhm;

    private String ksrzp;

    private String ksrlxdh;

    private String qymc;

    private String qydz;

    private String wtrxm;

    private String wtrzjlx;

    private String wtrzjhm;

    private String wtrzp;

    private String wtrlxdh;

    private String wtrhjdz;

    private String ksdz;

    private String kslx;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date kssj;

    private Float ksfy;

    private String bz;

    private String zmclzp;

    private String kszp;

    private String djr;

    private Date djsj;

    private String gxdw;

    private String ddh;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ksrxm
     */
    public String getKsrxm() {
        return ksrxm;
    }

    /**
     * @param ksrxm
     */
    public void setKsrxm(String ksrxm) {
        this.ksrxm = ksrxm;
    }

    /**
     * @return ksrzjlx
     */
    public String getKsrzjlx() {
        return ksrzjlx;
    }

    /**
     * @param ksrzjlx
     */
    public void setKsrzjlx(String ksrzjlx) {
        this.ksrzjlx = ksrzjlx;
    }

    /**
     * @return ksrzjhm
     */
    public String getKsrzjhm() {
        return ksrzjhm;
    }

    /**
     * @param ksrzjhm
     */
    public void setKsrzjhm(String ksrzjhm) {
        this.ksrzjhm = ksrzjhm;
    }

    /**
     * @return ksrzp
     */
    public String getKsrzp() {
        return ksrzp;
    }

    /**
     * @param ksrzp
     */
    public void setKsrzp(String ksrzp) {
        this.ksrzp = ksrzp;
    }

    /**
     * @return ksrlxdh
     */
    public String getKsrlxdh() {
        return ksrlxdh;
    }

    /**
     * @param ksrlxdh
     */
    public void setKsrlxdh(String ksrlxdh) {
        this.ksrlxdh = ksrlxdh;
    }

    /**
     * @return qymc
     */
    public String getQymc() {
        return qymc;
    }

    /**
     * @param qymc
     */
    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    /**
     * @return qydz
     */
    public String getQydz() {
        return qydz;
    }

    /**
     * @param qydz
     */
    public void setQydz(String qydz) {
        this.qydz = qydz;
    }

    /**
     * @return wtrxm
     */
    public String getWtrxm() {
        return wtrxm;
    }

    /**
     * @param wtrxm
     */
    public void setWtrxm(String wtrxm) {
        this.wtrxm = wtrxm;
    }

    /**
     * @return wtrzjlx
     */
    public String getWtrzjlx() {
        return wtrzjlx;
    }

    /**
     * @param wtrzjlx
     */
    public void setWtrzjlx(String wtrzjlx) {
        this.wtrzjlx = wtrzjlx;
    }

    /**
     * @return wtrzjhm
     */
    public String getWtrzjhm() {
        return wtrzjhm;
    }

    /**
     * @param wtrzjhm
     */
    public void setWtrzjhm(String wtrzjhm) {
        this.wtrzjhm = wtrzjhm;
    }

    /**
     * @return wtrzp
     */
    public String getWtrzp() {
        return wtrzp;
    }

    /**
     * @param wtrzp
     */
    public void setWtrzp(String wtrzp) {
        this.wtrzp = wtrzp;
    }

    /**
     * @return wtrlxdh
     */
    public String getWtrlxdh() {
        return wtrlxdh;
    }

    /**
     * @param wtrlxdh
     */
    public void setWtrlxdh(String wtrlxdh) {
        this.wtrlxdh = wtrlxdh;
    }

    /**
     * @return wtrhjdz
     */
    public String getWtrhjdz() {
        return wtrhjdz;
    }

    /**
     * @param wtrhjdz
     */
    public void setWtrhjdz(String wtrhjdz) {
        this.wtrhjdz = wtrhjdz;
    }

    /**
     * @return ksdz
     */
    public String getKsdz() {
        return ksdz;
    }

    /**
     * @param ksdz
     */
    public void setKsdz(String ksdz) {
        this.ksdz = ksdz;
    }

    /**
     * @return kslx
     */
    public String getKslx() {
        return kslx;
    }

    /**
     * @param kslx
     */
    public void setKslx(String kslx) {
        this.kslx = kslx;
    }

    /**
     * @return kssj
     */
    public Date getKssj() {
        return kssj;
    }

    /**
     * @param kssj
     */
    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    /**
     * @return ksfy
     */
    public Float getKsfy() {
        return ksfy;
    }

    /**
     * @param ksfy
     */
    public void setKsfy(Float ksfy) {
        this.ksfy = ksfy;
    }

    /**
     * @return bz
     */
    public String getBz() {
        return bz;
    }

    /**
     * @param bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * @return zmclzp
     */
    public String getZmclzp() {
        return zmclzp;
    }

    /**
     * @param zmclzp
     */
    public void setZmclzp(String zmclzp) {
        this.zmclzp = zmclzp;
    }

    /**
     * @return kszp
     */
    public String getKszp() {
        return kszp;
    }

    /**
     * @param kszp
     */
    public void setKszp(String kszp) {
        this.kszp = kszp;
    }

    /**
     * @return djr
     */
    public String getDjr() {
        return djr;
    }

    /**
     * @param djr
     */
    public void setDjr(String djr) {
        this.djr = djr;
    }

    /**
     * @return djsj
     */
    public Date getDjsj() {
        return djsj;
    }

    /**
     * @param djsj
     */
    public void setDjsj(Date djsj) {
        this.djsj = djsj;
    }

    /**
     * @return gxdw
     */
    public String getGxdw() {
        return gxdw;
    }

    /**
     * @param gxdw
     */
    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
    }

    public String getDdh() {
        return ddh;
    }

    public void setDdh(String ddh) {
        this.ddh = ddh;
    }
}