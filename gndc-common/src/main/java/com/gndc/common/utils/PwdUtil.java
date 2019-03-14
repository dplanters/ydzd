package com.gndc.common.utils;


import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;

import java.io.UnsupportedEncodingException;

public class PwdUtil {

    public static String decryptRC4(String rc4Pwd) throws HjException {
        String password = "";
        try {
            password = RC4.decrypt(rc4Pwd);
        } catch (UnsupportedEncodingException e) {
            throw new HjException(ResultCode.PARAMETER_ERROR);
        }
        return password;
    }

    public static String encryptRC4(String rc4Pwd) throws HjException {
        String password = "";
        try {
            password = RC4.encrypt(rc4Pwd);
        } catch (UnsupportedEncodingException e) {
            throw new HjException(ResultCode.PARAMETER_ERROR);
        }
        return password;
    }

    /**
     * @param rsaPwd
     * @return
     * @throws HjException
     * @Description RSA解密
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static String decryptRSA(String rsaPwd) throws HjException {
        String password = "";
        try {
            password = RSAUtil.decrypt(rsaPwd);
        } catch (Exception e) {
            throw new HjException(ResultCode.PARAMETER_ERROR);
        }
        return password;
    }

    /**
     * @param pwd
     * @return
     * @throws HjException
     * @Description RSA加密
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static String encryptRSA(String pwd) throws HjException {
        String password = "";
        try {
            password = RSAUtil.encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HjException(ResultCode.PARAMETER_ERROR);
        }
        return password;
    }

    /**
     * 校验密码合法性
     *
     * @param password
     * @throws RtfException
     */
    public static void validate(String password) throws HjException {
        if (password.length() < 6 || password.length() > 12) {
            throw new HjException(ResultCode.PASSWORD_LENGTH);
        }

        if (PatternUtil.isSame(password)) {
            throw new HjException(ResultCode.PASSWORD_FORMAT_ERROR);
        }

        if (PatternUtil.findChinese(password)) {
            throw new HjException(ResultCode.PASSWORD_FORMAT_ERROR);
        }
    }

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

    public static void main(String[] args) throws Exception {
        System.out.println(PwdUtil.encryptRSA("a111111"));
    }
}
