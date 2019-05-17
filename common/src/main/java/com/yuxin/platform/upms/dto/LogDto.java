package com.yuxin.platform.upms.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 日志dto
 *
 * @author wj
 */
public class LogDto {
    /**
     * 参数名称
     */
    private String paramName;
    /**
     * 参数值
     */
    private String paramValue;
    /**
     * 日志描述
     */
    private String description;
    /**
     * 登录时间开始
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date loginDateStart;
    /**
     * 登录时间结束
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date loginDateEnd;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLoginDateStart() {
        return loginDateStart;
    }

    public void setLoginDateStart(Date loginDateStart) {
        this.loginDateStart = loginDateStart;
    }

    public Date getLoginDateEnd() {
        return loginDateEnd;
    }

    public void setLoginDateEnd(Date loginDateEnd) {
        this.loginDateEnd = loginDateEnd;
    }
}
