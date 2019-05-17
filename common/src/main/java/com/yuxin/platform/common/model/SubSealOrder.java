package com.yuxin.platform.common.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sub_seal_order")
public class SubSealOrder implements Serializable {

    private static final long serialVersionUID = 6986794609836934278L;
    /**
     * Ψһ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ʹ
     */
    private String sydwmc;

    /**
     * ʹ
     */
    private String sydwbh;

    /**
     * ʹ
     */
    private String sydwlx;

    /**
     * ʹ
     */
    private String sydwdh;

    /**
     * ʹ
     */
    private String sydwdz;

    private String jbrxm;

    private String jbrzjlx;

    private String jbrzjh;

    private String jbrzp;

    private String jbrlxdh;

    private String zzdwbm;

    private String zzdwmc;

    private String zzr;

    private String zzdwdh;

    private String zzdwdz;

    private Date djsj;

    private String gxdw;

    private String ddh;

    private String badwbh;

    private String badwmc;

    private String bar;

    private Date basj;

    /**
     * 获取Ψһ
     *
     * @return id - Ψһ
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置Ψһ
     *
     * @param id Ψһ
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取ʹ
     *
     * @return sydwmc - ʹ
     */
    public String getSydwmc() {
        return sydwmc;
    }

    /**
     * 设置ʹ
     *
     * @param sydwmc ʹ
     */
    public void setSydwmc(String sydwmc) {
        this.sydwmc = sydwmc;
    }

    /**
     * 获取ʹ
     *
     * @return sydwbh - ʹ
     */
    public String getSydwbh() {
        return sydwbh;
    }

    /**
     * 设置ʹ
     *
     * @param sydwbh ʹ
     */
    public void setSydwbh(String sydwbh) {
        this.sydwbh = sydwbh;
    }

    /**
     * 获取ʹ
     *
     * @return sydwlx - ʹ
     */
    public String getSydwlx() {
        return sydwlx;
    }

    /**
     * 设置ʹ
     *
     * @param sydwlx ʹ
     */
    public void setSydwlx(String sydwlx) {
        this.sydwlx = sydwlx;
    }

    /**
     * 获取ʹ
     *
     * @return sydwdh - ʹ
     */
    public String getSydwdh() {
        return sydwdh;
    }

    /**
     * 设置ʹ
     *
     * @param sydwdh ʹ
     */
    public void setSydwdh(String sydwdh) {
        this.sydwdh = sydwdh;
    }

    /**
     * 获取ʹ
     *
     * @return sydwdz - ʹ
     */
    public String getSydwdz() {
        return sydwdz;
    }

    /**
     * 设置ʹ
     *
     * @param sydwdz ʹ
     */
    public void setSydwdz(String sydwdz) {
        this.sydwdz = sydwdz;
    }

    /**
     * @return jbrxm
     */
    public String getJbrxm() {
        return jbrxm;
    }

    /**
     * @param jbrxm
     */
    public void setJbrxm(String jbrxm) {
        this.jbrxm = jbrxm;
    }

    /**
     * @return jbrzjlx
     */
    public String getJbrzjlx() {
        return jbrzjlx;
    }

    /**
     * @param jbrzjlx
     */
    public void setJbrzjlx(String jbrzjlx) {
        this.jbrzjlx = jbrzjlx;
    }

    /**
     * @return jbrzjh
     */
    public String getJbrzjh() {
        return jbrzjh;
    }

    /**
     * @param jbrzjh
     */
    public void setJbrzjh(String jbrzjh) {
        this.jbrzjh = jbrzjh;
    }

    /**
     * @return jbrzp
     */
    public String getJbrzp() {
        return jbrzp;
    }

    /**
     * @param jbrzp
     */
    public void setJbrzp(String jbrzp) {
        this.jbrzp = jbrzp;
    }

    /**
     * @return jbrlxdh
     */
    public String getJbrlxdh() {
        return jbrlxdh;
    }

    /**
     * @param jbrlxdh
     */
    public void setJbrlxdh(String jbrlxdh) {
        this.jbrlxdh = jbrlxdh;
    }

    /**
     * @return zzdwbm
     */
    public String getZzdwbm() {
        return zzdwbm;
    }

    /**
     * @param zzdwbm
     */
    public void setZzdwbm(String zzdwbm) {
        this.zzdwbm = zzdwbm;
    }

    /**
     * @return zzdwmc
     */
    public String getZzdwmc() {
        return zzdwmc;
    }

    /**
     * @param zzdwmc
     */
    public void setZzdwmc(String zzdwmc) {
        this.zzdwmc = zzdwmc;
    }

    /**
     * @return zzr
     */
    public String getZzr() {
        return zzr;
    }

    /**
     * @param zzr
     */
    public void setZzr(String zzr) {
        this.zzr = zzr;
    }

    /**
     * @return zzdwdh
     */
    public String getZzdwdh() {
        return zzdwdh;
    }

    /**
     * @param zzdwdh
     */
    public void setZzdwdh(String zzdwdh) {
        this.zzdwdh = zzdwdh;
    }

    /**
     * @return zzdwdz
     */
    public String getZzdwdz() {
        return zzdwdz;
    }

    /**
     * @param zzdwdz
     */
    public void setZzdwdz(String zzdwdz) {
        this.zzdwdz = zzdwdz;
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

    /**
     * @return ddh
     */
    public String getDdh() {
        return ddh;
    }

    /**
     * @param ddh
     */
    public void setDdh(String ddh) {
        this.ddh = ddh;
    }

    /**
     * @return badwbh
     */
    public String getBadwbh() {
        return badwbh;
    }

    /**
     * @param badwbh
     */
    public void setBadwbh(String badwbh) {
        this.badwbh = badwbh;
    }

    /**
     * @return badwmc
     */
    public String getBadwmc() {
        return badwmc;
    }

    /**
     * @param badwmc
     */
    public void setBadwmc(String badwmc) {
        this.badwmc = badwmc;
    }

    /**
     * @return bar
     */
    public String getBar() {
        return bar;
    }

    /**
     * @param bar
     */
    public void setBar(String bar) {
        this.bar = bar;
    }

    /**
     * @return basj
     */
    public Date getBasj() {
        return basj;
    }

    /**
     * @param basj
     */
    public void setBasj(Date basj) {
        this.basj = basj;
    }
}