package com.yuxin.platform.zongzhi.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 印章首页统计dto
 *
 * @author wj
 */
public class SealDto {
    /**
     * 查询印章业务数量
     */
    private Integer sealNum;
    /**
     * 查询时间
     */
    private String sealDate;
    /**
     * 查询区域
     */
    private String dominionName;
    /**
     * 所属区域代码
     */
    private String dominionCode;
    /**
     * 所属区域机构编码
     */
    private Integer organizationId;
    /**
     * 印章类型
     */
    private String sealType;
    /**
     * 印章类型统计数量
     */
    private Integer sealTypeNum;
    /**
     * 印章制作单位数量
     */
    private Integer sealMarkNum;
    /**
     * 印章使用单位数量
     */
    private Integer sealUseNum;
    /**
     * 使用单位注册时间
     */
    private String companyAddDate;
    /**
     * 查询时间开始
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date registerDateStart;
    /**
     * 查询时间结束
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date registerDateEnd;
    /**
     * 时间标记
     */
    private String dateMark;
    /**
     * 参数标记
     */
    private String mark;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getDominionCode() {
        return dominionCode;
    }

    public void setDominionCode(String dominionCode) {
        this.dominionCode = dominionCode;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCompanyAddDate() {
        return companyAddDate;
    }

    public void setCompanyAddDate(String companyAddDate) {
        this.companyAddDate = companyAddDate;
    }

    public String getDateMark() {
        return dateMark;
    }

    public void setDateMark(String dateMark) {
        this.dateMark = dateMark;
    }

    public Integer getSealNum() {
        return sealNum;
    }

    public void setSealNum(Integer sealNum) {
        this.sealNum = sealNum;
    }

    public String getSealDate() {
        return sealDate;
    }

    public void setSealDate(String sealDate) {
        this.sealDate = sealDate;
    }

    public String getDominionName() {
        return dominionName;
    }

    public void setDominionName(String dominionName) {
        this.dominionName = dominionName;
    }

    public String getSealType() {
        return sealType;
    }

    public void setSealType(String sealType) {
        this.sealType = sealType;
    }

    public Integer getSealTypeNum() {
        return sealTypeNum;
    }

    public void setSealTypeNum(Integer sealTypeNum) {
        this.sealTypeNum = sealTypeNum;
    }

    public Integer getSealMarkNum() {
        return sealMarkNum;
    }

    public void setSealMarkNum(Integer sealMarkNum) {
        this.sealMarkNum = sealMarkNum;
    }

    public Integer getSealUseNum() {
        return sealUseNum;
    }

    public void setSealUseNum(Integer sealUseNum) {
        this.sealUseNum = sealUseNum;
    }

    public Date getRegisterDateStart() {
        return registerDateStart;
    }

    public void setRegisterDateStart(Date registerDateStart) {
        this.registerDateStart = registerDateStart;
    }

    public Date getRegisterDateEnd() {
        return registerDateEnd;
    }

    public void setRegisterDateEnd(Date registerDateEnd) {
        this.registerDateEnd = registerDateEnd;
    }
}
