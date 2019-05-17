package com.yuxin.platform.zongzhiserver.qyxx.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pub_qyjbxx")
public class PubQyjbxx {
    /**
     * 1企业ID
     */
    @Id
    @Column(name = "QYID")
    private Integer qyid;

    /**
     * 2行业类别ID
     */
    @Column(name = "HYLBDM")
    private String hylbdm;

    /**
     * 3行业类别
     */
    @Column(name = "HYLB")
    private String hylb;

    /**
     * 4企业编码
     */
    @Column(name = "QYBM")
    private String qybm;

    /**
     * 5企业名称
     */
    @Column(name = "QYMC")
    private String qymc;

    /**
     * 6企业全拼
     */
    @Column(name = "QYQP")
    private String qyqp;

    /**
     * 7企业简拼
     */
    @Column(name = "QYJP")
    private String qyjp;

    /**
     * 8企业主分类编码
     */
    @Column(name = "QYZFLBM")
    private String qyzflbm;

    /**
     * 9企业主分类名称
     */
    @Column(name = "QYZFLMC")
    private String qyzflmc;

    /**
     * 企业副分类编码
     */
    @Column(name = "QYFFLBM")
    private String qyfflbm;

    /**
     * 企业副分类名称
     */
    @Column(name = "QYFFLMC")
    private String qyfflmc;

    /**
     * 管辖单位编码
     */
    @Column(name = "GXDWBM")
    private String gxdwbm;

    /**
     * 管辖单位名称
     */
    @Column(name = "GXDWMC")
    private String gxdwmc;

    /**
     * 所属地县级公安机关机构代码
     */
    @Column(name = "SSDXJGAJGDM")
    private String ssdxjgajgdm;

    /**
     * 所属地县级公安机关机构名称
     */
    @Column(name = "SSDXJGAJGMC")
    private String ssdxjgajgmc;

    /**
     * 所属地地市机构代码
     */
    @Column(name = "SSDDSJGDM")
    private String ssddsjgdm;

    /**
     * 所属地地市机构名称
     */
    @Column(name = "SSDDSJGMC")
    private String ssddsjgmc;

    @Column(name = "QYZZJGDM")
    private String qyzzjgdm;

    /**
     * 联系电话
     */
    @Column(name = "LXDH")
    private String lxdh;

    @Column(name = "YZBM")
    private String yzbm;

    @Column(name = "CHZH")
    private String chzh;

    @Column(name = "JWDZB")
    private String jwdzb;

    @Column(name = "JJLXBM")
    private String jjlxbm;

    @Column(name = "JJLXMC")
    private String jjlxmc;

    /**
     * 经营范围（主营）
     */
    @Column(name = "JYFWZY")
    private String jyfwzy;

    /**
     * 经营范围（兼营）
     */
    @Column(name = "JYFWJY")
    private String jyfwjy;

    @Column(name = "ZCZJ")
    private Integer zczj;

    @Column(name = "JYMJ")
    private Integer jymj;

    @Column(name = "ZABDM")
    private String zabdm;

    @Column(name = "ZAJBMC")
    private String zajbmc;

    @Column(name = "YYZTDM")
    private String yyztdm;

    @Column(name = "YYZTMC")
    private String yyztmc;

    /**
     * 法人代表
     */
    @Column(name = "FRDB")
    private String frdb;

    @Column(name = "FRDBZJLB")
    private String frdbzjlb;

    /**
     * 法人代表证件号码
     */
    @Column(name = "FRDBZJHM")
    private String frdbzjhm;

    @Column(name = "FRDBLXFS")
    private String frdblxfs;

    @Column(name = "KYRQ")
    private Date kyrq;

    @Column(name = "YYSJ")
    private String yysj;

    @Column(name = "BABH")
    private String babh;

    @Column(name = "BARQ")
    private Date barq;

    @Column(name = "TYRQ")
    private Date tyrq;

    @Column(name = "JYFS")
    private String jyfs;

    /**
     * 经营地址
     */
    @Column(name = "JYDZ")
    private String jydz;

    @Column(name = "DWFZRZJLB")
    private String dwfzrzjlb;

    @Column(name = "DWFZRZJHM")
    private String dwfzrzjhm;

    @Column(name = "DWFZR")
    private String dwfzr;

    @Column(name = "DWFZRLXFS")
    private String dwfzrlxfs;

    @Column(name = "XFSHDW")
    private String xfshdw;

    @Column(name = "XFHGZH")
    private String xfhgzh;

    @Column(name = "HCDW")
    private String hcdw;

    @Column(name = "HCR")
    private String hcr;

    @Column(name = "HCSJ")
    private Date hcsj;

    @Column(name = "GDXX")
    private String gdxx;

    @Column(name = "ZRS")
    private Long zrs;

    @Column(name = "HDRS")
    private Integer hdrs;

    @Column(name = "BAGSMC")
    private String bagsmc;

    @Column(name = "BAFZRGMSFHM")
    private String bafzrgmsfhm;

    @Column(name = "BAFZRXM")
    private String bafzrxm;

    @Column(name = "BAFZRDH")
    private String bafzrdh;

    @Column(name = "BARS")
    private Integer bars;

    @Column(name = "JGPXRS")
    private Integer jgpxrs;

    @Column(name = "BAGSYJ")
    private String bagsyj;

    @Column(name = "CKSL")
    private Integer cksl;

    @Column(name = "BXBJSL")
    private Integer bxbjsl;

    @Column(name = "BZ")
    private String bz;

    /**
     * 0、未导出；
     * 1、已导出；
     */
    @Column(name = "DCBS")
    private Short dcbs;

