package com.gndc.common.utils;


import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;

public class PwdUtil {

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
     * 校验密码合法性
     *
     * @param password
     * @throws RtfException
     */
    public static void validate(String password) throws HjException {
        if (password.length() < 6 || password.length() > 12) {
            throw new HjException(ResultCode.PASSWORD_LENGTH);
        }
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

}
