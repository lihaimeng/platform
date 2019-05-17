package com.yuxin.platform.upms.pojo;

import java.util.Date;

/**
 * @author jyh
 * <p>
 * 2017年12月28日
 */
public class Log {
    private Integer logId;

    private String description;

    private String username;

    private Date addtime;

    private String uri;

    private String method;

    private String ip;

    private String result;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    @Override
    public String toString() {
        return "Log [logId=" + logId + ", description=" + description + ", username=" + username + ", addtime="
                + addtime + ", uri=" + uri + ", method=" + method + ", ip=" + ip + ", result=" + result + "]";
    }

}