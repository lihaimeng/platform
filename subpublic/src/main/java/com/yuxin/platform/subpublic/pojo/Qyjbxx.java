package com.yuxin.platform.subpublic.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

//企业基本信息
public class Qyjbxx {
    private Integer qyid;//企业id

    private String hylbdm;//行业类别代码

    private String hylb;//行业类别

    private String qybm;//企业编码

    private String qymc;//企业名称

    private String qyqp;//企业全拼

    private String qyjp;//企业简拼

    private String qyzflbm;//企业主分类编码

    private String qyzflmc;//企业主分类名称

    private String qyfflbm;//企业副分类编码

    private String qyfflmc;//企业副分类名称

    private String gxdwbm;//管辖单位编码

    private String gxdwmc;//管辖单位名称

    private String ssdxjgajgdm;//所属地县级公安机关机构代码

    private String ssdxjgajgmc;//所属地县级公安机关名称

    private String ssddsjgdm;//所属地地市机构代码

    private String ssddsjgmc;//所属地地市机构名称

    private String qyzzjgdm;//企业组织机构代码

    private String lxdh;//联系电话

    private String yzbm;//邮政编码

    private String chzh;//传真

    private String jwdzb;//经纬度坐标

    private String jjlxbm;//经济类型编码

    private String jjlxmc;//经济类型名称

    private String jyfwzy;//经营范围（主营）

    private String jyfwjy;//经营范围（兼营）

    private Integer zczj;//注册资金

    private Integer jymj;//经营面积

    private String zabdm;//治安级别代码

    private String zajbmc;//治安级别名称

    private String yyztdm;//营业状态代码

    private String yyztmc;//营业状态名称

    private String frdb;//法人代表

    private String frdbzjlb;//法人代表证件类别

    private String frdbzjhm;//法人代表证件号码

    private String frdblxfs;//法人代表联系方式

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date kyrq;//开业日期

    private String yysj;//营业时间

    private String babh;//备案编号

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date barq;//备案日期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date tyrq;//停业日期

    private String jyfs;//经营方式

    private String jydz;//经营地址

    private String dwfzrzjlb;//单位负责人证件类别

    private String dwfzrzjhm;//单位负责人证件号码

    private String dwfzr;//单位负责人

    private String dwfzrlxfs;//单位负责人联系方式

    private String xfshdw;//消防审核单位

    private String xfhgzh;//消防合格证号

    private String hcdw;//核查单位

    private String hcr;//核查人

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date hcsj;//核查时间

    private String gdxx;//股东信息

    private Long zrs;//总人数

    private Integer hdrs;//核定人数

    private String bagsmc;//保安公司名称

    private String bafzrgmsfhm;//保安负责人公民身份号码

    private String bafzrxm;//保安负责人姓名

    private String bafzrdh;//保安负责人电话

    private Integer bars;//保安人数

    private Integer jgpxrs;//经岗培训人数

    private String bagsyj;//保安公司意见

    private Integer cksl;//出口数量

    private Integer bxbjsl;//包厢包间数量

    private String bz;//备注

    private Short dcbs;//导出标识（0-未导出，1-已导出）

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date dcsj;//导出时间

    private String zt;//状态

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date ztgbrq;//状态改变日期

    private Short scbz;//

    private String jqbm;//机器编码

    private String zxbz;//注销标志

    private String zxyy;//注销原因

    private BigDecimal zdskb;//最低刷卡比

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date bcsj;//保存时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date lrsj;//录入时间

    private String lrr;//录入人

    private String lrdwbm;//录入单位编码

    private String lrdwmc;//录入单位名称

    private String thbajgdm;//特行备案机构代码

    private String thbajg;//特行备案机构

    private String bwbmdh;//保安部门电话

    private String sfazsxt;//是否安装摄像头

    private Integer azsxtsl;//安装摄像头数量

    private String zjztdm;//装机状态代码

    private String zjztmc;//装机状态名称

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date djrq;//登记日期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date nsrq;//年审日期

    private String qyjc;//企业简称

    private String qyjcqp;//企业简称全拼

