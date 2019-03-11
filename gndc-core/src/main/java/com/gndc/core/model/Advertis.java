package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dc_operation_advertis")
public class Advertis extends BaseEntity {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_operation_advertis.id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_operation_advertis.product_id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Integer productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_operation_advertis.advertis_type
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte advertisType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_operation_advertis.status
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_operation_advertis.is_del
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte isDel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_operation_advertis.link
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String link;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_operation_advertis.img_url
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String imgUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_operation_advertis.id
     *
     * @return the value of dc_operation_advertis.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_operation_advertis.id
     *
     * @param id the value for dc_operation_advertis.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_operation_advertis.product_id
     *
     * @return the value of dc_operation_advertis.product_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_operation_advertis.product_id
     *
     * @param productId the value for dc_operation_advertis.product_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_operation_advertis.advertis_type
     *
     * @return the value of dc_operation_advertis.advertis_type
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getAdvertisType() {
        return advertisType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_operation_advertis.advertis_type
     *
     * @param advertisType the value for dc_operation_advertis.advertis_type
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setAdvertisType(Byte advertisType) {
        this.advertisType = advertisType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_operation_advertis.status
     *
     * @return the value of dc_operation_advertis.status
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_operation_advertis.status
     *
     * @param status the value for dc_operation_advertis.status
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_operation_advertis.is_del
     *
     * @return the value of dc_operation_advertis.is_del
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_operation_advertis.is_del
     *
     * @param isDel the value for dc_operation_advertis.is_del
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_operation_advertis.link
     *
     * @return the value of dc_operation_advertis.link
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getLink() {
        return link;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_operation_advertis.link
     *
     * @param link the value for dc_operation_advertis.link
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_operation_advertis.img_url
     *
     * @return the value of dc_operation_advertis.img_url
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_operation_advertis.img_url
     *
     * @param imgUrl the value for dc_operation_advertis.img_url
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_operation_advertis
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
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
        Advertis other = (Advertis) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
                && (this.getAdvertisType() == null ? other.getAdvertisType() == null : this.getAdvertisType().equals(other.getAdvertisType()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
                && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()))
                && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_operation_advertis
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getAdvertisType() == null) ? 0 : getAdvertisType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_operation_advertis
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", advertisType=").append(advertisType);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append(", link=").append(link);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append("]");
        return sb.toString();
    }
}