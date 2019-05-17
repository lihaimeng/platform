package com.yuxin.platform.upms.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 5331286366278715041L;

    private Integer permissionId;

    private Integer pid;

    private String name;

    private Byte type;

    private String value;

    private String uri;

    private String icon;

    private Byte status;

    private Date addtime;

    private Integer orderby;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    @Override
    public String toString() {
        return "Permission [permissionId=" + permissionId + ", pid=" + pid + ", name=" + name + ", type=" + type
                + ", value=" + value + ", uri=" + uri + ", icon=" + icon + ", status=" + status + ", addtime=" + addtime
                + ", orderby=" + orderby + "]";
    }


}