    private String qyjcjp;//企业简称简拼

    private String sgscxfjjs;//

    private String jhltlxdm;

    private String jhltlxmc;

    private String sbzt;//上报状态

    private String wxywfl;//维修业务分类

    private String wxywfldm;//维修业务分类代码

    private String xfshyjsbh;//消防审核意见书编号

    private String xfshyjsfzjg;//消防审核意见书发证机关

    private String xfshyjsfzjgdm;//消防审核意见书发证机关代码

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date xfshyjsfzrq;//消防审核意见书发证机关日期

    private String yyzzbh;//营业时间执照编号

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date yyzzyxqz;//营业执照有效期至

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date yyzzfzrq;//营业执照发证日期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date thxkzyxqz;//特行许可证有效期至

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date thxkzfzrq;//特行许可证发证日期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date jyxkzyxqz;//经营许可证有效期至

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date jyxkzfzrq;//经营许可证发证日期

    private String jyfzrxbdm;//经营负责人性别代码

    private String jyfzrxb;//经营负责人性别

    private String frxbdm;//法人性别代码

    private String frxb;//法人性别

    private String gdjycscqbh;//固定经营场所产权编号

    private String gdjycssyqbh;//固定经营场所使用权编号

    private String sfjy;//是否兼营

    private String ssxdm;//省市县代码

    private String ssxmc;//省市县名称

    private String kdjyxkzbh;//快递经营许可证编号

    private String wstzqypzzsh;//外商投资企业批准证书号

    private String hwxg;//

    private String qymj;

    private String qymjlxdh;

    private Integer zdyjrs;

    public String getYyzzbh() {
        return yyzzbh;
    }

    public void setYyzzbh(String yyzzbh) {
        this.yyzzbh = yyzzbh;
    }

    public Integer getQyid() {
        return qyid;
    }

    public void setQyid(Integer qyid) {
        this.qyid = qyid;
    }

    public String getHylbdm() {
        return hylbdm;
    }

    public void setHylbdm(String hylbdm) {
        this.hylbdm = hylbdm == null ? null : hylbdm.trim();
    }

    public String getHylb() {
        return hylb;
    }

    public void setHylb(String hylb) {
        this.hylb = hylb == null ? null : hylb.trim();
    }

    public String getQybm() {
        return qybm;
    }

    public void setQybm(String qybm) {
        this.qybm = qybm == null ? null : qybm.trim();
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc == null ? null : qymc.trim();
    }

    public String getQyqp() {
        return qyqp;
    }

    public void setQyqp(String qyqp) {
        this.qyqp = qyqp == null ? null : qyqp.trim();
    }

    public String getQyjp() {
        return qyjp;
    }

    public void setQyjp(String qyjp) {
        this.qyjp = qyjp == null ? null : qyjp.trim();
    }

    public String getQyzflbm() {
        return qyzflbm;
    }

    public void setQyzflbm(String qyzflbm) {
        this.qyzflbm = qyzflbm == null ? null : qyzflbm.trim();
    }

    public String getQyzflmc() {
        return qyzflmc;
    }

    public void setQyzflmc(String qyzflmc) {
        this.qyzflmc = qyzflmc == null ? null : qyzflmc.trim();
    }

    public String getQyfflbm() {
        return qyfflbm;
    }

    public void setQyfflbm(String qyfflbm) {
        this.qyfflbm = qyfflbm == null ? null : qyfflbm.trim();
    }

    public String getQyfflmc() {
        return qyfflmc;
    }

    public void setQyfflmc(String qyfflmc) {
        this.qyfflmc = qyfflmc == null ? null : qyfflmc.trim();
    }

    public String getGxdwbm() {
        return gxdwbm;
    }

    public void setGxdwbm(String gxdwbm) {
        this.gxdwbm = gxdwbm == null ? null : gxdwbm.trim();
    }

    public String getGxdwmc() {
        return gxdwmc;
    }

    public void setGxdwmc(String gxdwmc) {
        this.gxdwmc = gxdwmc == null ? null : gxdwmc.trim();
    }

    public String getSsdxjgajgdm() {
        return ssdxjgajgdm;
    }

