package com.mivim.data.model;

import java.util.Date;

public class Item {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.id
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.itemName
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private String itemName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.unitPrice
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private String unitPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.inventary
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private String inventary;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.itemDescription
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private String itemDescription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.updatedDate
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private Date updatedDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.status
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.id
     *
     * @return the value of item.id
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.id
     *
     * @param id the value for item.id
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.itemName
     *
     * @return the value of item.itemName
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.itemName
     *
     * @param itemName the value for item.itemName
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.unitPrice
     *
     * @return the value of item.unitPrice
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.unitPrice
     *
     * @param unitPrice the value for item.unitPrice
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice == null ? null : unitPrice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.inventary
     *
     * @return the value of item.inventary
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public String getInventary() {
        return inventary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.inventary
     *
     * @param inventary the value for item.inventary
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setInventary(String inventary) {
        this.inventary = inventary == null ? null : inventary.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.itemDescription
     *
     * @return the value of item.itemDescription
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.itemDescription
     *
     * @param itemDescription the value for item.itemDescription
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription == null ? null : itemDescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.updatedDate
     *
     * @return the value of item.updatedDate
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.updatedDate
     *
     * @param updatedDate the value for item.updatedDate
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.status
     *
     * @return the value of item.status
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.status
     *
     * @param status the value for item.status
     *
     * @mbg.generated Wed Jul 19 11:59:46 IST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}