    @Column(name = "DCSJ")
    private Date dcsj;

    @Column(name = "ZT")
    private String zt;

    @Column(name = "ZTGBRQ")
    private Date ztgbrq;

    /**
     * 0、正常;
     * 1、删除；
     * 2、修改
     */
    @Column(name = "SCBZ")
    private Short scbz;

    @Column(name = "JQBM")
    private String jqbm;

    @Column(name = "ZXBZ")
    private String zxbz;

    @Column(name = "ZXYY")
    private String zxyy;

    @Column(name = "ZDSKB")
    private BigDecimal zdskb;

    @Column(name = "BCSJ")
    private Date bcsj;

    @Column(name = "LRSJ")
    private Date lrsj;

    @Column(name = "LRR")
    private String lrr;

    @Column(name = "LRDWBM")
    private String lrdwbm;

    @Column(name = "LRDWMC")
    private String lrdwmc;

    @Column(name = "THBAJGDM")
    private String thbajgdm;

    @Column(name = "THBAJG")
    private String thbajg;

    @Column(name = "BWBMDH")
    private String bwbmdh;

    @Column(name = "SFAZSXT")
    private String sfazsxt;

    @Column(name = "AZSXTSL")
    private Integer azsxtsl;

    @Column(name = "ZJZTDM")
    private String zjztdm;

    @Column(name = "ZJZTMC")
    private String zjztmc;

    /**
     * 登记日期
     */
    @Column(name = "DJRQ")
    private Date djrq;

    /**
     * 年审日期
     */
    @Column(name = "NSRQ")
    private Date nsrq;

    @Column(name = "QYJC")
    private String qyjc;

    @Column(name = "QYJCQP")
    private String qyjcqp;

    @Column(name = "QYJCJP")
    private String qyjcjp;

    @Column(name = "SGSCXFJJS")
    private String sgscxfjjs;

    @Column(name = "JHLTLXDM")
    private String jhltlxdm;

    @Column(name = "JHLTLXMC")
    private String jhltlxmc;

    @Column(name = "SBZT")
    private String sbzt;

    @Column(name = "WXYWFL")
    private String wxywfl;

    @Column(name = "WXYWFLDM")
    private String wxywfldm;

    @Column(name = "XFSHYJSBH")
    private String xfshyjsbh;

    @Column(name = "XFSHYJSFZJG")
    private String xfshyjsfzjg;

    @Column(name = "XFSHYJSFZJGDM")
    private String xfshyjsfzjgdm;

    @Column(name = "XFSHYJSFZRQ")
    private Date xfshyjsfzrq;

    @Column(name = "YYZZYXQZ")
    private Date yyzzyxqz;

    @Column(name = "YYZZFZRQ")
    private Date yyzzfzrq;

    @Column(name = "THXKZYXQZ")
    private Date thxkzyxqz;

    @Column(name = "THXKZFZRQ")
    private Date thxkzfzrq;

    @Column(name = "JYXKZYXQZ")
    private Date jyxkzyxqz;

    @Column(name = "JYXKZFZRQ")
    private Date jyxkzfzrq;

    @Column(name = "JYFZRXBDM")
    private String jyfzrxbdm;

    @Column(name = "JYFZRXB")
    private String jyfzrxb;

    @Column(name = "FRXBDM")
    private String frxbdm;

    @Column(name = "FRXB")
    private String frxb;

    @Column(name = "GDJYCSCQBH")
    private String gdjycscqbh;

    @Column(name = "GDJYCSSYQBH")
    private String gdjycssyqbh;

    @Column(name = "SFJY")
    private String sfjy;

    @Column(name = "SSXDM")
    private String ssxdm;

    @Column(name = "SSXMC")
    private String ssxmc;

    @Column(name = "KDJYXKZBH")
    private String kdjyxkzbh;

    @Column(name = "WSTZQYPZZSH")
    private String wstzqypzzsh;

    @Column(name = "HWXG")
    private String hwxg;

    @Column(name = "QYMJ")
    private String qymj;

    @Column(name = "QYMJLXDH")
    private String qymjlxdh;

    /**
     * 最大预警人数
     */
    @Column(name = "ZDYJRS")
    private Integer zdyjrs;

    @Column(name = "YYZZBH")
    private String yyzzbh;

    /**
     * 获取1企业ID
     *
     * @return QYID - 1企业ID
     */
    public Integer getQyid() {
        return qyid;
    }

    /**
     * 设置1企业ID
     *
     * @param qyid 1企业ID
     */
    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    /**
     * 获取2行业类别ID
     *
     * @return HYLBDM - 2行业类别ID
     */
    public String getHylbdm() {
        return hylbdm;
    }

    /**
     * 设置2行业类别ID
     *
     * @param hylbdm 2行业类别ID
     */
    public void setHylbdm(String hylbdm) {
        this.hylbdm = hylbdm;
    }

    /**
     * 获取3行业类别
     *
     * @return HYLB - 3行业类别
     */
    public String getHylb() {
        return hylb;
    }

    /**
     * 设置3行业类别
     *
     * @param hylb 3行业类别
     */
    public void setHylb(String hylb) {
        this.hylb = hylb;
    }

    /**
     * 获取4企业编码
     *
     * @return QYBM - 4企业编码
     */
    public String getQybm() {
        return qybm;
    }

    /**
     * 设置4企业编码
     *
     * @param qybm 4企业编码
     */
    public void setQybm(String qybm) {
        this.qybm = qybm;
    }

