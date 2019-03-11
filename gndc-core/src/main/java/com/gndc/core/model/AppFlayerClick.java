package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "dc_appsflyer_click")
public class AppFlayerClick extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_click.id
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_click.user_id
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_click.product_id
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_click.create_time
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_click.update_time
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_click.status
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_click.type
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    private Byte type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_click.id
     *
     * @return the value of dc_appsflyer_click.id
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_click.id
     *
     * @param id the value for dc_appsflyer_click.id
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_click.user_id
     *
     * @return the value of dc_appsflyer_click.user_id
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_click.user_id
     *
     * @param userId the value for dc_appsflyer_click.user_id
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_click.product_id
     *
     * @return the value of dc_appsflyer_click.product_id
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_click.product_id
     *
     * @param productId the value for dc_appsflyer_click.product_id
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_click.create_time
     *
     * @return the value of dc_appsflyer_click.create_time
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_click.create_time
     *
     * @param createTime the value for dc_appsflyer_click.create_time
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_click.update_time
     *
     * @return the value of dc_appsflyer_click.update_time
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_click.update_time
     *
     * @param updateTime the value for dc_appsflyer_click.update_time
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_click.status
     *
     * @return the value of dc_appsflyer_click.status
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_click.status
     *
     * @param status the value for dc_appsflyer_click.status
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_click.type
     *
     * @return the value of dc_appsflyer_click.type
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_click.type
     *
     * @param type the value for dc_appsflyer_click.type
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_appsflyer_click
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AppFlayerClick other = (AppFlayerClick) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_appsflyer_click
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_appsflyer_click
     *
     * @mbggenerated Wed Sep 05 11:12:36 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", productId=").append(productId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", status=").append(status);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}