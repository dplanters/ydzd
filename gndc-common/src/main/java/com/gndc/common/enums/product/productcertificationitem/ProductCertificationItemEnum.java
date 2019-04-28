/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.product.productcertificationitem;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/28  15:23
 */
public enum ProductCertificationItemEnum {

    //
    MOBILE("mobile","手机号"),
    NAME("name","姓名"),
    AADHAAR_CODE("AadhaarCode","Aadhaar_code"),
    REPAYMENT_BANK_CARD("repaymentBankCard","收款银行卡"),


    MARITAL_STATUS("maritalStatus","婚姻状况"),
    CITY("city","所在城市"),
    ADDRESS_INFO("addressInfo","居住详细地址"),
    HOUSEHOLD_REGISTRATION_CITY("householdRegistrationCity","户籍所在城市"),


    JOB_TYPE("jobType","工作类型"),
    MONTHLY_INCOME("monthlyIncome","     月收入："),
    WORKING_YEARS("workingYears","工作年限"),
    WORK_PHONE("workPhone","单位电话"),


    EDUCATION_LEVEL("educationLevel","教育程度"),
    SOCIAL_SECURITY_PROVIDENT_FUND("social_security_provident_fund","社保及公积金"),
    EMERGENCY_CONTACT("emergencyContact","紧急联系人"),
    CARRIER_CERTIFICATION("carrierCertification","运营商认证"),
    CREDIT_CARD_AUTHENTICATION("creditCardAuthentication"," 信用卡认证"),
    CREDENTIALS_UPLOAD("credentitalsUpload","证件上传"),
    HAND_HELD_IDENTITY_CARD("handHeldIdentityCard","手持身份证"),
    LIVING_BODY_IDENTIFICATION("livingBodyIdentification","活体识别"),
    DEVICE_INFORMATION("deviceInformation","设备信息"),
    FINGERPRINT_INFORMATION("fingerprintInformation","指纹信息"),
    ONLINE_SHOPPING_CREDIT("OnlineShoppingCredit","网购信用"),
    SOCIAL_INFORMATION_CERTIFICATION("socialInformationCertification"," 社交信息认证");


    private String key;
    private String name;

    ProductCertificationItemEnum(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
