package com.gndc.common.utils;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
@Configuration
@PropertySource(value = "classpath:/system.properties")
public class PwdUtil {

    @Value("${rsa.private}")
    private String privateKey;

    @Value("${rsa.public}")
    private String publicKey;

    public static RSA rsa;

    @PostConstruct
    public void init() {
        rsa = SecureUtil.rsa(privateKey, publicKey);
    }

    /**
     * 对字符串加密，返回加密后的base64编码
     * @param data
     * @return
     */
    public static String encrypt(String data) {
        return Base64.encode(rsa.encrypt(data, KeyType.PublicKey));
    }

    /**
     * 对加密后的Base64串进行解密得到原数据
     * @param data 加密后的Base64串
     * @return 原数据
     */
    public static String decrypt(String data) {
        String decrypt = null;
        try {
            decrypt = StrUtil.str(rsa.decrypt(Base64.decode(data), KeyType.PrivateKey), "UTF-8");
        } catch (Exception e) {
            log.warn("解密失败");
            throw new HjException(ResultCode.DECRYPT_ERROR);
        }
        return decrypt;
    }

    /**
     * 根据用户密码和随机sign生成一个md5串作为密码
     *
     * @param password
     * @param sign
     * @return
     * @Description
     */
    public static String passwordGenerate(String password, String sign) {
        return SecureUtil.md5(password + sign).substring(5, 30);
    }

    /**
     * 为treeMap中的元素使用&进行拼接并拼接随机字符串和秘钥
     * @param treeMap
     * @param randomStr
     * @param key
     * @return
     */
    public static String paramsJoin(TreeMap<String, Object> treeMap, String randomStr, String key) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            String entryKey = entry.getKey();
            Object entryValue = entry.getValue();
            sb.append(entryKey);
            sb.append("=");
            sb.append(entryValue);
            sb.append("&");
        }
        sb.append("randomStr=" + randomStr);
        sb.append("&key=");
        sb.append(key);
        return sb.toString();
    }

    /**
     * 把JSONObject对象中的不为null的值放入treeMap中
     * 注意：如果一个value是一个JSONObject对象，则只对其包含的不为null且不是JSONObject对象的值放入treeMap
     * @param params
     * @param treeMap
     */
    public static void pushToTreeMap(JSONObject params, TreeMap<String, Object> treeMap) {
        Iterator<String> iterator = params.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = params.get(key);
            if (!(value instanceof JSONObject) && ObjectUtil.isNotNull(value)) {
                treeMap.put(key, value);
            } else {
                pushToTreeMap((JSONObject) value, treeMap);
            }
        }
    }
}
