package com.yuxin.platform.zongzhiserver.lock.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 新印章业务显示统计页面
 *
 * @author dudong
 */
public class SubLockOrderDto {

    /**
     * 查询条件开锁人姓名
     */
    private String ksrxm;
    /**
     * 查询条件委托人姓名
     */
    private String wtrxm;
    /**
     * 查询条件管辖单位
     */
    private String gxdw;

    /**
     * 查询条件开锁企业名称
     */
    private String qymc;
    /**
     * 查询条件委托人证件号码
     */
    private String wtrzjhm;

    /**
     *
     */
    private String ddh;
    /**
     * 查询条件管辖单位(来自用户的管辖单位)
     */
    private String organizationCode;
    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }


    public String getDdh() {
        return ddh;
    }

    public void setDdh(String ddh) {
        this.ddh = ddh;
    }

    /**
     * 查询条件时间开始
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date registerTimeStart;
    /**
     * 查询条件时间结束
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date registerTimeEnd;

    public String getKsrxm() {
        return ksrxm;
    }

    public void setKsrxm(String ksrxm) {
        this.ksrxm = ksrxm;
    }

    public String getWtrxm() {
        return wtrxm;
    }

    public void setWtrxm(String wtrxm) {
        this.wtrxm = wtrxm;
    }

    public String getGxdw() {
        return gxdw;
    }

    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getWtrzjhm() {
        return wtrzjhm;
    }

    public void setWtrzjhm(String wtrzjhm) {
        this.wtrzjhm = wtrzjhm;
    }

    public Date getRegisterTimeStart() {
        return registerTimeStart;
    }

    public void setRegisterTimeStart(Date registerTimeStart) {
        this.registerTimeStart = registerTimeStart;
    }

    public Date getRegisterTimeEnd() {
        return registerTimeEnd;
    }

    public void setRegisterTimeEnd(Date registerTimeEnd) {
        this.registerTimeEnd = registerTimeEnd;
    }


}
