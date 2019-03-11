/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 密码工具类
 * @date 2018年1月24日 下午5:23:29
 */
public final class PasswordUtil {

    /**
     * 正则表达式验证密码必须要包含数字和大小写字母的6-20位密码
     *
     * @param input
     * @return
     */
    public static boolean rexCheckPassword(String input) {
        // 6-20 位，字母、数字、字符
        // String reg = "^([A-Z]|[a-z]|[0-9]|[`-=[];,./~!@#$%^*()_+}{:?]){6,20}$";
        // String regStr = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}$";
        // //2017-05-26 18:44 替换
        String regStr = "^([A-Z]|[a-z]|[0-9]|[~!@#$%^&*\\(\\)_+\\{\\}\\|:”<>?`\\[\\]\\-\\\\=;’,./]){6,16}$";
        return input.matches(regStr);
    }

    /**
     * 加密用户密码
     *
     * @param password
     * @param sign
     * @return
     * @Description
     */
    public static String getPassword(String password, String sign) {
        return MD5Util.getMD5(password + sign).substring(5, 30);
    }

    /**
     * 登陆验证
     *
     * @param passStr
     * @param passLogin
     * @param salt
     * @return
     */
    public static boolean validate(String passStr, String passLogin) {

        return StringUtils.equals(passStr, passLogin);
    }
}
