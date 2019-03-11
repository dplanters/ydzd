package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dc_partner_contact")
public class PartnerContact extends BaseEntity {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 合作机构ID
     */
    private Integer partnerId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 职位
     */
    private String position;

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
     * 合作机构ID
     *
     * @return partner_id 合作机构ID
     */
    public Integer getPartnerId() {
        return partnerId;
    }

    /**
     * 合作机构ID
     *
     * @param partnerId 合作机构ID
     */
    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * 姓名
     *
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 手机号
     *
     * @return phone 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 邮箱
     *
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 职位
     *
     * @return position 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position;
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
     * @mbggenerated 2019-02-25
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
        PartnerContact other = (PartnerContact) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * @mbggenerated 2019-02-25
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * @mbggenerated 2019-02-25
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", position=").append(position);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}