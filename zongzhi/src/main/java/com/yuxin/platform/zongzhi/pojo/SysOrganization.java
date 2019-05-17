package com.yuxin.platform.zongzhi.pojo;

import java.util.Date;

public class SysOrganization {
    private Integer organizationId;

    private Integer pid;

    private String name;

    private String description;

    private Date addtime;

    private String code;

    private String brevitycode;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getBrevitycode() {
        return brevitycode;
    }

    public void setBrevitycode(String brevitycode) {
        this.brevitycode = brevitycode;
    }
}