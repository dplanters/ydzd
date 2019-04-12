package com.gndc.common.advice;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.RequestMessage;
import com.gndc.common.utils.PwdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TreeMap;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 用于对接收到的三方消息进行解密
 * @date 2019/4/11
 */
@Slf4j
@RestControllerAdvice(basePackages = {
        "com.gndc.core.controller.open",
})
public class DecryptAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        String locale = ((RequestMessage) body).getHeader().getLocale();
        if (ObjectUtil.isNotNull(locale)) {
            LocaleContextHolder.setLocale(Locale.forLanguageTag(locale));
        }
        TreeMap<String, Object> treeMap = new TreeMap<>();
        String key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRXYFYTGI9uVipfl9P5loLAWLRIQPpSznBc1ACIpCO/ptKYLXjzunWz2TyCj5OV1yjs9pEIcyOnxs6ESplsUOsEakf6wDgox6sU3A51mQmQlm6ALxtfguurZGOJ0Ksg/gL1q97YWTSMsH9R1slDV95nvMKsQAd4Yd/6i+2/ihaxQIDAQAB";
        JSONObject params = JSONObject.parseObject(JSONObject.toJSONString(body));

        //参数放入treeMap进行排序
        PwdUtil.pushToTreeMap(params, treeMap);

        //移除sign
        treeMap.remove("sign");
        //移除randomStr
        treeMap.remove("randomStr");

        if (treeMap.get("pageNum").equals(Integer.valueOf(1)) && treeMap.get("pageSize").equals(Integer.valueOf(1))) {
            //当前页数和每页数量都为1时则为默认值不参与签名
            treeMap.remove("pageNum");
            treeMap.remove("pageSize");
        }

        JSONObject header = params.getJSONObject("header");

        String str = PwdUtil.paramsJoin(treeMap, params.getString("randomStr"), key);
        String sign = header.getString("sign");

        String decrypt = PwdUtil.decrypt(sign);
        if (str.equals(decrypt)) {
            log.info("解密成功");
        }

        //解密
        return body;
    }
}