    public void setSsdxjgajgdm(String ssdxjgajgdm) {
        this.ssdxjgajgdm = ssdxjgajgdm == null ? null : ssdxjgajgdm.trim();
    }

    public String getSsdxjgajgmc() {
        return ssdxjgajgmc;
    }

    public void setSsdxjgajgmc(String ssdxjgajgmc) {
        this.ssdxjgajgmc = ssdxjgajgmc == null ? null : ssdxjgajgmc.trim();
    }

    public String getSsddsjgdm() {
        return ssddsjgdm;
    }

    public void setSsddsjgdm(String ssddsjgdm) {
        this.ssddsjgdm = ssddsjgdm == null ? null : ssddsjgdm.trim();
    }

    public String getSsddsjgmc() {
        return ssddsjgmc;
    }

    public void setSsddsjgmc(String ssddsjgmc) {
        this.ssddsjgmc = ssddsjgmc == null ? null : ssddsjgmc.trim();
    }

    public String getQyzzjgdm() {
        return qyzzjgdm;
    }

    public void setQyzzjgdm(String qyzzjgdm) {
        this.qyzzjgdm = qyzzjgdm == null ? null : qyzzjgdm.trim();
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh == null ? null : lxdh.trim();
    }

    public String getYzbm() {
        return yzbm;
    }

    public void setYzbm(String yzbm) {
        this.yzbm = yzbm == null ? null : yzbm.trim();
    }

    public String getChzh() {
        return chzh;
    }

    public void setChzh(String chzh) {
        this.chzh = chzh == null ? null : chzh.trim();
    }

    public String getJwdzb() {
        return jwdzb;
    }

    public void setJwdzb(String jwdzb) {
        this.jwdzb = jwdzb == null ? null : jwdzb.trim();
    }

    public String getJjlxbm() {
        return jjlxbm;
    }

    public void setJjlxbm(String jjlxbm) {
        this.jjlxbm = jjlxbm == null ? null : jjlxbm.trim();
    }

    public String getJjlxmc() {
        return jjlxmc;
    }

    public void setJjlxmc(String jjlxmc) {
        this.jjlxmc = jjlxmc == null ? null : jjlxmc.trim();
    }

    public String getJyfwzy() {
        return jyfwzy;
    }

    public void setJyfwzy(String jyfwzy) {
        this.jyfwzy = jyfwzy == null ? null : jyfwzy.trim();
    }

    public String getJyfwjy() {
        return jyfwjy;
    }

    public void setJyfwjy(String jyfwjy) {
        this.jyfwjy = jyfwjy == null ? null : jyfwjy.trim();
    }

    public Integer getZczj() {
        return zczj;
    }

    public void setZczj(Integer zczj) {
        this.zczj = zczj;
    }

    public Integer getJymj() {
        return jymj;
    }

    public void setJymj(Integer jymj) {
        this.jymj = jymj;
    }

    public String getZabdm() {
        return zabdm;
    }

    public void setZabdm(String zabdm) {
        this.zabdm = zabdm == null ? null : zabdm.trim();
    }

    public String getZajbmc() {
        return zajbmc;
    }

    public void setZajbmc(String zajbmc) {
        this.zajbmc = zajbmc == null ? null : zajbmc.trim();
    }

    public String getYyztdm() {
        return yyztdm;
    }

    public void setYyztdm(String yyztdm) {
        this.yyztdm = yyztdm == null ? null : yyztdm.trim();
    }

    public String getYyztmc() {
        return yyztmc;
    }

    public void setYyztmc(String yyztmc) {
        this.yyztmc = yyztmc == null ? null : yyztmc.trim();
    }

    public String getFrdb() {
        return frdb;
    }

    public void setFrdb(String frdb) {
        this.frdb = frdb == null ? null : frdb.trim();
    }

    public String getFrdbzjlb() {
        return frdbzjlb;
    }

    public void setFrdbzjlb(String frdbzjlb) {
        this.frdbzjlb = frdbzjlb == null ? null : frdbzjlb.trim();
    }

