/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description json处理util
 * @date 2018年1月24日 下午5:18:24
 */
public class JsonUtil {
    /**
     * 传入任意的jsontext,返回的T都不会为null,只是T的属性为null
     *
     * @param <T>
     * @param jsontext
     * @param clazz
     * @return -> UserBean
     */
    public static final <T> T getObject(String jsontext, Class<T> clazz) {
        return JSON.parseObject(jsontext, clazz);
    }

    public static final <T> T getObject(String jsontext, TypeReference<T> clazz) {
        return JSON.parseObject(jsontext, clazz);
    }

    public static final <T> T getObject(JSON json, Class<T> clazz) {
        return JSON.toJavaObject(json, clazz);
    }

    public static final String toJSONString(Object object) {
        return JSON.toJSONString(object, false);
    }

    public static final String toJSONString(Object object, boolean prettyFormat) {
        return JSON.toJSONString(object, prettyFormat);
    }

    public static final String toJSONString(Object object, SimplePropertyPreFilter spp) {
        return JSON.toJSONString(object, spp);
    }
}
