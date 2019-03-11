package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "dc_appsflyer_events")
public class AppsflyerEvent extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_events.id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_events.event_type
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte eventType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_events.event_time
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Date eventTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_events.event_date
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Date eventDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_events.media_source
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Integer mediaSource;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_events.use_id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Integer useId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_events.app_type
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte appType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_appsflyer_events.product_id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Integer productId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_events.id
     *
     * @return the value of dc_appsflyer_events.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_events.id
     *
     * @param id the value for dc_appsflyer_events.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_events.event_type
     *
     * @return the value of dc_appsflyer_events.event_type
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getEventType() {
        return eventType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_events.event_type
     *
     * @param eventType the value for dc_appsflyer_events.event_type
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setEventType(Byte eventType) {
        this.eventType = eventType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_events.event_time
     *
     * @return the value of dc_appsflyer_events.event_time
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Date getEventTime() {
        return eventTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_events.event_time
     *
     * @param eventTime the value for dc_appsflyer_events.event_time
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_events.event_date
     *
     * @return the value of dc_appsflyer_events.event_date
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_events.event_date
     *
     * @param eventDate the value for dc_appsflyer_events.event_date
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_events.media_source
     *
     * @return the value of dc_appsflyer_events.media_source
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getMediaSource() {
        return mediaSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_events.media_source
     *
     * @param mediaSource the value for dc_appsflyer_events.media_source
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setMediaSource(Integer mediaSource) {
        this.mediaSource = mediaSource;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_events.use_id
     *
     * @return the value of dc_appsflyer_events.use_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getUseId() {
        return useId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_events.use_id
     *
     * @param useId the value for dc_appsflyer_events.use_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_events.app_type
     *
     * @return the value of dc_appsflyer_events.app_type
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getAppType() {
        return appType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_events.app_type
     *
     * @param appType the value for dc_appsflyer_events.app_type
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setAppType(Byte appType) {
        this.appType = appType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_appsflyer_events.product_id
     *
     * @return the value of dc_appsflyer_events.product_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_appsflyer_events.product_id
     *
     * @param productId the value for dc_appsflyer_events.product_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_appsflyer_events
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
        AppsflyerEvent other = (AppsflyerEvent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getEventType() == null ? other.getEventType() == null : this.getEventType().equals(other.getEventType()))
                && (this.getEventTime() == null ? other.getEventTime() == null : this.getEventTime().equals(other.getEventTime()))
                && (this.getEventDate() == null ? other.getEventDate() == null : this.getEventDate().equals(other.getEventDate()))
                && (this.getMediaSource() == null ? other.getMediaSource() == null : this.getMediaSource().equals(other.getMediaSource()))
                && (this.getUseId() == null ? other.getUseId() == null : this.getUseId().equals(other.getUseId()))
                && (this.getAppType() == null ? other.getAppType() == null : this.getAppType().equals(other.getAppType()))
                && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_appsflyer_events
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventType() == null) ? 0 : getEventType().hashCode());
        result = prime * result + ((getEventTime() == null) ? 0 : getEventTime().hashCode());
        result = prime * result + ((getEventDate() == null) ? 0 : getEventDate().hashCode());
        result = prime * result + ((getMediaSource() == null) ? 0 : getMediaSource().hashCode());
        result = prime * result + ((getUseId() == null) ? 0 : getUseId().hashCode());
        result = prime * result + ((getAppType() == null) ? 0 : getAppType().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_appsflyer_events
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
        sb.append(", eventType=").append(eventType);
        sb.append(", eventTime=").append(eventTime);
        sb.append(", eventDate=").append(eventDate);
        sb.append(", mediaSource=").append(mediaSource);
        sb.append(", useId=").append(useId);
        sb.append(", appType=").append(appType);
        sb.append(", productId=").append(productId);
        sb.append("]");
        return sb.toString();
    }
}