    public String getFrdbzjhm() {
        return frdbzjhm;
    }

    public void setFrdbzjhm(String frdbzjhm) {
        this.frdbzjhm = frdbzjhm == null ? null : frdbzjhm.trim();
    }

    public String getFrdblxfs() {
        return frdblxfs;
    }

    public void setFrdblxfs(String frdblxfs) {
        this.frdblxfs = frdblxfs == null ? null : frdblxfs.trim();
    }

    public Date getKyrq() {
        return kyrq;
    }

    public void setKyrq(Date kyrq) {
        this.kyrq = kyrq;
    }

    public String getYysj() {
        return yysj;
    }

    public void setYysj(String yysj) {
        this.yysj = yysj == null ? null : yysj.trim();
    }

    public String getBabh() {
        return babh;
    }

    public void setBabh(String babh) {
        this.babh = babh == null ? null : babh.trim();
    }

    public Date getBarq() {
        return barq;
    }

    public void setBarq(Date barq) {
        this.barq = barq;
    }

    public Date getTyrq() {
        return tyrq;
    }

    public void setTyrq(Date tyrq) {
        this.tyrq = tyrq;
    }

    public String getJyfs() {
        return jyfs;
    }

    public void setJyfs(String jyfs) {
        this.jyfs = jyfs == null ? null : jyfs.trim();
    }

    public String getJydz() {
        return jydz;
    }

    public void setJydz(String jydz) {
        this.jydz = jydz == null ? null : jydz.trim();
    }

    public String getDwfzrzjlb() {
        return dwfzrzjlb;
    }

    public void setDwfzrzjlb(String dwfzrzjlb) {
        this.dwfzrzjlb = dwfzrzjlb == null ? null : dwfzrzjlb.trim();
    }

    public String getDwfzrzjhm() {
        return dwfzrzjhm;
    }

    public void setDwfzrzjhm(String dwfzrzjhm) {
        this.dwfzrzjhm = dwfzrzjhm == null ? null : dwfzrzjhm.trim();
    }

    public String getDwfzr() {
        return dwfzr;
    }

    public void setDwfzr(String dwfzr) {
        this.dwfzr = dwfzr == null ? null : dwfzr.trim();
    }

    public String getDwfzrlxfs() {
        return dwfzrlxfs;
    }

    public void setDwfzrlxfs(String dwfzrlxfs) {
        this.dwfzrlxfs = dwfzrlxfs == null ? null : dwfzrlxfs.trim();
    }

    public String getXfshdw() {
        return xfshdw;
    }

    public void setXfshdw(String xfshdw) {
        this.xfshdw = xfshdw == null ? null : xfshdw.trim();
    }

    public String getXfhgzh() {
        return xfhgzh;
    }

    public void setXfhgzh(String xfhgzh) {
        this.xfhgzh = xfhgzh == null ? null : xfhgzh.trim();
    }

    public String getHcdw() {
        return hcdw;
    }

    public void setHcdw(String hcdw) {
        this.hcdw = hcdw == null ? null : hcdw.trim();
    }

    public String getHcr() {
        return hcr;
    }

    public void setHcr(String hcr) {
        this.hcr = hcr == null ? null : hcr.trim();
    }

    public Date getHcsj() {
        return hcsj;
    }

    public void setHcsj(Date hcsj) {
        this.hcsj = hcsj;
    }

    public String getGdxx() {
        return gdxx;
    }

    public void setGdxx(String gdxx) {
        this.gdxx = gdxx == null ? null : gdxx.trim();
    }

    public Long getZrs() {
        return zrs;
    }

    public void setZrs(Long zrs) {
        this.zrs = zrs;
    }

    public Integer getHdrs() {
        return hdrs;
    }

    public void setHdrs(Integer hdrs) {
        this.hdrs = hdrs;
    }

    public String getBagsmc() {
        return bagsmc;
    }

    public void setBagsmc(String bagsmc) {
        this.bagsmc = bagsmc == null ? null : bagsmc.trim();
    }

    public String getBafzrgmsfhm() {
        return bafzrgmsfhm;
    }