    /**
     * 获取5企业名称
     *
     * @return QYMC - 5企业名称
     */
    public String getQymc() {
        return qymc;
    }

    /**
     * 设置5企业名称
     *
     * @param qymc 5企业名称
     */
    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    /**
     * 获取6企业全拼
     *
     * @return QYQP - 6企业全拼
     */
    public String getQyqp() {
        return qyqp;
    }

    /**
     * 设置6企业全拼
     *
     * @param qyqp 6企业全拼
     */
    public void setQyqp(String qyqp) {
        this.qyqp = qyqp;
    }

    /**
     * 获取7企业简拼
     *
     * @return QYJP - 7企业简拼
     */
    public String getQyjp() {
        return qyjp;
    }

    /**
     * 设置7企业简拼
     *
     * @param qyjp 7企业简拼
     */
    public void setQyjp(String qyjp) {
        this.qyjp = qyjp;
    }

    /**
     * 获取8企业主分类编码
     *
     * @return QYZFLBM - 8企业主分类编码
     */
    public String getQyzflbm() {
        return qyzflbm;
    }

    /**
     * 设置8企业主分类编码
     *
     * @param qyzflbm 8企业主分类编码
     */
    public void setQyzflbm(String qyzflbm) {
        this.qyzflbm = qyzflbm;
    }

    /**
     * 获取9企业主分类名称
     *
     * @return QYZFLMC - 9企业主分类名称
     */
    public String getQyzflmc() {
        return qyzflmc;
    }

    /**
     * 设置9企业主分类名称
     *
     * @param qyzflmc 9企业主分类名称
     */
    public void setQyzflmc(String qyzflmc) {
        this.qyzflmc = qyzflmc;
    }

    /**
     * 获取企业副分类编码
     *
     * @return QYFFLBM - 企业副分类编码
     */
    public String getQyfflbm() {
        return qyfflbm;
    }

    /**
     * 设置企业副分类编码
     *
     * @param qyfflbm 企业副分类编码
     */
    public void setQyfflbm(String qyfflbm) {
        this.qyfflbm = qyfflbm;
    }

    /**
     * 获取企业副分类名称
     *
     * @return QYFFLMC - 企业副分类名称
     */
    public String getQyfflmc() {
        return qyfflmc;
    }

    /**
     * 设置企业副分类名称
     *
     * @param qyfflmc 企业副分类名称
     */
    public void setQyfflmc(String qyfflmc) {
        this.qyfflmc = qyfflmc;
    }

    /**
     * 获取管辖单位编码
     *
     * @return GXDWBM - 管辖单位编码
     */
    public String getGxdwbm() {
        return gxdwbm;
    }

    /**
     * 设置管辖单位编码
     *
     * @param gxdwbm 管辖单位编码
     */
    public void setGxdwbm(String gxdwbm) {
        this.gxdwbm = gxdwbm;
    }

    /**
     * 获取管辖单位名称
     *
     * @return GXDWMC - 管辖单位名称
     */
    public String getGxdwmc() {
        return gxdwmc;
    }

    /**
     * 设置管辖单位名称
     *
     * @param gxdwmc 管辖单位名称
     */
    public void setGxdwmc(String gxdwmc) {
        this.gxdwmc = gxdwmc;
    }

    /**
     * 获取所属地县级公安机关机构代码
     *
     * @return SSDXJGAJGDM - 所属地县级公安机关机构代码
     */
    public String getSsdxjgajgdm() {
        return ssdxjgajgdm;
    }

    /**
     * 设置所属地县级公安机关机构代码
     *
     * @param ssdxjgajgdm 所属地县级公安机关机构代码
     */
    public void setSsdxjgajgdm(String ssdxjgajgdm) {
        this.ssdxjgajgdm = ssdxjgajgdm;
    }

    /**
     * 获取所属地县级公安机关机构名称
     *
     * @return SSDXJGAJGMC - 所属地县级公安机关机构名称
     */
    public String getSsdxjgajgmc() {
        return ssdxjgajgmc;
    }

    /**
     * 设置所属地县级公安机关机构名称
     *
     * @param ssdxjgajgmc 所属地县级公安机关机构名称
     */
    public void setSsdxjgajgmc(String ssdxjgajgmc) {
        this.ssdxjgajgmc = ssdxjgajgmc;
    }

    /**
     * 获取所属地地市机构代码
     *
     * @return SSDDSJGDM - 所属地地市机构代码
     */
    public String getSsddsjgdm() {
        return ssddsjgdm;
    }

    /**
     * 设置所属地地市机构代码
     *
     * @param ssddsjgdm 所属地地市机构代码
     */
    public void setSsddsjgdm(String ssddsjgdm) {
        this.ssddsjgdm = ssddsjgdm;
    }

    /**
     * 获取所属地地市机构名称
     *
     * @return SSDDSJGMC - 所属地地市机构名称
     */
    public String getSsddsjgmc() {
        return ssddsjgmc;
    }

    /**
     * 设置所属地地市机构名称
     *
     * @param ssddsjgmc 所属地地市机构名称
     */
    public void setSsddsjgmc(String ssddsjgmc) {
        this.ssddsjgmc = ssddsjgmc;
    }

    /**
     * @return QYZZJGDM
     */
    public String getQyzzjgdm() {
        return qyzzjgdm;
    }

    /**
     * @param qyzzjgdm
     */
    public void setQyzzjgdm(String qyzzjgdm) {
        this.qyzzjgdm = qyzzjgdm;
    }

    /**
     * 获取联系电话
     *
     * @return LXDH - 联系电话
     */
    public String getLxdh() {
        return lxdh;
    }

