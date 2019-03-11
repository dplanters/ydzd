package com.gndc.core.etc.user;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class ManageUser {
    /**
     *
     */
    private int id;

    /**
     * 不重uuid，用于前后台用户标志
     */
    private String uuid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 串号
     */
    private String imei;

    /**
     * 手机终端品牌型号
     */
    private String termType;

    /**
     * 微信OpenID
     */
    private String openId;

    /**
     * 注册来源（1APP/2weixin/3PC）
     */
    private byte isFrom;

    /**
     * 是否认证（-1未认证/1认证）
     */
    private byte isAuth;

    /**
     * 是否删除（-1删除/1未删除）
     */
    private byte isDel;

    /**
     * 最后登录时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    /**
     * 注册日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 账户等级
     */
    private byte level;

    /**
     * 出生日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    /**
     * 身份证地址
     */
    private String cardAddress;

    /**
     * 居住地址
     */
    private String homeAddress;

    /**
     * 身份证发证日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date cardStartDate;

    /**
     * 身份证有效日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date cardEndDate;

    /**
     * 头像URL地址
     */
    private String photoUrl;

    /**
     * 手机号归属地对应s_area表ID
     */
    private int areaId;

    /**
     * 性别（1男/2女）
     */
    private byte sex;

    /**
     * 教育程度(1中专/高中以下/2中专/高中/3专科/4本科/5研究生以上)
     */
    private byte education;

    /**
     * 职业类型（1上班族/2个体户/3企业主/4自由职业）
     */
    private byte job;

    /**
     * 收入范围（1 5000以下/2 5000-1万/3 1万-3万/4 3万-5万/5 5万-10万/6 10万以上）
     */
    private byte income;

    /**
     * 有无信用卡（1有/2无）
     */
    private byte creditCard;

    /**
     * 信用卡张数
     */
    private int creditCardNum;

    /**
     * 信用卡最高额度范围（1 5000以下/2 5000-1万/3 1万-3万/4 3万-5万/5 5万-10万/6 10万以上）
     */
    private byte creditCardMoney;

    /**
     * 有无社保（1有/2无）
     */
    private byte socialSecurity;

    /**
     * 有无公积金（1有/2无）
     */
    private byte accumulationFund;

    /**
     * 有无房产（-1无/1准备购买/2有车无贷款/3有车 按揭贷款/4有车已被抵押）
     */
    private byte house;

    /**
     * 有无车（-1无/1有车 无贷款/2有车 按揭贷款/3有车 但已抵押）
     */
    private byte car;

    /**
     * 最后阅读的通知
     */
    private long lastNoticeId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public byte getIsFrom() {
        return isFrom;
    }

    public void setIsFrom(byte isFrom) {
        this.isFrom = isFrom;
    }

    public byte getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(byte isAuth) {
        this.isAuth = isAuth;
    }

    public byte getIsDel() {
        return isDel;
    }

    public void setIsDel(byte isDel) {
        this.isDel = isDel;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Date getCardStartDate() {
        return cardStartDate;
    }

    public void setCardStartDate(Date cardStartDate) {
        this.cardStartDate = cardStartDate;
    }

    public Date getCardEndDate() {
        return cardEndDate;
    }

    public void setCardEndDate(Date cardEndDate) {
        this.cardEndDate = cardEndDate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public byte getEducation() {
        return education;
    }

    public void setEducation(byte education) {
        this.education = education;
    }

    public byte getJob() {
        return job;
    }

    public void setJob(byte job) {
        this.job = job;
    }

    public byte getIncome() {
        return income;
    }

    public void setIncome(byte income) {
        this.income = income;
    }

    public byte getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(byte creditCard) {
        this.creditCard = creditCard;
    }

    public int getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(int creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public byte getCreditCardMoney() {
        return creditCardMoney;
    }

    public void setCreditCardMoney(byte creditCardMoney) {
        this.creditCardMoney = creditCardMoney;
    }

    public byte getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(byte socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public byte getAccumulationFund() {
        return accumulationFund;
    }

    public void setAccumulationFund(byte accumulationFund) {
        this.accumulationFund = accumulationFund;
    }

    public byte getHouse() {
        return house;
    }

    public void setHouse(byte house) {
        this.house = house;
    }

    public byte getCar() {
        return car;
    }

    public void setCar(byte car) {
        this.car = car;
    }

    public long getLastNoticeId() {
        return lastNoticeId;
    }

    public void setLastNoticeId(long lastNoticeId) {
        this.lastNoticeId = lastNoticeId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}