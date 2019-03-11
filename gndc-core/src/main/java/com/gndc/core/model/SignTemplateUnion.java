package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dc_sign_template_union")
public class SignTemplateUnion extends BaseEntity {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 签名id
     */
    private Integer signId;

    /**
     * 签名
     */
    private String signName;

    /**
     * 模板id
     */
    private Integer templateId;

    /**
     * 状态：1：正常；-1：删除
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
     * 签名id
     *
     * @return sign_id 签名id
     */
    public Integer getSignId() {
        return signId;
    }

    /**
     * 签名id
     *
     * @param signId 签名id
     */
    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    /**
     * 签名
     *
     * @return sign_name 签名
     */
    public String getSignName() {
        return signName;
    }

    /**
     * 签名
     *
     * @param signName 签名
     */
    public void setSignName(String signName) {
        this.signName = signName;
    }

    /**
     * 模板id
     *
     * @return template_id 模板id
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * 模板id
     *
     * @param templateId 模板id
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * 状态：1：正常；-1：删除
     *
     * @return status 状态：1：正常；-1：删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态：1：正常；-1：删除
     *
     * @param status 状态：1：正常；-1：删除
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
        SignTemplateUnion other = (SignTemplateUnion) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSignId() == null ? other.getSignId() == null : this.getSignId().equals(other.getSignId()))
                && (this.getSignName() == null ? other.getSignName() == null : this.getSignName().equals(other.getSignName()))
                && (this.getTemplateId() == null ? other.getTemplateId() == null : this.getTemplateId().equals(other.getTemplateId()))
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
        result = prime * result + ((getSignId() == null) ? 0 : getSignId().hashCode());
        result = prime * result + ((getSignName() == null) ? 0 : getSignName().hashCode());
        result = prime * result + ((getTemplateId() == null) ? 0 : getTemplateId().hashCode());
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
        sb.append(", signId=").append(signId);
        sb.append(", signName=").append(signName);
        sb.append(", templateId=").append(templateId);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}