    /**
     * 设置联系电话
     *
     * @param lxdh 联系电话
     */
    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    /**
     * @return YZBM
     */
    public String getYzbm() {
        return yzbm;
    }

    /**
     * @param yzbm
     */
    public void setYzbm(String yzbm) {
        this.yzbm = yzbm;
    }

    /**
     * @return CHZH
     */
    public String getChzh() {
        return chzh;
    }

    /**
     * @param chzh
     */
    public void setChzh(String chzh) {
        this.chzh = chzh;
    }

    /**
     * @return JWDZB
     */
    public String getJwdzb() {
        return jwdzb;
    }

    /**
     * @param jwdzb
     */
    public void setJwdzb(String jwdzb) {
        this.jwdzb = jwdzb;
    }

    /**
     * @return JJLXBM
     */
    public String getJjlxbm() {
        return jjlxbm;
    }

    /**
     * @param jjlxbm
     */
    public void setJjlxbm(String jjlxbm) {
        this.jjlxbm = jjlxbm;
    }

    /**
     * @return JJLXMC
     */
    public String getJjlxmc() {
        return jjlxmc;
    }

    /**
     * @param jjlxmc
     */
    public void setJjlxmc(String jjlxmc) {
        this.jjlxmc = jjlxmc;
    }

    /**
     * 获取经营范围（主营）
     *
     * @return JYFWZY - 经营范围（主营）
     */
    public String getJyfwzy() {
        return jyfwzy;
    }

    /**
     * 设置经营范围（主营）
     *
     * @param jyfwzy 经营范围（主营）
     */
    public void setJyfwzy(String jyfwzy) {
        this.jyfwzy = jyfwzy;
    }

    /**
     * 获取经营范围（兼营）
     *
     * @return JYFWJY - 经营范围（兼营）
     */
    public String getJyfwjy() {
        return jyfwjy;
    }

    /**
     * 设置经营范围（兼营）
     *
     * @param jyfwjy 经营范围（兼营）
     */
    public void setJyfwjy(String jyfwjy) {
        this.jyfwjy = jyfwjy;
    }

    /**
     * @return ZCZJ
     */
    public Integer getZczj() {
        return zczj;
    }

    /**
     * @param zczj
     */
    public void setZczj(Integer zczj) {
        this.zczj = zczj;
    }

    /**
     * @return JYMJ
     */
    public Integer getJymj() {
        return jymj;
    }

    /**
     * @param jymj
     */
    public void setJymj(Integer jymj) {
        this.jymj = jymj;
    }

    /**
     * @return ZABDM
     */
    public String getZabdm() {
        return zabdm;
    }

    /**
     * @param zabdm
     */
    public void setZabdm(String zabdm) {
        this.zabdm = zabdm;
    }

    /**
     * @return ZAJBMC
     */
    public String getZajbmc() {
        return zajbmc;
    }

    /**
     * @param zajbmc
     */
    public void setZajbmc(String zajbmc) {
        this.zajbmc = zajbmc;
    }

    /**
     * @return YYZTDM
     */
    public String getYyztdm() {
        return yyztdm;
    }

    /**
     * @param yyztdm
     */
    public void setYyztdm(String yyztdm) {
        this.yyztdm = yyztdm;
    }

    /**
     * @return YYZTMC
     */
    public String getYyztmc() {
        return yyztmc;
    }

    /**
     * @param yyztmc
     */
    public void setYyztmc(String yyztmc) {
        this.yyztmc = yyztmc;
    }

    /**
     * 获取法人代表
     *
     * @return FRDB - 法人代表
     */
    public String getFrdb() {
        return frdb;
    }

    /**
     * 设置法人代表
     *
     * @param frdb 法人代表
     */
    public void setFrdb(String frdb) {
        this.frdb = frdb;
    }

    /**
     * @return FRDBZJLB
     */
    public String getFrdbzjlb() {
        return frdbzjlb;
    }

    /**
     * @param frdbzjlb
     */
    public void setFrdbzjlb(String frdbzjlb) {
        this.frdbzjlb = frdbzjlb;
    }

    /**
     * 获取法人代表证件号码
     *
     * @return FRDBZJHM - 法人代表证件号码
     */
    public String getFrdbzjhm() {
        return frdbzjhm;
    }

    /**
     * 设置法人代表证件号码
     *
     * @param frdbzjhm 法人代表证件号码
     */
    public void setFrdbzjhm(String frdbzjhm) {
        this.frdbzjhm = frdbzjhm;
    }

    /**
     * @return FRDBLXFS
     */
    public String getFrdblxfs() {
        return frdblxfs;
    }

    /**
     * @param frdblxfs
     */
    public void setFrdblxfs(String frdblxfs) {
        this.frdblxfs = frdblxfs;
    }

    /**
     * @return KYRQ
     */
    public Date getKyrq() {
        return kyrq;
    }

    /**
     * @param kyrq
     */
    public void setKyrq(Date kyrq) {
        this.kyrq = kyrq;
    }

    /**
     * @return YYSJ
     */
    public String getYysj() {
        return yysj;
    }

    /**
     * @param yysj
     */
    public void setYysj(String yysj) {
        this.yysj = yysj;
    }

    /**
     * @return BABH
     */
    public String getBabh() {
        return babh;
    }

    /**
     * @param babh
     */
    public void setBabh(String babh) {
        this.babh = babh;
    }

    /**
     * @return BARQ
     */
    public Date getBarq() {
        return barq;
    }

