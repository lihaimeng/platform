package com.yuxin.platform.zongzhi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 锁业相关字段
 *
 * @author wj
 */
public class SubLockInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * 委托人电话
     */
    private String bksrdh;
    /**
     * 委托人身份证号
     */
    private String bksrsfzh;
    /**
     * 委托人姓名
     */
    private String bksrxm;
    /**
     * 开锁地址
     */
    private String ksdz;
    /**
     * 开锁地址
     */
    private String kslx;
    /**
     * 开锁机构地址
     */
    private String ksjgdz;
    /**
     * 开锁机构名称
     */
    private String ksjgmc;
    /**
     * 锁匠电话
     */
    private String ksrdh;
    /**
     * 锁匠身份证号
     */
    private String ksrsfzh;
    /**
     * 锁匠姓名
     */
    private String ksrxm;
    /**
     * 管辖单位名称
     */
    private String gxdwbm;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBksrdh() {
        return bksrdh;
    }

    public void setBksrdh(String bksrdh) {
        this.bksrdh = bksrdh;
    }

    public String getBksrsfzh() {
        return bksrsfzh;
    }

    public void setBksrsfzh(String bksrsfzh) {
        this.bksrsfzh = bksrsfzh;
    }

    public String getBksrxm() {
        return bksrxm;
    }

    public void setBksrxm(String bksrxm) {
        this.bksrxm = bksrxm;
    }

    public String getKsdz() {
        return ksdz;
    }

    public void setKsdz(String ksdz) {
        this.ksdz = ksdz;
    }

    public String getKsjgdz() {
        return ksjgdz;
    }

    public void setKsjgdz(String ksjgdz) {
        this.ksjgdz = ksjgdz;
    }

    public String getKsjgmc() {
        return ksjgmc;
    }

    public void setKsjgmc(String ksjgmc) {
        this.ksjgmc = ksjgmc;
    }

    public String getKsrdh() {
        return ksrdh;
    }

    public void setKsrdh(String ksrdh) {
        this.ksrdh = ksrdh;
    }

    public String getKsrsfzh() {
        return ksrsfzh;
    }

    public void setKsrsfzh(String ksrsfzh) {
        this.ksrsfzh = ksrsfzh;
    }

    public String getKsrxm() {
        return ksrxm;
    }

    public void setKsrxm(String ksrxm) {
        this.ksrxm = ksrxm;
    }

    public String getGxdwbm() {
        return gxdwbm;
    }

    public void setGxdwbm(String gxdwbm) {
        this.gxdwbm = gxdwbm;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getKslx() {
        return kslx;
    }

    public void setKslx(String kslx) {
        this.kslx = kslx;
    }
}