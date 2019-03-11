package com.gndc.core.etc.sms;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class SendValcodeLog {
    /**
     *
     */
    private int id;

    /**
     * 手机号
     */
    private long phone;

    /**
     * 验证码
     */
    private int code;

    /**
     *
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date sendTime;

    /**
     * 过期时间，以秒为单位，默认插入60秒
     */
    private int expireLimt;

    /**
     * 过期时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;

    /**
     * 调用接口返回状态码
     */
    private String returnCode;

    /**
     * 短信接口返回信息
     */
    private String returnMsg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public int getExpireLimt() {
        return expireLimt;
    }

    public void setExpireLimt(int expireLimt) {
        this.expireLimt = expireLimt;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

}