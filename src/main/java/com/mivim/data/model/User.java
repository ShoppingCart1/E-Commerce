package com.mivim.data.model;

import java.util.Date;

public class User extends UserKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.mobileNumber
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private String mobileNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.status
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.updated_date
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private Date updated_date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.mobileNumber
     *
     * @return the value of user.mobileNumber
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.mobileNumber
     *
     * @param mobileNumber the value for user.mobileNumber
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.status
     *
     * @return the value of user.status
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.status
     *
     * @param status the value for user.status
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.updated_date
     *
     * @return the value of user.updated_date
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public Date getUpdated_date() {
        return updated_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.updated_date
     *
     * @param updated_date the value for user.updated_date
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}