package com.gndc.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_sms_job_condition")
public class SmsJobCondition implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 条件id
     */
    @Column(name = "condition_id")
    private Integer conditionId;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 签名id
     */
    @Column(name = "sign_ids")
    private String signIds;

    /**
     * 模板id
     */
    @Column(name = "template_id")
    private Integer templateId;

    /**
     * 运营商id 1:移动，2：联通，3：电信
     */
    @Column(name = "operator_ids")
    private String operatorIds;

    /**
     * 创建者id
     */
    @Column(name = "create_admin_id")
    private Integer createAdminId;

    /**
     * 状态  1：正常；0：删除
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 电话
     */
    private String phones;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取条件id
     *
     * @return condition_id - 条件id
     */
    public Integer getConditionId() {
        return conditionId;
    }

    /**
     * 设置条件id
     *
     * @param conditionId 条件id
     */
    public void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    /**
     * 获取渠道id
     *
     * @return channel_id - 渠道id
     */
    public Integer getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道id
     *
     * @param channelId 渠道id
     */
    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取签名id
     *
     * @return sign_ids - 签名id
     */
    public String getSignIds() {
        return signIds;
    }

    /**
     * 设置签名id
     *
     * @param signIds 签名id
     */
    public void setSignIds(String signIds) {
        this.signIds = signIds;
    }

    /**
     * 获取模板id
     *
     * @return template_id - 模板id
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板id
     *
     * @param templateId 模板id
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取运营商id 1:移动，2：联通，3：电信
     *
     * @return operator_ids - 运营商id 1:移动，2：联通，3：电信
     */
    public String getOperatorIds() {
        return operatorIds;
    }

    /**
     * 设置运营商id 1:移动，2：联通，3：电信
     *
     * @param operatorIds 运营商id 1:移动，2：联通，3：电信
     */
    public void setOperatorIds(String operatorIds) {
        this.operatorIds = operatorIds;
    }

    /**
     * 获取创建者id
     *
     * @return create_admin_id - 创建者id
     */
    public Integer getCreateAdminId() {
        return createAdminId;
    }

    /**
     * 设置创建者id
     *
     * @param createAdminId 创建者id
     */
    public void setCreateAdminId(Integer createAdminId) {
        this.createAdminId = createAdminId;
    }

    /**
     * 获取状态  1：正常；0：删除
     *
     * @return status - 状态  1：正常；0：删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态  1：正常；0：删除
     *
     * @param status 状态  1：正常；0：删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取电话
     *
     * @return phones - 电话
     */
    public String getPhones() {
        return phones;
    }

    /**
     * 设置电话
     *
     * @param phones 电话
     */
    public void setPhones(String phones) {
        this.phones = phones;
    }
}