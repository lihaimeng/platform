package com.yuxin.platform.zongzhi.pojo;

public class SubZhzaQyjbxx {
    private Integer id;
    /**
     * 单位名称
     */
    private String dwmc;
    /**
     * 管辖单位名称
     */
    private String gxdwmc;
    /**
     * 管辖单位编码
     */
    private String gxdwbm;
    /**
     * 行业类型
     */
    private String hylx;
    /**
     * 行业类型编码
     */
    private String hylxbm;
    /**
     * 法人名称
     */
    private String frmc;
    /**
     * 法人身份证号
     */
    private String frsfzh;
    /**
     * 营业执照编号
     */
    private String yyzzbh;
    /**
     * 联系方式
     */
    private String lxdh;
    /**
     * 单位地址
     */
    private String dwdz;
    /**
     * 企业编码
     */
    private String qybm;
    /**
     * 注册时间
     */
    private String zcsj;

    public String getZcsj() {
        return zcsj;
    }

    public void setZcsj(String zcsj) {
        this.zcsj = zcsj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDwdz() {
        return dwdz;
    }

    public void setDwdz(String dwdz) {
        this.dwdz = dwdz == null ? null : dwdz.trim();
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc == null ? null : dwmc.trim();
    }

    public String getFrmc() {
        return frmc;
    }

    public void setFrmc(String frmc) {
        this.frmc = frmc == null ? null : frmc.trim();
    }

    public String getFrsfzh() {
        return frsfzh;
    }

    public void setFrsfzh(String frsfzh) {
        this.frsfzh = frsfzh == null ? null : frsfzh.trim();
    }

    public String getGxdwbm() {
        return gxdwbm;
    }

    public void setGxdwbm(String gxdwbm) {
        this.gxdwbm = gxdwbm == null ? null : gxdwbm.trim();
    }

    public String getGxdwmc() {
        return gxdwmc;
    }

    public void setGxdwmc(String gxdwmc) {
        this.gxdwmc = gxdwmc == null ? null : gxdwmc.trim();
    }

    public String getHylx() {
        return hylx;
    }

    public void setHylx(String hylx) {
        this.hylx = hylx == null ? null : hylx.trim();
    }

    public String getHylxbm() {
        return hylxbm;
    }

    public void setHylxbm(String hylxbm) {
        this.hylxbm = hylxbm == null ? null : hylxbm.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getQybm() {
        return qybm;
    }

    public void setQybm(String qybm) {
        this.qybm = qybm == null ? null : qybm.trim();
    }

    public String getYyzzbh() {
        return yyzzbh;
    }

    public void setYyzzbh(String yyzzbh) {
        this.yyzzbh = yyzzbh == null ? null : yyzzbh.trim();
    }
}