    public void setBafzrgmsfhm(String bafzrgmsfhm) {
        this.bafzrgmsfhm = bafzrgmsfhm == null ? null : bafzrgmsfhm.trim();
    }

    public String getBafzrxm() {
        return bafzrxm;
    }

    public void setBafzrxm(String bafzrxm) {
        this.bafzrxm = bafzrxm == null ? null : bafzrxm.trim();
    }

    public String getBafzrdh() {
        return bafzrdh;
    }

    public void setBafzrdh(String bafzrdh) {
        this.bafzrdh = bafzrdh == null ? null : bafzrdh.trim();
    }

    public Integer getBars() {
        return bars;
    }

    public void setBars(Integer bars) {
        this.bars = bars;
    }

    public Integer getJgpxrs() {
        return jgpxrs;
    }

    public void setJgpxrs(Integer jgpxrs) {
        this.jgpxrs = jgpxrs;
    }

    public String getBagsyj() {
        return bagsyj;
    }

    public void setBagsyj(String bagsyj) {
        this.bagsyj = bagsyj == null ? null : bagsyj.trim();
    }

    public Integer getCksl() {
        return cksl;
    }

    public void setCksl(Integer cksl) {
        this.cksl = cksl;
    }

    public Integer getBxbjsl() {
        return bxbjsl;
    }

    public void setBxbjsl(Integer bxbjsl) {
        this.bxbjsl = bxbjsl;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Short getDcbs() {
        return dcbs;
    }

    public void setDcbs(Short dcbs) {
        this.dcbs = dcbs;
    }

    public Date getDcsj() {
        return dcsj;
    }

    public void setDcsj(Date dcsj) {
        this.dcsj = dcsj;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt == null ? null : zt.trim();
    }

    public Date getZtgbrq() {
        return ztgbrq;
    }

    public void setZtgbrq(Date ztgbrq) {
        this.ztgbrq = ztgbrq;
    }

    public Short getScbz() {
        return scbz;
    }

    public void setScbz(Short scbz) {
        this.scbz = scbz;
    }

    public String getJqbm() {
        return jqbm;
    }

    public void setJqbm(String jqbm) {
        this.jqbm = jqbm == null ? null : jqbm.trim();
    }

    public String getZxbz() {
        return zxbz;
    }

    public void setZxbz(String zxbz) {
        this.zxbz = zxbz == null ? null : zxbz.trim();
    }

    public String getZxyy() {
        return zxyy;
    }

    public void setZxyy(String zxyy) {
        this.zxyy = zxyy == null ? null : zxyy.trim();
    }

    public BigDecimal getZdskb() {
        return zdskb;
    }

    public void setZdskb(BigDecimal zdskb) {
        this.zdskb = zdskb;
    }

    public Date getBcsj() {
        return bcsj;
    }

    public void setBcsj(Date bcsj) {
        this.bcsj = bcsj;
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr == null ? null : lrr.trim();
    }

    public String getLrdwbm() {
        return lrdwbm;
    }

    public void setLrdwbm(String lrdwbm) {
        this.lrdwbm = lrdwbm == null ? null : lrdwbm.trim();
    }

    public String getLrdwmc() {
        return lrdwmc;
    }

    public void setLrdwmc(String lrdwmc) {
        this.lrdwmc = lrdwmc == null ? null : lrdwmc.trim();
    }

    public String getThbajgdm() {
        return thbajgdm;
    }

    public void setThbajgdm(String thbajgdm) {
        this.thbajgdm = thbajgdm == null ? null : thbajgdm.trim();
    }

    public String getThbajg() {
        return thbajg;
    }

    public void setThbajg(String thbajg) {
        this.thbajg = thbajg == null ? null : thbajg.trim();
    }

    public String getBwbmdh() {
        return bwbmdh;
    }

    public void setBwbmdh(String bwbmdh) {
        this.bwbmdh = bwbmdh == null ? null : bwbmdh.trim();
    }

    public String getSfazsxt() {
        return sfazsxt;
    }

    public void setSfazsxt(String sfazsxt) {
        this.sfazsxt = sfazsxt == null ? null : sfazsxt.trim();
    }

    public Integer getAzsxtsl() {
        return azsxtsl;
    }

    public void setAzsxtsl(Integer azsxtsl) {
        this.azsxtsl = azsxtsl;
    }

    public String getZjztdm() {
        return zjztdm;
    }

    public void setZjztdm(String zjztdm) {
        this.zjztdm = zjztdm == null ? null : zjztdm.trim();
    }

    public String getZjztmc() {
        return zjztmc;
    }

    public void setZjztmc(String zjztmc) {
        this.zjztmc = zjztmc == null ? null : zjztmc.trim();
    }

    public Date getDjrq() {
        return djrq;
    }

    public void setDjrq(Date djrq) {
        this.djrq = djrq;
    }

    public Date getNsrq() {
        return nsrq;
    }

    public void setNsrq(Date nsrq) {
        this.nsrq = nsrq;
    }

    public String getQyjc() {
        return qyjc;
    }

    public void setQyjc(String qyjc) {
        this.qyjc = qyjc == null ? null : qyjc.trim();
    }

    public String getQyjcqp() {
        return qyjcqp;
    }

    public void setQyjcqp(String qyjcqp) {
        this.qyjcqp = qyjcqp == null ? null : qyjcqp.trim();
    }

    public String getQyjcjp() {
        return qyjcjp;
    }

    public void setQyjcjp(String qyjcjp) {
        this.qyjcjp = qyjcjp == null ? null : qyjcjp.trim();
    }

    public String getSgscxfjjs() {
        return sgscxfjjs;
    }

    public void setSgscxfjjs(String sgscxfjjs) {
        this.sgscxfjjs = sgscxfjjs == null ? null : sgscxfjjs.trim();
    }

    public String getJhltlxdm() {
        return jhltlxdm;
    }

    public void setJhltlxdm(String jhltlxdm) {
        this.jhltlxdm = jhltlxdm == null ? null : jhltlxdm.trim();
    }

    public String getJhltlxmc() {
        return jhltlxmc;
    }

    public void setJhltlxmc(String jhltlxmc) {
        this.jhltlxmc = jhltlxmc == null ? null : jhltlxmc.trim();
    }

    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt == null ? null : sbzt.trim();
    }

