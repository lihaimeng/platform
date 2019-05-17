package com.yuxin.platform.upms.pojo;

import java.util.Date;

/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
public class Role {
    private Integer roleId;

    private String name;

    private String description;

    private Date addtime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    @Override
    public String toString() {
        return "Role [roleId=" + roleId + ", name=" + name + ", description=" + description + ", addtime=" + addtime
                + "]";
    }


}