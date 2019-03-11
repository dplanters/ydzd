package com.gndc.core.api.user;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

import java.math.BigDecimal;

/**
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin8418</a>
 * @version V1.0.1
 * @Description 校验手机号码是否已经注册
 * @date 2018年7月19日 下午2:40:33
 */
public class UserInfoRequest extends RequestMessage {
    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 2301349644081904483L;

    /**
     * 姓名
     */
    private String userName;

    private byte sex;

    private String education;
    private String job;
    private int cityId;
    private int provinceId;
    /**
     * 出生日期
     */
    private String birthday;
    private BigDecimal income;

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday 要设置的 birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return provinceId
     */
    public int getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId 要设置的 provinceId
     */
    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return cityId
     */
    public int getCityId() {
        return cityId;
    }

    /**
     * @param cityId 要设置的 cityId
     */
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return income
     */
    public BigDecimal getIncome() {
        return income;
    }

    /**
     * @param income 要设置的 income
     */
    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.U_INFO_ADD);
    }

}
