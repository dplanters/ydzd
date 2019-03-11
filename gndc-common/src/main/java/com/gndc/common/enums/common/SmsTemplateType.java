/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.common;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 阿里云短信模版
 * @date 2018年1月24日 下午4:50:29
 */
public enum SmsTemplateType {

    USER_REGISTER((byte) 1, "SMS_105490010", "您的验证码为${code}，10分钟内有效。"),

    USER_FORGET_PWD((byte) 2, "SMS_105300005", "验证码${code},您正在找回密码，嘘~千万别告诉别人。"),

    // 修改手机验证码，目前和注册模板相同
    USER_MODIFY_PHONE((byte) 3, "SMS_105490010", "您的验证码为${code}，10分钟内有效。"),

    // 银行卡绑定验证码
    SELLER_BANK_BIND((byte) 4, "SMS_105475007", "您的验证码为${code}，您的银行卡正在互金网络平台开通绑定，请勿泄露。");

    // 短信类型
    private byte code;
    // 短信模板
    private String template;
    // 模板内容
    private String templateContent;

    private SmsTemplateType(byte code, String template, String templateContent) {
        this.code = code;
        this.template = template;
        this.templateContent = templateContent;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

}
