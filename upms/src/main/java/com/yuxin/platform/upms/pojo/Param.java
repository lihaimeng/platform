package com.yuxin.platform.upms.pojo;

/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
public class Param {
    private Integer paramId;

    private String paramName;

    private String code;

    private String paramValue;

    private String description;

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "Param [paramId=" + paramId + ", paramName=" + paramName + ", code=" + code + ", paramValue="
                + paramValue + ", description=" + description + "]";
    }


}