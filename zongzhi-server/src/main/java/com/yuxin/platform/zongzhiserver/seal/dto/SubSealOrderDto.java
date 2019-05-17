package com.yuxin.platform.zongzhiserver.seal.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 新印章业务显示统计页面
 *
 * @author dudong
 */
public class SubSealOrderDto {

    /**
     * 查询条件使用单位名称
     */
    private String sydwmc;
    /**
     * 查询条件使用单位编码
     */
    private String sydwbh;
    /**
     * 查询条件管辖单位
     */
    private String gxdw;

    /**
     * 查询条件制造单位名称
     */
    private String zzdwmc;
    /**
     * 查询条件经办人姓名
     */
    private String jbrxm;

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

    public String getSydwmc() {
        return sydwmc;
    }

    public void setSydwmc(String sydwmc) {
        this.sydwmc = sydwmc;
    }

    public String getSydwbh() {
        return sydwbh;
    }

    public void setSydwbh(String sydwbh) {
        this.sydwbh = sydwbh;
    }

    public String getGxdw() {
        return gxdw;
    }

    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
    }

    public String getZzdwmc() {
        return zzdwmc;
    }

    public void setZzdwmc(String zzdwmc) {
        this.zzdwmc = zzdwmc;
    }

    public String getJbrxm() {
        return jbrxm;
    }

    public void setJbrxm(String jbrxm) {
        this.jbrxm = jbrxm;
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