    /**
     * @param barq
     */
    public void setBarq(Date barq) {
        this.barq = barq;
    }

    /**
     * @return TYRQ
     */
    public Date getTyrq() {
        return tyrq;
    }

    /**
     * @param tyrq
     */
    public void setTyrq(Date tyrq) {
        this.tyrq = tyrq;
    }

    /**
     * @return JYFS
     */
    public String getJyfs() {
        return jyfs;
    }

    /**
     * @param jyfs
     */
    public void setJyfs(String jyfs) {
        this.jyfs = jyfs;
    }

    /**
     * 获取经营地址
     *
     * @return JYDZ - 经营地址
     */
    public String getJydz() {
        return jydz;
    }

    /**
     * 设置经营地址
     *
     * @param jydz 经营地址
     */
    public void setJydz(String jydz) {
        this.jydz = jydz;
    }

    /**
     * @return DWFZRZJLB
     */
    public String getDwfzrzjlb() {
        return dwfzrzjlb;
    }

    /**
     * @param dwfzrzjlb
     */
    public void setDwfzrzjlb(String dwfzrzjlb) {
        this.dwfzrzjlb = dwfzrzjlb;
    }

    /**
     * @return DWFZRZJHM
     */
    public String getDwfzrzjhm() {
        return dwfzrzjhm;
    }

    /**
     * @param dwfzrzjhm
     */
    public void setDwfzrzjhm(String dwfzrzjhm) {
        this.dwfzrzjhm = dwfzrzjhm;
    }

    /**
     * @return DWFZR
     */
    public String getDwfzr() {
        return dwfzr;
    }

    /**
     * @param dwfzr
     */
    public void setDwfzr(String dwfzr) {
        this.dwfzr = dwfzr;
    }

    /**
     * @return DWFZRLXFS
     */
    public String getDwfzrlxfs() {
        return dwfzrlxfs;
    }

    /**
     * @param dwfzrlxfs
     */
    public void setDwfzrlxfs(String dwfzrlxfs) {
        this.dwfzrlxfs = dwfzrlxfs;
    }

    /**
     * @return XFSHDW
     */
    public String getXfshdw() {
        return xfshdw;
    }

    /**
     * @param xfshdw
     */
    public void setXfshdw(String xfshdw) {
        this.xfshdw = xfshdw;
    }

    /**
     * @return XFHGZH
     */
    public String getXfhgzh() {
        return xfhgzh;
    }

    /**
     * @param xfhgzh
     */
    public void setXfhgzh(String xfhgzh) {
        this.xfhgzh = xfhgzh;
    }

    /**
     * @return HCDW
     */
    public String getHcdw() {
        return hcdw;
    }

    /**
     * @param hcdw
     */
    public void setHcdw(String hcdw) {
        this.hcdw = hcdw;
    }

    /**
     * @return HCR
     */
    public String getHcr() {
        return hcr;
    }

    /**
     * @param hcr
     */
    public void setHcr(String hcr) {
        this.hcr = hcr;
    }

    /**
     * @return HCSJ
     */
    public Date getHcsj() {
        return hcsj;
    }

    /**
     * @param hcsj
     */
    public void setHcsj(Date hcsj) {
        this.hcsj = hcsj;
    }

    /**
     * @return GDXX
     */
    public String getGdxx() {
        return gdxx;
    }

    /**
     * @param gdxx
     */
    public void setGdxx(String gdxx) {
        this.gdxx = gdxx;
    }

    /**
     * @return ZRS
     */
    public Long getZrs() {
        return zrs;
    }

    /**
     * @param zrs
     */
    public void setZrs(Long zrs) {
        this.zrs = zrs;
    }

    /**
     * @return HDRS
     */
    public Integer getHdrs() {
        return hdrs;
    }

    /**
     * @param hdrs
     */
    public void setHdrs(Integer hdrs) {
        this.hdrs = hdrs;
    }

    /**
     * @return BAGSMC
     */
    public String getBagsmc() {
        return bagsmc;
    }

    /**
     * @param bagsmc
     */
    public void setBagsmc(String bagsmc) {
        this.bagsmc = bagsmc;
    }

    /**
     * @return BAFZRGMSFHM
     */
    public String getBafzrgmsfhm() {
        return bafzrgmsfhm;
    }

    /**
     * @param bafzrgmsfhm
     */
    public void setBafzrgmsfhm(String bafzrgmsfhm) {
        this.bafzrgmsfhm = bafzrgmsfhm;
    }

    /**
     * @return BAFZRXM
     */
    public String getBafzrxm() {
        return bafzrxm;
    }

    /**
     * @param bafzrxm
     */
    public void setBafzrxm(String bafzrxm) {
        this.bafzrxm = bafzrxm;
    }

    /**
     * @return BAFZRDH
     */
    public String getBafzrdh() {
        return bafzrdh;
    }

    /**
     * @param bafzrdh
     */
    public void setBafzrdh(String bafzrdh) {
        this.bafzrdh = bafzrdh;
    }

    /**
     * @return BARS
     */
    public Integer getBars() {
        return bars;
    }

    /**
     * @param bars
     */
    public void setBars(Integer bars) {
        this.bars = bars;
    }

    /**
     * @return JGPXRS
     */
    public Integer getJgpxrs() {
        return jgpxrs;
    }

    /**
     * @param jgpxrs
     */
    public void setJgpxrs(Integer jgpxrs) {
        this.jgpxrs = jgpxrs;
    }

    /**
     * @return BAGSYJ
     */
    public String getBagsyj() {
        return bagsyj;
    }

