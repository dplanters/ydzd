package com.gndc.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_partner_api")
public class PartnerApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 机构id
     */
    @Column(name = "partner_id")
    private Integer partnerId;

    /**
     * 接口地址
     */
    @Column(name = "api_url")
    private String apiUrl;

    /**
     * 接口类型
     */
    @Column(name = "api_type")
    private Byte apiType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态  1：正常；0：删除
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
     * 获取机构id
     *
     * @return partner_id - 机构id
     */
    public Integer getPartnerId() {
        return partnerId;
    }

    /**
     * 设置机构id
     *
     * @param partnerId 机构id
     */
    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * 获取接口地址
     *
     * @return api_url - 接口地址
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * 设置接口地址
     *
     * @param apiUrl 接口地址
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * 获取接口类型
     *
     * @return api_type - 接口类型
     */
    public Byte getApiType() {
        return apiType;
    }

    /**
     * 设置接口类型
     *
     * @param apiType 接口类型
     */
    public void setApiType(Byte apiType) {
        this.apiType = apiType;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}