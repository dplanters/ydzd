package com.gndc.core.etc.admin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class AdminEvents {
    /**
     *
     */
    private long id;

    /**
     * 管理员id
     */
    private int adminId;

    /**
     * 关联事件id
     */
    private int objId;

    /**
     * 事件类型
     */
    private byte eventType;

    /**
     * 操作时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date eventTime;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 备注
     */
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }

    public byte getEventType() {
        return eventType;
    }

    public void setEventType(byte eventType) {
        this.eventType = eventType;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}