/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.gndc.common.api.RequestMessage;
import com.gndc.common.utils.DateUtil;

import java.util.Date;

/**
 * 用户信息更改
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月24日 下午2:35:18
 */
public class UserInfoEditRequest extends RequestMessage {
    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 2301349644081904483L;

    /**
     * 昵称
     */
    private String name;

    /**
     * 头像url
     */
    private String photoUrl;

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
    @JSONField(format = DateUtil.FORMAT_1)
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
    @JSONField(format = DateUtil.FORMAT_1)
    private Date cardStartDate;

    /**
     * 身份证有效日期
     */
    @JSONField(format = DateUtil.FORMAT_1)
    private Date cardEndDate;

    /**
     * 职业
     */
    private byte job;

    /**
     * 收入
     */
    private byte income;

    /**
     * 性别
     */
    private byte sex;

    /**
     * 教育程度
     */
    private byte education;

    /**
     * 信用卡
     */
    private byte creditCard;

    /**
     * 信用卡张数
     */
    private int creditCardNum;

    /**
     * 信用卡最高额度
     */
    private byte creditCardMoney;

    /**
     * 社保
     */
    private byte socialSecurity;

    /**
     * 公积金
     */
    private byte accumulationFund;

    /**
     * 房产
     */
    private byte house;

    /**
     * 车子
     */
    private byte car;

    /**
     * 最后阅读的通知
     */
    private long lastNoticeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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

}