    /**
     * @param bagsyj
     */
    public void setBagsyj(String bagsyj) {
        this.bagsyj = bagsyj;
    }

    /**
     * @return CKSL
     */
    public Integer getCksl() {
        return cksl;
    }

    /**
     * @param cksl
     */
    public void setCksl(Integer cksl) {
        this.cksl = cksl;
    }

    /**
     * @return BXBJSL
     */
    public Integer getBxbjsl() {
        return bxbjsl;
    }

    /**
     * @param bxbjsl
     */
    public void setBxbjsl(Integer bxbjsl) {
        this.bxbjsl = bxbjsl;
    }

    /**
     * @return BZ
     */
    public String getBz() {
        return bz;
    }

    /**
     * @param bz
     */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
     * 获取0、未导出；
     * 1、已导出；
     *
     * @return DCBS - 0、未导出；
     * 1、已导出；
     */
    public Short getDcbs() {
        return dcbs;
    }

    /**
     * 设置0、未导出；
     * 1、已导出；
     *
     * @param dcbs 0、未导出；
     *             1、已导出；
     */
    public void setDcbs(Short dcbs) {
        this.dcbs = dcbs;
    }

    /**
     * @return DCSJ
     */
    public Date getDcsj() {
        return dcsj;
    }

    /**
     * @param dcsj
     */
    public void setDcsj(Date dcsj) {
        this.dcsj = dcsj;
    }

    /**
     * @return ZT
     */
    public String getZt() {
        return zt;
    }

    /**
     * @param zt
     */
    public void setZt(String zt) {
        this.zt = zt;
    }

    /**
     * @return ZTGBRQ
     */
    public Date getZtgbrq() {
        return ztgbrq;
    }

    /**
     * @param ztgbrq
     */
    public void setZtgbrq(Date ztgbrq) {
        this.ztgbrq = ztgbrq;
    }

    /**
     * 获取0、正常;
     * 1、删除；
     * 2、修改
     *
     * @return SCBZ - 0、正常;
     * 1、删除；
     * 2、修改
     */
    public Short getScbz() {
        return scbz;
    }

    /**
     * 设置0、正常;
     * 1、删除；
     * 2、修改
     *
     * @param scbz 0、正常;
     *             1、删除；
     *             2、修改
     */
    public void setScbz(Short scbz) {
        this.scbz = scbz;
    }

    /**
     * @return JQBM
     */
    public String getJqbm() {
        return jqbm;
    }

    /**
     * @param jqbm
     */
    public void setJqbm(String jqbm) {
        this.jqbm = jqbm;
    }

    /**
     * @return ZXBZ
     */
    public String getZxbz() {
        return zxbz;
    }

    /**
     * @param zxbz
     */
    public void setZxbz(String zxbz) {
        this.zxbz = zxbz;
    }

    /**
     * @return ZXYY
     */
    public String getZxyy() {
        return zxyy;
    }

    /**
     * @param zxyy
     */
    public void setZxyy(String zxyy) {
        this.zxyy = zxyy;
    }

    /**
     * @return ZDSKB
     */
    public BigDecimal getZdskb() {
        return zdskb;
    }

    /**
     * @param zdskb
     */
    public void setZdskb(BigDecimal zdskb) {
        this.zdskb = zdskb;
    }

    /**
     * @return BCSJ
     */
    public Date getBcsj() {
        return bcsj;
    }

    /**
     * @param bcsj
     */
    public void setBcsj(Date bcsj) {
        this.bcsj = bcsj;
    }

    /**
     * @return LRSJ
     */
    public Date getLrsj() {
        return lrsj;
    }

    /**
     * @param lrsj
     */
    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    /**
     * @return LRR
     */
    public String getLrr() {
        return lrr;
    }

    /**
     * @param lrr
     */
    public void setLrr(String lrr) {
        this.lrr = lrr;
    }

    /**
     * @return LRDWBM
     */
    public String getLrdwbm() {
        return lrdwbm;
    }

    /**
     * @param lrdwbm
     */
    public void setLrdwbm(String lrdwbm) {
        this.lrdwbm = lrdwbm;
    }

    /**
     * @return LRDWMC
     */
    public String getLrdwmc() {
        return lrdwmc;
    }

    /**
     * @param lrdwmc
     */
    public void setLrdwmc(String lrdwmc) {
        this.lrdwmc = lrdwmc;
    }

    /**
     * @return THBAJGDM
     */
    public String getThbajgdm() {
        return thbajgdm;
    }

    /**
     * @param thbajgdm
     */
    public void setThbajgdm(String thbajgdm) {
        this.thbajgdm = thbajgdm;
    }

    /**
     * @return THBAJG
     */
    public String getThbajg() {
        return thbajg;
    }

    /**
     * @param thbajg
     */
    public void setThbajg(String thbajg) {
        this.thbajg = thbajg;
    }

    /**
     * @return BWBMDH
     */
    public String getBwbmdh() {
        return bwbmdh;
    }

    /**
     * @param bwbmdh
     */
    public void setBwbmdh(String bwbmdh) {
        this.bwbmdh = bwbmdh;
    }

    /**
     * @return SFAZSXT
     */
    public String getSfazsxt() {
        return sfazsxt;
    }

    /**
     * @param sfazsxt
     */
    public void setSfazsxt(String sfazsxt) {
        this.sfazsxt = sfazsxt;
    }

    /**
     * @return AZSXTSL
     */
    public Integer getAzsxtsl() {
        return azsxtsl;
    }

    /**
     * @param azsxtsl
     */
    public void setAzsxtsl(Integer azsxtsl) {
        this.azsxtsl = azsxtsl;
    }

