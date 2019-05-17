package com.yuxin.platform.subpublic.dto;

import com.yuxin.platform.subpublic.pojo.Qyryxx;
import com.yuxin.platform.upms.pojo.Role;

public class CyryDto {

    private Qyryxx qyryxx;
    private Role role;

    public Qyryxx getQyryxx() {
        return qyryxx;
    }

    public void setQyryxx(Qyryxx qyryxx) {
        this.qyryxx = qyryxx;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}