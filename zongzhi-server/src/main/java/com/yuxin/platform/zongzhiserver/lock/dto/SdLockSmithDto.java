package com.yuxin.platform.zongzhiserver.lock.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class SdLockSmithDto {

    /**
     * 锁匠姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idcard;
    /**
     * 查询条件管辖单位
     */
    private String gxdw;

    /**
     * 上岗证编号
     */
    private String licensenumber;

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


    public String getGxdw() {
        return gxdw;
    }

    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }
}
