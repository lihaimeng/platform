package com.yuxin.platform.upms.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
public class User implements Serializable {


    private static final long serialVersionUID = -4903735529784321734L;

    private Integer userId;

    private Integer organizationId;

    private String username;

    private String password;

    private String realname;

    private Byte sex;

    private Byte status;

    private String email;

    private String phone;

    private Date addtime;

    private String organizationName;

    private String roleName;

    private String qyrybm;

    public String getQyrybm() {
        return qyrybm;
    }

    public void setQyrybm(String qyrybm) {
        this.qyrybm = qyrybm;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", organizationId=" + organizationId + ", username=" + username
                + ", password=" + password + ", realname=" + realname + ", sex=" + sex + ", status=" + status
                + ", email=" + email + ", phone=" + phone + ", addtime=" + addtime + "]";
    }

}