    public String getWxywfl() {
        return wxywfl;
    }

    public void setWxywfl(String wxywfl) {
        this.wxywfl = wxywfl == null ? null : wxywfl.trim();
    }

    public String getWxywfldm() {
        return wxywfldm;
    }

    public void setWxywfldm(String wxywfldm) {
        this.wxywfldm = wxywfldm == null ? null : wxywfldm.trim();
    }

    public String getXfshyjsbh() {
        return xfshyjsbh;
    }

    public void setXfshyjsbh(String xfshyjsbh) {
        this.xfshyjsbh = xfshyjsbh == null ? null : xfshyjsbh.trim();
    }

    public String getXfshyjsfzjg() {
        return xfshyjsfzjg;
    }

    public void setXfshyjsfzjg(String xfshyjsfzjg) {
        this.xfshyjsfzjg = xfshyjsfzjg == null ? null : xfshyjsfzjg.trim();
    }

    public String getXfshyjsfzjgdm() {
        return xfshyjsfzjgdm;
    }

    public void setXfshyjsfzjgdm(String xfshyjsfzjgdm) {
        this.xfshyjsfzjgdm = xfshyjsfzjgdm == null ? null : xfshyjsfzjgdm.trim();
    }

    public Date getXfshyjsfzrq() {
        return xfshyjsfzrq;
    }

    public void setXfshyjsfzrq(Date xfshyjsfzrq) {
        this.xfshyjsfzrq = xfshyjsfzrq;
    }

    public Date getYyzzyxqz() {
        return yyzzyxqz;
    }

    public void setYyzzyxqz(Date yyzzyxqz) {
        this.yyzzyxqz = yyzzyxqz;
    }

    public Date getYyzzfzrq() {
        return yyzzfzrq;
    }

    public void setYyzzfzrq(Date yyzzfzrq) {
        this.yyzzfzrq = yyzzfzrq;
    }

