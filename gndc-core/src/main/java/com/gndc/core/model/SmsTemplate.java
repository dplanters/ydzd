package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dc_sms_template")
public class SmsTemplate extends BaseEntity {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 签名ID
     */
    private Integer signId;

    /**
     * 类型 0-未定义 1-验证码 2-营销类 3-提醒类
     */
    private Byte type;

    /**
     * 短信模板内容
     */
    private String content;

    /**
     *
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
     * 签名ID
     *
     * @return sign_id 签名ID
     */
    public Integer getSignId() {
        return signId;
    }

    /**
     * 签名ID
     *
     * @param signId 签名ID
     */
    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    /**
     * 类型 0-未定义 1-验证码 2-营销类 3-提醒类
     *
     * @return type 类型 0-未定义 1-验证码 2-营销类 3-提醒类
     */
    public Byte getType() {
        return type;
    }

    /**
     * 类型 0-未定义 1-验证码 2-营销类 3-提醒类
     *
     * @param type 类型 0-未定义 1-验证码 2-营销类 3-提醒类
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 短信模板内容
     *
     * @return content 短信模板内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 短信模板内容
     *
     * @param content 短信模板内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return status
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * @param status
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
        SmsTemplate other = (SmsTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getSignId() == null ? other.getSignId() == null : this.getSignId().equals(other.getSignId()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
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
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
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
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}