/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2017年11月3日 下午4:09:53
 */
public class UrlUtil {

    /**
     * MethodsTitle:传入的URL中参数的处理
     *
     * @param url        传入的url
     *                   ex："http://exp.kunnr.com/so/index.html?kunnrId=16&openid=16#/app/home"
     * @param paramName  参数名
     * @param paramValue 参数值
     * @return
     * @author: xg.chen
     * @date:2016年9月2日
     */
    public static String inputURL(String url, String paramName, String paramValue) {
        // 参数和参数名为空的话就返回原来的URL
        if (StringUtils.isBlank(paramValue) || StringUtils.isBlank(paramName)) {
            return url;
        }
        // 先很据# ? 将URL拆分成一个String数组
        String a = "";// url前缀
        String b = "";// ?后面参数#之前内容
        String c = "";// #后面内容

        String[] abcArray = url.split("[#]");

        a = abcArray[0];

        if (abcArray.length > 1) {
            c = abcArray[1];
        }

        String[] abArray = a.split("[?]");
        a = abArray[0];
        if (abArray.length > 1) {
            b = abArray[1];
        }

        if (StringUtils.isBlank(b)) {
            String result = a + "?" + paramName + "=" + paramValue;
            if (StringUtils.isNotBlank(c)) {
                result += "#" + c;
            }
            return result;
        }

        // 用&拆p, p1=1&p2=2 ，{p1=1,p2=2}
        String[] bArray = b.split("&");
        String newb = "";
        boolean found = false;
        for (int i = 0; i < bArray.length; i++) {
            String bi = bArray[i];
            if (StringUtils.isBlank(bi)) {
                continue;
            }
            String key = "";
            String value = "";

            String[] biArray = bi.split("="); // {p1,1}
            key = biArray[0];
            if (biArray.length > 1) {
                value = biArray[1];
            }

            if (key.equals(paramName)) {
                found = true;
                if (StringUtils.isNotBlank(paramValue)) {
                    newb = newb + "&" + key + "=" + paramValue;
                } else {
                    continue;
                }
            } else {
                newb = newb + "&" + key + "=" + value;
            }
        }
        // 如果没找到，加上
        if (!found && StringUtils.isNotBlank(paramValue)) {
            newb = newb + "&" + paramName + "=" + paramValue;
        }
        if (StringUtils.isNotBlank(newb)) {
            a = a + "?" + newb;
        }
        if (StringUtils.isNotBlank(c)) {
            a = a + "#" + c;
        }
        return a;
    }

    /**
     * MethodsTitle: 从url地址中根据key获取value
     *
     * @param url       "http://exp.kunnr.com/so/index.html?kunnrId=16&openid=16#/app/home"
     * @param paramName
     * @return
     * @author: xg.chen
     * @date:2016年9月2日
     */
    public static String getURLParamValue(String url, String paramName) {
        if (StringUtils.isBlank(paramName)) {
            return null;
        }
        // ? #拆开，先把?拆开 a?b#c ->{a,b,c}
        String b = "";
        String[] abcArray = url.split("[?]");
        if (abcArray.length > 1) {
            String bc = abcArray[1];
            String[] bcArray = bc.split("#");
            b = bcArray[0];
        }
        if (StringUtils.isBlank(b)) {
            return null;
        }

        // 用&拆p, p1=1&p2=2 ，{p1=1,p2=2}
        String[] bArray = b.split("&");
        for (int i = 0; i < bArray.length; i++) {
            String bi = bArray[i];
            if (StringUtils.isBlank(bi))
                continue;
            String key = "";
            String value = "";
            String[] biArray = bi.split("="); // {p1,1}
            key = biArray[0];
            if (biArray.length > 1)
                value = biArray[1];
            if (key.equals(paramName)) {
                return value;
            }
        }
        return null;
    }

    /**
     * @param args
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public static void main(String[] args) {
        String url1 = "http//:a.com?a=b,c&a=c=&m=n#DD";
        String url2 = "http//:a.com?a=b&a==&m=n#DD";
        String url3 = "http//:a.com?#A";

        System.out.println(inputURL(url1, "a", "hh"));
        System.out.println(inputURL(url2, "a", "hh"));
        System.out.println(inputURL(url3, "a", "hh"));

        System.out.println(getURLParamValue(url1, "a"));
        System.out.println(getURLParamValue(url2, "a"));
        System.out.println(getURLParamValue(url3, "a"));
    }

}
