/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.user;

/**
 * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
 * @version V1.0.1
 * @Description
 * @date Aug 30, 2018 4:12:47 PM
 */
public class AccountKitPhone {
    private String number;
    private String country_prefix;
    private String national_number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry_prefix() {
        return country_prefix;
    }

    public void setCountry_prefix(String country_prefix) {
        this.country_prefix = country_prefix;
    }

    public String getNational_number() {
        return national_number;
    }

    public void setNational_number(String national_number) {
        this.national_number = national_number;
    }

}
