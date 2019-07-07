package com.ldx.domain.export;

import java.util.ArrayList;
import java.util.List;

public class cargoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cargo
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cargo
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cargo
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public cargoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cargo
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cargo
     *
     * @mbg.generated
     */
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

        public Criteria andCargoIdIsNull() {
            addCriterion("cargo_id is null");
            return (Criteria) this;
        }

        public Criteria andCargoIdIsNotNull() {
            addCriterion("cargo_id is not null");
            return (Criteria) this;
        }

        public Criteria andCargoIdEqualTo(String value) {
            addCriterion("cargo_id =", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdNotEqualTo(String value) {
            addCriterion("cargo_id <>", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdGreaterThan(String value) {
            addCriterion("cargo_id >", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdGreaterThanOrEqualTo(String value) {
            addCriterion("cargo_id >=", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdLessThan(String value) {
            addCriterion("cargo_id <", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdLessThanOrEqualTo(String value) {
            addCriterion("cargo_id <=", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdLike(String value) {
            addCriterion("cargo_id like", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdNotLike(String value) {
            addCriterion("cargo_id not like", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdIn(List<String> values) {
            addCriterion("cargo_id in", values, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdNotIn(List<String> values) {
            addCriterion("cargo_id not in", values, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdBetween(String value1, String value2) {
            addCriterion("cargo_id between", value1, value2, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdNotBetween(String value1, String value2) {
            addCriterion("cargo_id not between", value1, value2, "cargoId");
            return (Criteria) this;
        }

        public Criteria andFbaIdIsNull() {
            addCriterion("fba_id is null");
            return (Criteria) this;
        }

        public Criteria andFbaIdIsNotNull() {
            addCriterion("fba_id is not null");
            return (Criteria) this;
        }

        public Criteria andFbaIdEqualTo(String value) {
            addCriterion("fba_id =", value, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdNotEqualTo(String value) {
            addCriterion("fba_id <>", value, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdGreaterThan(String value) {
            addCriterion("fba_id >", value, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdGreaterThanOrEqualTo(String value) {
            addCriterion("fba_id >=", value, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdLessThan(String value) {
            addCriterion("fba_id <", value, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdLessThanOrEqualTo(String value) {
            addCriterion("fba_id <=", value, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdLike(String value) {
            addCriterion("fba_id like", value, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdNotLike(String value) {
            addCriterion("fba_id not like", value, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdIn(List<String> values) {
            addCriterion("fba_id in", values, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdNotIn(List<String> values) {
            addCriterion("fba_id not in", values, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdBetween(String value1, String value2) {
            addCriterion("fba_id between", value1, value2, "fbaId");
            return (Criteria) this;
        }

        public Criteria andFbaIdNotBetween(String value1, String value2) {
            addCriterion("fba_id not between", value1, value2, "fbaId");
            return (Criteria) this;
        }

        public Criteria andCargoNameIsNull() {
            addCriterion("cargo_name is null");
            return (Criteria) this;
        }

        public Criteria andCargoNameIsNotNull() {
            addCriterion("cargo_name is not null");
            return (Criteria) this;
        }

        public Criteria andCargoNameEqualTo(String value) {
            addCriterion("cargo_name =", value, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameNotEqualTo(String value) {
            addCriterion("cargo_name <>", value, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameGreaterThan(String value) {
            addCriterion("cargo_name >", value, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameGreaterThanOrEqualTo(String value) {
            addCriterion("cargo_name >=", value, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameLessThan(String value) {
            addCriterion("cargo_name <", value, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameLessThanOrEqualTo(String value) {
            addCriterion("cargo_name <=", value, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameLike(String value) {
            addCriterion("cargo_name like", value, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameNotLike(String value) {
            addCriterion("cargo_name not like", value, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameIn(List<String> values) {
            addCriterion("cargo_name in", values, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameNotIn(List<String> values) {
            addCriterion("cargo_name not in", values, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameBetween(String value1, String value2) {
            addCriterion("cargo_name between", value1, value2, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoNameNotBetween(String value1, String value2) {
            addCriterion("cargo_name not between", value1, value2, "cargoName");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameIsNull() {
            addCriterion("cargo_enname is null");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameIsNotNull() {
            addCriterion("cargo_enname is not null");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameEqualTo(String value) {
            addCriterion("cargo_enname =", value, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameNotEqualTo(String value) {
            addCriterion("cargo_enname <>", value, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameGreaterThan(String value) {
            addCriterion("cargo_enname >", value, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameGreaterThanOrEqualTo(String value) {
            addCriterion("cargo_enname >=", value, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameLessThan(String value) {
            addCriterion("cargo_enname <", value, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameLessThanOrEqualTo(String value) {
            addCriterion("cargo_enname <=", value, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameLike(String value) {
            addCriterion("cargo_enname like", value, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameNotLike(String value) {
            addCriterion("cargo_enname not like", value, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameIn(List<String> values) {
            addCriterion("cargo_enname in", values, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameNotIn(List<String> values) {
            addCriterion("cargo_enname not in", values, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameBetween(String value1, String value2) {
            addCriterion("cargo_enname between", value1, value2, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andCargoEnnameNotBetween(String value1, String value2) {
            addCriterion("cargo_enname not between", value1, value2, "cargoEnname");
            return (Criteria) this;
        }

        public Criteria andEurIsNull() {
            addCriterion("EUR is null");
            return (Criteria) this;
        }

        public Criteria andEurIsNotNull() {
            addCriterion("EUR is not null");
            return (Criteria) this;
        }

        public Criteria andEurEqualTo(String value) {
            addCriterion("EUR =", value, "eur");
            return (Criteria) this;
        }

        public Criteria andEurNotEqualTo(String value) {
            addCriterion("EUR <>", value, "eur");
            return (Criteria) this;
        }

        public Criteria andEurGreaterThan(String value) {
            addCriterion("EUR >", value, "eur");
            return (Criteria) this;
        }

        public Criteria andEurGreaterThanOrEqualTo(String value) {
            addCriterion("EUR >=", value, "eur");
            return (Criteria) this;
        }

        public Criteria andEurLessThan(String value) {
            addCriterion("EUR <", value, "eur");
            return (Criteria) this;
        }

        public Criteria andEurLessThanOrEqualTo(String value) {
            addCriterion("EUR <=", value, "eur");
            return (Criteria) this;
        }

        public Criteria andEurLike(String value) {
            addCriterion("EUR like", value, "eur");
            return (Criteria) this;
        }

        public Criteria andEurNotLike(String value) {
            addCriterion("EUR not like", value, "eur");
            return (Criteria) this;
        }

        public Criteria andEurIn(List<String> values) {
            addCriterion("EUR in", values, "eur");
            return (Criteria) this;
        }

        public Criteria andEurNotIn(List<String> values) {
            addCriterion("EUR not in", values, "eur");
            return (Criteria) this;
        }

        public Criteria andEurBetween(String value1, String value2) {
            addCriterion("EUR between", value1, value2, "eur");
            return (Criteria) this;
        }

        public Criteria andEurNotBetween(String value1, String value2) {
            addCriterion("EUR not between", value1, value2, "eur");
            return (Criteria) this;
        }

        public Criteria andPcsIsNull() {
            addCriterion("PCS is null");
            return (Criteria) this;
        }

        public Criteria andPcsIsNotNull() {
            addCriterion("PCS is not null");
            return (Criteria) this;
        }

        public Criteria andPcsEqualTo(String value) {
            addCriterion("PCS =", value, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsNotEqualTo(String value) {
            addCriterion("PCS <>", value, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsGreaterThan(String value) {
            addCriterion("PCS >", value, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsGreaterThanOrEqualTo(String value) {
            addCriterion("PCS >=", value, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsLessThan(String value) {
            addCriterion("PCS <", value, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsLessThanOrEqualTo(String value) {
            addCriterion("PCS <=", value, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsLike(String value) {
            addCriterion("PCS like", value, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsNotLike(String value) {
            addCriterion("PCS not like", value, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsIn(List<String> values) {
            addCriterion("PCS in", values, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsNotIn(List<String> values) {
            addCriterion("PCS not in", values, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsBetween(String value1, String value2) {
            addCriterion("PCS between", value1, value2, "pcs");
            return (Criteria) this;
        }

        public Criteria andPcsNotBetween(String value1, String value2) {
            addCriterion("PCS not between", value1, value2, "pcs");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNull() {
            addCriterion("purpose is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIsNotNull() {
            addCriterion("purpose is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeEqualTo(String value) {
            addCriterion("purpose =", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotEqualTo(String value) {
            addCriterion("purpose <>", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThan(String value) {
            addCriterion("purpose >", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeGreaterThanOrEqualTo(String value) {
            addCriterion("purpose >=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThan(String value) {
            addCriterion("purpose <", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLessThanOrEqualTo(String value) {
            addCriterion("purpose <=", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeLike(String value) {
            addCriterion("purpose like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotLike(String value) {
            addCriterion("purpose not like", value, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeIn(List<String> values) {
            addCriterion("purpose in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotIn(List<String> values) {
            addCriterion("purpose not in", values, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeBetween(String value1, String value2) {
            addCriterion("purpose between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andPurposeNotBetween(String value1, String value2) {
            addCriterion("purpose not between", value1, value2, "purpose");
            return (Criteria) this;
        }

        public Criteria andStyleIsNull() {
            addCriterion("style is null");
            return (Criteria) this;
        }

        public Criteria andStyleIsNotNull() {
            addCriterion("style is not null");
            return (Criteria) this;
        }

        public Criteria andStyleEqualTo(String value) {
            addCriterion("style =", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotEqualTo(String value) {
            addCriterion("style <>", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThan(String value) {
            addCriterion("style >", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThanOrEqualTo(String value) {
            addCriterion("style >=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThan(String value) {
            addCriterion("style <", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThanOrEqualTo(String value) {
            addCriterion("style <=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLike(String value) {
            addCriterion("style like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotLike(String value) {
            addCriterion("style not like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleIn(List<String> values) {
            addCriterion("style in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotIn(List<String> values) {
            addCriterion("style not in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleBetween(String value1, String value2) {
            addCriterion("style between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotBetween(String value1, String value2) {
            addCriterion("style not between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andCustomsIdIsNull() {
            addCriterion("customs_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomsIdIsNotNull() {
            addCriterion("customs_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomsIdEqualTo(String value) {
            addCriterion("customs_id =", value, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdNotEqualTo(String value) {
            addCriterion("customs_id <>", value, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdGreaterThan(String value) {
            addCriterion("customs_id >", value, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdGreaterThanOrEqualTo(String value) {
            addCriterion("customs_id >=", value, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdLessThan(String value) {
            addCriterion("customs_id <", value, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdLessThanOrEqualTo(String value) {
            addCriterion("customs_id <=", value, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdLike(String value) {
            addCriterion("customs_id like", value, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdNotLike(String value) {
            addCriterion("customs_id not like", value, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdIn(List<String> values) {
            addCriterion("customs_id in", values, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdNotIn(List<String> values) {
            addCriterion("customs_id not in", values, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdBetween(String value1, String value2) {
            addCriterion("customs_id between", value1, value2, "customsId");
            return (Criteria) this;
        }

        public Criteria andCustomsIdNotBetween(String value1, String value2) {
            addCriterion("customs_id not between", value1, value2, "customsId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cargo
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cargo
     *
     * @mbg.generated
     */
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