    /**
     * @return ZJZTDM
     */
    public String getZjztdm() {
        return zjztdm;
    }

    /**
     * @param zjztdm
     */
    public void setZjztdm(String zjztdm) {
        this.zjztdm = zjztdm;
    }

    /**
     * @return ZJZTMC
     */
    public String getZjztmc() {
        return zjztmc;
    }

    /**
     * @param zjztmc
     */
    public void setZjztmc(String zjztmc) {
        this.zjztmc = zjztmc;
    }

    /**
     * 获取登记日期
     *
     * @return DJRQ - 登记日期
     */
    public Date getDjrq() {
        return djrq;
    }

    /**
     * 设置登记日期
     *
     * @param djrq 登记日期
     */
    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    /**
     * 获取年审日期
     *
     * @return NSRQ - 年审日期
     */
    public Date getNsrq() {
        return nsrq;
    }

    /**
     * 设置年审日期
     *
     * @param nsrq 年审日期
     */
    public void setNsrq(Date nsrq) {
        this.nsrq = nsrq;
    }

    /**
     * @return QYJC
     */
    public String getQyjc() {
        return qyjc;
    }

    /**
     * @param qyjc
     */
    public void setQyjc(String qyjc) {
        this.qyjc = qyjc;
    }

    /**
     * @return QYJCQP
     */
    public String getQyjcqp() {
        return qyjcqp;
    }

    /**
     * @param qyjcqp
     */
    public void setQyjcqp(String qyjcqp) {
        this.qyjcqp = qyjcqp;
    }

    /**
     * @return QYJCJP
     */
    public String getQyjcjp() {
        return qyjcjp;
    }

    /**
     * @param qyjcjp
     */
    public void setQyjcjp(String qyjcjp) {
        this.qyjcjp = qyjcjp;
    }

    /**
     * @return SGSCXFJJS
     */
    public String getSgscxfjjs() {
        return sgscxfjjs;
    }

    /**
     * @param sgscxfjjs
     */
    public void setSgscxfjjs(String sgscxfjjs) {
        this.sgscxfjjs = sgscxfjjs;
    }

    /**
     * @return JHLTLXDM
     */
    public String getJhltlxdm() {
        return jhltlxdm;
    }

    /**
     * @param jhltlxdm
     */
    public void setJhltlxdm(String jhltlxdm) {
        this.jhltlxdm = jhltlxdm;
    }

    /**
     * @return JHLTLXMC
     */
    public String getJhltlxmc() {
        return jhltlxmc;
    }

    /**
     * @param jhltlxmc
     */
    public void setJhltlxmc(String jhltlxmc) {
        this.jhltlxmc = jhltlxmc;
    }

    /**
     * @return SBZT
     */
    public String getSbzt() {
        return sbzt;
    }

    /**
     * @param sbzt
     */
    public void setSbzt(String sbzt) {
        this.sbzt = sbzt;
    }

    /**
     * @return WXYWFL
     */
    public String getWxywfl() {
        return wxywfl;
    }

    /**
     * @param wxywfl
     */
    public void setWxywfl(String wxywfl) {
        this.wxywfl = wxywfl;
    }

    /**
     * @return WXYWFLDM
     */
    public String getWxywfldm() {
        return wxywfldm;
    }

    /**
     * @param wxywfldm
     */
    public void setWxywfldm(String wxywfldm) {
        this.wxywfldm = wxywfldm;
    }

    /**
     * @return XFSHYJSBH
     */
    public String getXfshyjsbh() {
        return xfshyjsbh;
    }

    /**
     * @param xfshyjsbh
     */
    public void setXfshyjsbh(String xfshyjsbh) {
        this.xfshyjsbh = xfshyjsbh;
    }

    /**
     * @return XFSHYJSFZJG
     */
    public String getXfshyjsfzjg() {
        return xfshyjsfzjg;
    }

    /**
     * @param xfshyjsfzjg
     */
    public void setXfshyjsfzjg(String xfshyjsfzjg) {
        this.xfshyjsfzjg = xfshyjsfzjg;
    }

    /**
     * @return XFSHYJSFZJGDM
     */
    public String getXfshyjsfzjgdm() {
        return xfshyjsfzjgdm;
    }

    /**
     * @param xfshyjsfzjgdm
     */
    public void setXfshyjsfzjgdm(String xfshyjsfzjgdm) {
        this.xfshyjsfzjgdm = xfshyjsfzjgdm;
    }

    /**
     * @return XFSHYJSFZRQ
     */
    public Date getXfshyjsfzrq() {
        return xfshyjsfzrq;
    }

    /**
     * @param xfshyjsfzrq
     */
    public void setXfshyjsfzrq(Date xfshyjsfzrq) {
        this.xfshyjsfzrq = xfshyjsfzrq;
    }

    /**
     * @return YYZZYXQZ
     */
    public Date getYyzzyxqz() {
        return yyzzyxqz;
    }

    /**
     * @param yyzzyxqz
     */
    public void setYyzzyxqz(Date yyzzyxqz) {
        this.yyzzyxqz = yyzzyxqz;
    }

    /**
     * @return YYZZFZRQ
     */
    public Date getYyzzfzrq() {
        return yyzzfzrq;
    }

    /**
     * @param yyzzfzrq
     */
    public void setYyzzfzrq(Date yyzzfzrq) {
        this.yyzzfzrq = yyzzfzrq;
    }

    /**
     * @return THXKZYXQZ
     */
    public Date getThxkzyxqz() {
        return thxkzyxqz;
    }

