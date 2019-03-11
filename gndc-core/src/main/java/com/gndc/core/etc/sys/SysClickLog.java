package com.gndc.core.etc.sys;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class SysClickLog {
    /**
     * 微信号
     */
    private String openId;

    /**
     * 号码
     */
    private String phone;

    /**
     * 手机串号
     */
    private String imei;

    /**
     * 点击来源,分为PC,WX,IOS,ANDRIOD
     */
    private String clickRes;

    /**
     * 产品类型,如Bank,Card,SuperMarket,Repayment
     */
    private String prodType;

    /**
     * 产品编号
     */
    private int prodId;

    /**
     * 点击时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date clickTime;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getClickRes() {
        return clickRes;
    }

    public void setClickRes(String clickRes) {
        this.clickRes = clickRes;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public Date getClickTime() {
        return clickTime;
    }

    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }

}