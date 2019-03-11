package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dc_sms_sign")
public class SmsSign extends BaseEntity {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 短信通道id
     */
    private Integer channelId;

    /**
     * 短信通道名
     */
    private String channelName;

    /**
     * 签名
     */
    private String name;

    /**
     * 状态 1正常 -1删除
     */
    private Byte status;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 短信通道id
     *
     * @return channel_id 短信通道id
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 短信通道id
     *
     * @param channelId 短信通道id
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 短信通道名
     *
     * @return channel_name 短信通道名
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 短信通道名
     *
     * @param channelName 短信通道名
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 签名
     *
     * @return name 签名
     */
    public String getName() {
        return name;
    }

    /**
     * 签名
     *
     * @param name 签名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 状态 1正常 -1删除
     *
     * @return status 状态 1正常 -1删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态 1正常 -1删除
     *
     * @param status 状态 1正常 -1删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @mbggenerated 2019-03-02
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
        SmsSign other = (SmsSign) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
                && (this.getChannelName() == null ? other.getChannelName() == null : this.getChannelName().equals(other.getChannelName()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * @mbggenerated 2019-03-02
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelName() == null) ? 0 : getChannelName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * @mbggenerated 2019-03-02
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", channelId=").append(channelId);
        sb.append(", channelName=").append(channelName);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}