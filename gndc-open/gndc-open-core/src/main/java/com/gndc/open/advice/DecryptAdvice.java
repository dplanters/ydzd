package com.gndc.open.advice;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.PwdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 用于对接收到的三方消息进行解密
 * @date 2019/4/11
 */
@Slf4j
@RestControllerAdvice(basePackages = {
        "com.gndc.open.controller",
})
public class DecryptAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        //TODO 校验参数
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(body));

        JSONObject header = params.getJSONObject("header");
        String signStr = header.getString("sign");
        String randomStr = params.getString("randomStr");

        //移除sign
        header.remove("sign");
        //移除randomStr,不然下边PwdUtil.paramsJoin方法会将randomStr拼接两次
        params.remove("randomStr");

        String joinStr = PwdUtil.paramsJoin(params, randomStr);

        //对接收到的sign进行base64解码
        byte[] signDecode = Base64.decode(signStr, Charset.forName("UTF-8"));

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRXYFYTGI9uVipfl9P5loLAWLRIQPpSznBc1ACIpCO/ptKYLXjzunWz2TyCj5OV1yjs9pEIcyOnxs6ESplsUOsEakf6wDgox6sU3A51mQmQlm6ALxtfguurZGOJ0Ksg/gL1q97YWTSMsH9R1slDV95nvMKsQAd4Yd/6i+2/ihaxQIDAQAB";

        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJFdgVhMYj25WKl+X0/mWgsBYtEhA+lLOcFzUAIikI7+m0pgtePO6dbPZPIKPk5XXKOz2kQhzI6fGzoRKmWxQ6wRqR/rAOCjHqxTcDnWZCZCWboAvG1+C66tkY4nQqyD+AvWr3thZNIywf1HWyUNX3me8wqxAB3hh3/qL7b+KFrFAgMBAAECgYAoC4BEWNZ/dn3MQ3nyQtzvRzR3tAal0AlbF28lB2yXV+BjvvycgzW77Wo7m0LKxhpJJpSsTDtT1tTjTDNHzGt9oxscdWDYAgaQZpDaL/nBH4A9AJG2gPfszJUGrN7HtAQJWNAQUDwcdMSuz9rJRUt3T1e/QEz8nobzuPQ1AWACgQJBAMQZ8MaCGGcBcowKMY6F3RWP7pCe2ukJtsiH4FwqE3K5R8g2+/CWn3oRbHz7erydBpgToQJWbccbUs2FAJNc+VUCQQC9xEdwiV5xKprzTziCHohXgatv6CgcgK5oiuxMgfHgq1WkN2zq8XemjUrghy6q4AxE9viVnj78DkZaZ/vKRBuxAkAnwG5rfxG9R7DVrHdRQdeIOG4OyPTtSnfP/KNBa5IXrnFbp7G4mn/necK5Ly05MMeWalw4IhcMxoApgy2TscQlAkEAlblTlFsOBMPU1bvfnepxMHnCxdyqKTLuaNWTcxnjuZv1Skfgy84Q1XwNY/HExFVZ2N/zajkdAMpSf+ojI4dxQQJAO7Nio7zdggqd8nu2Cy7K9FWg3XEqff4HMZ8PKakwhOaq2p0gOUc4aVM1ajd2FzGU8yb1Rcwu5EfM19bv5lRsCQ==";

        Sign sign = SecureUtil.sign(SignAlgorithm.MD5withRSA, privateKey, publicKey);

        if (!sign.verify(joinStr.getBytes(Charset.forName("UTF-8")), signDecode)) {
            throw new HjException(ResultCode.CHECK_SIGN_FAIL);
        }
        //存放数据
        return body;
    }
}
