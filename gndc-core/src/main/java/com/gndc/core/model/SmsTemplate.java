package com.gndc.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_sms_template")
public class SmsTemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 签名ID
     */
    @Column(name = "sign_id")
    private Integer signId;

    /**
     * 类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    private Byte type;

    /**
     * 短信模板内容
     */
    private String content;

    /**
     * 状态 1正常 -1删除
     */
    private Byte status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者id
     */
    @Column(name = "create_admin_id")
    private Integer createAdminId;

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
     * 获取签名ID
     *
     * @return sign_id - 签名ID
     */
    public Integer getSignId() {
        return signId;
    }

    /**
     * 设置签名ID
     *
     * @param signId 签名ID
     */
    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    /**
     * 获取类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     *
     * @return type - 类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     *
     * @param type 类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取短信模板内容
     *
     * @return content - 短信模板内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置短信模板内容
     *
     * @param content 短信模板内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取状态 1正常 -1删除
     *
     * @return status - 状态 1正常 -1删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 1正常 -1删除
     *
     * @param status 状态 1正常 -1删除
     */
    public void setStatus(Byte status) {
        this.status = status;
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
}