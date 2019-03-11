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
 * @Description 国都互联短信接口返回状态码和提示信息
 * @date 2018年1月25日 上午9:59:17
 */
public enum GdhlSmsReturnCode {

    BATCH_SUCCESS("00", " 批量短信提交成功"),

    PERSONAL_SUCCESS("01", "个性化短信提交成功"),

    IP_CHECK_FAIL("02", "IP验证失败"),

    SINGLE_SUCCESS("03", "单条短信提交成功"),

    USERNAME_ERROR("04", "用户名错误"),

    PASSWORD_ERROR("05", "密码错误"),

    PARAMETER_ERROR("06", "参数有误"),

    SENDTIME_ERROR("07", "SendTime格式错误"),

    CONTENT_ISNULL("08", "短信内容为空"),

    MOBILE_ISNULL("09", "手机号码为空"),

    APPENDID_ERROR("10", "AppendID格式错误"),

    BALANCE_NOT_ENOUGH("11", "余额不足"),

    USERCASE_ERROR("16", "用户自传UserCase错误"),

    SUBMIT_EXCEPTION("-1", "提交异常");

    private String code;
    private String message;

    GdhlSmsReturnCode(String code, String name) {
        this.code = code;
        this.message = name;
    }

    public static String getName(String code) {
        for (GdhlSmsReturnCode temp : GdhlSmsReturnCode.values()) {
            if (temp.code.equals(code)) {
                return temp.message;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return message;
    }

    public void setName(String name) {
        this.message = name;
    }

}
