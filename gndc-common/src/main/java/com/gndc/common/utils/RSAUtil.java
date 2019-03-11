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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月25日 下午2:06:31
 */

@Configuration
@PropertySource(value = "classpath:/system.properties")
public class RSAUtil {
    public static final String ENCRYPTION_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    public static String PUBLIC_KEY;
    public static String PRIVATE_KEY;

    /**
     * 加密
     */
    public static byte[] encrypt(byte[] data, String keyString, boolean isPublic) throws Exception {
        Map<String, Object> keyAndFactoryMap = RSAUtil.generateKeyAndFactory(keyString, isPublic);
        KeyFactory keyFactory = RSAUtil.getKeyFactory(keyAndFactoryMap);
        Key key = RSAUtil.getKey(keyAndFactoryMap);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(data);
        return result;
    }

    /**
     * @param data
     * @return
     * @throws Exception
     * @Description 加密
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static String encrypt(String data) throws Exception {
        Map<String, Object> keyAndFactoryMap = RSAUtil.generateKeyAndFactory(PUBLIC_KEY, true);
        KeyFactory keyFactory = RSAUtil.getKeyFactory(keyAndFactoryMap);
        Key key = RSAUtil.getKey(keyAndFactoryMap);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] result = cipher.doFinal(data.getBytes());
        return java.util.Base64.getEncoder().encodeToString(result);
    }

    // /**
    // * 生成密钥
    // */
    // public static Map<String, Object> initKey() throws Exception {
    // /* 初始化密钥生成器 */
    // KeyPairGenerator keyPairGenerator =
    // KeyPairGenerator.getInstance(ENCRYPTION_ALGORITHM);
    // keyPairGenerator.initialize(1024);
    //
    // /* 生成密钥 */
    // KeyPair keyPair = keyPairGenerator.generateKeyPair();
    // RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    // RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    //
    // Map<String, Object> keyMap = new HashMap<String, Object>(2);
    // keyMap.put("PublicKey", publicKey);
    // keyMap.put("PrivateKey", privateKey);
    // return keyMap;
    // }
    //
    // /**
    // * 取得公钥
    // */
    // public static String getPublicKey(Map<String, Object> keyMap) throws
    // Exception {
    // Key key = (Key) keyMap.get("PublicKey");
    // return Base64.encodeBase64String(key.getEncoded());
    // }
    //
    // /**
    // * 取得私钥
    // */
    // public static String getPrivateKey(Map<String, Object> keyMap) throws
    // Exception {
    // Key key = (Key) keyMap.get("PrivateKey");
    // return Base64.encodeBase64String(key.getEncoded());
    // }

    /**
     * 解密
     */
    public static byte[] decrypt(byte[] data, String keyString, boolean isPublic) throws Exception {
        Map<String, Object> keyAndFactoryMap = RSAUtil.generateKeyAndFactory(keyString, isPublic);
        KeyFactory keyFactory = RSAUtil.getKeyFactory(keyAndFactoryMap);
        Key key = RSAUtil.getKey(keyAndFactoryMap);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);

        return cipher.doFinal(data);
    }

    /**
     * @param data
     * @return
     * @throws Exception
     * @Description 解密
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static String decrypt(String data) throws Exception {
        Map<String, Object> keyAndFactoryMap = RSAUtil.generateKeyAndFactory(PRIVATE_KEY, false);
        KeyFactory keyFactory = RSAUtil.getKeyFactory(keyAndFactoryMap);
        Key key = RSAUtil.getKey(keyAndFactoryMap);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] aa = java.util.Base64.getDecoder().decode(data);
        byte[] result = cipher.doFinal(aa);
        return new String(result, "utf-8");
    }

    /**
     * 生成钥匙
     */
    public static Map<String, Object> generateKeyAndFactory(String keyString, boolean isPublic) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(keyString);
        KeyFactory keyFactory = KeyFactory.getInstance(ENCRYPTION_ALGORITHM);
        Key key = null;
        if (isPublic) {
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            key = keyFactory.generatePublic(x509KeySpec);
        } else {
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            key = keyFactory.generatePrivate(pkcs8KeySpec);
        }

        Map<String, Object> keyAndFactoryMap = new HashMap<String, Object>(2);
        keyAndFactoryMap.put("key", key);
        keyAndFactoryMap.put("keyFactory", keyFactory);

        return keyAndFactoryMap;
    }

    /**
     * 从指定对象中获取钥匙
     */
    public static Key getKey(Map<String, Object> map) {
        if (map.get("key") == null) {
            return null;
        }
        return (Key) map.get("key");
    }

    /**
     * 从指定对象中获取钥匙工厂
     */
    public static KeyFactory getKeyFactory(Map<String, Object> map) {
        if (map.get("keyFactory") == null) {
            return null;
        }
        return (KeyFactory) map.get("keyFactory");
    }

    /**
     * 对信息生成数字签名（用私钥）
     */
    public static String sign(byte[] data, String keyString) throws Exception {
        Map<String, Object> keyAndFactoryMap = RSAUtil.generateKeyAndFactory(keyString, false);
        Key key = RSAUtil.getKey(keyAndFactoryMap);

        PrivateKey privateKey = (PrivateKey) key;

        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        return Base64.encodeBase64String(signature.sign());
    }

    /**
     * 校验数字签名（用公钥）
     */
    public static boolean verify(byte[] data, String keyString, String sign) throws Exception {
        Map<String, Object> keyAndFactoryMap = RSAUtil.generateKeyAndFactory(keyString, true);
        Key key = RSAUtil.getKey(keyAndFactoryMap);

        PublicKey publicKey = (PublicKey) key;

        // 取公钥匙对象
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(data);

        // 验证签名是否正常
        return signature.verify(Base64.decodeBase64(sign));
    }

    @Value("${rsa.private}")
    public void setPrivate(String privateKey) {
        RSAUtil.PRIVATE_KEY = privateKey;
    }

    @Value("${rsa.public}")
    public void setPublic(String publicKey) {
        RSAUtil.PUBLIC_KEY = publicKey;
    }

}
