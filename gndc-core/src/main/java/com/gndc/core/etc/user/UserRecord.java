package com.gndc.core.etc.user;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class UserRecord {
    /**
     *
     */
    private int id;

    /**
     * 新增用户
     */
    private int added;

    /**
     * 活跃用户
     */
    private int active;

    /**
     * 时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdded() {
        return added;
    }

    public void setAdded(int added) {
        this.added = added;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}