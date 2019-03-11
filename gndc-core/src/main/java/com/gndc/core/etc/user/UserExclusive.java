package com.gndc.core.etc.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.gndc.common.utils.DateUtil;

import java.util.Date;

public class UserExclusive {
    /**
     *
     */
    private int id;

    /**
     *
     */
    private int userId;

    /**
     * 产品类型（1贷款产品/2银行产品/3代还产品）
     */
    private byte type;

    @JSONField(format = DateUtil.FORMAT_2)
    private Date createdAt;

    @JSONField(format = DateUtil.FORMAT_2)
    private Date updatedAt;

    /**
     * 产品专属
     */
    private String exclusive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 产品专属
     *
     * @return exclusive 产品专属
     */
    public String getExclusive() {
        return exclusive;
    }

    /**
     * 产品专属
     *
     * @param exclusive 产品专属
     */
    public void setExclusive(String exclusive) {
        this.exclusive = exclusive == null ? null : exclusive.trim();
    }
}