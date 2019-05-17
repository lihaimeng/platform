package com.yuxin.platform.zongzhi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DmXctbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DmXctbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTbidIsNull() {
            addCriterion("TBID is null");
            return (Criteria) this;
        }

        public Criteria andTbidIsNotNull() {
            addCriterion("TBID is not null");
            return (Criteria) this;
        }

        public Criteria andTbidEqualTo(Integer value) {
            addCriterion("TBID =", value, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidNotEqualTo(Integer value) {
            addCriterion("TBID <>", value, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidGreaterThan(Integer value) {
            addCriterion("TBID >", value, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TBID >=", value, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidLessThan(Integer value) {
            addCriterion("TBID <", value, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidLessThanOrEqualTo(Integer value) {
            addCriterion("TBID <=", value, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidIn(List<Integer> values) {
            addCriterion("TBID in", values, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidNotIn(List<Integer> values) {
            addCriterion("TBID not in", values, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidBetween(Integer value1, Integer value2) {
            addCriterion("TBID between", value1, value2, "tbid");
            return (Criteria) this;
        }

        public Criteria andTbidNotBetween(Integer value1, Integer value2) {
            addCriterion("TBID not between", value1, value2, "tbid");
            return (Criteria) this;
        }

        public Criteria andBtIsNull() {
            addCriterion("BT is null");
            return (Criteria) this;
        }

        public Criteria andBtIsNotNull() {
            addCriterion("BT is not null");
            return (Criteria) this;
        }

        public Criteria andBtEqualTo(String value) {
            addCriterion("BT =", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtNotEqualTo(String value) {
            addCriterion("BT <>", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtGreaterThan(String value) {
            addCriterion("BT >", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtGreaterThanOrEqualTo(String value) {
            addCriterion("BT >=", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtLessThan(String value) {
            addCriterion("BT <", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtLessThanOrEqualTo(String value) {
            addCriterion("BT <=", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtLike(String value) {
            addCriterion("BT like", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtNotLike(String value) {
            addCriterion("BT not like", value, "bt");
            return (Criteria) this;
        }

        public Criteria andBtIn(List<String> values) {
            addCriterion("BT in", values, "bt");
            return (Criteria) this;
        }

        public Criteria andBtNotIn(List<String> values) {
            addCriterion("BT not in", values, "bt");
            return (Criteria) this;
        }

        public Criteria andBtBetween(String value1, String value2) {
            addCriterion("BT between", value1, value2, "bt");
            return (Criteria) this;
        }

        public Criteria andBtNotBetween(String value1, String value2) {
            addCriterion("BT not between", value1, value2, "bt");
            return (Criteria) this;
        }

        public Criteria andFbsjIsNull() {
            addCriterion("FBSJ is null");
            return (Criteria) this;
        }

        public Criteria andFbsjIsNotNull() {
            addCriterion("FBSJ is not null");
            return (Criteria) this;
        }

        public Criteria andFbsjEqualTo(Date value) {
            addCriterion("FBSJ =", value, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjNotEqualTo(Date value) {
            addCriterion("FBSJ <>", value, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjGreaterThan(Date value) {
            addCriterion("FBSJ >", value, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjGreaterThanOrEqualTo(Date value) {
            addCriterion("FBSJ >=", value, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjLessThan(Date value) {
            addCriterion("FBSJ <", value, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjLessThanOrEqualTo(Date value) {
            addCriterion("FBSJ <=", value, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjIn(List<Date> values) {
            addCriterion("FBSJ in", values, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjNotIn(List<Date> values) {
            addCriterion("FBSJ not in", values, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjBetween(Date value1, Date value2) {
            addCriterion("FBSJ between", value1, value2, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbsjNotBetween(Date value1, Date value2) {
            addCriterion("FBSJ not between", value1, value2, "fbsj");
            return (Criteria) this;
        }

        public Criteria andFbnrIsNull() {
            addCriterion("FBNR is null");
            return (Criteria) this;
        }

        public Criteria andFbnrIsNotNull() {
            addCriterion("FBNR is not null");
            return (Criteria) this;
        }

        public Criteria andFbnrEqualTo(String value) {
            addCriterion("FBNR =", value, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrNotEqualTo(String value) {
            addCriterion("FBNR <>", value, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrGreaterThan(String value) {
            addCriterion("FBNR >", value, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrGreaterThanOrEqualTo(String value) {
            addCriterion("FBNR >=", value, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrLessThan(String value) {
            addCriterion("FBNR <", value, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrLessThanOrEqualTo(String value) {
            addCriterion("FBNR <=", value, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrLike(String value) {
            addCriterion("FBNR like", value, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrNotLike(String value) {
            addCriterion("FBNR not like", value, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrIn(List<String> values) {
            addCriterion("FBNR in", values, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrNotIn(List<String> values) {
            addCriterion("FBNR not in", values, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrBetween(String value1, String value2) {
            addCriterion("FBNR between", value1, value2, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbnrNotBetween(String value1, String value2) {
            addCriterion("FBNR not between", value1, value2, "fbnr");
            return (Criteria) this;
        }

        public Criteria andFbrIsNull() {
            addCriterion("FBR is null");
            return (Criteria) this;
        }

        public Criteria andFbrIsNotNull() {
            addCriterion("FBR is not null");
            return (Criteria) this;
        }

        public Criteria andFbrEqualTo(String value) {
            addCriterion("FBR =", value, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrNotEqualTo(String value) {
            addCriterion("FBR <>", value, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrGreaterThan(String value) {
            addCriterion("FBR >", value, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrGreaterThanOrEqualTo(String value) {
            addCriterion("FBR >=", value, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrLessThan(String value) {
            addCriterion("FBR <", value, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrLessThanOrEqualTo(String value) {
            addCriterion("FBR <=", value, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrLike(String value) {
            addCriterion("FBR like", value, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrNotLike(String value) {
            addCriterion("FBR not like", value, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrIn(List<String> values) {
            addCriterion("FBR in", values, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrNotIn(List<String> values) {
            addCriterion("FBR not in", values, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrBetween(String value1, String value2) {
            addCriterion("FBR between", value1, value2, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbrNotBetween(String value1, String value2) {
            addCriterion("FBR not between", value1, value2, "fbr");
            return (Criteria) this;
        }

        public Criteria andFbdwbmIsNull() {
            addCriterion("FBDWBM is null");
            return (Criteria) this;
        }

        public Criteria andFbdwbmIsNotNull() {
            addCriterion("FBDWBM is not null");
            return (Criteria) this;
        }

        public Criteria andFbdwbmEqualTo(String value) {
            addCriterion("FBDWBM =", value, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmNotEqualTo(String value) {
            addCriterion("FBDWBM <>", value, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmGreaterThan(String value) {
            addCriterion("FBDWBM >", value, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmGreaterThanOrEqualTo(String value) {
            addCriterion("FBDWBM >=", value, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmLessThan(String value) {
            addCriterion("FBDWBM <", value, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmLessThanOrEqualTo(String value) {
            addCriterion("FBDWBM <=", value, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmLike(String value) {
            addCriterion("FBDWBM like", value, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmNotLike(String value) {
            addCriterion("FBDWBM not like", value, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmIn(List<String> values) {
            addCriterion("FBDWBM in", values, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmNotIn(List<String> values) {
            addCriterion("FBDWBM not in", values, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmBetween(String value1, String value2) {
            addCriterion("FBDWBM between", value1, value2, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwbmNotBetween(String value1, String value2) {
            addCriterion("FBDWBM not between", value1, value2, "fbdwbm");
            return (Criteria) this;
        }

        public Criteria andFbdwIsNull() {
            addCriterion("FBDW is null");
            return (Criteria) this;
        }

        public Criteria andFbdwIsNotNull() {
            addCriterion("FBDW is not null");
            return (Criteria) this;
        }

        public Criteria andFbdwEqualTo(String value) {
            addCriterion("FBDW =", value, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwNotEqualTo(String value) {
            addCriterion("FBDW <>", value, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwGreaterThan(String value) {
            addCriterion("FBDW >", value, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwGreaterThanOrEqualTo(String value) {
            addCriterion("FBDW >=", value, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwLessThan(String value) {
            addCriterion("FBDW <", value, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwLessThanOrEqualTo(String value) {
            addCriterion("FBDW <=", value, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwLike(String value) {
            addCriterion("FBDW like", value, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwNotLike(String value) {
            addCriterion("FBDW not like", value, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwIn(List<String> values) {
            addCriterion("FBDW in", values, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwNotIn(List<String> values) {
            addCriterion("FBDW not in", values, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwBetween(String value1, String value2) {
            addCriterion("FBDW between", value1, value2, "fbdw");
            return (Criteria) this;
        }

        public Criteria andFbdwNotBetween(String value1, String value2) {
            addCriterion("FBDW not between", value1, value2, "fbdw");
            return (Criteria) this;
        }

        public Criteria andJzrqIsNull() {
            addCriterion("JZRQ is null");
            return (Criteria) this;
        }

        public Criteria andJzrqIsNotNull() {
            addCriterion("JZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJzrqEqualTo(Date value) {
            addCriterion("JZRQ =", value, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqNotEqualTo(Date value) {
            addCriterion("JZRQ <>", value, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqGreaterThan(Date value) {
            addCriterion("JZRQ >", value, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("JZRQ >=", value, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqLessThan(Date value) {
            addCriterion("JZRQ <", value, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqLessThanOrEqualTo(Date value) {
            addCriterion("JZRQ <=", value, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqIn(List<Date> values) {
            addCriterion("JZRQ in", values, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqNotIn(List<Date> values) {
            addCriterion("JZRQ not in", values, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqBetween(Date value1, Date value2) {
            addCriterion("JZRQ between", value1, value2, "jzrq");
            return (Criteria) this;
        }

        public Criteria andJzrqNotBetween(Date value1, Date value2) {
            addCriterion("JZRQ not between", value1, value2, "jzrq");
            return (Criteria) this;
        }

        public Criteria andGqbsIsNull() {
            addCriterion("GQBS is null");
            return (Criteria) this;
        }

        public Criteria andGqbsIsNotNull() {
            addCriterion("GQBS is not null");
            return (Criteria) this;
        }

        public Criteria andGqbsEqualTo(String value) {
            addCriterion("GQBS =", value, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsNotEqualTo(String value) {
            addCriterion("GQBS <>", value, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsGreaterThan(String value) {
            addCriterion("GQBS >", value, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsGreaterThanOrEqualTo(String value) {
            addCriterion("GQBS >=", value, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsLessThan(String value) {
            addCriterion("GQBS <", value, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsLessThanOrEqualTo(String value) {
            addCriterion("GQBS <=", value, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsLike(String value) {
            addCriterion("GQBS like", value, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsNotLike(String value) {
            addCriterion("GQBS not like", value, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsIn(List<String> values) {
            addCriterion("GQBS in", values, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsNotIn(List<String> values) {
            addCriterion("GQBS not in", values, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsBetween(String value1, String value2) {
            addCriterion("GQBS between", value1, value2, "gqbs");
            return (Criteria) this;
        }

        public Criteria andGqbsNotBetween(String value1, String value2) {
            addCriterion("GQBS not between", value1, value2, "gqbs");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmIsNull() {
            addCriterion("SXHYLBDM is null");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmIsNotNull() {
            addCriterion("SXHYLBDM is not null");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmEqualTo(String value) {
            addCriterion("SXHYLBDM =", value, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmNotEqualTo(String value) {
            addCriterion("SXHYLBDM <>", value, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmGreaterThan(String value) {
            addCriterion("SXHYLBDM >", value, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmGreaterThanOrEqualTo(String value) {
            addCriterion("SXHYLBDM >=", value, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmLessThan(String value) {
            addCriterion("SXHYLBDM <", value, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmLessThanOrEqualTo(String value) {
            addCriterion("SXHYLBDM <=", value, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmLike(String value) {
            addCriterion("SXHYLBDM like", value, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmNotLike(String value) {
            addCriterion("SXHYLBDM not like", value, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmIn(List<String> values) {
            addCriterion("SXHYLBDM in", values, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmNotIn(List<String> values) {
            addCriterion("SXHYLBDM not in", values, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmBetween(String value1, String value2) {
            addCriterion("SXHYLBDM between", value1, value2, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbdmNotBetween(String value1, String value2) {
            addCriterion("SXHYLBDM not between", value1, value2, "sxhylbdm");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcIsNull() {
            addCriterion("SXHYLBMC is null");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcIsNotNull() {
            addCriterion("SXHYLBMC is not null");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcEqualTo(String value) {
            addCriterion("SXHYLBMC =", value, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcNotEqualTo(String value) {
            addCriterion("SXHYLBMC <>", value, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcGreaterThan(String value) {
            addCriterion("SXHYLBMC >", value, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcGreaterThanOrEqualTo(String value) {
            addCriterion("SXHYLBMC >=", value, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcLessThan(String value) {
            addCriterion("SXHYLBMC <", value, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcLessThanOrEqualTo(String value) {
            addCriterion("SXHYLBMC <=", value, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcLike(String value) {
            addCriterion("SXHYLBMC like", value, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcNotLike(String value) {
            addCriterion("SXHYLBMC not like", value, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcIn(List<String> values) {
            addCriterion("SXHYLBMC in", values, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcNotIn(List<String> values) {
            addCriterion("SXHYLBMC not in", values, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcBetween(String value1, String value2) {
            addCriterion("SXHYLBMC between", value1, value2, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andSxhylbmcNotBetween(String value1, String value2) {
            addCriterion("SXHYLBMC not between", value1, value2, "sxhylbmc");
            return (Criteria) this;
        }

        public Criteria andYtbidIsNull() {
            addCriterion("YTBID is null");
            return (Criteria) this;
        }

        public Criteria andYtbidIsNotNull() {
            addCriterion("YTBID is not null");
            return (Criteria) this;
        }

        public Criteria andYtbidEqualTo(Long value) {
            addCriterion("YTBID =", value, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidNotEqualTo(Long value) {
            addCriterion("YTBID <>", value, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidGreaterThan(Long value) {
            addCriterion("YTBID >", value, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidGreaterThanOrEqualTo(Long value) {
            addCriterion("YTBID >=", value, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidLessThan(Long value) {
            addCriterion("YTBID <", value, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidLessThanOrEqualTo(Long value) {
            addCriterion("YTBID <=", value, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidIn(List<Long> values) {
            addCriterion("YTBID in", values, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidNotIn(List<Long> values) {
            addCriterion("YTBID not in", values, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidBetween(Long value1, Long value2) {
            addCriterion("YTBID between", value1, value2, "ytbid");
            return (Criteria) this;
        }

        public Criteria andYtbidNotBetween(Long value1, Long value2) {
            addCriterion("YTBID not between", value1, value2, "ytbid");
            return (Criteria) this;
        }

        public Criteria andSbztIsNull() {
            addCriterion("SBZT is null");
            return (Criteria) this;
        }

        public Criteria andSbztIsNotNull() {
            addCriterion("SBZT is not null");
            return (Criteria) this;
        }

        public Criteria andSbztEqualTo(String value) {
            addCriterion("SBZT =", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotEqualTo(String value) {
            addCriterion("SBZT <>", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThan(String value) {
            addCriterion("SBZT >", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztGreaterThanOrEqualTo(String value) {
            addCriterion("SBZT >=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThan(String value) {
            addCriterion("SBZT <", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLessThanOrEqualTo(String value) {
            addCriterion("SBZT <=", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztLike(String value) {
            addCriterion("SBZT like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotLike(String value) {
            addCriterion("SBZT not like", value, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztIn(List<String> values) {
            addCriterion("SBZT in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotIn(List<String> values) {
            addCriterion("SBZT not in", values, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztBetween(String value1, String value2) {
            addCriterion("SBZT between", value1, value2, "sbzt");
            return (Criteria) this;
        }

        public Criteria andSbztNotBetween(String value1, String value2) {
            addCriterion("SBZT not between", value1, value2, "sbzt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}