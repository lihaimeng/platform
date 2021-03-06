package com.yuxin.platform.zongzhi.pojo;

/**
 * 印章相关字段
 *
 * @author wj
 */
public class SubSealInfo {
    /**
     * subSealInfo对象id
     */
    private Integer id;
    /**
     * 印章编码
     */
    private String sealId;
    /**
     * 印章名称
     */
    private String sealName;
    /**
     * 印章状态
     */
    private String state;
    /**
     * 印章类型
     */
    private String sealType;
    /**
     * 印章形状
     */
    private String sealShape;
    /**
     * 印章规格
     */
    private String sealModel;
    /**
     * 印章材质
     */
    private String sealMaterial;
    /**
     * 印章中心图案
     */
    private String sealPattern;
    /**
     * 经办人
     */
    private String operator;
    /**
     * 经办人证件号码
     */
    private String operatorCard;
    /**
     * 经办人证件类型
     */
    private String operatorCardType;
    /**
     * 经办人联系方式
     */
    private String operatorPhone;
    /**
     * 登记时间
     */
    private String registerDate;
    /**
     * 使用单位名称
     */
    private String company;
    /**
     * 使用单位编号
     */
    private String companyId;
    /**
     * 使用单位类型
     */
    private String companyType;
    /**
     * 使用单位地址
     */
    private String companyAddress;
    /**
     * 使用单位注册时间
     */
    private String companyAddDate;
    /**
     * 所属区域名称
     */
    private String dominion;
    /**
     * 所属区域编码
     */
    private String dominionCode;
    /**
     * 法人姓名
     */
    private String lawPerson;
    /**
     * 法人身份证号
     */
    private String lawPersonCard;
    /**
     * 法人证件类型
     */
    private String lawPersonCardType;
    /**
     * 法人联系方式
     */
    private String lawPersonPhone;
    /**
     * 制作单位
     */
    private String markCompany;
    /**
     * 制作单位地址
     */
    private String markCompanyAddress;
    /**
     * 制作单位编码
     */
    private String markCompanyId;
    /**
     * 制作单位法人姓名
     */
    private String markLawPerson;
    /**
     * 制作单位法人身份证号
     */
    private String getMarkLawCard;
    /**
     * 制作单位法人证件类型
     */
    private String markLawCardType;
    /**
     * 制作单位法人联系方式
     */
    private String markPhone;

    public String getCompanyAddDate() {
        return companyAddDate;
    }

    public void setCompanyAddDate(String companyAddDate) {
        this.companyAddDate = companyAddDate;
    }

    public String getDominionCode() {
        return dominionCode;
    }

    public void setDominionCode(String dominionCode) {
        this.dominionCode = dominionCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getDominion() {
        return dominion;
    }

    public void setDominion(String dominion) {
        this.dominion = dominion == null ? null : dominion.trim();
    }

    public String getGetMarkLawCard() {
        return getMarkLawCard;
    }

    public void setGetMarkLawCard(String getMarkLawCard) {
        this.getMarkLawCard = getMarkLawCard == null ? null : getMarkLawCard.trim();
    }

    public String getLawPerson() {
        return lawPerson;
    }

    public void setLawPerson(String lawPerson) {
        this.lawPerson = lawPerson == null ? null : lawPerson.trim();
    }

    public String getLawPersonCard() {
        return lawPersonCard;
    }

    public void setLawPersonCard(String lawPersonCard) {
        this.lawPersonCard = lawPersonCard == null ? null : lawPersonCard.trim();
    }

    public String getLawPersonCardType() {
        return lawPersonCardType;
    }

    public void setLawPersonCardType(String lawPersonCardType) {
        this.lawPersonCardType = lawPersonCardType == null ? null : lawPersonCardType.trim();
    }

    public String getLawPersonPhone() {
        return lawPersonPhone;
    }

    public void setLawPersonPhone(String lawPersonPhone) {
        this.lawPersonPhone = lawPersonPhone == null ? null : lawPersonPhone.trim();
    }

    public String getMarkCompany() {
        return markCompany;
    }

    public void setMarkCompany(String markCompany) {
        this.markCompany = markCompany == null ? null : markCompany.trim();
    }

    public String getMarkCompanyAddress() {
        return markCompanyAddress;
    }

    public void setMarkCompanyAddress(String markCompanyAddress) {
        this.markCompanyAddress = markCompanyAddress == null ? null : markCompanyAddress.trim();
    }

    public String getMarkCompanyId() {
        return markCompanyId;
    }

    public void setMarkCompanyId(String markCompanyId) {
        this.markCompanyId = markCompanyId == null ? null : markCompanyId.trim();
    }

    public String getMarkLawCardType() {
        return markLawCardType;
    }

    public void setMarkLawCardType(String markLawCardType) {
        this.markLawCardType = markLawCardType == null ? null : markLawCardType.trim();
    }

    public String getMarkLawPerson() {
        return markLawPerson;
    }

    public void setMarkLawPerson(String markLawPerson) {
        this.markLawPerson = markLawPerson == null ? null : markLawPerson.trim();
    }

    public String getMarkPhone() {
        return markPhone;
    }

    public void setMarkPhone(String markPhone) {
        this.markPhone = markPhone == null ? null : markPhone.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOperatorCard() {
        return operatorCard;
    }

    public void setOperatorCard(String operatorCard) {
        this.operatorCard = operatorCard == null ? null : operatorCard.trim();
    }

    public String getOperatorCardType() {
        return operatorCardType;
    }

    public void setOperatorCardType(String operatorCardType) {
        this.operatorCardType = operatorCardType == null ? null : operatorCardType.trim();
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone == null ? null : operatorPhone.trim();
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate == null ? null : registerDate.trim();
    }

    public String getSealId() {
        return sealId;
    }

    public void setSealId(String sealId) {
        this.sealId = sealId == null ? null : sealId.trim();
    }

    public String getSealMaterial() {
        return sealMaterial;
    }

    public void setSealMaterial(String sealMaterial) {
        this.sealMaterial = sealMaterial == null ? null : sealMaterial.trim();
    }

    public String getSealModel() {
        return sealModel;
    }

    public void setSealModel(String sealModel) {
        this.sealModel = sealModel == null ? null : sealModel.trim();
    }

    public String getSealName() {
        return sealName;
    }

    public void setSealName(String sealName) {
        this.sealName = sealName == null ? null : sealName.trim();
    }

    public String getSealPattern() {
        return sealPattern;
    }

    public void setSealPattern(String sealPattern) {
        this.sealPattern = sealPattern == null ? null : sealPattern.trim();
    }

    public String getSealShape() {
        return sealShape;
    }

    public void setSealShape(String sealShape) {
        this.sealShape = sealShape == null ? null : sealShape.trim();
    }

    public String getSealType() {
        return sealType;
    }

    public void setSealType(String sealType) {
        this.sealType = sealType == null ? null : sealType.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}