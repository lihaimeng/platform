package com.yuxin.platform.subpublic.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QyjbxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QyjbxxExample() {
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

        public Criteria andQyidIsNull() {
            addCriterion("QYID is null");
            return (Criteria) this;
        }

        public Criteria andQyidIsNotNull() {
            addCriterion("QYID is not null");
            return (Criteria) this;
        }

        public Criteria andQyidEqualTo(Integer value) {
            addCriterion("QYID =", value, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidNotEqualTo(Integer value) {
            addCriterion("QYID <>", value, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidGreaterThan(Integer value) {
            addCriterion("QYID >", value, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("QYID >=", value, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidLessThan(Integer value) {
            addCriterion("QYID <", value, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidLessThanOrEqualTo(Integer value) {
            addCriterion("QYID <=", value, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidIn(List<Integer> values) {
            addCriterion("QYID in", values, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidNotIn(List<Integer> values) {
            addCriterion("QYID not in", values, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidBetween(Integer value1, Integer value2) {
            addCriterion("QYID between", value1, value2, "qyid");
            return (Criteria) this;
        }

        public Criteria andQyidNotBetween(Integer value1, Integer value2) {
            addCriterion("QYID not between", value1, value2, "qyid");
            return (Criteria) this;
        }

        public Criteria andHylbdmIsNull() {
            addCriterion("HYLBDM is null");
            return (Criteria) this;
        }

        public Criteria andHylbdmIsNotNull() {
            addCriterion("HYLBDM is not null");
            return (Criteria) this;
        }

        public Criteria andHylbdmEqualTo(String value) {
            addCriterion("HYLBDM =", value, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmNotEqualTo(String value) {
            addCriterion("HYLBDM <>", value, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmGreaterThan(String value) {
            addCriterion("HYLBDM >", value, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmGreaterThanOrEqualTo(String value) {
            addCriterion("HYLBDM >=", value, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmLessThan(String value) {
            addCriterion("HYLBDM <", value, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmLessThanOrEqualTo(String value) {
            addCriterion("HYLBDM <=", value, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmLike(String value) {
            addCriterion("HYLBDM like", value, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmNotLike(String value) {
            addCriterion("HYLBDM not like", value, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmIn(List<String> values) {
            addCriterion("HYLBDM in", values, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmNotIn(List<String> values) {
            addCriterion("HYLBDM not in", values, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmBetween(String value1, String value2) {
            addCriterion("HYLBDM between", value1, value2, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbdmNotBetween(String value1, String value2) {
            addCriterion("HYLBDM not between", value1, value2, "hylbdm");
            return (Criteria) this;
        }

        public Criteria andHylbIsNull() {
            addCriterion("HYLB is null");
            return (Criteria) this;
        }

        public Criteria andHylbIsNotNull() {
            addCriterion("HYLB is not null");
            return (Criteria) this;
        }

        public Criteria andHylbEqualTo(String value) {
            addCriterion("HYLB =", value, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbNotEqualTo(String value) {
            addCriterion("HYLB <>", value, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbGreaterThan(String value) {
            addCriterion("HYLB >", value, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbGreaterThanOrEqualTo(String value) {
            addCriterion("HYLB >=", value, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbLessThan(String value) {
            addCriterion("HYLB <", value, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbLessThanOrEqualTo(String value) {
            addCriterion("HYLB <=", value, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbLike(String value) {
            addCriterion("HYLB like", value, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbNotLike(String value) {
            addCriterion("HYLB not like", value, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbIn(List<String> values) {
            addCriterion("HYLB in", values, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbNotIn(List<String> values) {
            addCriterion("HYLB not in", values, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbBetween(String value1, String value2) {
            addCriterion("HYLB between", value1, value2, "hylb");
            return (Criteria) this;
        }

        public Criteria andHylbNotBetween(String value1, String value2) {
            addCriterion("HYLB not between", value1, value2, "hylb");
            return (Criteria) this;
        }

        public Criteria andQybmIsNull() {
            addCriterion("QYBM is null");
            return (Criteria) this;
        }

        public Criteria andQybmIsNotNull() {
            addCriterion("QYBM is not null");
            return (Criteria) this;
        }

        public Criteria andQybmEqualTo(String value) {
            addCriterion("QYBM =", value, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmNotEqualTo(String value) {
            addCriterion("QYBM <>", value, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmGreaterThan(String value) {
            addCriterion("QYBM >", value, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmGreaterThanOrEqualTo(String value) {
            addCriterion("QYBM >=", value, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmLessThan(String value) {
            addCriterion("QYBM <", value, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmLessThanOrEqualTo(String value) {
            addCriterion("QYBM <=", value, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmLike(String value) {
            addCriterion("QYBM like", value, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmNotLike(String value) {
            addCriterion("QYBM not like", value, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmIn(List<String> values) {
            addCriterion("QYBM in", values, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmNotIn(List<String> values) {
            addCriterion("QYBM not in", values, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmBetween(String value1, String value2) {
            addCriterion("QYBM between", value1, value2, "qybm");
            return (Criteria) this;
        }

        public Criteria andQybmNotBetween(String value1, String value2) {
            addCriterion("QYBM not between", value1, value2, "qybm");
            return (Criteria) this;
        }

        public Criteria andQymcIsNull() {
            addCriterion("QYMC is null");
            return (Criteria) this;
        }

        public Criteria andQymcIsNotNull() {
            addCriterion("QYMC is not null");
            return (Criteria) this;
        }

        public Criteria andQymcEqualTo(String value) {
            addCriterion("QYMC =", value, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcNotEqualTo(String value) {
            addCriterion("QYMC <>", value, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcGreaterThan(String value) {
            addCriterion("QYMC >", value, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcGreaterThanOrEqualTo(String value) {
            addCriterion("QYMC >=", value, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcLessThan(String value) {
            addCriterion("QYMC <", value, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcLessThanOrEqualTo(String value) {
            addCriterion("QYMC <=", value, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcLike(String value) {
            addCriterion("QYMC like", value, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcNotLike(String value) {
            addCriterion("QYMC not like", value, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcIn(List<String> values) {
            addCriterion("QYMC in", values, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcNotIn(List<String> values) {
            addCriterion("QYMC not in", values, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcBetween(String value1, String value2) {
            addCriterion("QYMC between", value1, value2, "qymc");
            return (Criteria) this;
        }

        public Criteria andQymcNotBetween(String value1, String value2) {
            addCriterion("QYMC not between", value1, value2, "qymc");
            return (Criteria) this;
        }

        public Criteria andQyqpIsNull() {
            addCriterion("QYQP is null");
            return (Criteria) this;
        }

        public Criteria andQyqpIsNotNull() {
            addCriterion("QYQP is not null");
            return (Criteria) this;
        }

        public Criteria andQyqpEqualTo(String value) {
            addCriterion("QYQP =", value, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpNotEqualTo(String value) {
            addCriterion("QYQP <>", value, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpGreaterThan(String value) {
            addCriterion("QYQP >", value, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpGreaterThanOrEqualTo(String value) {
            addCriterion("QYQP >=", value, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpLessThan(String value) {
            addCriterion("QYQP <", value, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpLessThanOrEqualTo(String value) {
            addCriterion("QYQP <=", value, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpLike(String value) {
            addCriterion("QYQP like", value, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpNotLike(String value) {
            addCriterion("QYQP not like", value, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpIn(List<String> values) {
            addCriterion("QYQP in", values, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpNotIn(List<String> values) {
            addCriterion("QYQP not in", values, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpBetween(String value1, String value2) {
            addCriterion("QYQP between", value1, value2, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyqpNotBetween(String value1, String value2) {
            addCriterion("QYQP not between", value1, value2, "qyqp");
            return (Criteria) this;
        }

        public Criteria andQyjpIsNull() {
            addCriterion("QYJP is null");
            return (Criteria) this;
        }

        public Criteria andQyjpIsNotNull() {
            addCriterion("QYJP is not null");
            return (Criteria) this;
        }

        public Criteria andQyjpEqualTo(String value) {
            addCriterion("QYJP =", value, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpNotEqualTo(String value) {
            addCriterion("QYJP <>", value, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpGreaterThan(String value) {
            addCriterion("QYJP >", value, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpGreaterThanOrEqualTo(String value) {
            addCriterion("QYJP >=", value, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpLessThan(String value) {
            addCriterion("QYJP <", value, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpLessThanOrEqualTo(String value) {
            addCriterion("QYJP <=", value, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpLike(String value) {
            addCriterion("QYJP like", value, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpNotLike(String value) {
            addCriterion("QYJP not like", value, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpIn(List<String> values) {
            addCriterion("QYJP in", values, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpNotIn(List<String> values) {
            addCriterion("QYJP not in", values, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpBetween(String value1, String value2) {
            addCriterion("QYJP between", value1, value2, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyjpNotBetween(String value1, String value2) {
            addCriterion("QYJP not between", value1, value2, "qyjp");
            return (Criteria) this;
        }

        public Criteria andQyzflbmIsNull() {
            addCriterion("QYZFLBM is null");
            return (Criteria) this;
        }

        public Criteria andQyzflbmIsNotNull() {
            addCriterion("QYZFLBM is not null");
            return (Criteria) this;
        }

        public Criteria andQyzflbmEqualTo(String value) {
            addCriterion("QYZFLBM =", value, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmNotEqualTo(String value) {
            addCriterion("QYZFLBM <>", value, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmGreaterThan(String value) {
            addCriterion("QYZFLBM >", value, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmGreaterThanOrEqualTo(String value) {
            addCriterion("QYZFLBM >=", value, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmLessThan(String value) {
            addCriterion("QYZFLBM <", value, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmLessThanOrEqualTo(String value) {
            addCriterion("QYZFLBM <=", value, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmLike(String value) {
            addCriterion("QYZFLBM like", value, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmNotLike(String value) {
            addCriterion("QYZFLBM not like", value, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmIn(List<String> values) {
            addCriterion("QYZFLBM in", values, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmNotIn(List<String> values) {
            addCriterion("QYZFLBM not in", values, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmBetween(String value1, String value2) {
            addCriterion("QYZFLBM between", value1, value2, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflbmNotBetween(String value1, String value2) {
            addCriterion("QYZFLBM not between", value1, value2, "qyzflbm");
            return (Criteria) this;
        }

        public Criteria andQyzflmcIsNull() {
            addCriterion("QYZFLMC is null");
            return (Criteria) this;
        }

        public Criteria andQyzflmcIsNotNull() {
            addCriterion("QYZFLMC is not null");
            return (Criteria) this;
        }

        public Criteria andQyzflmcEqualTo(String value) {
            addCriterion("QYZFLMC =", value, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcNotEqualTo(String value) {
            addCriterion("QYZFLMC <>", value, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcGreaterThan(String value) {
            addCriterion("QYZFLMC >", value, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcGreaterThanOrEqualTo(String value) {
            addCriterion("QYZFLMC >=", value, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcLessThan(String value) {
            addCriterion("QYZFLMC <", value, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcLessThanOrEqualTo(String value) {
            addCriterion("QYZFLMC <=", value, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcLike(String value) {
            addCriterion("QYZFLMC like", value, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcNotLike(String value) {
            addCriterion("QYZFLMC not like", value, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcIn(List<String> values) {
            addCriterion("QYZFLMC in", values, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcNotIn(List<String> values) {
            addCriterion("QYZFLMC not in", values, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcBetween(String value1, String value2) {
            addCriterion("QYZFLMC between", value1, value2, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyzflmcNotBetween(String value1, String value2) {
            addCriterion("QYZFLMC not between", value1, value2, "qyzflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflbmIsNull() {
            addCriterion("QYFFLBM is null");
            return (Criteria) this;
        }

        public Criteria andQyfflbmIsNotNull() {
            addCriterion("QYFFLBM is not null");
            return (Criteria) this;
        }

        public Criteria andQyfflbmEqualTo(String value) {
            addCriterion("QYFFLBM =", value, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmNotEqualTo(String value) {
            addCriterion("QYFFLBM <>", value, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmGreaterThan(String value) {
            addCriterion("QYFFLBM >", value, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmGreaterThanOrEqualTo(String value) {
            addCriterion("QYFFLBM >=", value, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmLessThan(String value) {
            addCriterion("QYFFLBM <", value, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmLessThanOrEqualTo(String value) {
            addCriterion("QYFFLBM <=", value, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmLike(String value) {
            addCriterion("QYFFLBM like", value, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmNotLike(String value) {
            addCriterion("QYFFLBM not like", value, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmIn(List<String> values) {
            addCriterion("QYFFLBM in", values, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmNotIn(List<String> values) {
            addCriterion("QYFFLBM not in", values, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmBetween(String value1, String value2) {
            addCriterion("QYFFLBM between", value1, value2, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflbmNotBetween(String value1, String value2) {
            addCriterion("QYFFLBM not between", value1, value2, "qyfflbm");
            return (Criteria) this;
        }

        public Criteria andQyfflmcIsNull() {
            addCriterion("QYFFLMC is null");
            return (Criteria) this;
        }

        public Criteria andQyfflmcIsNotNull() {
            addCriterion("QYFFLMC is not null");
            return (Criteria) this;
        }

        public Criteria andQyfflmcEqualTo(String value) {
            addCriterion("QYFFLMC =", value, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcNotEqualTo(String value) {
            addCriterion("QYFFLMC <>", value, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcGreaterThan(String value) {
            addCriterion("QYFFLMC >", value, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcGreaterThanOrEqualTo(String value) {
            addCriterion("QYFFLMC >=", value, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcLessThan(String value) {
            addCriterion("QYFFLMC <", value, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcLessThanOrEqualTo(String value) {
            addCriterion("QYFFLMC <=", value, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcLike(String value) {
            addCriterion("QYFFLMC like", value, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcNotLike(String value) {
            addCriterion("QYFFLMC not like", value, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcIn(List<String> values) {
            addCriterion("QYFFLMC in", values, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcNotIn(List<String> values) {
            addCriterion("QYFFLMC not in", values, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcBetween(String value1, String value2) {
            addCriterion("QYFFLMC between", value1, value2, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andQyfflmcNotBetween(String value1, String value2) {
            addCriterion("QYFFLMC not between", value1, value2, "qyfflmc");
            return (Criteria) this;
        }

        public Criteria andGxdwbmIsNull() {
            addCriterion("GXDWBM is null");
            return (Criteria) this;
        }

        public Criteria andGxdwbmIsNotNull() {
            addCriterion("GXDWBM is not null");
            return (Criteria) this;
        }

        public Criteria andGxdwbmEqualTo(String value) {
            addCriterion("GXDWBM =", value, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmNotEqualTo(String value) {
            addCriterion("GXDWBM <>", value, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmGreaterThan(String value) {
            addCriterion("GXDWBM >", value, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmGreaterThanOrEqualTo(String value) {
            addCriterion("GXDWBM >=", value, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmLessThan(String value) {
            addCriterion("GXDWBM <", value, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmLessThanOrEqualTo(String value) {
            addCriterion("GXDWBM <=", value, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmLike(String value) {
            addCriterion("GXDWBM like", value, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmNotLike(String value) {
            addCriterion("GXDWBM not like", value, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmIn(List<String> values) {
            addCriterion("GXDWBM in", values, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmNotIn(List<String> values) {
            addCriterion("GXDWBM not in", values, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmBetween(String value1, String value2) {
            addCriterion("GXDWBM between", value1, value2, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwbmNotBetween(String value1, String value2) {
            addCriterion("GXDWBM not between", value1, value2, "gxdwbm");
            return (Criteria) this;
        }

        public Criteria andGxdwmcIsNull() {
            addCriterion("GXDWMC is null");
            return (Criteria) this;
        }

        public Criteria andGxdwmcIsNotNull() {
            addCriterion("GXDWMC is not null");
            return (Criteria) this;
        }

        public Criteria andGxdwmcEqualTo(String value) {
            addCriterion("GXDWMC =", value, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcNotEqualTo(String value) {
            addCriterion("GXDWMC <>", value, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcGreaterThan(String value) {
            addCriterion("GXDWMC >", value, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcGreaterThanOrEqualTo(String value) {
            addCriterion("GXDWMC >=", value, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcLessThan(String value) {
            addCriterion("GXDWMC <", value, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcLessThanOrEqualTo(String value) {
            addCriterion("GXDWMC <=", value, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcLike(String value) {
            addCriterion("GXDWMC like", value, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcNotLike(String value) {
            addCriterion("GXDWMC not like", value, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcIn(List<String> values) {
            addCriterion("GXDWMC in", values, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcNotIn(List<String> values) {
            addCriterion("GXDWMC not in", values, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcBetween(String value1, String value2) {
            addCriterion("GXDWMC between", value1, value2, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andGxdwmcNotBetween(String value1, String value2) {
            addCriterion("GXDWMC not between", value1, value2, "gxdwmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmIsNull() {
            addCriterion("SSDXJGAJGDM is null");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmIsNotNull() {
            addCriterion("SSDXJGAJGDM is not null");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmEqualTo(String value) {
            addCriterion("SSDXJGAJGDM =", value, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmNotEqualTo(String value) {
            addCriterion("SSDXJGAJGDM <>", value, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmGreaterThan(String value) {
            addCriterion("SSDXJGAJGDM >", value, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmGreaterThanOrEqualTo(String value) {
            addCriterion("SSDXJGAJGDM >=", value, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmLessThan(String value) {
            addCriterion("SSDXJGAJGDM <", value, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmLessThanOrEqualTo(String value) {
            addCriterion("SSDXJGAJGDM <=", value, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmLike(String value) {
            addCriterion("SSDXJGAJGDM like", value, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmNotLike(String value) {
            addCriterion("SSDXJGAJGDM not like", value, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmIn(List<String> values) {
            addCriterion("SSDXJGAJGDM in", values, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmNotIn(List<String> values) {
            addCriterion("SSDXJGAJGDM not in", values, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmBetween(String value1, String value2) {
            addCriterion("SSDXJGAJGDM between", value1, value2, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgdmNotBetween(String value1, String value2) {
            addCriterion("SSDXJGAJGDM not between", value1, value2, "ssdxjgajgdm");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcIsNull() {
            addCriterion("SSDXJGAJGMC is null");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcIsNotNull() {
            addCriterion("SSDXJGAJGMC is not null");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcEqualTo(String value) {
            addCriterion("SSDXJGAJGMC =", value, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcNotEqualTo(String value) {
            addCriterion("SSDXJGAJGMC <>", value, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcGreaterThan(String value) {
            addCriterion("SSDXJGAJGMC >", value, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcGreaterThanOrEqualTo(String value) {
            addCriterion("SSDXJGAJGMC >=", value, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcLessThan(String value) {
            addCriterion("SSDXJGAJGMC <", value, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcLessThanOrEqualTo(String value) {
            addCriterion("SSDXJGAJGMC <=", value, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcLike(String value) {
            addCriterion("SSDXJGAJGMC like", value, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcNotLike(String value) {
            addCriterion("SSDXJGAJGMC not like", value, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcIn(List<String> values) {
            addCriterion("SSDXJGAJGMC in", values, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcNotIn(List<String> values) {
            addCriterion("SSDXJGAJGMC not in", values, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcBetween(String value1, String value2) {
            addCriterion("SSDXJGAJGMC between", value1, value2, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsdxjgajgmcNotBetween(String value1, String value2) {
            addCriterion("SSDXJGAJGMC not between", value1, value2, "ssdxjgajgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmIsNull() {
            addCriterion("SSDDSJGDM is null");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmIsNotNull() {
            addCriterion("SSDDSJGDM is not null");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmEqualTo(String value) {
            addCriterion("SSDDSJGDM =", value, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmNotEqualTo(String value) {
            addCriterion("SSDDSJGDM <>", value, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmGreaterThan(String value) {
            addCriterion("SSDDSJGDM >", value, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmGreaterThanOrEqualTo(String value) {
            addCriterion("SSDDSJGDM >=", value, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmLessThan(String value) {
            addCriterion("SSDDSJGDM <", value, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmLessThanOrEqualTo(String value) {
            addCriterion("SSDDSJGDM <=", value, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmLike(String value) {
            addCriterion("SSDDSJGDM like", value, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmNotLike(String value) {
            addCriterion("SSDDSJGDM not like", value, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmIn(List<String> values) {
            addCriterion("SSDDSJGDM in", values, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmNotIn(List<String> values) {
            addCriterion("SSDDSJGDM not in", values, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmBetween(String value1, String value2) {
            addCriterion("SSDDSJGDM between", value1, value2, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgdmNotBetween(String value1, String value2) {
            addCriterion("SSDDSJGDM not between", value1, value2, "ssddsjgdm");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcIsNull() {
            addCriterion("SSDDSJGMC is null");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcIsNotNull() {
            addCriterion("SSDDSJGMC is not null");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcEqualTo(String value) {
            addCriterion("SSDDSJGMC =", value, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcNotEqualTo(String value) {
            addCriterion("SSDDSJGMC <>", value, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcGreaterThan(String value) {
            addCriterion("SSDDSJGMC >", value, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcGreaterThanOrEqualTo(String value) {
            addCriterion("SSDDSJGMC >=", value, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcLessThan(String value) {
            addCriterion("SSDDSJGMC <", value, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcLessThanOrEqualTo(String value) {
            addCriterion("SSDDSJGMC <=", value, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcLike(String value) {
            addCriterion("SSDDSJGMC like", value, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcNotLike(String value) {
            addCriterion("SSDDSJGMC not like", value, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcIn(List<String> values) {
            addCriterion("SSDDSJGMC in", values, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcNotIn(List<String> values) {
            addCriterion("SSDDSJGMC not in", values, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcBetween(String value1, String value2) {
            addCriterion("SSDDSJGMC between", value1, value2, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andSsddsjgmcNotBetween(String value1, String value2) {
            addCriterion("SSDDSJGMC not between", value1, value2, "ssddsjgmc");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmIsNull() {
            addCriterion("QYZZJGDM is null");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmIsNotNull() {
            addCriterion("QYZZJGDM is not null");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmEqualTo(String value) {
            addCriterion("QYZZJGDM =", value, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmNotEqualTo(String value) {
            addCriterion("QYZZJGDM <>", value, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmGreaterThan(String value) {
            addCriterion("QYZZJGDM >", value, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmGreaterThanOrEqualTo(String value) {
            addCriterion("QYZZJGDM >=", value, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmLessThan(String value) {
            addCriterion("QYZZJGDM <", value, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmLessThanOrEqualTo(String value) {
            addCriterion("QYZZJGDM <=", value, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmLike(String value) {
            addCriterion("QYZZJGDM like", value, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmNotLike(String value) {
            addCriterion("QYZZJGDM not like", value, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmIn(List<String> values) {
            addCriterion("QYZZJGDM in", values, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmNotIn(List<String> values) {
            addCriterion("QYZZJGDM not in", values, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmBetween(String value1, String value2) {
            addCriterion("QYZZJGDM between", value1, value2, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andQyzzjgdmNotBetween(String value1, String value2) {
            addCriterion("QYZZJGDM not between", value1, value2, "qyzzjgdm");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNull() {
            addCriterion("LXDH is null");
            return (Criteria) this;
        }

        public Criteria andLxdhIsNotNull() {
            addCriterion("LXDH is not null");
            return (Criteria) this;
        }

        public Criteria andLxdhEqualTo(String value) {
            addCriterion("LXDH =", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotEqualTo(String value) {
            addCriterion("LXDH <>", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThan(String value) {
            addCriterion("LXDH >", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhGreaterThanOrEqualTo(String value) {
            addCriterion("LXDH >=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThan(String value) {
            addCriterion("LXDH <", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLessThanOrEqualTo(String value) {
            addCriterion("LXDH <=", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhLike(String value) {
            addCriterion("LXDH like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotLike(String value) {
            addCriterion("LXDH not like", value, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhIn(List<String> values) {
            addCriterion("LXDH in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotIn(List<String> values) {
            addCriterion("LXDH not in", values, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhBetween(String value1, String value2) {
            addCriterion("LXDH between", value1, value2, "lxdh");
            return (Criteria) this;
        }

        public Criteria andLxdhNotBetween(String value1, String value2) {
            addCriterion("LXDH not between", value1, value2, "lxdh");
            return (Criteria) this;
        }

        public Criteria andYzbmIsNull() {
            addCriterion("YZBM is null");
            return (Criteria) this;
        }

        public Criteria andYzbmIsNotNull() {
            addCriterion("YZBM is not null");
            return (Criteria) this;
        }

        public Criteria andYzbmEqualTo(String value) {
            addCriterion("YZBM =", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmNotEqualTo(String value) {
            addCriterion("YZBM <>", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmGreaterThan(String value) {
            addCriterion("YZBM >", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmGreaterThanOrEqualTo(String value) {
            addCriterion("YZBM >=", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmLessThan(String value) {
            addCriterion("YZBM <", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmLessThanOrEqualTo(String value) {
            addCriterion("YZBM <=", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmLike(String value) {
            addCriterion("YZBM like", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmNotLike(String value) {
            addCriterion("YZBM not like", value, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmIn(List<String> values) {
            addCriterion("YZBM in", values, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmNotIn(List<String> values) {
            addCriterion("YZBM not in", values, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmBetween(String value1, String value2) {
            addCriterion("YZBM between", value1, value2, "yzbm");
            return (Criteria) this;
        }

        public Criteria andYzbmNotBetween(String value1, String value2) {
            addCriterion("YZBM not between", value1, value2, "yzbm");
            return (Criteria) this;
        }

        public Criteria andChzhIsNull() {
            addCriterion("CHZH is null");
            return (Criteria) this;
        }

        public Criteria andChzhIsNotNull() {
            addCriterion("CHZH is not null");
            return (Criteria) this;
        }

        public Criteria andChzhEqualTo(String value) {
            addCriterion("CHZH =", value, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhNotEqualTo(String value) {
            addCriterion("CHZH <>", value, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhGreaterThan(String value) {
            addCriterion("CHZH >", value, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhGreaterThanOrEqualTo(String value) {
            addCriterion("CHZH >=", value, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhLessThan(String value) {
            addCriterion("CHZH <", value, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhLessThanOrEqualTo(String value) {
            addCriterion("CHZH <=", value, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhLike(String value) {
            addCriterion("CHZH like", value, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhNotLike(String value) {
            addCriterion("CHZH not like", value, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhIn(List<String> values) {
            addCriterion("CHZH in", values, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhNotIn(List<String> values) {
            addCriterion("CHZH not in", values, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhBetween(String value1, String value2) {
            addCriterion("CHZH between", value1, value2, "chzh");
            return (Criteria) this;
        }

        public Criteria andChzhNotBetween(String value1, String value2) {
            addCriterion("CHZH not between", value1, value2, "chzh");
            return (Criteria) this;
        }

        public Criteria andJwdzbIsNull() {
            addCriterion("JWDZB is null");
            return (Criteria) this;
        }

        public Criteria andJwdzbIsNotNull() {
            addCriterion("JWDZB is not null");
            return (Criteria) this;
        }

        public Criteria andJwdzbEqualTo(String value) {
            addCriterion("JWDZB =", value, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbNotEqualTo(String value) {
            addCriterion("JWDZB <>", value, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbGreaterThan(String value) {
            addCriterion("JWDZB >", value, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbGreaterThanOrEqualTo(String value) {
            addCriterion("JWDZB >=", value, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbLessThan(String value) {
            addCriterion("JWDZB <", value, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbLessThanOrEqualTo(String value) {
            addCriterion("JWDZB <=", value, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbLike(String value) {
            addCriterion("JWDZB like", value, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbNotLike(String value) {
            addCriterion("JWDZB not like", value, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbIn(List<String> values) {
            addCriterion("JWDZB in", values, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbNotIn(List<String> values) {
            addCriterion("JWDZB not in", values, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbBetween(String value1, String value2) {
            addCriterion("JWDZB between", value1, value2, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJwdzbNotBetween(String value1, String value2) {
            addCriterion("JWDZB not between", value1, value2, "jwdzb");
            return (Criteria) this;
        }

        public Criteria andJjlxbmIsNull() {
            addCriterion("JJLXBM is null");
            return (Criteria) this;
        }

        public Criteria andJjlxbmIsNotNull() {
            addCriterion("JJLXBM is not null");
            return (Criteria) this;
        }

        public Criteria andJjlxbmEqualTo(String value) {
            addCriterion("JJLXBM =", value, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmNotEqualTo(String value) {
            addCriterion("JJLXBM <>", value, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmGreaterThan(String value) {
            addCriterion("JJLXBM >", value, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmGreaterThanOrEqualTo(String value) {
            addCriterion("JJLXBM >=", value, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmLessThan(String value) {
            addCriterion("JJLXBM <", value, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmLessThanOrEqualTo(String value) {
            addCriterion("JJLXBM <=", value, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmLike(String value) {
            addCriterion("JJLXBM like", value, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmNotLike(String value) {
            addCriterion("JJLXBM not like", value, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmIn(List<String> values) {
            addCriterion("JJLXBM in", values, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmNotIn(List<String> values) {
            addCriterion("JJLXBM not in", values, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmBetween(String value1, String value2) {
            addCriterion("JJLXBM between", value1, value2, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxbmNotBetween(String value1, String value2) {
            addCriterion("JJLXBM not between", value1, value2, "jjlxbm");
            return (Criteria) this;
        }

        public Criteria andJjlxmcIsNull() {
            addCriterion("JJLXMC is null");
            return (Criteria) this;
        }

        public Criteria andJjlxmcIsNotNull() {
            addCriterion("JJLXMC is not null");
            return (Criteria) this;
        }

        public Criteria andJjlxmcEqualTo(String value) {
            addCriterion("JJLXMC =", value, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcNotEqualTo(String value) {
            addCriterion("JJLXMC <>", value, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcGreaterThan(String value) {
            addCriterion("JJLXMC >", value, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcGreaterThanOrEqualTo(String value) {
            addCriterion("JJLXMC >=", value, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcLessThan(String value) {
            addCriterion("JJLXMC <", value, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcLessThanOrEqualTo(String value) {
            addCriterion("JJLXMC <=", value, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcLike(String value) {
            addCriterion("JJLXMC like", value, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcNotLike(String value) {
            addCriterion("JJLXMC not like", value, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcIn(List<String> values) {
            addCriterion("JJLXMC in", values, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcNotIn(List<String> values) {
            addCriterion("JJLXMC not in", values, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcBetween(String value1, String value2) {
            addCriterion("JJLXMC between", value1, value2, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJjlxmcNotBetween(String value1, String value2) {
            addCriterion("JJLXMC not between", value1, value2, "jjlxmc");
            return (Criteria) this;
        }

        public Criteria andJyfwzyIsNull() {
            addCriterion("JYFWZY is null");
            return (Criteria) this;
        }

        public Criteria andJyfwzyIsNotNull() {
            addCriterion("JYFWZY is not null");
            return (Criteria) this;
        }

        public Criteria andJyfwzyEqualTo(String value) {
            addCriterion("JYFWZY =", value, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyNotEqualTo(String value) {
            addCriterion("JYFWZY <>", value, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyGreaterThan(String value) {
            addCriterion("JYFWZY >", value, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyGreaterThanOrEqualTo(String value) {
            addCriterion("JYFWZY >=", value, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyLessThan(String value) {
            addCriterion("JYFWZY <", value, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyLessThanOrEqualTo(String value) {
            addCriterion("JYFWZY <=", value, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyLike(String value) {
            addCriterion("JYFWZY like", value, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyNotLike(String value) {
            addCriterion("JYFWZY not like", value, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyIn(List<String> values) {
            addCriterion("JYFWZY in", values, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyNotIn(List<String> values) {
            addCriterion("JYFWZY not in", values, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyBetween(String value1, String value2) {
            addCriterion("JYFWZY between", value1, value2, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwzyNotBetween(String value1, String value2) {
            addCriterion("JYFWZY not between", value1, value2, "jyfwzy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyIsNull() {
            addCriterion("JYFWJY is null");
            return (Criteria) this;
        }

        public Criteria andJyfwjyIsNotNull() {
            addCriterion("JYFWJY is not null");
            return (Criteria) this;
        }

        public Criteria andJyfwjyEqualTo(String value) {
            addCriterion("JYFWJY =", value, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyNotEqualTo(String value) {
            addCriterion("JYFWJY <>", value, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyGreaterThan(String value) {
            addCriterion("JYFWJY >", value, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyGreaterThanOrEqualTo(String value) {
            addCriterion("JYFWJY >=", value, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyLessThan(String value) {
            addCriterion("JYFWJY <", value, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyLessThanOrEqualTo(String value) {
            addCriterion("JYFWJY <=", value, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyLike(String value) {
            addCriterion("JYFWJY like", value, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyNotLike(String value) {
            addCriterion("JYFWJY not like", value, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyIn(List<String> values) {
            addCriterion("JYFWJY in", values, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyNotIn(List<String> values) {
            addCriterion("JYFWJY not in", values, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyBetween(String value1, String value2) {
            addCriterion("JYFWJY between", value1, value2, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andJyfwjyNotBetween(String value1, String value2) {
            addCriterion("JYFWJY not between", value1, value2, "jyfwjy");
            return (Criteria) this;
        }

        public Criteria andZczjIsNull() {
            addCriterion("ZCZJ is null");
            return (Criteria) this;
        }

        public Criteria andZczjIsNotNull() {
            addCriterion("ZCZJ is not null");
            return (Criteria) this;
        }

        public Criteria andZczjEqualTo(Integer value) {
            addCriterion("ZCZJ =", value, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjNotEqualTo(Integer value) {
            addCriterion("ZCZJ <>", value, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjGreaterThan(Integer value) {
            addCriterion("ZCZJ >", value, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZCZJ >=", value, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjLessThan(Integer value) {
            addCriterion("ZCZJ <", value, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjLessThanOrEqualTo(Integer value) {
            addCriterion("ZCZJ <=", value, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjIn(List<Integer> values) {
            addCriterion("ZCZJ in", values, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjNotIn(List<Integer> values) {
            addCriterion("ZCZJ not in", values, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjBetween(Integer value1, Integer value2) {
            addCriterion("ZCZJ between", value1, value2, "zczj");
            return (Criteria) this;
        }

        public Criteria andZczjNotBetween(Integer value1, Integer value2) {
            addCriterion("ZCZJ not between", value1, value2, "zczj");
            return (Criteria) this;
        }

        public Criteria andJymjIsNull() {
            addCriterion("JYMJ is null");
            return (Criteria) this;
        }

        public Criteria andJymjIsNotNull() {
            addCriterion("JYMJ is not null");
            return (Criteria) this;
        }

        public Criteria andJymjEqualTo(Integer value) {
            addCriterion("JYMJ =", value, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjNotEqualTo(Integer value) {
            addCriterion("JYMJ <>", value, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjGreaterThan(Integer value) {
            addCriterion("JYMJ >", value, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjGreaterThanOrEqualTo(Integer value) {
            addCriterion("JYMJ >=", value, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjLessThan(Integer value) {
            addCriterion("JYMJ <", value, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjLessThanOrEqualTo(Integer value) {
            addCriterion("JYMJ <=", value, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjIn(List<Integer> values) {
            addCriterion("JYMJ in", values, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjNotIn(List<Integer> values) {
            addCriterion("JYMJ not in", values, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjBetween(Integer value1, Integer value2) {
            addCriterion("JYMJ between", value1, value2, "jymj");
            return (Criteria) this;
        }

        public Criteria andJymjNotBetween(Integer value1, Integer value2) {
            addCriterion("JYMJ not between", value1, value2, "jymj");
            return (Criteria) this;
        }

        public Criteria andZabdmIsNull() {
            addCriterion("ZABDM is null");
            return (Criteria) this;
        }

        public Criteria andZabdmIsNotNull() {
            addCriterion("ZABDM is not null");
            return (Criteria) this;
        }

        public Criteria andZabdmEqualTo(String value) {
            addCriterion("ZABDM =", value, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmNotEqualTo(String value) {
            addCriterion("ZABDM <>", value, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmGreaterThan(String value) {
            addCriterion("ZABDM >", value, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmGreaterThanOrEqualTo(String value) {
            addCriterion("ZABDM >=", value, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmLessThan(String value) {
            addCriterion("ZABDM <", value, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmLessThanOrEqualTo(String value) {
            addCriterion("ZABDM <=", value, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmLike(String value) {
            addCriterion("ZABDM like", value, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmNotLike(String value) {
            addCriterion("ZABDM not like", value, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmIn(List<String> values) {
            addCriterion("ZABDM in", values, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmNotIn(List<String> values) {
            addCriterion("ZABDM not in", values, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmBetween(String value1, String value2) {
            addCriterion("ZABDM between", value1, value2, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZabdmNotBetween(String value1, String value2) {
            addCriterion("ZABDM not between", value1, value2, "zabdm");
            return (Criteria) this;
        }

        public Criteria andZajbmcIsNull() {
            addCriterion("ZAJBMC is null");
            return (Criteria) this;
        }

        public Criteria andZajbmcIsNotNull() {
            addCriterion("ZAJBMC is not null");
            return (Criteria) this;
        }

        public Criteria andZajbmcEqualTo(String value) {
            addCriterion("ZAJBMC =", value, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcNotEqualTo(String value) {
            addCriterion("ZAJBMC <>", value, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcGreaterThan(String value) {
            addCriterion("ZAJBMC >", value, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcGreaterThanOrEqualTo(String value) {
            addCriterion("ZAJBMC >=", value, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcLessThan(String value) {
            addCriterion("ZAJBMC <", value, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcLessThanOrEqualTo(String value) {
            addCriterion("ZAJBMC <=", value, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcLike(String value) {
            addCriterion("ZAJBMC like", value, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcNotLike(String value) {
            addCriterion("ZAJBMC not like", value, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcIn(List<String> values) {
            addCriterion("ZAJBMC in", values, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcNotIn(List<String> values) {
            addCriterion("ZAJBMC not in", values, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcBetween(String value1, String value2) {
            addCriterion("ZAJBMC between", value1, value2, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andZajbmcNotBetween(String value1, String value2) {
            addCriterion("ZAJBMC not between", value1, value2, "zajbmc");
            return (Criteria) this;
        }

        public Criteria andYyztdmIsNull() {
            addCriterion("YYZTDM is null");
            return (Criteria) this;
        }

        public Criteria andYyztdmIsNotNull() {
            addCriterion("YYZTDM is not null");
            return (Criteria) this;
        }

        public Criteria andYyztdmEqualTo(String value) {
            addCriterion("YYZTDM =", value, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmNotEqualTo(String value) {
            addCriterion("YYZTDM <>", value, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmGreaterThan(String value) {
            addCriterion("YYZTDM >", value, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmGreaterThanOrEqualTo(String value) {
            addCriterion("YYZTDM >=", value, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmLessThan(String value) {
            addCriterion("YYZTDM <", value, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmLessThanOrEqualTo(String value) {
            addCriterion("YYZTDM <=", value, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmLike(String value) {
            addCriterion("YYZTDM like", value, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmNotLike(String value) {
            addCriterion("YYZTDM not like", value, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmIn(List<String> values) {
            addCriterion("YYZTDM in", values, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmNotIn(List<String> values) {
            addCriterion("YYZTDM not in", values, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmBetween(String value1, String value2) {
            addCriterion("YYZTDM between", value1, value2, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztdmNotBetween(String value1, String value2) {
            addCriterion("YYZTDM not between", value1, value2, "yyztdm");
            return (Criteria) this;
        }

        public Criteria andYyztmcIsNull() {
            addCriterion("YYZTMC is null");
            return (Criteria) this;
        }

        public Criteria andYyztmcIsNotNull() {
            addCriterion("YYZTMC is not null");
            return (Criteria) this;
        }

        public Criteria andYyztmcEqualTo(String value) {
            addCriterion("YYZTMC =", value, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcNotEqualTo(String value) {
            addCriterion("YYZTMC <>", value, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcGreaterThan(String value) {
            addCriterion("YYZTMC >", value, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcGreaterThanOrEqualTo(String value) {
            addCriterion("YYZTMC >=", value, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcLessThan(String value) {
            addCriterion("YYZTMC <", value, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcLessThanOrEqualTo(String value) {
            addCriterion("YYZTMC <=", value, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcLike(String value) {
            addCriterion("YYZTMC like", value, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcNotLike(String value) {
            addCriterion("YYZTMC not like", value, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcIn(List<String> values) {
            addCriterion("YYZTMC in", values, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcNotIn(List<String> values) {
            addCriterion("YYZTMC not in", values, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcBetween(String value1, String value2) {
            addCriterion("YYZTMC between", value1, value2, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andYyztmcNotBetween(String value1, String value2) {
            addCriterion("YYZTMC not between", value1, value2, "yyztmc");
            return (Criteria) this;
        }

        public Criteria andFrdbIsNull() {
            addCriterion("FRDB is null");
            return (Criteria) this;
        }

        public Criteria andFrdbIsNotNull() {
            addCriterion("FRDB is not null");
            return (Criteria) this;
        }

        public Criteria andFrdbEqualTo(String value) {
            addCriterion("FRDB =", value, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbNotEqualTo(String value) {
            addCriterion("FRDB <>", value, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbGreaterThan(String value) {
            addCriterion("FRDB >", value, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbGreaterThanOrEqualTo(String value) {
            addCriterion("FRDB >=", value, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbLessThan(String value) {
            addCriterion("FRDB <", value, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbLessThanOrEqualTo(String value) {
            addCriterion("FRDB <=", value, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbLike(String value) {
            addCriterion("FRDB like", value, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbNotLike(String value) {
            addCriterion("FRDB not like", value, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbIn(List<String> values) {
            addCriterion("FRDB in", values, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbNotIn(List<String> values) {
            addCriterion("FRDB not in", values, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbBetween(String value1, String value2) {
            addCriterion("FRDB between", value1, value2, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbNotBetween(String value1, String value2) {
            addCriterion("FRDB not between", value1, value2, "frdb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbIsNull() {
            addCriterion("FRDBZJLB is null");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbIsNotNull() {
            addCriterion("FRDBZJLB is not null");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbEqualTo(String value) {
            addCriterion("FRDBZJLB =", value, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbNotEqualTo(String value) {
            addCriterion("FRDBZJLB <>", value, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbGreaterThan(String value) {
            addCriterion("FRDBZJLB >", value, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbGreaterThanOrEqualTo(String value) {
            addCriterion("FRDBZJLB >=", value, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbLessThan(String value) {
            addCriterion("FRDBZJLB <", value, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbLessThanOrEqualTo(String value) {
            addCriterion("FRDBZJLB <=", value, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbLike(String value) {
            addCriterion("FRDBZJLB like", value, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbNotLike(String value) {
            addCriterion("FRDBZJLB not like", value, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbIn(List<String> values) {
            addCriterion("FRDBZJLB in", values, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbNotIn(List<String> values) {
            addCriterion("FRDBZJLB not in", values, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbBetween(String value1, String value2) {
            addCriterion("FRDBZJLB between", value1, value2, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjlbNotBetween(String value1, String value2) {
            addCriterion("FRDBZJLB not between", value1, value2, "frdbzjlb");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmIsNull() {
            addCriterion("FRDBZJHM is null");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmIsNotNull() {
            addCriterion("FRDBZJHM is not null");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmEqualTo(String value) {
            addCriterion("FRDBZJHM =", value, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmNotEqualTo(String value) {
            addCriterion("FRDBZJHM <>", value, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmGreaterThan(String value) {
            addCriterion("FRDBZJHM >", value, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmGreaterThanOrEqualTo(String value) {
            addCriterion("FRDBZJHM >=", value, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmLessThan(String value) {
            addCriterion("FRDBZJHM <", value, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmLessThanOrEqualTo(String value) {
            addCriterion("FRDBZJHM <=", value, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmLike(String value) {
            addCriterion("FRDBZJHM like", value, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmNotLike(String value) {
            addCriterion("FRDBZJHM not like", value, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmIn(List<String> values) {
            addCriterion("FRDBZJHM in", values, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmNotIn(List<String> values) {
            addCriterion("FRDBZJHM not in", values, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmBetween(String value1, String value2) {
            addCriterion("FRDBZJHM between", value1, value2, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdbzjhmNotBetween(String value1, String value2) {
            addCriterion("FRDBZJHM not between", value1, value2, "frdbzjhm");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsIsNull() {
            addCriterion("FRDBLXFS is null");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsIsNotNull() {
            addCriterion("FRDBLXFS is not null");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsEqualTo(String value) {
            addCriterion("FRDBLXFS =", value, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsNotEqualTo(String value) {
            addCriterion("FRDBLXFS <>", value, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsGreaterThan(String value) {
            addCriterion("FRDBLXFS >", value, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsGreaterThanOrEqualTo(String value) {
            addCriterion("FRDBLXFS >=", value, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsLessThan(String value) {
            addCriterion("FRDBLXFS <", value, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsLessThanOrEqualTo(String value) {
            addCriterion("FRDBLXFS <=", value, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsLike(String value) {
            addCriterion("FRDBLXFS like", value, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsNotLike(String value) {
            addCriterion("FRDBLXFS not like", value, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsIn(List<String> values) {
            addCriterion("FRDBLXFS in", values, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsNotIn(List<String> values) {
            addCriterion("FRDBLXFS not in", values, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsBetween(String value1, String value2) {
            addCriterion("FRDBLXFS between", value1, value2, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andFrdblxfsNotBetween(String value1, String value2) {
            addCriterion("FRDBLXFS not between", value1, value2, "frdblxfs");
            return (Criteria) this;
        }

        public Criteria andKyrqIsNull() {
            addCriterion("KYRQ is null");
            return (Criteria) this;
        }

        public Criteria andKyrqIsNotNull() {
            addCriterion("KYRQ is not null");
            return (Criteria) this;
        }

        public Criteria andKyrqEqualTo(Date value) {
            addCriterion("KYRQ =", value, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqNotEqualTo(Date value) {
            addCriterion("KYRQ <>", value, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqGreaterThan(Date value) {
            addCriterion("KYRQ >", value, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqGreaterThanOrEqualTo(Date value) {
            addCriterion("KYRQ >=", value, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqLessThan(Date value) {
            addCriterion("KYRQ <", value, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqLessThanOrEqualTo(Date value) {
            addCriterion("KYRQ <=", value, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqIn(List<Date> values) {
            addCriterion("KYRQ in", values, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqNotIn(List<Date> values) {
            addCriterion("KYRQ not in", values, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqBetween(Date value1, Date value2) {
            addCriterion("KYRQ between", value1, value2, "kyrq");
            return (Criteria) this;
        }

        public Criteria andKyrqNotBetween(Date value1, Date value2) {
            addCriterion("KYRQ not between", value1, value2, "kyrq");
            return (Criteria) this;
        }

        public Criteria andYysjIsNull() {
            addCriterion("YYSJ is null");
            return (Criteria) this;
        }

        public Criteria andYysjIsNotNull() {
            addCriterion("YYSJ is not null");
            return (Criteria) this;
        }

        public Criteria andYysjEqualTo(String value) {
            addCriterion("YYSJ =", value, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjNotEqualTo(String value) {
            addCriterion("YYSJ <>", value, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjGreaterThan(String value) {
            addCriterion("YYSJ >", value, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjGreaterThanOrEqualTo(String value) {
            addCriterion("YYSJ >=", value, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjLessThan(String value) {
            addCriterion("YYSJ <", value, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjLessThanOrEqualTo(String value) {
            addCriterion("YYSJ <=", value, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjLike(String value) {
            addCriterion("YYSJ like", value, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjNotLike(String value) {
            addCriterion("YYSJ not like", value, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjIn(List<String> values) {
            addCriterion("YYSJ in", values, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjNotIn(List<String> values) {
            addCriterion("YYSJ not in", values, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjBetween(String value1, String value2) {
            addCriterion("YYSJ between", value1, value2, "yysj");
            return (Criteria) this;
        }

        public Criteria andYysjNotBetween(String value1, String value2) {
            addCriterion("YYSJ not between", value1, value2, "yysj");
            return (Criteria) this;
        }

        public Criteria andBabhIsNull() {
            addCriterion("BABH is null");
            return (Criteria) this;
        }

        public Criteria andBabhIsNotNull() {
            addCriterion("BABH is not null");
            return (Criteria) this;
        }

        public Criteria andBabhEqualTo(String value) {
            addCriterion("BABH =", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhNotEqualTo(String value) {
            addCriterion("BABH <>", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhGreaterThan(String value) {
            addCriterion("BABH >", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhGreaterThanOrEqualTo(String value) {
            addCriterion("BABH >=", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhLessThan(String value) {
            addCriterion("BABH <", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhLessThanOrEqualTo(String value) {
            addCriterion("BABH <=", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhLike(String value) {
            addCriterion("BABH like", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhNotLike(String value) {
            addCriterion("BABH not like", value, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhIn(List<String> values) {
            addCriterion("BABH in", values, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhNotIn(List<String> values) {
            addCriterion("BABH not in", values, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhBetween(String value1, String value2) {
            addCriterion("BABH between", value1, value2, "babh");
            return (Criteria) this;
        }

        public Criteria andBabhNotBetween(String value1, String value2) {
            addCriterion("BABH not between", value1, value2, "babh");
            return (Criteria) this;
        }

        public Criteria andBarqIsNull() {
            addCriterion("BARQ is null");
            return (Criteria) this;
        }

        public Criteria andBarqIsNotNull() {
            addCriterion("BARQ is not null");
            return (Criteria) this;
        }

        public Criteria andBarqEqualTo(Date value) {
            addCriterion("BARQ =", value, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqNotEqualTo(Date value) {
            addCriterion("BARQ <>", value, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqGreaterThan(Date value) {
            addCriterion("BARQ >", value, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqGreaterThanOrEqualTo(Date value) {
            addCriterion("BARQ >=", value, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqLessThan(Date value) {
            addCriterion("BARQ <", value, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqLessThanOrEqualTo(Date value) {
            addCriterion("BARQ <=", value, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqIn(List<Date> values) {
            addCriterion("BARQ in", values, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqNotIn(List<Date> values) {
            addCriterion("BARQ not in", values, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqBetween(Date value1, Date value2) {
            addCriterion("BARQ between", value1, value2, "barq");
            return (Criteria) this;
        }

        public Criteria andBarqNotBetween(Date value1, Date value2) {
            addCriterion("BARQ not between", value1, value2, "barq");
            return (Criteria) this;
        }

        public Criteria andTyrqIsNull() {
            addCriterion("TYRQ is null");
            return (Criteria) this;
        }

        public Criteria andTyrqIsNotNull() {
            addCriterion("TYRQ is not null");
            return (Criteria) this;
        }

        public Criteria andTyrqEqualTo(Date value) {
            addCriterion("TYRQ =", value, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqNotEqualTo(Date value) {
            addCriterion("TYRQ <>", value, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqGreaterThan(Date value) {
            addCriterion("TYRQ >", value, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqGreaterThanOrEqualTo(Date value) {
            addCriterion("TYRQ >=", value, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqLessThan(Date value) {
            addCriterion("TYRQ <", value, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqLessThanOrEqualTo(Date value) {
            addCriterion("TYRQ <=", value, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqIn(List<Date> values) {
            addCriterion("TYRQ in", values, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqNotIn(List<Date> values) {
            addCriterion("TYRQ not in", values, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqBetween(Date value1, Date value2) {
            addCriterion("TYRQ between", value1, value2, "tyrq");
            return (Criteria) this;
        }

        public Criteria andTyrqNotBetween(Date value1, Date value2) {
            addCriterion("TYRQ not between", value1, value2, "tyrq");
            return (Criteria) this;
        }

        public Criteria andJyfsIsNull() {
            addCriterion("JYFS is null");
            return (Criteria) this;
        }

        public Criteria andJyfsIsNotNull() {
            addCriterion("JYFS is not null");
            return (Criteria) this;
        }

        public Criteria andJyfsEqualTo(String value) {
            addCriterion("JYFS =", value, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsNotEqualTo(String value) {
            addCriterion("JYFS <>", value, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsGreaterThan(String value) {
            addCriterion("JYFS >", value, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsGreaterThanOrEqualTo(String value) {
            addCriterion("JYFS >=", value, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsLessThan(String value) {
            addCriterion("JYFS <", value, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsLessThanOrEqualTo(String value) {
            addCriterion("JYFS <=", value, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsLike(String value) {
            addCriterion("JYFS like", value, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsNotLike(String value) {
            addCriterion("JYFS not like", value, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsIn(List<String> values) {
            addCriterion("JYFS in", values, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsNotIn(List<String> values) {
            addCriterion("JYFS not in", values, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsBetween(String value1, String value2) {
            addCriterion("JYFS between", value1, value2, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJyfsNotBetween(String value1, String value2) {
            addCriterion("JYFS not between", value1, value2, "jyfs");
            return (Criteria) this;
        }

        public Criteria andJydzIsNull() {
            addCriterion("JYDZ is null");
            return (Criteria) this;
        }

        public Criteria andJydzIsNotNull() {
            addCriterion("JYDZ is not null");
            return (Criteria) this;
        }

        public Criteria andJydzEqualTo(String value) {
            addCriterion("JYDZ =", value, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzNotEqualTo(String value) {
            addCriterion("JYDZ <>", value, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzGreaterThan(String value) {
            addCriterion("JYDZ >", value, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzGreaterThanOrEqualTo(String value) {
            addCriterion("JYDZ >=", value, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzLessThan(String value) {
            addCriterion("JYDZ <", value, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzLessThanOrEqualTo(String value) {
            addCriterion("JYDZ <=", value, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzLike(String value) {
            addCriterion("JYDZ like", value, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzNotLike(String value) {
            addCriterion("JYDZ not like", value, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzIn(List<String> values) {
            addCriterion("JYDZ in", values, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzNotIn(List<String> values) {
            addCriterion("JYDZ not in", values, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzBetween(String value1, String value2) {
            addCriterion("JYDZ between", value1, value2, "jydz");
            return (Criteria) this;
        }

        public Criteria andJydzNotBetween(String value1, String value2) {
            addCriterion("JYDZ not between", value1, value2, "jydz");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbIsNull() {
            addCriterion("DWFZRZJLB is null");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbIsNotNull() {
            addCriterion("DWFZRZJLB is not null");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbEqualTo(String value) {
            addCriterion("DWFZRZJLB =", value, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbNotEqualTo(String value) {
            addCriterion("DWFZRZJLB <>", value, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbGreaterThan(String value) {
            addCriterion("DWFZRZJLB >", value, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbGreaterThanOrEqualTo(String value) {
            addCriterion("DWFZRZJLB >=", value, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbLessThan(String value) {
            addCriterion("DWFZRZJLB <", value, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbLessThanOrEqualTo(String value) {
            addCriterion("DWFZRZJLB <=", value, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbLike(String value) {
            addCriterion("DWFZRZJLB like", value, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbNotLike(String value) {
            addCriterion("DWFZRZJLB not like", value, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbIn(List<String> values) {
            addCriterion("DWFZRZJLB in", values, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbNotIn(List<String> values) {
            addCriterion("DWFZRZJLB not in", values, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbBetween(String value1, String value2) {
            addCriterion("DWFZRZJLB between", value1, value2, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjlbNotBetween(String value1, String value2) {
            addCriterion("DWFZRZJLB not between", value1, value2, "dwfzrzjlb");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmIsNull() {
            addCriterion("DWFZRZJHM is null");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmIsNotNull() {
            addCriterion("DWFZRZJHM is not null");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmEqualTo(String value) {
            addCriterion("DWFZRZJHM =", value, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmNotEqualTo(String value) {
            addCriterion("DWFZRZJHM <>", value, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmGreaterThan(String value) {
            addCriterion("DWFZRZJHM >", value, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmGreaterThanOrEqualTo(String value) {
            addCriterion("DWFZRZJHM >=", value, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmLessThan(String value) {
            addCriterion("DWFZRZJHM <", value, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmLessThanOrEqualTo(String value) {
            addCriterion("DWFZRZJHM <=", value, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmLike(String value) {
            addCriterion("DWFZRZJHM like", value, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmNotLike(String value) {
            addCriterion("DWFZRZJHM not like", value, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmIn(List<String> values) {
            addCriterion("DWFZRZJHM in", values, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmNotIn(List<String> values) {
            addCriterion("DWFZRZJHM not in", values, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmBetween(String value1, String value2) {
            addCriterion("DWFZRZJHM between", value1, value2, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrzjhmNotBetween(String value1, String value2) {
            addCriterion("DWFZRZJHM not between", value1, value2, "dwfzrzjhm");
            return (Criteria) this;
        }

        public Criteria andDwfzrIsNull() {
            addCriterion("DWFZR is null");
            return (Criteria) this;
        }

        public Criteria andDwfzrIsNotNull() {
            addCriterion("DWFZR is not null");
            return (Criteria) this;
        }

        public Criteria andDwfzrEqualTo(String value) {
            addCriterion("DWFZR =", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrNotEqualTo(String value) {
            addCriterion("DWFZR <>", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrGreaterThan(String value) {
            addCriterion("DWFZR >", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrGreaterThanOrEqualTo(String value) {
            addCriterion("DWFZR >=", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrLessThan(String value) {
            addCriterion("DWFZR <", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrLessThanOrEqualTo(String value) {
            addCriterion("DWFZR <=", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrLike(String value) {
            addCriterion("DWFZR like", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrNotLike(String value) {
            addCriterion("DWFZR not like", value, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrIn(List<String> values) {
            addCriterion("DWFZR in", values, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrNotIn(List<String> values) {
            addCriterion("DWFZR not in", values, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrBetween(String value1, String value2) {
            addCriterion("DWFZR between", value1, value2, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrNotBetween(String value1, String value2) {
            addCriterion("DWFZR not between", value1, value2, "dwfzr");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsIsNull() {
            addCriterion("DWFZRLXFS is null");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsIsNotNull() {
            addCriterion("DWFZRLXFS is not null");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsEqualTo(String value) {
            addCriterion("DWFZRLXFS =", value, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsNotEqualTo(String value) {
            addCriterion("DWFZRLXFS <>", value, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsGreaterThan(String value) {
            addCriterion("DWFZRLXFS >", value, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsGreaterThanOrEqualTo(String value) {
            addCriterion("DWFZRLXFS >=", value, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsLessThan(String value) {
            addCriterion("DWFZRLXFS <", value, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsLessThanOrEqualTo(String value) {
            addCriterion("DWFZRLXFS <=", value, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsLike(String value) {
            addCriterion("DWFZRLXFS like", value, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsNotLike(String value) {
            addCriterion("DWFZRLXFS not like", value, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsIn(List<String> values) {
            addCriterion("DWFZRLXFS in", values, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsNotIn(List<String> values) {
            addCriterion("DWFZRLXFS not in", values, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsBetween(String value1, String value2) {
            addCriterion("DWFZRLXFS between", value1, value2, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andDwfzrlxfsNotBetween(String value1, String value2) {
            addCriterion("DWFZRLXFS not between", value1, value2, "dwfzrlxfs");
            return (Criteria) this;
        }

        public Criteria andXfshdwIsNull() {
            addCriterion("XFSHDW is null");
            return (Criteria) this;
        }

        public Criteria andXfshdwIsNotNull() {
            addCriterion("XFSHDW is not null");
            return (Criteria) this;
        }

        public Criteria andXfshdwEqualTo(String value) {
            addCriterion("XFSHDW =", value, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwNotEqualTo(String value) {
            addCriterion("XFSHDW <>", value, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwGreaterThan(String value) {
            addCriterion("XFSHDW >", value, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwGreaterThanOrEqualTo(String value) {
            addCriterion("XFSHDW >=", value, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwLessThan(String value) {
            addCriterion("XFSHDW <", value, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwLessThanOrEqualTo(String value) {
            addCriterion("XFSHDW <=", value, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwLike(String value) {
            addCriterion("XFSHDW like", value, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwNotLike(String value) {
            addCriterion("XFSHDW not like", value, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwIn(List<String> values) {
            addCriterion("XFSHDW in", values, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwNotIn(List<String> values) {
            addCriterion("XFSHDW not in", values, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwBetween(String value1, String value2) {
            addCriterion("XFSHDW between", value1, value2, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfshdwNotBetween(String value1, String value2) {
            addCriterion("XFSHDW not between", value1, value2, "xfshdw");
            return (Criteria) this;
        }

        public Criteria andXfhgzhIsNull() {
            addCriterion("XFHGZH is null");
            return (Criteria) this;
        }

        public Criteria andXfhgzhIsNotNull() {
            addCriterion("XFHGZH is not null");
            return (Criteria) this;
        }

        public Criteria andXfhgzhEqualTo(String value) {
            addCriterion("XFHGZH =", value, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhNotEqualTo(String value) {
            addCriterion("XFHGZH <>", value, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhGreaterThan(String value) {
            addCriterion("XFHGZH >", value, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhGreaterThanOrEqualTo(String value) {
            addCriterion("XFHGZH >=", value, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhLessThan(String value) {
            addCriterion("XFHGZH <", value, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhLessThanOrEqualTo(String value) {
            addCriterion("XFHGZH <=", value, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhLike(String value) {
            addCriterion("XFHGZH like", value, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhNotLike(String value) {
            addCriterion("XFHGZH not like", value, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhIn(List<String> values) {
            addCriterion("XFHGZH in", values, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhNotIn(List<String> values) {
            addCriterion("XFHGZH not in", values, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhBetween(String value1, String value2) {
            addCriterion("XFHGZH between", value1, value2, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andXfhgzhNotBetween(String value1, String value2) {
            addCriterion("XFHGZH not between", value1, value2, "xfhgzh");
            return (Criteria) this;
        }

        public Criteria andHcdwIsNull() {
            addCriterion("HCDW is null");
            return (Criteria) this;
        }

        public Criteria andHcdwIsNotNull() {
            addCriterion("HCDW is not null");
            return (Criteria) this;
        }

        public Criteria andHcdwEqualTo(String value) {
            addCriterion("HCDW =", value, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwNotEqualTo(String value) {
            addCriterion("HCDW <>", value, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwGreaterThan(String value) {
            addCriterion("HCDW >", value, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwGreaterThanOrEqualTo(String value) {
            addCriterion("HCDW >=", value, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwLessThan(String value) {
            addCriterion("HCDW <", value, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwLessThanOrEqualTo(String value) {
            addCriterion("HCDW <=", value, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwLike(String value) {
            addCriterion("HCDW like", value, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwNotLike(String value) {
            addCriterion("HCDW not like", value, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwIn(List<String> values) {
            addCriterion("HCDW in", values, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwNotIn(List<String> values) {
            addCriterion("HCDW not in", values, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwBetween(String value1, String value2) {
            addCriterion("HCDW between", value1, value2, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcdwNotBetween(String value1, String value2) {
            addCriterion("HCDW not between", value1, value2, "hcdw");
            return (Criteria) this;
        }

        public Criteria andHcrIsNull() {
            addCriterion("HCR is null");
            return (Criteria) this;
        }

        public Criteria andHcrIsNotNull() {
            addCriterion("HCR is not null");
            return (Criteria) this;
        }

        public Criteria andHcrEqualTo(String value) {
            addCriterion("HCR =", value, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrNotEqualTo(String value) {
            addCriterion("HCR <>", value, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrGreaterThan(String value) {
            addCriterion("HCR >", value, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrGreaterThanOrEqualTo(String value) {
            addCriterion("HCR >=", value, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrLessThan(String value) {
            addCriterion("HCR <", value, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrLessThanOrEqualTo(String value) {
            addCriterion("HCR <=", value, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrLike(String value) {
            addCriterion("HCR like", value, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrNotLike(String value) {
            addCriterion("HCR not like", value, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrIn(List<String> values) {
            addCriterion("HCR in", values, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrNotIn(List<String> values) {
            addCriterion("HCR not in", values, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrBetween(String value1, String value2) {
            addCriterion("HCR between", value1, value2, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcrNotBetween(String value1, String value2) {
            addCriterion("HCR not between", value1, value2, "hcr");
            return (Criteria) this;
        }

        public Criteria andHcsjIsNull() {
            addCriterion("HCSJ is null");
            return (Criteria) this;
        }

        public Criteria andHcsjIsNotNull() {
            addCriterion("HCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andHcsjEqualTo(Date value) {
            addCriterion("HCSJ =", value, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjNotEqualTo(Date value) {
            addCriterion("HCSJ <>", value, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjGreaterThan(Date value) {
            addCriterion("HCSJ >", value, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjGreaterThanOrEqualTo(Date value) {
            addCriterion("HCSJ >=", value, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjLessThan(Date value) {
            addCriterion("HCSJ <", value, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjLessThanOrEqualTo(Date value) {
            addCriterion("HCSJ <=", value, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjIn(List<Date> values) {
            addCriterion("HCSJ in", values, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjNotIn(List<Date> values) {
            addCriterion("HCSJ not in", values, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjBetween(Date value1, Date value2) {
            addCriterion("HCSJ between", value1, value2, "hcsj");
            return (Criteria) this;
        }

        public Criteria andHcsjNotBetween(Date value1, Date value2) {
            addCriterion("HCSJ not between", value1, value2, "hcsj");
            return (Criteria) this;
        }

        public Criteria andGdxxIsNull() {
            addCriterion("GDXX is null");
            return (Criteria) this;
        }

        public Criteria andGdxxIsNotNull() {
            addCriterion("GDXX is not null");
            return (Criteria) this;
        }

        public Criteria andGdxxEqualTo(String value) {
            addCriterion("GDXX =", value, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxNotEqualTo(String value) {
            addCriterion("GDXX <>", value, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxGreaterThan(String value) {
            addCriterion("GDXX >", value, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxGreaterThanOrEqualTo(String value) {
            addCriterion("GDXX >=", value, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxLessThan(String value) {
            addCriterion("GDXX <", value, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxLessThanOrEqualTo(String value) {
            addCriterion("GDXX <=", value, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxLike(String value) {
            addCriterion("GDXX like", value, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxNotLike(String value) {
            addCriterion("GDXX not like", value, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxIn(List<String> values) {
            addCriterion("GDXX in", values, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxNotIn(List<String> values) {
            addCriterion("GDXX not in", values, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxBetween(String value1, String value2) {
            addCriterion("GDXX between", value1, value2, "gdxx");
            return (Criteria) this;
        }

        public Criteria andGdxxNotBetween(String value1, String value2) {
            addCriterion("GDXX not between", value1, value2, "gdxx");
            return (Criteria) this;
        }

        public Criteria andZrsIsNull() {
            addCriterion("ZRS is null");
            return (Criteria) this;
        }

        public Criteria andZrsIsNotNull() {
            addCriterion("ZRS is not null");
            return (Criteria) this;
        }

        public Criteria andZrsEqualTo(Long value) {
            addCriterion("ZRS =", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsNotEqualTo(Long value) {
            addCriterion("ZRS <>", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsGreaterThan(Long value) {
            addCriterion("ZRS >", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsGreaterThanOrEqualTo(Long value) {
            addCriterion("ZRS >=", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsLessThan(Long value) {
            addCriterion("ZRS <", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsLessThanOrEqualTo(Long value) {
            addCriterion("ZRS <=", value, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsIn(List<Long> values) {
            addCriterion("ZRS in", values, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsNotIn(List<Long> values) {
            addCriterion("ZRS not in", values, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsBetween(Long value1, Long value2) {
            addCriterion("ZRS between", value1, value2, "zrs");
            return (Criteria) this;
        }

        public Criteria andZrsNotBetween(Long value1, Long value2) {
            addCriterion("ZRS not between", value1, value2, "zrs");
            return (Criteria) this;
        }

        public Criteria andHdrsIsNull() {
            addCriterion("HDRS is null");
            return (Criteria) this;
        }

        public Criteria andHdrsIsNotNull() {
            addCriterion("HDRS is not null");
            return (Criteria) this;
        }

        public Criteria andHdrsEqualTo(Integer value) {
            addCriterion("HDRS =", value, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsNotEqualTo(Integer value) {
            addCriterion("HDRS <>", value, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsGreaterThan(Integer value) {
            addCriterion("HDRS >", value, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("HDRS >=", value, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsLessThan(Integer value) {
            addCriterion("HDRS <", value, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsLessThanOrEqualTo(Integer value) {
            addCriterion("HDRS <=", value, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsIn(List<Integer> values) {
            addCriterion("HDRS in", values, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsNotIn(List<Integer> values) {
            addCriterion("HDRS not in", values, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsBetween(Integer value1, Integer value2) {
            addCriterion("HDRS between", value1, value2, "hdrs");
            return (Criteria) this;
        }

        public Criteria andHdrsNotBetween(Integer value1, Integer value2) {
            addCriterion("HDRS not between", value1, value2, "hdrs");
            return (Criteria) this;
        }

        public Criteria andBagsmcIsNull() {
            addCriterion("BAGSMC is null");
            return (Criteria) this;
        }

        public Criteria andBagsmcIsNotNull() {
            addCriterion("BAGSMC is not null");
            return (Criteria) this;
        }

        public Criteria andBagsmcEqualTo(String value) {
            addCriterion("BAGSMC =", value, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcNotEqualTo(String value) {
            addCriterion("BAGSMC <>", value, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcGreaterThan(String value) {
            addCriterion("BAGSMC >", value, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcGreaterThanOrEqualTo(String value) {
            addCriterion("BAGSMC >=", value, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcLessThan(String value) {
            addCriterion("BAGSMC <", value, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcLessThanOrEqualTo(String value) {
            addCriterion("BAGSMC <=", value, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcLike(String value) {
            addCriterion("BAGSMC like", value, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcNotLike(String value) {
            addCriterion("BAGSMC not like", value, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcIn(List<String> values) {
            addCriterion("BAGSMC in", values, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcNotIn(List<String> values) {
            addCriterion("BAGSMC not in", values, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcBetween(String value1, String value2) {
            addCriterion("BAGSMC between", value1, value2, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBagsmcNotBetween(String value1, String value2) {
            addCriterion("BAGSMC not between", value1, value2, "bagsmc");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmIsNull() {
            addCriterion("BAFZRGMSFHM is null");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmIsNotNull() {
            addCriterion("BAFZRGMSFHM is not null");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmEqualTo(String value) {
            addCriterion("BAFZRGMSFHM =", value, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmNotEqualTo(String value) {
            addCriterion("BAFZRGMSFHM <>", value, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmGreaterThan(String value) {
            addCriterion("BAFZRGMSFHM >", value, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmGreaterThanOrEqualTo(String value) {
            addCriterion("BAFZRGMSFHM >=", value, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmLessThan(String value) {
            addCriterion("BAFZRGMSFHM <", value, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmLessThanOrEqualTo(String value) {
            addCriterion("BAFZRGMSFHM <=", value, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmLike(String value) {
            addCriterion("BAFZRGMSFHM like", value, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmNotLike(String value) {
            addCriterion("BAFZRGMSFHM not like", value, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmIn(List<String> values) {
            addCriterion("BAFZRGMSFHM in", values, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmNotIn(List<String> values) {
            addCriterion("BAFZRGMSFHM not in", values, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmBetween(String value1, String value2) {
            addCriterion("BAFZRGMSFHM between", value1, value2, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrgmsfhmNotBetween(String value1, String value2) {
            addCriterion("BAFZRGMSFHM not between", value1, value2, "bafzrgmsfhm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmIsNull() {
            addCriterion("BAFZRXM is null");
            return (Criteria) this;
        }

        public Criteria andBafzrxmIsNotNull() {
            addCriterion("BAFZRXM is not null");
            return (Criteria) this;
        }

        public Criteria andBafzrxmEqualTo(String value) {
            addCriterion("BAFZRXM =", value, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmNotEqualTo(String value) {
            addCriterion("BAFZRXM <>", value, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmGreaterThan(String value) {
            addCriterion("BAFZRXM >", value, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmGreaterThanOrEqualTo(String value) {
            addCriterion("BAFZRXM >=", value, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmLessThan(String value) {
            addCriterion("BAFZRXM <", value, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmLessThanOrEqualTo(String value) {
            addCriterion("BAFZRXM <=", value, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmLike(String value) {
            addCriterion("BAFZRXM like", value, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmNotLike(String value) {
            addCriterion("BAFZRXM not like", value, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmIn(List<String> values) {
            addCriterion("BAFZRXM in", values, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmNotIn(List<String> values) {
            addCriterion("BAFZRXM not in", values, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmBetween(String value1, String value2) {
            addCriterion("BAFZRXM between", value1, value2, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrxmNotBetween(String value1, String value2) {
            addCriterion("BAFZRXM not between", value1, value2, "bafzrxm");
            return (Criteria) this;
        }

        public Criteria andBafzrdhIsNull() {
            addCriterion("BAFZRDH is null");
            return (Criteria) this;
        }

        public Criteria andBafzrdhIsNotNull() {
            addCriterion("BAFZRDH is not null");
            return (Criteria) this;
        }

        public Criteria andBafzrdhEqualTo(String value) {
            addCriterion("BAFZRDH =", value, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhNotEqualTo(String value) {
            addCriterion("BAFZRDH <>", value, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhGreaterThan(String value) {
            addCriterion("BAFZRDH >", value, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhGreaterThanOrEqualTo(String value) {
            addCriterion("BAFZRDH >=", value, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhLessThan(String value) {
            addCriterion("BAFZRDH <", value, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhLessThanOrEqualTo(String value) {
            addCriterion("BAFZRDH <=", value, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhLike(String value) {
            addCriterion("BAFZRDH like", value, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhNotLike(String value) {
            addCriterion("BAFZRDH not like", value, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhIn(List<String> values) {
            addCriterion("BAFZRDH in", values, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhNotIn(List<String> values) {
            addCriterion("BAFZRDH not in", values, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhBetween(String value1, String value2) {
            addCriterion("BAFZRDH between", value1, value2, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBafzrdhNotBetween(String value1, String value2) {
            addCriterion("BAFZRDH not between", value1, value2, "bafzrdh");
            return (Criteria) this;
        }

        public Criteria andBarsIsNull() {
            addCriterion("BARS is null");
            return (Criteria) this;
        }

        public Criteria andBarsIsNotNull() {
            addCriterion("BARS is not null");
            return (Criteria) this;
        }

        public Criteria andBarsEqualTo(Integer value) {
            addCriterion("BARS =", value, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsNotEqualTo(Integer value) {
            addCriterion("BARS <>", value, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsGreaterThan(Integer value) {
            addCriterion("BARS >", value, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsGreaterThanOrEqualTo(Integer value) {
            addCriterion("BARS >=", value, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsLessThan(Integer value) {
            addCriterion("BARS <", value, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsLessThanOrEqualTo(Integer value) {
            addCriterion("BARS <=", value, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsIn(List<Integer> values) {
            addCriterion("BARS in", values, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsNotIn(List<Integer> values) {
            addCriterion("BARS not in", values, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsBetween(Integer value1, Integer value2) {
            addCriterion("BARS between", value1, value2, "bars");
            return (Criteria) this;
        }

        public Criteria andBarsNotBetween(Integer value1, Integer value2) {
            addCriterion("BARS not between", value1, value2, "bars");
            return (Criteria) this;
        }

        public Criteria andJgpxrsIsNull() {
            addCriterion("JGPXRS is null");
            return (Criteria) this;
        }

        public Criteria andJgpxrsIsNotNull() {
            addCriterion("JGPXRS is not null");
            return (Criteria) this;
        }

        public Criteria andJgpxrsEqualTo(Integer value) {
            addCriterion("JGPXRS =", value, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsNotEqualTo(Integer value) {
            addCriterion("JGPXRS <>", value, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsGreaterThan(Integer value) {
            addCriterion("JGPXRS >", value, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("JGPXRS >=", value, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsLessThan(Integer value) {
            addCriterion("JGPXRS <", value, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsLessThanOrEqualTo(Integer value) {
            addCriterion("JGPXRS <=", value, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsIn(List<Integer> values) {
            addCriterion("JGPXRS in", values, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsNotIn(List<Integer> values) {
            addCriterion("JGPXRS not in", values, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsBetween(Integer value1, Integer value2) {
            addCriterion("JGPXRS between", value1, value2, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andJgpxrsNotBetween(Integer value1, Integer value2) {
            addCriterion("JGPXRS not between", value1, value2, "jgpxrs");
            return (Criteria) this;
        }

        public Criteria andBagsyjIsNull() {
            addCriterion("BAGSYJ is null");
            return (Criteria) this;
        }

        public Criteria andBagsyjIsNotNull() {
            addCriterion("BAGSYJ is not null");
            return (Criteria) this;
        }

        public Criteria andBagsyjEqualTo(String value) {
            addCriterion("BAGSYJ =", value, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjNotEqualTo(String value) {
            addCriterion("BAGSYJ <>", value, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjGreaterThan(String value) {
            addCriterion("BAGSYJ >", value, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjGreaterThanOrEqualTo(String value) {
            addCriterion("BAGSYJ >=", value, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjLessThan(String value) {
            addCriterion("BAGSYJ <", value, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjLessThanOrEqualTo(String value) {
            addCriterion("BAGSYJ <=", value, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjLike(String value) {
            addCriterion("BAGSYJ like", value, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjNotLike(String value) {
            addCriterion("BAGSYJ not like", value, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjIn(List<String> values) {
            addCriterion("BAGSYJ in", values, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjNotIn(List<String> values) {
            addCriterion("BAGSYJ not in", values, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjBetween(String value1, String value2) {
            addCriterion("BAGSYJ between", value1, value2, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andBagsyjNotBetween(String value1, String value2) {
            addCriterion("BAGSYJ not between", value1, value2, "bagsyj");
            return (Criteria) this;
        }

        public Criteria andCkslIsNull() {
            addCriterion("CKSL is null");
            return (Criteria) this;
        }

        public Criteria andCkslIsNotNull() {
            addCriterion("CKSL is not null");
            return (Criteria) this;
        }

        public Criteria andCkslEqualTo(Integer value) {
            addCriterion("CKSL =", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslNotEqualTo(Integer value) {
            addCriterion("CKSL <>", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslGreaterThan(Integer value) {
            addCriterion("CKSL >", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslGreaterThanOrEqualTo(Integer value) {
            addCriterion("CKSL >=", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslLessThan(Integer value) {
            addCriterion("CKSL <", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslLessThanOrEqualTo(Integer value) {
            addCriterion("CKSL <=", value, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslIn(List<Integer> values) {
            addCriterion("CKSL in", values, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslNotIn(List<Integer> values) {
            addCriterion("CKSL not in", values, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslBetween(Integer value1, Integer value2) {
            addCriterion("CKSL between", value1, value2, "cksl");
            return (Criteria) this;
        }

        public Criteria andCkslNotBetween(Integer value1, Integer value2) {
            addCriterion("CKSL not between", value1, value2, "cksl");
            return (Criteria) this;
        }

        public Criteria andBxbjslIsNull() {
            addCriterion("BXBJSL is null");
            return (Criteria) this;
        }

        public Criteria andBxbjslIsNotNull() {
            addCriterion("BXBJSL is not null");
            return (Criteria) this;
        }

        public Criteria andBxbjslEqualTo(Integer value) {
            addCriterion("BXBJSL =", value, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslNotEqualTo(Integer value) {
            addCriterion("BXBJSL <>", value, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslGreaterThan(Integer value) {
            addCriterion("BXBJSL >", value, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslGreaterThanOrEqualTo(Integer value) {
            addCriterion("BXBJSL >=", value, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslLessThan(Integer value) {
            addCriterion("BXBJSL <", value, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslLessThanOrEqualTo(Integer value) {
            addCriterion("BXBJSL <=", value, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslIn(List<Integer> values) {
            addCriterion("BXBJSL in", values, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslNotIn(List<Integer> values) {
            addCriterion("BXBJSL not in", values, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslBetween(Integer value1, Integer value2) {
            addCriterion("BXBJSL between", value1, value2, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBxbjslNotBetween(Integer value1, Integer value2) {
            addCriterion("BXBJSL not between", value1, value2, "bxbjsl");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andDcbsIsNull() {
            addCriterion("DCBS is null");
            return (Criteria) this;
        }

        public Criteria andDcbsIsNotNull() {
            addCriterion("DCBS is not null");
            return (Criteria) this;
        }

        public Criteria andDcbsEqualTo(Short value) {
            addCriterion("DCBS =", value, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsNotEqualTo(Short value) {
            addCriterion("DCBS <>", value, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsGreaterThan(Short value) {
            addCriterion("DCBS >", value, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsGreaterThanOrEqualTo(Short value) {
            addCriterion("DCBS >=", value, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsLessThan(Short value) {
            addCriterion("DCBS <", value, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsLessThanOrEqualTo(Short value) {
            addCriterion("DCBS <=", value, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsIn(List<Short> values) {
            addCriterion("DCBS in", values, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsNotIn(List<Short> values) {
            addCriterion("DCBS not in", values, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsBetween(Short value1, Short value2) {
            addCriterion("DCBS between", value1, value2, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcbsNotBetween(Short value1, Short value2) {
            addCriterion("DCBS not between", value1, value2, "dcbs");
            return (Criteria) this;
        }

        public Criteria andDcsjIsNull() {
            addCriterion("DCSJ is null");
            return (Criteria) this;
        }

        public Criteria andDcsjIsNotNull() {
            addCriterion("DCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andDcsjEqualTo(Date value) {
            addCriterion("DCSJ =", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjNotEqualTo(Date value) {
            addCriterion("DCSJ <>", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjGreaterThan(Date value) {
            addCriterion("DCSJ >", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjGreaterThanOrEqualTo(Date value) {
            addCriterion("DCSJ >=", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjLessThan(Date value) {
            addCriterion("DCSJ <", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjLessThanOrEqualTo(Date value) {
            addCriterion("DCSJ <=", value, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjIn(List<Date> values) {
            addCriterion("DCSJ in", values, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjNotIn(List<Date> values) {
            addCriterion("DCSJ not in", values, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjBetween(Date value1, Date value2) {
            addCriterion("DCSJ between", value1, value2, "dcsj");
            return (Criteria) this;
        }

        public Criteria andDcsjNotBetween(Date value1, Date value2) {
            addCriterion("DCSJ not between", value1, value2, "dcsj");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("ZT is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("ZT is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(String value) {
            addCriterion("ZT =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(String value) {
            addCriterion("ZT <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(String value) {
            addCriterion("ZT >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(String value) {
            addCriterion("ZT >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(String value) {
            addCriterion("ZT <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(String value) {
            addCriterion("ZT <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLike(String value) {
            addCriterion("ZT like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotLike(String value) {
            addCriterion("ZT not like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<String> values) {
            addCriterion("ZT in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<String> values) {
            addCriterion("ZT not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(String value1, String value2) {
            addCriterion("ZT between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(String value1, String value2) {
            addCriterion("ZT not between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtgbrqIsNull() {
            addCriterion("ZTGBRQ is null");
            return (Criteria) this;
        }

        public Criteria andZtgbrqIsNotNull() {
            addCriterion("ZTGBRQ is not null");
            return (Criteria) this;
        }

        public Criteria andZtgbrqEqualTo(Date value) {
            addCriterion("ZTGBRQ =", value, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqNotEqualTo(Date value) {
            addCriterion("ZTGBRQ <>", value, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqGreaterThan(Date value) {
            addCriterion("ZTGBRQ >", value, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqGreaterThanOrEqualTo(Date value) {
            addCriterion("ZTGBRQ >=", value, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqLessThan(Date value) {
            addCriterion("ZTGBRQ <", value, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqLessThanOrEqualTo(Date value) {
            addCriterion("ZTGBRQ <=", value, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqIn(List<Date> values) {
            addCriterion("ZTGBRQ in", values, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqNotIn(List<Date> values) {
            addCriterion("ZTGBRQ not in", values, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqBetween(Date value1, Date value2) {
            addCriterion("ZTGBRQ between", value1, value2, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andZtgbrqNotBetween(Date value1, Date value2) {
            addCriterion("ZTGBRQ not between", value1, value2, "ztgbrq");
            return (Criteria) this;
        }

        public Criteria andScbzIsNull() {
            addCriterion("SCBZ is null");
            return (Criteria) this;
        }

        public Criteria andScbzIsNotNull() {
            addCriterion("SCBZ is not null");
            return (Criteria) this;
        }

        public Criteria andScbzEqualTo(Short value) {
            addCriterion("SCBZ =", value, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzNotEqualTo(Short value) {
            addCriterion("SCBZ <>", value, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzGreaterThan(Short value) {
            addCriterion("SCBZ >", value, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzGreaterThanOrEqualTo(Short value) {
            addCriterion("SCBZ >=", value, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzLessThan(Short value) {
            addCriterion("SCBZ <", value, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzLessThanOrEqualTo(Short value) {
            addCriterion("SCBZ <=", value, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzIn(List<Short> values) {
            addCriterion("SCBZ in", values, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzNotIn(List<Short> values) {
            addCriterion("SCBZ not in", values, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzBetween(Short value1, Short value2) {
            addCriterion("SCBZ between", value1, value2, "scbz");
            return (Criteria) this;
        }

        public Criteria andScbzNotBetween(Short value1, Short value2) {
            addCriterion("SCBZ not between", value1, value2, "scbz");
            return (Criteria) this;
        }

        public Criteria andJqbmIsNull() {
            addCriterion("JQBM is null");
            return (Criteria) this;
        }

        public Criteria andJqbmIsNotNull() {
            addCriterion("JQBM is not null");
            return (Criteria) this;
        }

        public Criteria andJqbmEqualTo(String value) {
            addCriterion("JQBM =", value, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmNotEqualTo(String value) {
            addCriterion("JQBM <>", value, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmGreaterThan(String value) {
            addCriterion("JQBM >", value, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmGreaterThanOrEqualTo(String value) {
            addCriterion("JQBM >=", value, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmLessThan(String value) {
            addCriterion("JQBM <", value, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmLessThanOrEqualTo(String value) {
            addCriterion("JQBM <=", value, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmLike(String value) {
            addCriterion("JQBM like", value, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmNotLike(String value) {
            addCriterion("JQBM not like", value, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmIn(List<String> values) {
            addCriterion("JQBM in", values, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmNotIn(List<String> values) {
            addCriterion("JQBM not in", values, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmBetween(String value1, String value2) {
            addCriterion("JQBM between", value1, value2, "jqbm");
            return (Criteria) this;
        }

        public Criteria andJqbmNotBetween(String value1, String value2) {
            addCriterion("JQBM not between", value1, value2, "jqbm");
            return (Criteria) this;
        }

        public Criteria andZxbzIsNull() {
            addCriterion("ZXBZ is null");
            return (Criteria) this;
        }

        public Criteria andZxbzIsNotNull() {
            addCriterion("ZXBZ is not null");
            return (Criteria) this;
        }

        public Criteria andZxbzEqualTo(String value) {
            addCriterion("ZXBZ =", value, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzNotEqualTo(String value) {
            addCriterion("ZXBZ <>", value, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzGreaterThan(String value) {
            addCriterion("ZXBZ >", value, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzGreaterThanOrEqualTo(String value) {
            addCriterion("ZXBZ >=", value, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzLessThan(String value) {
            addCriterion("ZXBZ <", value, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzLessThanOrEqualTo(String value) {
            addCriterion("ZXBZ <=", value, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzLike(String value) {
            addCriterion("ZXBZ like", value, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzNotLike(String value) {
            addCriterion("ZXBZ not like", value, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzIn(List<String> values) {
            addCriterion("ZXBZ in", values, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzNotIn(List<String> values) {
            addCriterion("ZXBZ not in", values, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzBetween(String value1, String value2) {
            addCriterion("ZXBZ between", value1, value2, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxbzNotBetween(String value1, String value2) {
            addCriterion("ZXBZ not between", value1, value2, "zxbz");
            return (Criteria) this;
        }

        public Criteria andZxyyIsNull() {
            addCriterion("ZXYY is null");
            return (Criteria) this;
        }

        public Criteria andZxyyIsNotNull() {
            addCriterion("ZXYY is not null");
            return (Criteria) this;
        }

        public Criteria andZxyyEqualTo(String value) {
            addCriterion("ZXYY =", value, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyNotEqualTo(String value) {
            addCriterion("ZXYY <>", value, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyGreaterThan(String value) {
            addCriterion("ZXYY >", value, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyGreaterThanOrEqualTo(String value) {
            addCriterion("ZXYY >=", value, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyLessThan(String value) {
            addCriterion("ZXYY <", value, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyLessThanOrEqualTo(String value) {
            addCriterion("ZXYY <=", value, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyLike(String value) {
            addCriterion("ZXYY like", value, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyNotLike(String value) {
            addCriterion("ZXYY not like", value, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyIn(List<String> values) {
            addCriterion("ZXYY in", values, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyNotIn(List<String> values) {
            addCriterion("ZXYY not in", values, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyBetween(String value1, String value2) {
            addCriterion("ZXYY between", value1, value2, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZxyyNotBetween(String value1, String value2) {
            addCriterion("ZXYY not between", value1, value2, "zxyy");
            return (Criteria) this;
        }

        public Criteria andZdskbIsNull() {
            addCriterion("ZDSKB is null");
            return (Criteria) this;
        }

        public Criteria andZdskbIsNotNull() {
            addCriterion("ZDSKB is not null");
            return (Criteria) this;
        }

        public Criteria andZdskbEqualTo(BigDecimal value) {
            addCriterion("ZDSKB =", value, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbNotEqualTo(BigDecimal value) {
            addCriterion("ZDSKB <>", value, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbGreaterThan(BigDecimal value) {
            addCriterion("ZDSKB >", value, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZDSKB >=", value, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbLessThan(BigDecimal value) {
            addCriterion("ZDSKB <", value, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZDSKB <=", value, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbIn(List<BigDecimal> values) {
            addCriterion("ZDSKB in", values, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbNotIn(List<BigDecimal> values) {
            addCriterion("ZDSKB not in", values, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZDSKB between", value1, value2, "zdskb");
            return (Criteria) this;
        }

        public Criteria andZdskbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZDSKB not between", value1, value2, "zdskb");
            return (Criteria) this;
        }

        public Criteria andBcsjIsNull() {
            addCriterion("BCSJ is null");
            return (Criteria) this;
        }

        public Criteria andBcsjIsNotNull() {
            addCriterion("BCSJ is not null");
            return (Criteria) this;
        }

        public Criteria andBcsjEqualTo(Date value) {
            addCriterion("BCSJ =", value, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjNotEqualTo(Date value) {
            addCriterion("BCSJ <>", value, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjGreaterThan(Date value) {
            addCriterion("BCSJ >", value, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjGreaterThanOrEqualTo(Date value) {
            addCriterion("BCSJ >=", value, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjLessThan(Date value) {
            addCriterion("BCSJ <", value, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjLessThanOrEqualTo(Date value) {
            addCriterion("BCSJ <=", value, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjIn(List<Date> values) {
            addCriterion("BCSJ in", values, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjNotIn(List<Date> values) {
            addCriterion("BCSJ not in", values, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjBetween(Date value1, Date value2) {
            addCriterion("BCSJ between", value1, value2, "bcsj");
            return (Criteria) this;
        }

        public Criteria andBcsjNotBetween(Date value1, Date value2) {
            addCriterion("BCSJ not between", value1, value2, "bcsj");
            return (Criteria) this;
        }

        public Criteria andLrsjIsNull() {
            addCriterion("LRSJ is null");
            return (Criteria) this;
        }

        public Criteria andLrsjIsNotNull() {
            addCriterion("LRSJ is not null");
            return (Criteria) this;
        }

        public Criteria andLrsjEqualTo(Date value) {
            addCriterion("LRSJ =", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotEqualTo(Date value) {
            addCriterion("LRSJ <>", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjGreaterThan(Date value) {
            addCriterion("LRSJ >", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjGreaterThanOrEqualTo(Date value) {
            addCriterion("LRSJ >=", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjLessThan(Date value) {
            addCriterion("LRSJ <", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjLessThanOrEqualTo(Date value) {
            addCriterion("LRSJ <=", value, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjIn(List<Date> values) {
            addCriterion("LRSJ in", values, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotIn(List<Date> values) {
            addCriterion("LRSJ not in", values, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjBetween(Date value1, Date value2) {
            addCriterion("LRSJ between", value1, value2, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrsjNotBetween(Date value1, Date value2) {
            addCriterion("LRSJ not between", value1, value2, "lrsj");
            return (Criteria) this;
        }

        public Criteria andLrrIsNull() {
            addCriterion("LRR is null");
            return (Criteria) this;
        }

        public Criteria andLrrIsNotNull() {
            addCriterion("LRR is not null");
            return (Criteria) this;
        }

        public Criteria andLrrEqualTo(String value) {
            addCriterion("LRR =", value, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrNotEqualTo(String value) {
            addCriterion("LRR <>", value, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrGreaterThan(String value) {
            addCriterion("LRR >", value, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrGreaterThanOrEqualTo(String value) {
            addCriterion("LRR >=", value, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrLessThan(String value) {
            addCriterion("LRR <", value, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrLessThanOrEqualTo(String value) {
            addCriterion("LRR <=", value, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrLike(String value) {
            addCriterion("LRR like", value, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrNotLike(String value) {
            addCriterion("LRR not like", value, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrIn(List<String> values) {
            addCriterion("LRR in", values, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrNotIn(List<String> values) {
            addCriterion("LRR not in", values, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrBetween(String value1, String value2) {
            addCriterion("LRR between", value1, value2, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrrNotBetween(String value1, String value2) {
            addCriterion("LRR not between", value1, value2, "lrr");
            return (Criteria) this;
        }

        public Criteria andLrdwbmIsNull() {
            addCriterion("LRDWBM is null");
            return (Criteria) this;
        }

        public Criteria andLrdwbmIsNotNull() {
            addCriterion("LRDWBM is not null");
            return (Criteria) this;
        }

        public Criteria andLrdwbmEqualTo(String value) {
            addCriterion("LRDWBM =", value, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmNotEqualTo(String value) {
            addCriterion("LRDWBM <>", value, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmGreaterThan(String value) {
            addCriterion("LRDWBM >", value, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmGreaterThanOrEqualTo(String value) {
            addCriterion("LRDWBM >=", value, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmLessThan(String value) {
            addCriterion("LRDWBM <", value, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmLessThanOrEqualTo(String value) {
            addCriterion("LRDWBM <=", value, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmLike(String value) {
            addCriterion("LRDWBM like", value, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmNotLike(String value) {
            addCriterion("LRDWBM not like", value, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmIn(List<String> values) {
            addCriterion("LRDWBM in", values, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmNotIn(List<String> values) {
            addCriterion("LRDWBM not in", values, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmBetween(String value1, String value2) {
            addCriterion("LRDWBM between", value1, value2, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwbmNotBetween(String value1, String value2) {
            addCriterion("LRDWBM not between", value1, value2, "lrdwbm");
            return (Criteria) this;
        }

        public Criteria andLrdwmcIsNull() {
            addCriterion("LRDWMC is null");
            return (Criteria) this;
        }

        public Criteria andLrdwmcIsNotNull() {
            addCriterion("LRDWMC is not null");
            return (Criteria) this;
        }

        public Criteria andLrdwmcEqualTo(String value) {
            addCriterion("LRDWMC =", value, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcNotEqualTo(String value) {
            addCriterion("LRDWMC <>", value, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcGreaterThan(String value) {
            addCriterion("LRDWMC >", value, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcGreaterThanOrEqualTo(String value) {
            addCriterion("LRDWMC >=", value, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcLessThan(String value) {
            addCriterion("LRDWMC <", value, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcLessThanOrEqualTo(String value) {
            addCriterion("LRDWMC <=", value, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcLike(String value) {
            addCriterion("LRDWMC like", value, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcNotLike(String value) {
            addCriterion("LRDWMC not like", value, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcIn(List<String> values) {
            addCriterion("LRDWMC in", values, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcNotIn(List<String> values) {
            addCriterion("LRDWMC not in", values, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcBetween(String value1, String value2) {
            addCriterion("LRDWMC between", value1, value2, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andLrdwmcNotBetween(String value1, String value2) {
            addCriterion("LRDWMC not between", value1, value2, "lrdwmc");
            return (Criteria) this;
        }

        public Criteria andThbajgdmIsNull() {
            addCriterion("THBAJGDM is null");
            return (Criteria) this;
        }

        public Criteria andThbajgdmIsNotNull() {
            addCriterion("THBAJGDM is not null");
            return (Criteria) this;
        }

        public Criteria andThbajgdmEqualTo(String value) {
            addCriterion("THBAJGDM =", value, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmNotEqualTo(String value) {
            addCriterion("THBAJGDM <>", value, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmGreaterThan(String value) {
            addCriterion("THBAJGDM >", value, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmGreaterThanOrEqualTo(String value) {
            addCriterion("THBAJGDM >=", value, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmLessThan(String value) {
            addCriterion("THBAJGDM <", value, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmLessThanOrEqualTo(String value) {
            addCriterion("THBAJGDM <=", value, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmLike(String value) {
            addCriterion("THBAJGDM like", value, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmNotLike(String value) {
            addCriterion("THBAJGDM not like", value, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmIn(List<String> values) {
            addCriterion("THBAJGDM in", values, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmNotIn(List<String> values) {
            addCriterion("THBAJGDM not in", values, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmBetween(String value1, String value2) {
            addCriterion("THBAJGDM between", value1, value2, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgdmNotBetween(String value1, String value2) {
            addCriterion("THBAJGDM not between", value1, value2, "thbajgdm");
            return (Criteria) this;
        }

        public Criteria andThbajgIsNull() {
            addCriterion("THBAJG is null");
            return (Criteria) this;
        }

        public Criteria andThbajgIsNotNull() {
            addCriterion("THBAJG is not null");
            return (Criteria) this;
        }

        public Criteria andThbajgEqualTo(String value) {
            addCriterion("THBAJG =", value, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgNotEqualTo(String value) {
            addCriterion("THBAJG <>", value, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgGreaterThan(String value) {
            addCriterion("THBAJG >", value, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgGreaterThanOrEqualTo(String value) {
            addCriterion("THBAJG >=", value, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgLessThan(String value) {
            addCriterion("THBAJG <", value, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgLessThanOrEqualTo(String value) {
            addCriterion("THBAJG <=", value, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgLike(String value) {
            addCriterion("THBAJG like", value, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgNotLike(String value) {
            addCriterion("THBAJG not like", value, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgIn(List<String> values) {
            addCriterion("THBAJG in", values, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgNotIn(List<String> values) {
            addCriterion("THBAJG not in", values, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgBetween(String value1, String value2) {
            addCriterion("THBAJG between", value1, value2, "thbajg");
            return (Criteria) this;
        }

        public Criteria andThbajgNotBetween(String value1, String value2) {
            addCriterion("THBAJG not between", value1, value2, "thbajg");
            return (Criteria) this;
        }

        public Criteria andBwbmdhIsNull() {
            addCriterion("BWBMDH is null");
            return (Criteria) this;
        }

        public Criteria andBwbmdhIsNotNull() {
            addCriterion("BWBMDH is not null");
            return (Criteria) this;
        }

        public Criteria andBwbmdhEqualTo(String value) {
            addCriterion("BWBMDH =", value, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhNotEqualTo(String value) {
            addCriterion("BWBMDH <>", value, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhGreaterThan(String value) {
            addCriterion("BWBMDH >", value, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhGreaterThanOrEqualTo(String value) {
            addCriterion("BWBMDH >=", value, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhLessThan(String value) {
            addCriterion("BWBMDH <", value, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhLessThanOrEqualTo(String value) {
            addCriterion("BWBMDH <=", value, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhLike(String value) {
            addCriterion("BWBMDH like", value, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhNotLike(String value) {
            addCriterion("BWBMDH not like", value, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhIn(List<String> values) {
            addCriterion("BWBMDH in", values, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhNotIn(List<String> values) {
            addCriterion("BWBMDH not in", values, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhBetween(String value1, String value2) {
            addCriterion("BWBMDH between", value1, value2, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andBwbmdhNotBetween(String value1, String value2) {
            addCriterion("BWBMDH not between", value1, value2, "bwbmdh");
            return (Criteria) this;
        }

        public Criteria andSfazsxtIsNull() {
            addCriterion("SFAZSXT is null");
            return (Criteria) this;
        }

        public Criteria andSfazsxtIsNotNull() {
            addCriterion("SFAZSXT is not null");
            return (Criteria) this;
        }

        public Criteria andSfazsxtEqualTo(String value) {
            addCriterion("SFAZSXT =", value, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtNotEqualTo(String value) {
            addCriterion("SFAZSXT <>", value, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtGreaterThan(String value) {
            addCriterion("SFAZSXT >", value, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtGreaterThanOrEqualTo(String value) {
            addCriterion("SFAZSXT >=", value, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtLessThan(String value) {
            addCriterion("SFAZSXT <", value, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtLessThanOrEqualTo(String value) {
            addCriterion("SFAZSXT <=", value, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtLike(String value) {
            addCriterion("SFAZSXT like", value, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtNotLike(String value) {
            addCriterion("SFAZSXT not like", value, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtIn(List<String> values) {
            addCriterion("SFAZSXT in", values, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtNotIn(List<String> values) {
            addCriterion("SFAZSXT not in", values, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtBetween(String value1, String value2) {
            addCriterion("SFAZSXT between", value1, value2, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andSfazsxtNotBetween(String value1, String value2) {
            addCriterion("SFAZSXT not between", value1, value2, "sfazsxt");
            return (Criteria) this;
        }

        public Criteria andAzsxtslIsNull() {
            addCriterion("AZSXTSL is null");
            return (Criteria) this;
        }

        public Criteria andAzsxtslIsNotNull() {
            addCriterion("AZSXTSL is not null");
            return (Criteria) this;
        }

        public Criteria andAzsxtslEqualTo(Integer value) {
            addCriterion("AZSXTSL =", value, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslNotEqualTo(Integer value) {
            addCriterion("AZSXTSL <>", value, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslGreaterThan(Integer value) {
            addCriterion("AZSXTSL >", value, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslGreaterThanOrEqualTo(Integer value) {
            addCriterion("AZSXTSL >=", value, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslLessThan(Integer value) {
            addCriterion("AZSXTSL <", value, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslLessThanOrEqualTo(Integer value) {
            addCriterion("AZSXTSL <=", value, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslIn(List<Integer> values) {
            addCriterion("AZSXTSL in", values, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslNotIn(List<Integer> values) {
            addCriterion("AZSXTSL not in", values, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslBetween(Integer value1, Integer value2) {
            addCriterion("AZSXTSL between", value1, value2, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andAzsxtslNotBetween(Integer value1, Integer value2) {
            addCriterion("AZSXTSL not between", value1, value2, "azsxtsl");
            return (Criteria) this;
        }

        public Criteria andZjztdmIsNull() {
            addCriterion("ZJZTDM is null");
            return (Criteria) this;
        }

        public Criteria andZjztdmIsNotNull() {
            addCriterion("ZJZTDM is not null");
            return (Criteria) this;
        }

        public Criteria andZjztdmEqualTo(String value) {
            addCriterion("ZJZTDM =", value, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmNotEqualTo(String value) {
            addCriterion("ZJZTDM <>", value, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmGreaterThan(String value) {
            addCriterion("ZJZTDM >", value, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmGreaterThanOrEqualTo(String value) {
            addCriterion("ZJZTDM >=", value, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmLessThan(String value) {
            addCriterion("ZJZTDM <", value, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmLessThanOrEqualTo(String value) {
            addCriterion("ZJZTDM <=", value, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmLike(String value) {
            addCriterion("ZJZTDM like", value, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmNotLike(String value) {
            addCriterion("ZJZTDM not like", value, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmIn(List<String> values) {
            addCriterion("ZJZTDM in", values, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmNotIn(List<String> values) {
            addCriterion("ZJZTDM not in", values, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmBetween(String value1, String value2) {
            addCriterion("ZJZTDM between", value1, value2, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztdmNotBetween(String value1, String value2) {
            addCriterion("ZJZTDM not between", value1, value2, "zjztdm");
            return (Criteria) this;
        }

        public Criteria andZjztmcIsNull() {
            addCriterion("ZJZTMC is null");
            return (Criteria) this;
        }

        public Criteria andZjztmcIsNotNull() {
            addCriterion("ZJZTMC is not null");
            return (Criteria) this;
        }

        public Criteria andZjztmcEqualTo(String value) {
            addCriterion("ZJZTMC =", value, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcNotEqualTo(String value) {
            addCriterion("ZJZTMC <>", value, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcGreaterThan(String value) {
            addCriterion("ZJZTMC >", value, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcGreaterThanOrEqualTo(String value) {
            addCriterion("ZJZTMC >=", value, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcLessThan(String value) {
            addCriterion("ZJZTMC <", value, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcLessThanOrEqualTo(String value) {
            addCriterion("ZJZTMC <=", value, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcLike(String value) {
            addCriterion("ZJZTMC like", value, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcNotLike(String value) {
            addCriterion("ZJZTMC not like", value, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcIn(List<String> values) {
            addCriterion("ZJZTMC in", values, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcNotIn(List<String> values) {
            addCriterion("ZJZTMC not in", values, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcBetween(String value1, String value2) {
            addCriterion("ZJZTMC between", value1, value2, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andZjztmcNotBetween(String value1, String value2) {
            addCriterion("ZJZTMC not between", value1, value2, "zjztmc");
            return (Criteria) this;
        }

        public Criteria andDjrqIsNull() {
            addCriterion("DJRQ is null");
            return (Criteria) this;
        }

        public Criteria andDjrqIsNotNull() {
            addCriterion("DJRQ is not null");
            return (Criteria) this;
        }

        public Criteria andDjrqEqualTo(Date value) {
            addCriterion("DJRQ =", value, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqNotEqualTo(Date value) {
            addCriterion("DJRQ <>", value, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqGreaterThan(Date value) {
            addCriterion("DJRQ >", value, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqGreaterThanOrEqualTo(Date value) {
            addCriterion("DJRQ >=", value, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqLessThan(Date value) {
            addCriterion("DJRQ <", value, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqLessThanOrEqualTo(Date value) {
            addCriterion("DJRQ <=", value, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqIn(List<Date> values) {
            addCriterion("DJRQ in", values, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqNotIn(List<Date> values) {
            addCriterion("DJRQ not in", values, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqBetween(Date value1, Date value2) {
            addCriterion("DJRQ between", value1, value2, "djrq");
            return (Criteria) this;
        }

        public Criteria andDjrqNotBetween(Date value1, Date value2) {
            addCriterion("DJRQ not between", value1, value2, "djrq");
            return (Criteria) this;
        }

        public Criteria andNsrqIsNull() {
            addCriterion("NSRQ is null");
            return (Criteria) this;
        }

        public Criteria andNsrqIsNotNull() {
            addCriterion("NSRQ is not null");
            return (Criteria) this;
        }

        public Criteria andNsrqEqualTo(Date value) {
            addCriterion("NSRQ =", value, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqNotEqualTo(Date value) {
            addCriterion("NSRQ <>", value, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqGreaterThan(Date value) {
            addCriterion("NSRQ >", value, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("NSRQ >=", value, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqLessThan(Date value) {
            addCriterion("NSRQ <", value, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqLessThanOrEqualTo(Date value) {
            addCriterion("NSRQ <=", value, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqIn(List<Date> values) {
            addCriterion("NSRQ in", values, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqNotIn(List<Date> values) {
            addCriterion("NSRQ not in", values, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqBetween(Date value1, Date value2) {
            addCriterion("NSRQ between", value1, value2, "nsrq");
            return (Criteria) this;
        }

        public Criteria andNsrqNotBetween(Date value1, Date value2) {
            addCriterion("NSRQ not between", value1, value2, "nsrq");
            return (Criteria) this;
        }

        public Criteria andQyjcIsNull() {
            addCriterion("QYJC is null");
            return (Criteria) this;
        }

        public Criteria andQyjcIsNotNull() {
            addCriterion("QYJC is not null");
            return (Criteria) this;
        }

        public Criteria andQyjcEqualTo(String value) {
            addCriterion("QYJC =", value, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcNotEqualTo(String value) {
            addCriterion("QYJC <>", value, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcGreaterThan(String value) {
            addCriterion("QYJC >", value, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcGreaterThanOrEqualTo(String value) {
            addCriterion("QYJC >=", value, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcLessThan(String value) {
            addCriterion("QYJC <", value, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcLessThanOrEqualTo(String value) {
            addCriterion("QYJC <=", value, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcLike(String value) {
            addCriterion("QYJC like", value, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcNotLike(String value) {
            addCriterion("QYJC not like", value, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcIn(List<String> values) {
            addCriterion("QYJC in", values, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcNotIn(List<String> values) {
            addCriterion("QYJC not in", values, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcBetween(String value1, String value2) {
            addCriterion("QYJC between", value1, value2, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcNotBetween(String value1, String value2) {
            addCriterion("QYJC not between", value1, value2, "qyjc");
            return (Criteria) this;
        }

        public Criteria andQyjcqpIsNull() {
            addCriterion("QYJCQP is null");
            return (Criteria) this;
        }

        public Criteria andQyjcqpIsNotNull() {
            addCriterion("QYJCQP is not null");
            return (Criteria) this;
        }

        public Criteria andQyjcqpEqualTo(String value) {
            addCriterion("QYJCQP =", value, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpNotEqualTo(String value) {
            addCriterion("QYJCQP <>", value, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpGreaterThan(String value) {
            addCriterion("QYJCQP >", value, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpGreaterThanOrEqualTo(String value) {
            addCriterion("QYJCQP >=", value, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpLessThan(String value) {
            addCriterion("QYJCQP <", value, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpLessThanOrEqualTo(String value) {
            addCriterion("QYJCQP <=", value, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpLike(String value) {
            addCriterion("QYJCQP like", value, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpNotLike(String value) {
            addCriterion("QYJCQP not like", value, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpIn(List<String> values) {
            addCriterion("QYJCQP in", values, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpNotIn(List<String> values) {
            addCriterion("QYJCQP not in", values, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpBetween(String value1, String value2) {
            addCriterion("QYJCQP between", value1, value2, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcqpNotBetween(String value1, String value2) {
            addCriterion("QYJCQP not between", value1, value2, "qyjcqp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpIsNull() {
            addCriterion("QYJCJP is null");
            return (Criteria) this;
        }

        public Criteria andQyjcjpIsNotNull() {
            addCriterion("QYJCJP is not null");
            return (Criteria) this;
        }

        public Criteria andQyjcjpEqualTo(String value) {
            addCriterion("QYJCJP =", value, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpNotEqualTo(String value) {
            addCriterion("QYJCJP <>", value, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpGreaterThan(String value) {
            addCriterion("QYJCJP >", value, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpGreaterThanOrEqualTo(String value) {
            addCriterion("QYJCJP >=", value, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpLessThan(String value) {
            addCriterion("QYJCJP <", value, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpLessThanOrEqualTo(String value) {
            addCriterion("QYJCJP <=", value, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpLike(String value) {
            addCriterion("QYJCJP like", value, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpNotLike(String value) {
            addCriterion("QYJCJP not like", value, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpIn(List<String> values) {
            addCriterion("QYJCJP in", values, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpNotIn(List<String> values) {
            addCriterion("QYJCJP not in", values, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpBetween(String value1, String value2) {
            addCriterion("QYJCJP between", value1, value2, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andQyjcjpNotBetween(String value1, String value2) {
            addCriterion("QYJCJP not between", value1, value2, "qyjcjp");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsIsNull() {
            addCriterion("SGSCXFJJS is null");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsIsNotNull() {
            addCriterion("SGSCXFJJS is not null");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsEqualTo(String value) {
            addCriterion("SGSCXFJJS =", value, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsNotEqualTo(String value) {
            addCriterion("SGSCXFJJS <>", value, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsGreaterThan(String value) {
            addCriterion("SGSCXFJJS >", value, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsGreaterThanOrEqualTo(String value) {
            addCriterion("SGSCXFJJS >=", value, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsLessThan(String value) {
            addCriterion("SGSCXFJJS <", value, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsLessThanOrEqualTo(String value) {
            addCriterion("SGSCXFJJS <=", value, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsLike(String value) {
            addCriterion("SGSCXFJJS like", value, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsNotLike(String value) {
            addCriterion("SGSCXFJJS not like", value, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsIn(List<String> values) {
            addCriterion("SGSCXFJJS in", values, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsNotIn(List<String> values) {
            addCriterion("SGSCXFJJS not in", values, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsBetween(String value1, String value2) {
            addCriterion("SGSCXFJJS between", value1, value2, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andSgscxfjjsNotBetween(String value1, String value2) {
            addCriterion("SGSCXFJJS not between", value1, value2, "sgscxfjjs");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmIsNull() {
            addCriterion("JHLTLXDM is null");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmIsNotNull() {
            addCriterion("JHLTLXDM is not null");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmEqualTo(String value) {
            addCriterion("JHLTLXDM =", value, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmNotEqualTo(String value) {
            addCriterion("JHLTLXDM <>", value, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmGreaterThan(String value) {
            addCriterion("JHLTLXDM >", value, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmGreaterThanOrEqualTo(String value) {
            addCriterion("JHLTLXDM >=", value, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmLessThan(String value) {
            addCriterion("JHLTLXDM <", value, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmLessThanOrEqualTo(String value) {
            addCriterion("JHLTLXDM <=", value, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmLike(String value) {
            addCriterion("JHLTLXDM like", value, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmNotLike(String value) {
            addCriterion("JHLTLXDM not like", value, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmIn(List<String> values) {
            addCriterion("JHLTLXDM in", values, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmNotIn(List<String> values) {
            addCriterion("JHLTLXDM not in", values, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmBetween(String value1, String value2) {
            addCriterion("JHLTLXDM between", value1, value2, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxdmNotBetween(String value1, String value2) {
            addCriterion("JHLTLXDM not between", value1, value2, "jhltlxdm");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcIsNull() {
            addCriterion("JHLTLXMC is null");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcIsNotNull() {
            addCriterion("JHLTLXMC is not null");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcEqualTo(String value) {
            addCriterion("JHLTLXMC =", value, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcNotEqualTo(String value) {
            addCriterion("JHLTLXMC <>", value, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcGreaterThan(String value) {
            addCriterion("JHLTLXMC >", value, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcGreaterThanOrEqualTo(String value) {
            addCriterion("JHLTLXMC >=", value, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcLessThan(String value) {
            addCriterion("JHLTLXMC <", value, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcLessThanOrEqualTo(String value) {
            addCriterion("JHLTLXMC <=", value, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcLike(String value) {
            addCriterion("JHLTLXMC like", value, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcNotLike(String value) {
            addCriterion("JHLTLXMC not like", value, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcIn(List<String> values) {
            addCriterion("JHLTLXMC in", values, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcNotIn(List<String> values) {
            addCriterion("JHLTLXMC not in", values, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcBetween(String value1, String value2) {
            addCriterion("JHLTLXMC between", value1, value2, "jhltlxmc");
            return (Criteria) this;
        }

        public Criteria andJhltlxmcNotBetween(String value1, String value2) {
            addCriterion("JHLTLXMC not between", value1, value2, "jhltlxmc");
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

        public Criteria andWxywflIsNull() {
            addCriterion("WXYWFL is null");
            return (Criteria) this;
        }

        public Criteria andWxywflIsNotNull() {
            addCriterion("WXYWFL is not null");
            return (Criteria) this;
        }

        public Criteria andWxywflEqualTo(String value) {
            addCriterion("WXYWFL =", value, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflNotEqualTo(String value) {
            addCriterion("WXYWFL <>", value, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflGreaterThan(String value) {
            addCriterion("WXYWFL >", value, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflGreaterThanOrEqualTo(String value) {
            addCriterion("WXYWFL >=", value, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflLessThan(String value) {
            addCriterion("WXYWFL <", value, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflLessThanOrEqualTo(String value) {
            addCriterion("WXYWFL <=", value, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflLike(String value) {
            addCriterion("WXYWFL like", value, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflNotLike(String value) {
            addCriterion("WXYWFL not like", value, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflIn(List<String> values) {
            addCriterion("WXYWFL in", values, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflNotIn(List<String> values) {
            addCriterion("WXYWFL not in", values, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflBetween(String value1, String value2) {
            addCriterion("WXYWFL between", value1, value2, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywflNotBetween(String value1, String value2) {
            addCriterion("WXYWFL not between", value1, value2, "wxywfl");
            return (Criteria) this;
        }

        public Criteria andWxywfldmIsNull() {
            addCriterion("WXYWFLDM is null");
            return (Criteria) this;
        }

        public Criteria andWxywfldmIsNotNull() {
            addCriterion("WXYWFLDM is not null");
            return (Criteria) this;
        }

        public Criteria andWxywfldmEqualTo(String value) {
            addCriterion("WXYWFLDM =", value, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmNotEqualTo(String value) {
            addCriterion("WXYWFLDM <>", value, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmGreaterThan(String value) {
            addCriterion("WXYWFLDM >", value, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmGreaterThanOrEqualTo(String value) {
            addCriterion("WXYWFLDM >=", value, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmLessThan(String value) {
            addCriterion("WXYWFLDM <", value, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmLessThanOrEqualTo(String value) {
            addCriterion("WXYWFLDM <=", value, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmLike(String value) {
            addCriterion("WXYWFLDM like", value, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmNotLike(String value) {
            addCriterion("WXYWFLDM not like", value, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmIn(List<String> values) {
            addCriterion("WXYWFLDM in", values, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmNotIn(List<String> values) {
            addCriterion("WXYWFLDM not in", values, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmBetween(String value1, String value2) {
            addCriterion("WXYWFLDM between", value1, value2, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andWxywfldmNotBetween(String value1, String value2) {
            addCriterion("WXYWFLDM not between", value1, value2, "wxywfldm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhIsNull() {
            addCriterion("XFSHYJSBH is null");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhIsNotNull() {
            addCriterion("XFSHYJSBH is not null");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhEqualTo(String value) {
            addCriterion("XFSHYJSBH =", value, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhNotEqualTo(String value) {
            addCriterion("XFSHYJSBH <>", value, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhGreaterThan(String value) {
            addCriterion("XFSHYJSBH >", value, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhGreaterThanOrEqualTo(String value) {
            addCriterion("XFSHYJSBH >=", value, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhLessThan(String value) {
            addCriterion("XFSHYJSBH <", value, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhLessThanOrEqualTo(String value) {
            addCriterion("XFSHYJSBH <=", value, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhLike(String value) {
            addCriterion("XFSHYJSBH like", value, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhNotLike(String value) {
            addCriterion("XFSHYJSBH not like", value, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhIn(List<String> values) {
            addCriterion("XFSHYJSBH in", values, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhNotIn(List<String> values) {
            addCriterion("XFSHYJSBH not in", values, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhBetween(String value1, String value2) {
            addCriterion("XFSHYJSBH between", value1, value2, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsbhNotBetween(String value1, String value2) {
            addCriterion("XFSHYJSBH not between", value1, value2, "xfshyjsbh");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgIsNull() {
            addCriterion("XFSHYJSFZJG is null");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgIsNotNull() {
            addCriterion("XFSHYJSFZJG is not null");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgEqualTo(String value) {
            addCriterion("XFSHYJSFZJG =", value, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgNotEqualTo(String value) {
            addCriterion("XFSHYJSFZJG <>", value, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgGreaterThan(String value) {
            addCriterion("XFSHYJSFZJG >", value, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgGreaterThanOrEqualTo(String value) {
            addCriterion("XFSHYJSFZJG >=", value, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgLessThan(String value) {
            addCriterion("XFSHYJSFZJG <", value, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgLessThanOrEqualTo(String value) {
            addCriterion("XFSHYJSFZJG <=", value, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgLike(String value) {
            addCriterion("XFSHYJSFZJG like", value, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgNotLike(String value) {
            addCriterion("XFSHYJSFZJG not like", value, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgIn(List<String> values) {
            addCriterion("XFSHYJSFZJG in", values, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgNotIn(List<String> values) {
            addCriterion("XFSHYJSFZJG not in", values, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgBetween(String value1, String value2) {
            addCriterion("XFSHYJSFZJG between", value1, value2, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgNotBetween(String value1, String value2) {
            addCriterion("XFSHYJSFZJG not between", value1, value2, "xfshyjsfzjg");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmIsNull() {
            addCriterion("XFSHYJSFZJGDM is null");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmIsNotNull() {
            addCriterion("XFSHYJSFZJGDM is not null");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmEqualTo(String value) {
            addCriterion("XFSHYJSFZJGDM =", value, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmNotEqualTo(String value) {
            addCriterion("XFSHYJSFZJGDM <>", value, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmGreaterThan(String value) {
            addCriterion("XFSHYJSFZJGDM >", value, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmGreaterThanOrEqualTo(String value) {
            addCriterion("XFSHYJSFZJGDM >=", value, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmLessThan(String value) {
            addCriterion("XFSHYJSFZJGDM <", value, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmLessThanOrEqualTo(String value) {
            addCriterion("XFSHYJSFZJGDM <=", value, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmLike(String value) {
            addCriterion("XFSHYJSFZJGDM like", value, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmNotLike(String value) {
            addCriterion("XFSHYJSFZJGDM not like", value, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmIn(List<String> values) {
            addCriterion("XFSHYJSFZJGDM in", values, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmNotIn(List<String> values) {
            addCriterion("XFSHYJSFZJGDM not in", values, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmBetween(String value1, String value2) {
            addCriterion("XFSHYJSFZJGDM between", value1, value2, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzjgdmNotBetween(String value1, String value2) {
            addCriterion("XFSHYJSFZJGDM not between", value1, value2, "xfshyjsfzjgdm");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqIsNull() {
            addCriterion("XFSHYJSFZRQ is null");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqIsNotNull() {
            addCriterion("XFSHYJSFZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqEqualTo(Date value) {
            addCriterion("XFSHYJSFZRQ =", value, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqNotEqualTo(Date value) {
            addCriterion("XFSHYJSFZRQ <>", value, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqGreaterThan(Date value) {
            addCriterion("XFSHYJSFZRQ >", value, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("XFSHYJSFZRQ >=", value, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqLessThan(Date value) {
            addCriterion("XFSHYJSFZRQ <", value, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqLessThanOrEqualTo(Date value) {
            addCriterion("XFSHYJSFZRQ <=", value, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqIn(List<Date> values) {
            addCriterion("XFSHYJSFZRQ in", values, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqNotIn(List<Date> values) {
            addCriterion("XFSHYJSFZRQ not in", values, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqBetween(Date value1, Date value2) {
            addCriterion("XFSHYJSFZRQ between", value1, value2, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andXfshyjsfzrqNotBetween(Date value1, Date value2) {
            addCriterion("XFSHYJSFZRQ not between", value1, value2, "xfshyjsfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzIsNull() {
            addCriterion("YYZZYXQZ is null");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzIsNotNull() {
            addCriterion("YYZZYXQZ is not null");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzEqualTo(Date value) {
            addCriterion("YYZZYXQZ =", value, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzNotEqualTo(Date value) {
            addCriterion("YYZZYXQZ <>", value, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzGreaterThan(Date value) {
            addCriterion("YYZZYXQZ >", value, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzGreaterThanOrEqualTo(Date value) {
            addCriterion("YYZZYXQZ >=", value, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzLessThan(Date value) {
            addCriterion("YYZZYXQZ <", value, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzLessThanOrEqualTo(Date value) {
            addCriterion("YYZZYXQZ <=", value, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzIn(List<Date> values) {
            addCriterion("YYZZYXQZ in", values, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzNotIn(List<Date> values) {
            addCriterion("YYZZYXQZ not in", values, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzBetween(Date value1, Date value2) {
            addCriterion("YYZZYXQZ between", value1, value2, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzyxqzNotBetween(Date value1, Date value2) {
            addCriterion("YYZZYXQZ not between", value1, value2, "yyzzyxqz");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqIsNull() {
            addCriterion("YYZZFZRQ is null");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqIsNotNull() {
            addCriterion("YYZZFZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqEqualTo(Date value) {
            addCriterion("YYZZFZRQ =", value, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqNotEqualTo(Date value) {
            addCriterion("YYZZFZRQ <>", value, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqGreaterThan(Date value) {
            addCriterion("YYZZFZRQ >", value, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("YYZZFZRQ >=", value, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqLessThan(Date value) {
            addCriterion("YYZZFZRQ <", value, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqLessThanOrEqualTo(Date value) {
            addCriterion("YYZZFZRQ <=", value, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqIn(List<Date> values) {
            addCriterion("YYZZFZRQ in", values, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqNotIn(List<Date> values) {
            addCriterion("YYZZFZRQ not in", values, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqBetween(Date value1, Date value2) {
            addCriterion("YYZZFZRQ between", value1, value2, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andYyzzfzrqNotBetween(Date value1, Date value2) {
            addCriterion("YYZZFZRQ not between", value1, value2, "yyzzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzIsNull() {
            addCriterion("THXKZYXQZ is null");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzIsNotNull() {
            addCriterion("THXKZYXQZ is not null");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzEqualTo(Date value) {
            addCriterion("THXKZYXQZ =", value, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzNotEqualTo(Date value) {
            addCriterion("THXKZYXQZ <>", value, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzGreaterThan(Date value) {
            addCriterion("THXKZYXQZ >", value, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzGreaterThanOrEqualTo(Date value) {
            addCriterion("THXKZYXQZ >=", value, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzLessThan(Date value) {
            addCriterion("THXKZYXQZ <", value, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzLessThanOrEqualTo(Date value) {
            addCriterion("THXKZYXQZ <=", value, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzIn(List<Date> values) {
            addCriterion("THXKZYXQZ in", values, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzNotIn(List<Date> values) {
            addCriterion("THXKZYXQZ not in", values, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzBetween(Date value1, Date value2) {
            addCriterion("THXKZYXQZ between", value1, value2, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzyxqzNotBetween(Date value1, Date value2) {
            addCriterion("THXKZYXQZ not between", value1, value2, "thxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqIsNull() {
            addCriterion("THXKZFZRQ is null");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqIsNotNull() {
            addCriterion("THXKZFZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqEqualTo(Date value) {
            addCriterion("THXKZFZRQ =", value, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqNotEqualTo(Date value) {
            addCriterion("THXKZFZRQ <>", value, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqGreaterThan(Date value) {
            addCriterion("THXKZFZRQ >", value, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("THXKZFZRQ >=", value, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqLessThan(Date value) {
            addCriterion("THXKZFZRQ <", value, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqLessThanOrEqualTo(Date value) {
            addCriterion("THXKZFZRQ <=", value, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqIn(List<Date> values) {
            addCriterion("THXKZFZRQ in", values, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqNotIn(List<Date> values) {
            addCriterion("THXKZFZRQ not in", values, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqBetween(Date value1, Date value2) {
            addCriterion("THXKZFZRQ between", value1, value2, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andThxkzfzrqNotBetween(Date value1, Date value2) {
            addCriterion("THXKZFZRQ not between", value1, value2, "thxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzIsNull() {
            addCriterion("JYXKZYXQZ is null");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzIsNotNull() {
            addCriterion("JYXKZYXQZ is not null");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzEqualTo(Date value) {
            addCriterion("JYXKZYXQZ =", value, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzNotEqualTo(Date value) {
            addCriterion("JYXKZYXQZ <>", value, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzGreaterThan(Date value) {
            addCriterion("JYXKZYXQZ >", value, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzGreaterThanOrEqualTo(Date value) {
            addCriterion("JYXKZYXQZ >=", value, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzLessThan(Date value) {
            addCriterion("JYXKZYXQZ <", value, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzLessThanOrEqualTo(Date value) {
            addCriterion("JYXKZYXQZ <=", value, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzIn(List<Date> values) {
            addCriterion("JYXKZYXQZ in", values, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzNotIn(List<Date> values) {
            addCriterion("JYXKZYXQZ not in", values, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzBetween(Date value1, Date value2) {
            addCriterion("JYXKZYXQZ between", value1, value2, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzyxqzNotBetween(Date value1, Date value2) {
            addCriterion("JYXKZYXQZ not between", value1, value2, "jyxkzyxqz");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqIsNull() {
            addCriterion("JYXKZFZRQ is null");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqIsNotNull() {
            addCriterion("JYXKZFZRQ is not null");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqEqualTo(Date value) {
            addCriterion("JYXKZFZRQ =", value, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqNotEqualTo(Date value) {
            addCriterion("JYXKZFZRQ <>", value, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqGreaterThan(Date value) {
            addCriterion("JYXKZFZRQ >", value, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqGreaterThanOrEqualTo(Date value) {
            addCriterion("JYXKZFZRQ >=", value, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqLessThan(Date value) {
            addCriterion("JYXKZFZRQ <", value, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqLessThanOrEqualTo(Date value) {
            addCriterion("JYXKZFZRQ <=", value, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqIn(List<Date> values) {
            addCriterion("JYXKZFZRQ in", values, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqNotIn(List<Date> values) {
            addCriterion("JYXKZFZRQ not in", values, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqBetween(Date value1, Date value2) {
            addCriterion("JYXKZFZRQ between", value1, value2, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyxkzfzrqNotBetween(Date value1, Date value2) {
            addCriterion("JYXKZFZRQ not between", value1, value2, "jyxkzfzrq");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmIsNull() {
            addCriterion("JYFZRXBDM is null");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmIsNotNull() {
            addCriterion("JYFZRXBDM is not null");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmEqualTo(String value) {
            addCriterion("JYFZRXBDM =", value, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmNotEqualTo(String value) {
            addCriterion("JYFZRXBDM <>", value, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmGreaterThan(String value) {
            addCriterion("JYFZRXBDM >", value, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmGreaterThanOrEqualTo(String value) {
            addCriterion("JYFZRXBDM >=", value, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmLessThan(String value) {
            addCriterion("JYFZRXBDM <", value, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmLessThanOrEqualTo(String value) {
            addCriterion("JYFZRXBDM <=", value, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmLike(String value) {
            addCriterion("JYFZRXBDM like", value, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmNotLike(String value) {
            addCriterion("JYFZRXBDM not like", value, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmIn(List<String> values) {
            addCriterion("JYFZRXBDM in", values, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmNotIn(List<String> values) {
            addCriterion("JYFZRXBDM not in", values, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmBetween(String value1, String value2) {
            addCriterion("JYFZRXBDM between", value1, value2, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbdmNotBetween(String value1, String value2) {
            addCriterion("JYFZRXBDM not between", value1, value2, "jyfzrxbdm");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbIsNull() {
            addCriterion("JYFZRXB is null");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbIsNotNull() {
            addCriterion("JYFZRXB is not null");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbEqualTo(String value) {
            addCriterion("JYFZRXB =", value, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbNotEqualTo(String value) {
            addCriterion("JYFZRXB <>", value, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbGreaterThan(String value) {
            addCriterion("JYFZRXB >", value, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbGreaterThanOrEqualTo(String value) {
            addCriterion("JYFZRXB >=", value, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbLessThan(String value) {
            addCriterion("JYFZRXB <", value, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbLessThanOrEqualTo(String value) {
            addCriterion("JYFZRXB <=", value, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbLike(String value) {
            addCriterion("JYFZRXB like", value, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbNotLike(String value) {
            addCriterion("JYFZRXB not like", value, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbIn(List<String> values) {
            addCriterion("JYFZRXB in", values, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbNotIn(List<String> values) {
            addCriterion("JYFZRXB not in", values, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbBetween(String value1, String value2) {
            addCriterion("JYFZRXB between", value1, value2, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andJyfzrxbNotBetween(String value1, String value2) {
            addCriterion("JYFZRXB not between", value1, value2, "jyfzrxb");
            return (Criteria) this;
        }

        public Criteria andFrxbdmIsNull() {
            addCriterion("FRXBDM is null");
            return (Criteria) this;
        }

        public Criteria andFrxbdmIsNotNull() {
            addCriterion("FRXBDM is not null");
            return (Criteria) this;
        }

        public Criteria andFrxbdmEqualTo(String value) {
            addCriterion("FRXBDM =", value, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmNotEqualTo(String value) {
            addCriterion("FRXBDM <>", value, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmGreaterThan(String value) {
            addCriterion("FRXBDM >", value, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmGreaterThanOrEqualTo(String value) {
            addCriterion("FRXBDM >=", value, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmLessThan(String value) {
            addCriterion("FRXBDM <", value, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmLessThanOrEqualTo(String value) {
            addCriterion("FRXBDM <=", value, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmLike(String value) {
            addCriterion("FRXBDM like", value, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmNotLike(String value) {
            addCriterion("FRXBDM not like", value, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmIn(List<String> values) {
            addCriterion("FRXBDM in", values, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmNotIn(List<String> values) {
            addCriterion("FRXBDM not in", values, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmBetween(String value1, String value2) {
            addCriterion("FRXBDM between", value1, value2, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbdmNotBetween(String value1, String value2) {
            addCriterion("FRXBDM not between", value1, value2, "frxbdm");
            return (Criteria) this;
        }

        public Criteria andFrxbIsNull() {
            addCriterion("FRXB is null");
            return (Criteria) this;
        }

        public Criteria andFrxbIsNotNull() {
            addCriterion("FRXB is not null");
            return (Criteria) this;
        }

        public Criteria andFrxbEqualTo(String value) {
            addCriterion("FRXB =", value, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbNotEqualTo(String value) {
            addCriterion("FRXB <>", value, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbGreaterThan(String value) {
            addCriterion("FRXB >", value, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbGreaterThanOrEqualTo(String value) {
            addCriterion("FRXB >=", value, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbLessThan(String value) {
            addCriterion("FRXB <", value, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbLessThanOrEqualTo(String value) {
            addCriterion("FRXB <=", value, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbLike(String value) {
            addCriterion("FRXB like", value, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbNotLike(String value) {
            addCriterion("FRXB not like", value, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbIn(List<String> values) {
            addCriterion("FRXB in", values, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbNotIn(List<String> values) {
            addCriterion("FRXB not in", values, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbBetween(String value1, String value2) {
            addCriterion("FRXB between", value1, value2, "frxb");
            return (Criteria) this;
        }

        public Criteria andFrxbNotBetween(String value1, String value2) {
            addCriterion("FRXB not between", value1, value2, "frxb");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhIsNull() {
            addCriterion("GDJYCSCQBH is null");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhIsNotNull() {
            addCriterion("GDJYCSCQBH is not null");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhEqualTo(String value) {
            addCriterion("GDJYCSCQBH =", value, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhNotEqualTo(String value) {
            addCriterion("GDJYCSCQBH <>", value, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhGreaterThan(String value) {
            addCriterion("GDJYCSCQBH >", value, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhGreaterThanOrEqualTo(String value) {
            addCriterion("GDJYCSCQBH >=", value, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhLessThan(String value) {
            addCriterion("GDJYCSCQBH <", value, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhLessThanOrEqualTo(String value) {
            addCriterion("GDJYCSCQBH <=", value, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhLike(String value) {
            addCriterion("GDJYCSCQBH like", value, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhNotLike(String value) {
            addCriterion("GDJYCSCQBH not like", value, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhIn(List<String> values) {
            addCriterion("GDJYCSCQBH in", values, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhNotIn(List<String> values) {
            addCriterion("GDJYCSCQBH not in", values, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhBetween(String value1, String value2) {
            addCriterion("GDJYCSCQBH between", value1, value2, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycscqbhNotBetween(String value1, String value2) {
            addCriterion("GDJYCSCQBH not between", value1, value2, "gdjycscqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhIsNull() {
            addCriterion("GDJYCSSYQBH is null");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhIsNotNull() {
            addCriterion("GDJYCSSYQBH is not null");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhEqualTo(String value) {
            addCriterion("GDJYCSSYQBH =", value, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhNotEqualTo(String value) {
            addCriterion("GDJYCSSYQBH <>", value, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhGreaterThan(String value) {
            addCriterion("GDJYCSSYQBH >", value, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhGreaterThanOrEqualTo(String value) {
            addCriterion("GDJYCSSYQBH >=", value, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhLessThan(String value) {
            addCriterion("GDJYCSSYQBH <", value, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhLessThanOrEqualTo(String value) {
            addCriterion("GDJYCSSYQBH <=", value, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhLike(String value) {
            addCriterion("GDJYCSSYQBH like", value, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhNotLike(String value) {
            addCriterion("GDJYCSSYQBH not like", value, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhIn(List<String> values) {
            addCriterion("GDJYCSSYQBH in", values, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhNotIn(List<String> values) {
            addCriterion("GDJYCSSYQBH not in", values, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhBetween(String value1, String value2) {
            addCriterion("GDJYCSSYQBH between", value1, value2, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andGdjycssyqbhNotBetween(String value1, String value2) {
            addCriterion("GDJYCSSYQBH not between", value1, value2, "gdjycssyqbh");
            return (Criteria) this;
        }

        public Criteria andSfjyIsNull() {
            addCriterion("SFJY is null");
            return (Criteria) this;
        }

        public Criteria andSfjyIsNotNull() {
            addCriterion("SFJY is not null");
            return (Criteria) this;
        }

        public Criteria andSfjyEqualTo(String value) {
            addCriterion("SFJY =", value, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyNotEqualTo(String value) {
            addCriterion("SFJY <>", value, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyGreaterThan(String value) {
            addCriterion("SFJY >", value, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyGreaterThanOrEqualTo(String value) {
            addCriterion("SFJY >=", value, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyLessThan(String value) {
            addCriterion("SFJY <", value, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyLessThanOrEqualTo(String value) {
            addCriterion("SFJY <=", value, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyLike(String value) {
            addCriterion("SFJY like", value, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyNotLike(String value) {
            addCriterion("SFJY not like", value, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyIn(List<String> values) {
            addCriterion("SFJY in", values, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyNotIn(List<String> values) {
            addCriterion("SFJY not in", values, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyBetween(String value1, String value2) {
            addCriterion("SFJY between", value1, value2, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSfjyNotBetween(String value1, String value2) {
            addCriterion("SFJY not between", value1, value2, "sfjy");
            return (Criteria) this;
        }

        public Criteria andSsxdmIsNull() {
            addCriterion("SSXDM is null");
            return (Criteria) this;
        }

        public Criteria andSsxdmIsNotNull() {
            addCriterion("SSXDM is not null");
            return (Criteria) this;
        }

        public Criteria andSsxdmEqualTo(String value) {
            addCriterion("SSXDM =", value, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmNotEqualTo(String value) {
            addCriterion("SSXDM <>", value, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmGreaterThan(String value) {
            addCriterion("SSXDM >", value, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmGreaterThanOrEqualTo(String value) {
            addCriterion("SSXDM >=", value, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmLessThan(String value) {
            addCriterion("SSXDM <", value, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmLessThanOrEqualTo(String value) {
            addCriterion("SSXDM <=", value, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmLike(String value) {
            addCriterion("SSXDM like", value, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmNotLike(String value) {
            addCriterion("SSXDM not like", value, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmIn(List<String> values) {
            addCriterion("SSXDM in", values, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmNotIn(List<String> values) {
            addCriterion("SSXDM not in", values, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmBetween(String value1, String value2) {
            addCriterion("SSXDM between", value1, value2, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxdmNotBetween(String value1, String value2) {
            addCriterion("SSXDM not between", value1, value2, "ssxdm");
            return (Criteria) this;
        }

        public Criteria andSsxmcIsNull() {
            addCriterion("SSXMC is null");
            return (Criteria) this;
        }

        public Criteria andSsxmcIsNotNull() {
            addCriterion("SSXMC is not null");
            return (Criteria) this;
        }

        public Criteria andSsxmcEqualTo(String value) {
            addCriterion("SSXMC =", value, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcNotEqualTo(String value) {
            addCriterion("SSXMC <>", value, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcGreaterThan(String value) {
            addCriterion("SSXMC >", value, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcGreaterThanOrEqualTo(String value) {
            addCriterion("SSXMC >=", value, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcLessThan(String value) {
            addCriterion("SSXMC <", value, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcLessThanOrEqualTo(String value) {
            addCriterion("SSXMC <=", value, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcLike(String value) {
            addCriterion("SSXMC like", value, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcNotLike(String value) {
            addCriterion("SSXMC not like", value, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcIn(List<String> values) {
            addCriterion("SSXMC in", values, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcNotIn(List<String> values) {
            addCriterion("SSXMC not in", values, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcBetween(String value1, String value2) {
            addCriterion("SSXMC between", value1, value2, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andSsxmcNotBetween(String value1, String value2) {
            addCriterion("SSXMC not between", value1, value2, "ssxmc");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhIsNull() {
            addCriterion("KDJYXKZBH is null");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhIsNotNull() {
            addCriterion("KDJYXKZBH is not null");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhEqualTo(String value) {
            addCriterion("KDJYXKZBH =", value, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhNotEqualTo(String value) {
            addCriterion("KDJYXKZBH <>", value, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhGreaterThan(String value) {
            addCriterion("KDJYXKZBH >", value, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhGreaterThanOrEqualTo(String value) {
            addCriterion("KDJYXKZBH >=", value, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhLessThan(String value) {
            addCriterion("KDJYXKZBH <", value, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhLessThanOrEqualTo(String value) {
            addCriterion("KDJYXKZBH <=", value, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhLike(String value) {
            addCriterion("KDJYXKZBH like", value, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhNotLike(String value) {
            addCriterion("KDJYXKZBH not like", value, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhIn(List<String> values) {
            addCriterion("KDJYXKZBH in", values, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhNotIn(List<String> values) {
            addCriterion("KDJYXKZBH not in", values, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhBetween(String value1, String value2) {
            addCriterion("KDJYXKZBH between", value1, value2, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andKdjyxkzbhNotBetween(String value1, String value2) {
            addCriterion("KDJYXKZBH not between", value1, value2, "kdjyxkzbh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshIsNull() {
            addCriterion("WSTZQYPZZSH is null");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshIsNotNull() {
            addCriterion("WSTZQYPZZSH is not null");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshEqualTo(String value) {
            addCriterion("WSTZQYPZZSH =", value, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshNotEqualTo(String value) {
            addCriterion("WSTZQYPZZSH <>", value, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshGreaterThan(String value) {
            addCriterion("WSTZQYPZZSH >", value, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshGreaterThanOrEqualTo(String value) {
            addCriterion("WSTZQYPZZSH >=", value, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshLessThan(String value) {
            addCriterion("WSTZQYPZZSH <", value, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshLessThanOrEqualTo(String value) {
            addCriterion("WSTZQYPZZSH <=", value, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshLike(String value) {
            addCriterion("WSTZQYPZZSH like", value, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshNotLike(String value) {
            addCriterion("WSTZQYPZZSH not like", value, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshIn(List<String> values) {
            addCriterion("WSTZQYPZZSH in", values, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshNotIn(List<String> values) {
            addCriterion("WSTZQYPZZSH not in", values, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshBetween(String value1, String value2) {
            addCriterion("WSTZQYPZZSH between", value1, value2, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andWstzqypzzshNotBetween(String value1, String value2) {
            addCriterion("WSTZQYPZZSH not between", value1, value2, "wstzqypzzsh");
            return (Criteria) this;
        }

        public Criteria andHwxgIsNull() {
            addCriterion("HWXG is null");
            return (Criteria) this;
        }

        public Criteria andHwxgIsNotNull() {
            addCriterion("HWXG is not null");
            return (Criteria) this;
        }

        public Criteria andHwxgEqualTo(String value) {
            addCriterion("HWXG =", value, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgNotEqualTo(String value) {
            addCriterion("HWXG <>", value, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgGreaterThan(String value) {
            addCriterion("HWXG >", value, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgGreaterThanOrEqualTo(String value) {
            addCriterion("HWXG >=", value, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgLessThan(String value) {
            addCriterion("HWXG <", value, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgLessThanOrEqualTo(String value) {
            addCriterion("HWXG <=", value, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgLike(String value) {
            addCriterion("HWXG like", value, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgNotLike(String value) {
            addCriterion("HWXG not like", value, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgIn(List<String> values) {
            addCriterion("HWXG in", values, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgNotIn(List<String> values) {
            addCriterion("HWXG not in", values, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgBetween(String value1, String value2) {
            addCriterion("HWXG between", value1, value2, "hwxg");
            return (Criteria) this;
        }

        public Criteria andHwxgNotBetween(String value1, String value2) {
            addCriterion("HWXG not between", value1, value2, "hwxg");
            return (Criteria) this;
        }

        public Criteria andQymjIsNull() {
            addCriterion("QYMJ is null");
            return (Criteria) this;
        }

        public Criteria andQymjIsNotNull() {
            addCriterion("QYMJ is not null");
            return (Criteria) this;
        }

        public Criteria andQymjEqualTo(String value) {
            addCriterion("QYMJ =", value, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjNotEqualTo(String value) {
            addCriterion("QYMJ <>", value, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjGreaterThan(String value) {
            addCriterion("QYMJ >", value, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjGreaterThanOrEqualTo(String value) {
            addCriterion("QYMJ >=", value, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjLessThan(String value) {
            addCriterion("QYMJ <", value, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjLessThanOrEqualTo(String value) {
            addCriterion("QYMJ <=", value, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjLike(String value) {
            addCriterion("QYMJ like", value, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjNotLike(String value) {
            addCriterion("QYMJ not like", value, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjIn(List<String> values) {
            addCriterion("QYMJ in", values, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjNotIn(List<String> values) {
            addCriterion("QYMJ not in", values, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjBetween(String value1, String value2) {
            addCriterion("QYMJ between", value1, value2, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjNotBetween(String value1, String value2) {
            addCriterion("QYMJ not between", value1, value2, "qymj");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhIsNull() {
            addCriterion("QYMJLXDH is null");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhIsNotNull() {
            addCriterion("QYMJLXDH is not null");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhEqualTo(String value) {
            addCriterion("QYMJLXDH =", value, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhNotEqualTo(String value) {
            addCriterion("QYMJLXDH <>", value, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhGreaterThan(String value) {
            addCriterion("QYMJLXDH >", value, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhGreaterThanOrEqualTo(String value) {
            addCriterion("QYMJLXDH >=", value, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhLessThan(String value) {
            addCriterion("QYMJLXDH <", value, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhLessThanOrEqualTo(String value) {
            addCriterion("QYMJLXDH <=", value, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhLike(String value) {
            addCriterion("QYMJLXDH like", value, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhNotLike(String value) {
            addCriterion("QYMJLXDH not like", value, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhIn(List<String> values) {
            addCriterion("QYMJLXDH in", values, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhNotIn(List<String> values) {
            addCriterion("QYMJLXDH not in", values, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhBetween(String value1, String value2) {
            addCriterion("QYMJLXDH between", value1, value2, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andQymjlxdhNotBetween(String value1, String value2) {
            addCriterion("QYMJLXDH not between", value1, value2, "qymjlxdh");
            return (Criteria) this;
        }

        public Criteria andZdyjrsIsNull() {
            addCriterion("ZDYJRS is null");
            return (Criteria) this;
        }

        public Criteria andZdyjrsIsNotNull() {
            addCriterion("ZDYJRS is not null");
            return (Criteria) this;
        }

        public Criteria andZdyjrsEqualTo(Integer value) {
            addCriterion("ZDYJRS =", value, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsNotEqualTo(Integer value) {
            addCriterion("ZDYJRS <>", value, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsGreaterThan(Integer value) {
            addCriterion("ZDYJRS >", value, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZDYJRS >=", value, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsLessThan(Integer value) {
            addCriterion("ZDYJRS <", value, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsLessThanOrEqualTo(Integer value) {
            addCriterion("ZDYJRS <=", value, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsIn(List<Integer> values) {
            addCriterion("ZDYJRS in", values, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsNotIn(List<Integer> values) {
            addCriterion("ZDYJRS not in", values, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsBetween(Integer value1, Integer value2) {
            addCriterion("ZDYJRS between", value1, value2, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andZdyjrsNotBetween(Integer value1, Integer value2) {
            addCriterion("ZDYJRS not between", value1, value2, "zdyjrs");
            return (Criteria) this;
        }

        public Criteria andYyzzbhIsNull() {
            addCriterion("YYZZBH is null");
            return (Criteria) this;
        }

        public Criteria andYyzzbhIsNotNull() {
            addCriterion("YYZZBH is not null");
            return (Criteria) this;
        }

        public Criteria andYyzzbhEqualTo(String value) {
            addCriterion("YYZZBH =", value, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhNotEqualTo(String value) {
            addCriterion("YYZZBH <>", value, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhGreaterThan(String value) {
            addCriterion("YYZZBH >", value, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhGreaterThanOrEqualTo(String value) {
            addCriterion("YYZZBH >=", value, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhLessThan(String value) {
            addCriterion("YYZZBH <", value, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhLessThanOrEqualTo(String value) {
            addCriterion("YYZZBH <=", value, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhLike(String value) {
            addCriterion("YYZZBH like", value, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhNotLike(String value) {
            addCriterion("YYZZBH not like", value, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhIn(List<String> values) {
            addCriterion("YYZZBH in", values, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhNotIn(List<String> values) {
            addCriterion("YYZZBH not in", values, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhBetween(String value1, String value2) {
            addCriterion("YYZZBH between", value1, value2, "yyzzbh");
            return (Criteria) this;
        }

        public Criteria andYyzzbhNotBetween(String value1, String value2) {
            addCriterion("YYZZBH not between", value1, value2, "yyzzbh");
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