    /**
     * @param thxkzyxqz
     */
    public void setThxkzyxqz(Date thxkzyxqz) {
        this.thxkzyxqz = thxkzyxqz;
    }

    /**
     * @return THXKZFZRQ
     */
    public Date getThxkzfzrq() {
        return thxkzfzrq;
    }

    /**
     * @param thxkzfzrq
     */
    public void setThxkzfzrq(Date thxkzfzrq) {
        this.thxkzfzrq = thxkzfzrq;
    }

    /**
     * @return JYXKZYXQZ
     */
    public Date getJyxkzyxqz() {
        return jyxkzyxqz;
    }

    /**
     * @param jyxkzyxqz
     */
    public void setJyxkzyxqz(Date jyxkzyxqz) {
        this.jyxkzyxqz = jyxkzyxqz;
    }

    /**
     * @return JYXKZFZRQ
     */
    public Date getJyxkzfzrq() {
        return jyxkzfzrq;
    }

    /**
     * @param jyxkzfzrq
     */
    public void setJyxkzfzrq(Date jyxkzfzrq) {
        this.jyxkzfzrq = jyxkzfzrq;
    }

    /**
     * @return JYFZRXBDM
     */
    public String getJyfzrxbdm() {
        return jyfzrxbdm;
    }

    /**
     * @param jyfzrxbdm
     */
    public void setJyfzrxbdm(String jyfzrxbdm) {
        this.jyfzrxbdm = jyfzrxbdm;
    }

    /**
     * @return JYFZRXB
     */
    public String getJyfzrxb() {
        return jyfzrxb;
    }

    /**
     * @param jyfzrxb
     */
    public void setJyfzrxb(String jyfzrxb) {
        this.jyfzrxb = jyfzrxb;
    }

    /**
     * @return FRXBDM
     */
    public String getFrxbdm() {
        return frxbdm;
    }

    /**
     * @param frxbdm
     */
    public void setFrxbdm(String frxbdm) {
        this.frxbdm = frxbdm;
    }

    /**
     * @return FRXB
     */
    public String getFrxb() {
        return frxb;
    }

    /**
     * @param frxb
     */
    public void setFrxb(String frxb) {
        this.frxb = frxb;
    }

    /**
     * @return GDJYCSCQBH
     */
    public String getGdjycscqbh() {
        return gdjycscqbh;
    }

    /**
     * @param gdjycscqbh
     */
    public void setGdjycscqbh(String gdjycscqbh) {
        this.gdjycscqbh = gdjycscqbh;
    }

    /**
     * @return GDJYCSSYQBH
     */
    public String getGdjycssyqbh() {
        return gdjycssyqbh;
    }

    /**
     * @param gdjycssyqbh
     */
    public void setGdjycssyqbh(String gdjycssyqbh) {
        this.gdjycssyqbh = gdjycssyqbh;
    }

    /**
     * @return SFJY
     */
    public String getSfjy() {
        return sfjy;
    }

    /**
     * @param sfjy
     */
    public void setSfjy(String sfjy) {
        this.sfjy = sfjy;
    }

    /**
     * @return SSXDM
     */
    public String getSsxdm() {
        return ssxdm;
    }

    /**
     * @param ssxdm
     */
    public void setSsxdm(String ssxdm) {
        this.ssxdm = ssxdm;
    }

    /**
     * @return SSXMC
     */
    public String getSsxmc() {
        return ssxmc;
    }

    /**
     * @param ssxmc
     */
    public void setSsxmc(String ssxmc) {
        this.ssxmc = ssxmc;
    }

    /**
     * @return KDJYXKZBH
     */
    public String getKdjyxkzbh() {
        return kdjyxkzbh;
    }

    /**
     * @param kdjyxkzbh
     */
    public void setKdjyxkzbh(String kdjyxkzbh) {
        this.kdjyxkzbh = kdjyxkzbh;
    }

    /**
     * @return WSTZQYPZZSH
     */
    public String getWstzqypzzsh() {
        return wstzqypzzsh;
    }

    /**
     * @param wstzqypzzsh
     */
    public void setWstzqypzzsh(String wstzqypzzsh) {
        this.wstzqypzzsh = wstzqypzzsh;
    }

    /**
     * @return HWXG
     */
    public String getHwxg() {
        return hwxg;
    }

    /**
     * @param hwxg
     */
    public void setHwxg(String hwxg) {
        this.hwxg = hwxg;
    }

    /**
     * @return QYMJ
     */
    public String getQymj() {
        return qymj;
    }

    /**
     * @param qymj
     */
    public void setQymj(String qymj) {
        this.qymj = qymj;
    }

    /**
     * @return QYMJLXDH
     */
    public String getQymjlxdh() {
        return qymjlxdh;
    }

    /**
     * @param qymjlxdh
     */
    public void setQymjlxdh(String qymjlxdh) {
        this.qymjlxdh = qymjlxdh;
    }

    /**
     * 获取最大预警人数
     *
     * @return ZDYJRS - 最大预警人数
     */
    public Integer getZdyjrs() {
        return zdyjrs;
    }

    /**
     * 设置最大预警人数
     *
     * @param zdyjrs 最大预警人数
     */
    public void setZdyjrs(Integer zdyjrs) {
        this.zdyjrs = zdyjrs;
    }

    /**
     * @return YYZZBH
     */
    public String getYyzzbh() {
        return yyzzbh;
    }

    /**
     * @param yyzzbh
     */
    public void setYyzzbh(String yyzzbh) {
        this.yyzzbh = yyzzbh;
    }
}