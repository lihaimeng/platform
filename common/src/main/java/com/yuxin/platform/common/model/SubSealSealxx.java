package com.yuxin.platform.common.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sub_seal_sealxx")
public class SubSealSealxx implements Serializable {

    private static final long serialVersionUID = 5656724474806918735L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ӡ
     */
    private String yzbm;

    /**
     * ӡ
     */
    private String yznr;

    /**
     * ӡ
     */
    private String yzlx;

    /**
     * ӡ
     */
    private String yzxz;

    /**
     * ӡ
     */
    private String yzgg;

    /**
     * ӡ
     */
    private String yzcl;

    private String pbfs;

    private String zxta;

    private Integer jg;

    /**
     * ӡģ
     */
    private String ymldzp;

    private Date djsj;

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
     * 获取ӡ
     *
     * @return yzbm - ӡ
     */
    public String getYzbm() {
        return yzbm;
    }

    /**
     * 设置ӡ
     *
     * @param yzbm ӡ
     */
    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    /**
     * 获取ӡ
     *
     * @return yznr - ӡ
     */
    public String getYznr() {
        return yznr;
    }

    /**
     * 设置ӡ
     *
     * @param yznr ӡ
     */
    public void setYznr(String yznr) {
        this.yznr = yznr;
    }

    /**
     * 获取ӡ
     *
     * @return yzlx - ӡ
     */
    public String getYzlx() {
        return yzlx;
    }

    /**
     * 设置ӡ
     *
     * @param yzlx ӡ
     */
    public void setYzlx(String yzlx) {
        this.yzlx = yzlx;
    }

    /**
     * 获取ӡ
     *
     * @return yzxz - ӡ
     */
    public String getYzxz() {
        return yzxz;
    }

    /**
     * 设置ӡ
     *
     * @param yzxz ӡ
     */
    public void setYzxz(String yzxz) {
        this.yzxz = yzxz;
    }

    /**
     * 获取ӡ
     *
     * @return yzgg - ӡ
     */
    public String getYzgg() {
        return yzgg;
    }

    /**
     * 设置ӡ
     *
     * @param yzgg ӡ
     */
    public void setYzgg(String yzgg) {
        this.yzgg = yzgg;
    }

    /**
     * 获取ӡ
     *
     * @return yzcl - ӡ
     */
    public String getYzcl() {
        return yzcl;
    }

    /**
     * 设置ӡ
     *
     * @param yzcl ӡ
     */
    public void setYzcl(String yzcl) {
        this.yzcl = yzcl;
    }

    /**
     * @return pbfs
     */
    public String getPbfs() {
        return pbfs;
    }

    /**
     * @param pbfs
     */
    public void setPbfs(String pbfs) {
        this.pbfs = pbfs;
    }

    /**
     * @return zxta
     */
    public String getZxta() {
        return zxta;
    }

    /**
     * @param zxta
     */
    public void setZxta(String zxta) {
        this.zxta = zxta;
    }

    /**
     * @return jg
     */
    public Integer getJg() {
        return jg;
    }

    /**
     * @param jg
     */
    public void setJg(Integer jg) {
        this.jg = jg;
    }

    /**
     * 获取ӡģ
     *
     * @return ymldzp - ӡģ
     */
    public String getYmldzp() {
        return ymldzp;
    }

    /**
     * 设置ӡģ
     *
     * @param ymldzp ӡģ
     */
    public void setYmldzp(String ymldzp) {
        this.ymldzp = ymldzp;
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
}