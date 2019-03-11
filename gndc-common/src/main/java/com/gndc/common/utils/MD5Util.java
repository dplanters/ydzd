/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import java.security.MessageDigest;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description md5util
 * @date 2018年1月24日 下午5:22:08
 */
public class MD5Util {

    public static String getMD5(String str) {
        return getMD5(str, "utf-8", 1);
    }

    /**
     * MD5加密方法
     *
     * @param str
     * @param encoding
     * @param no_Lower_Upper
     * @return
     */
    public static String getMD5(String str, String encoding, int no_Lower_Upper) {
        if (null == encoding)
            encoding = "utf-8";
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes(encoding));
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (no_Lower_Upper == 0) {
            return sb.toString();
        }
        if (no_Lower_Upper == 1) {
            return sb.toString().toLowerCase();
        }
        if (no_Lower_Upper == 2) {
            return sb.toString().toUpperCase();
        }
        return null;
    }

}