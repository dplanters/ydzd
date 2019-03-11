package com.gndc.core.etc.user;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class UserEvents {
    /**
     *
     */
    private int userId;

    /**
     * 事件类型
     */
    private byte type;

    /**
     * 关联事件ID
     */
    private int objId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}