    public Date getThxkzyxqz() {
        return thxkzyxqz;
    }

    public void setThxkzyxqz(Date thxkzyxqz) {
        this.thxkzyxqz = thxkzyxqz;
    }

    public Date getThxkzfzrq() {
        return thxkzfzrq;
    }

    public void setThxkzfzrq(Date thxkzfzrq) {
        this.thxkzfzrq = thxkzfzrq;
    }

    public Date getJyxkzyxqz() {
        return jyxkzyxqz;
    }

    public void setJyxkzyxqz(Date jyxkzyxqz) {
        this.jyxkzyxqz = jyxkzyxqz;
    }

    public Date getJyxkzfzrq() {
        return jyxkzfzrq;
    }

    public void setJyxkzfzrq(Date jyxkzfzrq) {
        this.jyxkzfzrq = jyxkzfzrq;
    }

    public String getJyfzrxbdm() {
        return jyfzrxbdm;
    }

    public void setJyfzrxbdm(String jyfzrxbdm) {
        this.jyfzrxbdm = jyfzrxbdm == null ? null : jyfzrxbdm.trim();
    }

    public String getJyfzrxb() {
        return jyfzrxb;
    }

    public void setJyfzrxb(String jyfzrxb) {
        this.jyfzrxb = jyfzrxb == null ? null : jyfzrxb.trim();
    }

    public String getFrxbdm() {
        return frxbdm;
    }

    public void setFrxbdm(String frxbdm) {
        this.frxbdm = frxbdm == null ? null : frxbdm.trim();
    }

    public String getFrxb() {
        return frxb;
    }

    public void setFrxb(String frxb) {
        this.frxb = frxb == null ? null : frxb.trim();
    }

    public String getGdjycscqbh() {
        return gdjycscqbh;
    }

    public void setGdjycscqbh(String gdjycscqbh) {
        this.gdjycscqbh = gdjycscqbh == null ? null : gdjycscqbh.trim();
    }

    public String getGdjycssyqbh() {
        return gdjycssyqbh;
    }

    public void setGdjycssyqbh(String gdjycssyqbh) {
        this.gdjycssyqbh = gdjycssyqbh == null ? null : gdjycssyqbh.trim();
    }

    public String getSfjy() {
        return sfjy;
    }

    public void setSfjy(String sfjy) {
        this.sfjy = sfjy == null ? null : sfjy.trim();
    }

    public String getSsxdm() {
        return ssxdm;
    }

    public void setSsxdm(String ssxdm) {
        this.ssxdm = ssxdm == null ? null : ssxdm.trim();
    }

    public String getSsxmc() {
        return ssxmc;
    }

    public void setSsxmc(String ssxmc) {
        this.ssxmc = ssxmc == null ? null : ssxmc.trim();
    }

    public String getKdjyxkzbh() {
        return kdjyxkzbh;
    }

    public void setKdjyxkzbh(String kdjyxkzbh) {
        this.kdjyxkzbh = kdjyxkzbh == null ? null : kdjyxkzbh.trim();
    }

    public String getWstzqypzzsh() {
        return wstzqypzzsh;
    }

    public void setWstzqypzzsh(String wstzqypzzsh) {
        this.wstzqypzzsh = wstzqypzzsh == null ? null : wstzqypzzsh.trim();
    }

    public String getHwxg() {
        return hwxg;
    }

    public void setHwxg(String hwxg) {
        this.hwxg = hwxg == null ? null : hwxg.trim();
    }

    public String getQymj() {
        return qymj;
    }

    public void setQymj(String qymj) {
        this.qymj = qymj == null ? null : qymj.trim();
    }

    public String getQymjlxdh() {
        return qymjlxdh;
    }

    public void setQymjlxdh(String qymjlxdh) {
        this.qymjlxdh = qymjlxdh == null ? null : qymjlxdh.trim();
    }

    public Integer getZdyjrs() {
        return zdyjrs;
    }

    public void setZdyjrs(Integer zdyjrs) {
        this.zdyjrs = zdyjrs;
    }
}