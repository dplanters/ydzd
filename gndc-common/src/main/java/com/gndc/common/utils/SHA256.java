/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
 * @version V1.0.1
 * @Description
 * @date Aug 30, 2018 3:49:41 PM
 */
public class SHA256 {

    private static Logger logger = LoggerFactory.getLogger(SHA256.class);


    public static String sha256_HMAC(String message, String secret) {

        String hash = "";

        try {

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");

            sha256_HMAC.init(secret_key);

            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());

            hash = byteArrayToHexString(bytes);

            logger.info(hash);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);

        }

        return hash;

    }

    private static String byteArrayToHexString(byte[] b) {

        StringBuilder hs = new StringBuilder();

        String stmp;

        for (int n = 0; b != null && n < b.length; n++) {

            stmp = Integer.toHexString(b[n] & 0XFF);

            if (stmp.length() == 1)

                hs.append('0');

            hs.append(stmp);

        }

        return hs.toString().toLowerCase();

    }
}
