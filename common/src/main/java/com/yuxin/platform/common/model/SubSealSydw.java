package com.yuxin.platform.common.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sub_seal_sydw")
public class SubSealSydw implements Serializable {


    private static final long serialVersionUID = -9108044983115957665L;
    /**
     * Ψһ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dwmc;

    private String dwbh;

    private String dwdz;

    private String dwlx;

    private String dwdh;

    /**
     * Ӫҵִ
     */
    private String yyzzzp;

    /**
     * Ӫҵִ
     */
    private String yyzzbh;

    private Date djsj;

    private String gxdw;

    private String frxm;

    private String frzjhm;

    private String frzjlx;

    private String frzp;

    private String frhjdz;

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
     * @return dwmc
     */
    public String getDwmc() {
        return dwmc;
    }

    /**
     * @param dwmc
     */
    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    /**
     * @return dwbh
     */
    public String getDwbh() {
        return dwbh;
    }

    /**
     * @param dwbh
     */
    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    /**
     * @return dwdz
     */
    public String getDwdz() {
        return dwdz;
    }

    /**
     * @param dwdz
     */
    public void setDwdz(String dwdz) {
        this.dwdz = dwdz;
    }

    /**
     * @return dwlx
     */
    public String getDwlx() {
        return dwlx;
    }

    /**
     * @param dwlx
     */
    public void setDwlx(String dwlx) {
        this.dwlx = dwlx;
    }

    /**
     * @return dwdh
     */
    public String getDwdh() {
        return dwdh;
    }

    /**
     * @param dwdh
     */
    public void setDwdh(String dwdh) {
        this.dwdh = dwdh;
    }

    /**
     * 获取Ӫҵִ
     *
     * @return yyzzzp - Ӫҵִ
     */
    public String getYyzzzp() {
        return yyzzzp;
    }

    /**
     * 设置Ӫҵִ
     *
     * @param yyzzzp Ӫҵִ
     */
    public void setYyzzzp(String yyzzzp) {
        this.yyzzzp = yyzzzp;
    }

    /**
     * 获取Ӫҵִ
     *
     * @return yyzzbh - Ӫҵִ
     */
    public String getYyzzbh() {
        return yyzzbh;
    }

    /**
     * 设置Ӫҵִ
     *
     * @param yyzzbh Ӫҵִ
     */
    public void setYyzzbh(String yyzzbh) {
        this.yyzzbh = yyzzbh;
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
     * @return frxm
     */
    public String getFrxm() {
        return frxm;
    }

    /**
     * @param frxm
     */
    public void setFrxm(String frxm) {
        this.frxm = frxm;
    }

    /**
     * @return frzjhm
     */
    public String getFrzjhm() {
        return frzjhm;
    }

    /**
     * @param frzjhm
     */
    public void setFrzjhm(String frzjhm) {
        this.frzjhm = frzjhm;
    }

    /**
     * @return frzjlx
     */
    public String getFrzjlx() {
        return frzjlx;
    }

    /**
     * @param frzjlx
     */
    public void setFrzjlx(String frzjlx) {
        this.frzjlx = frzjlx;
    }

    /**
     * @return frzp
     */
    public String getFrzp() {
        return frzp;
    }

    /**
     * @param frzp
     */
    public void setFrzp(String frzp) {
        this.frzp = frzp;
    }

    /**
     * @return frhjdz
     */
    public String getFrhjdz() {
        return frhjdz;
    }

    /**
     * @param frhjdz
     */
    public void setFrhjdz(String frhjdz) {
        this.frhjdz = frhjdz;
    }
}