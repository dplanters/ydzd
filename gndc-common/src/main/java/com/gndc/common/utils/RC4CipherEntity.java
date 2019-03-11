package com.gndc.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;

public class RC4CipherEntity {
    private static String KEY = "hj@321";

    static String RC4(String keys, String encrypt) {
        char[] keyBytes = new char[256];
        char[] cypherBytes = new char[256];

        for (int i = 0; i < 256; ++i) {
            keyBytes[i] = keys.charAt(i % keys.length());
            cypherBytes[i] = (char) i;
        }

        int jump = 0;
        for (int i = 0; i < 256; ++i) {
            jump = (jump + cypherBytes[i] + keyBytes[i]) & 0xFF;
            char tmp = cypherBytes[i]; // Swap:
            cypherBytes[i] = cypherBytes[jump];
            cypherBytes[jump] = tmp;
        }

        int i = 0;
        jump = 0;
        StringBuilder result = new StringBuilder();
        for (int x = 0; x < encrypt.length(); ++x) {
            i = (i + 1) & 0xFF;
            char tmp = cypherBytes[i];
            jump = (jump + tmp) & 0xFF;
            char t = (char) ((tmp + cypherBytes[jump]) & 0xFF);
            cypherBytes[i] = cypherBytes[jump]; // Swap:
            cypherBytes[jump] = tmp;

            try {
                result.append(new String(new char[]{(char) (encrypt.charAt(x) ^ cypherBytes[t])}));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }

    static String Data2ASCIIhex(String inputString) {
        String result = "";
        String Chars = "0123456789ABCDEF";

        for (int i = 0; i < inputString.length(); ++i) {
            char ch = (char) inputString.charAt(i);
            char lo = (char) (ch & 0x0F);
            char hi = (char) (ch >> 4);
            result += new String(new char[]{Chars.charAt(hi), Chars.charAt(lo)});
        }

        return result;
    }

    /**
     * 加密
     *
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encrypt(String data) throws UnsupportedEncodingException {
        return encrypt(data, KEY);
    }

    public static String encrypt(String data, String key) throws UnsupportedEncodingException {
        if (StringUtils.isNotEmpty(data)) {
            return Base64.encodeBase64String(RC4(key, data).getBytes("utf-8"));
        }
        return data;
    }

    /**
     * 解密
     *
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String decrypt(String data) throws UnsupportedEncodingException {
        return decrypt(data, KEY);
    }

    public static String decrypt(String data, String key) throws UnsupportedEncodingException {
        if (StringUtils.isNotEmpty(data)) {
            return RC4(key, new String(Base64.decodeBase64(data), "utf-8"));
        }
        return data;
    }

    public static void main(String args[]) throws UnsupportedEncodingException {
        String message = "a123456";
        String result = encrypt(message);
        String result2 = decrypt(result);
        System.out.println("result:" + result);
        System.out.println("result2:" + result2);
    }
}
