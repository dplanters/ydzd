/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import org.apache.commons.lang.StringUtils;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 谷歌手机号码归属地查询util类
 * @date 2018年1月25日 上午9:34:07
 */
public class PhoneUtil {

    /**
     * 中国电信号码格式验证 手机段： 133,153,180,181,189,177,1700,173,199
     **/
    private static final String CHINA_TELECOM_PATTERN = "(^1(33|53|77|73|99|8[019])\\d{8}$)|(^1700\\d{7}$)";

    /**
     * 中国联通号码格式验证 手机段：130,131,132,155,156,185,186,145,176,1709
     **/
    private static final String CHINA_UNICOM_PATTERN = "(^1(3[0-2]|4[5]|5[56]|7[6]|8[56])\\d{8}$)|(^1709\\d{7}$)";

    /**
     * 中国移动号码格式验证
     * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184,187,188,147,178,1705
     **/
    private static final String CHINA_MOBILE_PATTERN = "(^1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(^1705\\d{7}$)";


    private final static String LANGUAGE = "CN";
    // private static final Logger logger =
    // LoggerFactory.getLogger(PhoneUtil.class);
    private static PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 手机号归属地获取工具类
     *
     * @param phoneNum
     * @return
     */
    public static String getCity(String phoneNum) {
        if (StringUtils.isBlank(phoneNum)) {
            return null;
        }
        try {
            PhoneNumberOfflineGeocoder phoneNumberOfflineGeocoder = PhoneNumberOfflineGeocoder.getInstance();
            PhoneNumber referencePhoneNumber = phoneUtil.parse(phoneNum, LANGUAGE);
            // 手机号码归属城市 city
            return phoneNumberOfflineGeocoder.getDescriptionForNumber(referencePhoneNumber, Locale.CHINA);

        } catch (NumberParseException e) {
            e.printStackTrace();
            // logger.error(e.getMessage());
        }

        return null;
    }

    /**
     * 校验并处理手机号
     *
     * @param phone
     * @return
     * @throws Exception
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static boolean checkPhone(String phone) {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    // public static void main(String[] args) throws HjException {
    // boolean flag = checkPhone("15215962807");
    // System.out.println(flag);
    // }

    /**
     * 处理手机号
     *
     * @param phone
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static String dealPhone(String phone) {
        phone = StringUtils.deleteWhitespace(StringUtils.trimToEmpty(phone));

        Pattern p2 = Pattern.compile("^(((\\+{0,1}(86|62|63|84)){0,1})(0){0,1})");
        Matcher m2 = p2.matcher(phone);
        StringBuffer sb = new StringBuffer();
        while (m2.find()) {
            m2.appendReplacement(sb, "");
        }
        m2.appendTail(sb);
        return sb.toString();

    }

    /**
     * 处理固话
     *
     * @param phone
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static String dealFixedPhone(String phone) {
        phone = StringUtils.deleteWhitespace(StringUtils.trimToEmpty(phone));

        Pattern p2 = Pattern.compile("^((\\+{0,1}(86|62|63|84)){0,1})");
        Matcher m2 = p2.matcher(phone);
        StringBuffer sb = new StringBuffer();
        while (m2.find()) {
            m2.appendReplacement(sb, "");
        }
        m2.appendTail(sb);
        return sb.toString();

    }

    public static String uniquePhone(String phone) {
        phone = phone.replace("-", "");
        String first = (String) phone.subSequence(0, 1);
        if (first.equals("0")) {
            phone = (String) phone.subSequence(1, phone.length());
        }
        return phone;
    }

    /**
     * 查询电话属于哪个运营商
     *
     * @param tel 手机号码
     * @return 0：不属于任何一个运营商，1:移动，2：联通，3：电信
     */
    public static Integer isChinaMobilePhoneNum(String tel) {
        boolean b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_MOBILE_PATTERN, tel);
        if (b1) {
            return 1;
        }
        b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_UNICOM_PATTERN, tel);
        if (b1) {
            return 2;
        }
        b1 = tel == null || tel.trim().equals("") ? false : match(CHINA_TELECOM_PATTERN, tel);
        if (b1) {
            return 3;
        }
        return 0;
    }


    /**
     * 匹配函数
     * @param regex
     * @param tel
     * @return
     */
    private static boolean match(String regex, String tel) {
        return Pattern.matches(regex, tel);
    }

}
