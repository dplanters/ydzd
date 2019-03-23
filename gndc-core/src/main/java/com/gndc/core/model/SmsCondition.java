package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_sms_condition")
public class SmsCondition implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 条件类型 0-未定义 1-营销 2-催收 3-提醒 4-通知
     */
    private Byte type;

    /**
     * 条件
     */
    private String condition;

    /**
     * 创建者id
     */
    @Column(name = "create_admin_id")
    private Integer createAdminId;

    /**
     * 状态  1存在；-1删除
     */
    @Column(name = "is_del")
    private Byte isDel;

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
     * 获取条件类型 0-未定义 1-营销 2-催收 3-提醒 4-通知
     *
     * @return type - 条件类型 0-未定义 1-营销 2-催收 3-提醒 4-通知
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置条件类型 0-未定义 1-营销 2-催收 3-提醒 4-通知
     *
     * @param type 条件类型 0-未定义 1-营销 2-催收 3-提醒 4-通知
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取条件
     *
     * @return condition - 条件
     */
    public String getCondition() {
        return condition;
    }

    /**
     * 设置条件
     *
     * @param condition 条件
     */
    public void setCondition(String condition) {
        this.condition = condition;
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
     * 获取状态  1存在；-1删除
     *
     * @return is_del - 状态  1存在；-1删除
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     * 设置状态  1存在；-1删除
     *
     * @param isDel 状态  1存在；-1删除
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
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