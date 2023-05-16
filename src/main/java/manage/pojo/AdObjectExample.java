package manage.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdObjectExample() {
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

        public Criteria andAdIdIsNull() {
            addCriterion("ad_id is null");
            return (Criteria) this;
        }

        public Criteria andAdIdIsNotNull() {
            addCriterion("ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdEqualTo(Integer value) {
            addCriterion("ad_id =", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotEqualTo(Integer value) {
            addCriterion("ad_id <>", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThan(Integer value) {
            addCriterion("ad_id >", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_id >=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThan(Integer value) {
            addCriterion("ad_id <", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThanOrEqualTo(Integer value) {
            addCriterion("ad_id <=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdIn(List<Integer> values) {
            addCriterion("ad_id in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotIn(List<Integer> values) {
            addCriterion("ad_id not in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdBetween(Integer value1, Integer value2) {
            addCriterion("ad_id between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_id not between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNull() {
            addCriterion("ad_name is null");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNotNull() {
            addCriterion("ad_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdNameEqualTo(String value) {
            addCriterion("ad_name =", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotEqualTo(String value) {
            addCriterion("ad_name <>", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThan(String value) {
            addCriterion("ad_name >", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_name >=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThan(String value) {
            addCriterion("ad_name <", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThanOrEqualTo(String value) {
            addCriterion("ad_name <=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLike(String value) {
            addCriterion("ad_name like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotLike(String value) {
            addCriterion("ad_name not like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameIn(List<String> values) {
            addCriterion("ad_name in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotIn(List<String> values) {
            addCriterion("ad_name not in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameBetween(String value1, String value2) {
            addCriterion("ad_name between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotBetween(String value1, String value2) {
            addCriterion("ad_name not between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdSrcIsNull() {
            addCriterion("ad_src is null");
            return (Criteria) this;
        }

        public Criteria andAdSrcIsNotNull() {
            addCriterion("ad_src is not null");
            return (Criteria) this;
        }

        public Criteria andAdSrcEqualTo(String value) {
            addCriterion("ad_src =", value, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcNotEqualTo(String value) {
            addCriterion("ad_src <>", value, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcGreaterThan(String value) {
            addCriterion("ad_src >", value, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcGreaterThanOrEqualTo(String value) {
            addCriterion("ad_src >=", value, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcLessThan(String value) {
            addCriterion("ad_src <", value, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcLessThanOrEqualTo(String value) {
            addCriterion("ad_src <=", value, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcLike(String value) {
            addCriterion("ad_src like", value, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcNotLike(String value) {
            addCriterion("ad_src not like", value, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcIn(List<String> values) {
            addCriterion("ad_src in", values, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcNotIn(List<String> values) {
            addCriterion("ad_src not in", values, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcBetween(String value1, String value2) {
            addCriterion("ad_src between", value1, value2, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdSrcNotBetween(String value1, String value2) {
            addCriterion("ad_src not between", value1, value2, "adSrc");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceIsNull() {
            addCriterion("ad_introduce is null");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceIsNotNull() {
            addCriterion("ad_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceEqualTo(String value) {
            addCriterion("ad_introduce =", value, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceNotEqualTo(String value) {
            addCriterion("ad_introduce <>", value, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceGreaterThan(String value) {
            addCriterion("ad_introduce >", value, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("ad_introduce >=", value, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceLessThan(String value) {
            addCriterion("ad_introduce <", value, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceLessThanOrEqualTo(String value) {
            addCriterion("ad_introduce <=", value, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceLike(String value) {
            addCriterion("ad_introduce like", value, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceNotLike(String value) {
            addCriterion("ad_introduce not like", value, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceIn(List<String> values) {
            addCriterion("ad_introduce in", values, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceNotIn(List<String> values) {
            addCriterion("ad_introduce not in", values, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceBetween(String value1, String value2) {
            addCriterion("ad_introduce between", value1, value2, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdIntroduceNotBetween(String value1, String value2) {
            addCriterion("ad_introduce not between", value1, value2, "adIntroduce");
            return (Criteria) this;
        }

        public Criteria andAdAdminidIsNull() {
            addCriterion("ad_adminId is null");
            return (Criteria) this;
        }

        public Criteria andAdAdminidIsNotNull() {
            addCriterion("ad_adminId is not null");
            return (Criteria) this;
        }

        public Criteria andAdAdminidEqualTo(Integer value) {
            addCriterion("ad_adminId =", value, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidNotEqualTo(Integer value) {
            addCriterion("ad_adminId <>", value, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidGreaterThan(Integer value) {
            addCriterion("ad_adminId >", value, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_adminId >=", value, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidLessThan(Integer value) {
            addCriterion("ad_adminId <", value, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidLessThanOrEqualTo(Integer value) {
            addCriterion("ad_adminId <=", value, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidIn(List<Integer> values) {
            addCriterion("ad_adminId in", values, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidNotIn(List<Integer> values) {
            addCriterion("ad_adminId not in", values, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidBetween(Integer value1, Integer value2) {
            addCriterion("ad_adminId between", value1, value2, "adAdminid");
            return (Criteria) this;
        }

        public Criteria andAdAdminidNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_adminId not between", value1, value2, "adAdminid");
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