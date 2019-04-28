package com.gndc.product.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_system_config")
public class SystemConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分组
     */
    private String group;

    /**
     * 配置项key
     */
    private String key;

    /**
     * 配置项value
     */
    private String value;

    /**
     * 备注，描述
     */
    private String remark;

    /**
     * 记录状态  1：正常；0：删除；
     */
    private Boolean status;

    /**
     * 更新者id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

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
     * 获取分组
     *
     * @return group - 分组
     */
    public String getGroup() {
        return group;
    }

    /**
     * 设置分组
     *
     * @param group 分组
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 获取配置项key
     *
     * @return key - 配置项key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置配置项key
     *
     * @param key 配置项key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取配置项value
     *
     * @return value - 配置项value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置配置项value
     *
     * @param value 配置项value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取备注，描述
     *
     * @return remark - 备注，描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注，描述
     *
     * @param remark 备注，描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取记录状态  1：正常；0：删除；
     *
     * @return status - 记录状态  1：正常；0：删除；
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置记录状态  1：正常；0：删除；
     *
     * @param status 记录状态  1：正常；0：删除；
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取更新者id
     *
     * @return operator_id - 更新者id
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * 设置更新者id
     *
     * @param operatorId 更新者id
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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
}