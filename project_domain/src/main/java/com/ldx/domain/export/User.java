package com.ldx.domain.export;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.birthday
     *
     * @mbg.generated
     */
    private String birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.user_email
     *
     * @mbg.generated
     */
    private String userEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.position
     *
     * @mbg.generated
     */
    private String position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.company_id
     *
     * @mbg.generated
     */
    private String companyId;

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public User() {
    }

    public User(String userId, String userName, String password, String birthday, String userEmail, String position, String companyId, String companyName, String createDate, String remark, String wage) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
        this.userEmail = userEmail;
        this.position = position;
        this.companyId = companyId;
        this.companyName = companyName;
        this.createDate = createDate;
        this.remark = remark;
        this.wage = wage;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.create_date
     *
     * @mbg.generated
     */
    private String createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ldx_user.wage
     *
     * @mbg.generated
     */
    private String wage;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.user_id
     *
     * @return the value of ldx_user.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.user_id
     *
     * @param userId the value for ldx_user.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.user_name
     *
     * @return the value of ldx_user.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.user_name
     *
     * @param userName the value for ldx_user.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.password
     *
     * @return the value of ldx_user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.password
     *
     * @param password the value for ldx_user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.birthday
     *
     * @return the value of ldx_user.birthday
     *
     * @mbg.generated
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.birthday
     *
     * @param birthday the value for ldx_user.birthday
     *
     * @mbg.generated
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.user_email
     *
     * @return the value of ldx_user.user_email
     *
     * @mbg.generated
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.user_email
     *
     * @param userEmail the value for ldx_user.user_email
     *
     * @mbg.generated
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.position
     *
     * @return the value of ldx_user.position
     *
     * @mbg.generated
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.position
     *
     * @param position the value for ldx_user.position
     *
     * @mbg.generated
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.company_id
     *
     * @return the value of ldx_user.company_id
     *
     * @mbg.generated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.company_id
     *
     * @param companyId the value for ldx_user.company_id
     *
     * @mbg.generated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.create_date
     *
     * @return the value of ldx_user.create_date
     *
     * @mbg.generated
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.create_date
     *
     * @param createDate the value for ldx_user.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.remark
     *
     * @return the value of ldx_user.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.remark
     *
     * @param remark the value for ldx_user.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ldx_user.wage
     *
     * @return the value of ldx_user.wage
     *
     * @mbg.generated
     */
    public String getWage() {
        return wage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ldx_user.wage
     *
     * @param wage the value for ldx_user.wage
     *
     * @mbg.generated
     */
    public void setWage(String wage) {
        this.wage = wage == null ? null : wage.trim();
    }
}