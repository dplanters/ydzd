/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 正则表达式util
 * @date 2018年1月25日 上午9:18:50
 */
public class PatternUtil {

    /**
     * 判断是中文开头
     *
     * @param str
     * @return
     */
    public static boolean isStartWithChinese(String str) {
        String firstChar = str.substring(0, 1);
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(firstChar);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否字母开头
     *
     * @param str
     * @return
     */
    public static boolean isStartWithLetter(String str) {
        String firstChar = str.substring(0, 1);
        Pattern p = Pattern.compile("[A-Za-z]");
        Matcher m = p.matcher(firstChar);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否数字开头
     *
     * @param str
     * @return
     */
    public static boolean isStartWithNumber(String str) {
        String firstChar = str.substring(0, 1);
        return isNumber(firstChar);
    }

    /**
     * 功能：判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean findChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 功能：判断字符串是否为日期格式
     *
     * @param str
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern.compile(
                "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否为连续的数字或者字符
     *
     * @param passwod
     * @return
     */
    public static boolean isSame(String str) {
        Pattern pattern = Pattern.compile(String.format("([0-9a-zA-Z])\\1{%d}", str.length() - 1));
        Matcher m = pattern.matcher(str);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
