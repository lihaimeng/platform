package com.yuxin.platform.zongzhiserver.lock.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sd_locksmith")
public class SdLockSmith {
    @Id
    private Integer lid;

    /**
     * 锁匠姓名
     */
    private String name;

    /**
     * 身份证号码
     */
    private String idcard;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 上岗证编号
     */
    private String licensenumber;

    /**
     * 上岗证到期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date licenseendtime;

    /**
     * 登记时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date addtime;

    /**
     * 锁匠照片
     */
    private String locksmithphoto;

    /**
     * 手持身份证照片
     */
    private String idcardphoto;

    /**
     * 上岗证照片
     */
    private String workphoto;

    /**
     * 营业照照片
     */
    private String businessphoto;

    /**
     * 手持身份证照片
     */
    private String handcardphoto;

    private String ip;

    /**
     * 管辖单位
     */
    private String gxdw;

    /**
     * @return lid
     */
    public Integer getLid() {
        return lid;
    }

    /**
     * @param lid
     */
    public void setLid(Integer lid) {
        this.lid = lid;
    }

    /**
     * 获取锁匠姓名
     *
     * @return name - 锁匠姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置锁匠姓名
     *
     * @param name 锁匠姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取身份证号码
     *
     * @return idcard - 身份证号码
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号码
     *
     * @param idcard 身份证号码
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取详细地址
     *
     * @return address - 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     *
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取电话
     *
     * @return mobile - 电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置电话
     *
     * @param mobile 电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取上岗证编号
     *
     * @return licensenumber - 上岗证编号
     */
    public String getLicensenumber() {
        return licensenumber;
    }

    /**
     * 设置上岗证编号
     *
     * @param licensenumber 上岗证编号
     */
    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    /**
     * 获取上岗证到期时间
     *
     * @return licenseendtime - 上岗证到期时间
     */
    public Date getLicenseendtime() {
        return licenseendtime;
    }

    /**
     * 设置上岗证到期时间
     *
     * @param licenseendtime 上岗证到期时间
     */
    public void setLicenseendtime(Date licenseendtime) {
        this.licenseendtime = licenseendtime;
    }

    /**
     * 获取登记时间
     *
     * @return addtime - 登记时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置登记时间
     *
     * @param addtime 登记时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取锁匠照片
     *
     * @return locksmithphoto - 锁匠照片
     */
    public String getLocksmithphoto() {
        return locksmithphoto;
    }

    /**
     * 设置锁匠照片
     *
     * @param locksmithphoto 锁匠照片
     */
    public void setLocksmithphoto(String locksmithphoto) {
        this.locksmithphoto = locksmithphoto;
    }

    /**
     * 获取手持身份证照片
     *
     * @return idcardphoto - 手持身份证照片
     */
    public String getIdcardphoto() {
        return idcardphoto;
    }

    /**
     * 设置手持身份证照片
     *
     * @param idcardphoto 手持身份证照片
     */
    public void setIdcardphoto(String idcardphoto) {
        this.idcardphoto = idcardphoto;
    }

    /**
     * 获取上岗证照片
     *
     * @return workphoto - 上岗证照片
     */
    public String getWorkphoto() {
        return workphoto;
    }

    /**
     * 设置上岗证照片
     *
     * @param workphoto 上岗证照片
     */
    public void setWorkphoto(String workphoto) {
        this.workphoto = workphoto;
    }

    /**
     * 获取营业照照片
     *
     * @return businessphoto - 营业照照片
     */
    public String getBusinessphoto() {
        return businessphoto;
    }

    /**
     * 设置营业照照片
     *
     * @param businessphoto 营业照照片
     */
    public void setBusinessphoto(String businessphoto) {
        this.businessphoto = businessphoto;
    }

    /**
     * 获取手持身份证照片
     *
     * @return handcardphoto - 手持身份证照片
     */
    public String getHandcardphoto() {
        return handcardphoto;
    }

    /**
     * 设置手持身份证照片
     *
     * @param handcardphoto 手持身份证照片
     */
    public void setHandcardphoto(String handcardphoto) {
        this.handcardphoto = handcardphoto;
    }

    /**
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGxdw() {
        return gxdw;
    }

    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
    }
}