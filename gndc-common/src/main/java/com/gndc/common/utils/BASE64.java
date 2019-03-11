/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description base64加密util
 * @date 2018年1月25日 上午9:14:06
 */
public class BASE64 {

    /**
     * @param base64String
     * @return
     * @throws UnsupportedEncodingException
     * @Description 加密
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static String encode(String base64String) throws UnsupportedEncodingException {
        return Base64.encodeBase64String(base64String.getBytes("utf-8"));
    }

    public static String encode(byte[] binaryData) {
        return Base64.encodeBase64String(binaryData);
    }

    /**
     * @param base64String
     * @return
     * @throws UnsupportedEncodingException
     * @Description 解密
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static String decode(String base64String) throws UnsupportedEncodingException {
        return new String(Base64.decodeBase64(base64String), "utf-8");
    }

    public static byte[] decode(byte[] binaryData) {
        return Base64.decodeBase64(binaryData);
    }

    /**
     * 转换*号为 -x-， 为了防止有违反协议的字符，-x 转换为-xx
     *
     * @param str
     * @return
     */
    // private static String encodeSpecialLetter(String str) {
    // str = str.replace("-x", "-xx");
    // str = str.replace("*", "-x-");
    // return str;
    // }

    /**
     * 将 s 进行 BASE64 编码,针对url的编码
     *
     * @param s
     * @return
     */
    public static String encodeForUrl(byte[] s) {
        if (s == null)
            return null;
        String standerBase64 = encode(s);
        String encodeForUrl = standerBase64;
        // 转成针对url的base64编码
        // encodeForUrl = encodeForUrl.replace("=", "");
        encodeForUrl = encodeForUrl.replace("+", "*");
        encodeForUrl = encodeForUrl.replace("/", "-");
        // 去除换行
        // encodeForUrl = encodeForUrl.replace("\n", "");
        // encodeForUrl = encodeForUrl.replace("\r", "");

        // 转换*号为 -x-
        // 防止有违反协议的字符
        // encodeForUrl = encodeSpecialLetter(encodeForUrl);

        return encodeForUrl;

    }

    /**
     * 转换 -x-号为*，-xx转换为-x
     *
     * @param str
     * @return
     */
    // private static String decodeSpecialLetter(String str) {
    // str = str.replace("-x-", "*");
    // str = str.replace("-xx", "-x");
    // return str;
    // }
    public static String byte2Image(byte[] data, String path) throws FileNotFoundException, IOException {
        if (!(data.length < 3 || path.equals(""))) {
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        }
        return path;
    }

    /**
     * 将 BASE64 编码的字符串 s 进行解码
     *
     * @param s
     * @return
     */
    public static byte[] decodeForUrl(String s) {
        if (s == null)
            return null;
        // s = decodeSpecialLetter(s);
        s = s.replace("*", "+");
        s = s.replace("-", "/");
        // s += "=";
        try {
            byte[] b = Base64.decodeBase64(s);
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    // public static void main(String[] args) throws Exception {
    // String password = "5>=! '";
    // String encode = BASE64.encode(password);
    // System.out.println(encode);
    // System.out.println(BASE64.decode(encode));
    // System.out.println(BASE64.decode("MTEx"));
    // }

}
