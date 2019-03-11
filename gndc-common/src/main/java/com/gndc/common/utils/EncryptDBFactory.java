package com.gndc.common.utils;

import org.springframework.beans.factory.FactoryBean;

import java.io.UnsupportedEncodingException;

public class EncryptDBFactory implements FactoryBean<Object> {

    private static final String KEY = "RTFDB2016";

    private String password;

    public static String encode(String secret) {
        try {
            return RC4CipherEntity.encrypt(secret, KEY);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return secret;
    }

    public static String decode(String secret) {
        try {
            return RC4CipherEntity.decrypt(secret, KEY);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return secret;
    }

    public Object getObject() throws Exception {
        if (password != null) {
            return String.valueOf(decode(password));
        } else {
            return null;
        }
    }

    public Class<?> getObjectType() {
        return String.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
