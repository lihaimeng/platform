package com.yuxin.platform.zongzhi.vo;

/**
 * 印章vo对象
 *
 * @author wj
 */
public class SealVo {
    private Integer id;
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
     * 印章使用单位注册时间
     */
    private String companyAddDate;

    public String getCompanyAddDate() {
        return companyAddDate;
    }

    public void setCompanyAddDate(String companyAddDate) {
        this.companyAddDate = companyAddDate;
    }

    public Integer getSealTypeNum() {
        return sealTypeNum;
    }

    public void setSealTypeNum(Integer sealTypeNum) {
        this.sealTypeNum = sealTypeNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDominionName() {
        return dominionName;
    }

    public void setDominionName(String dominionName) {
        this.dominionName = dominionName;
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

    public String getSealType() {
        return sealType;
    }

    public void setSealType(String sealType) {
        this.sealType = sealType;
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
}
