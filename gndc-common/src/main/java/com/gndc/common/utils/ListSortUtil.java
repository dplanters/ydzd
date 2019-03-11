/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @param <T>
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 列表排序util
 * @date 2018年1月24日 下午5:19:45
 */
public class ListSortUtil<T> {
    /**
     * @param targetList 目标排序List
     * @param sortField  排序字段(实体类属性名)
     * @param sortMode   排序方式（asc or desc）
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void sort(List<T> targetList, final String sortField, final String sortMode) {

        Collections.sort(targetList, new Comparator() {
            public int compare(Object obj1, Object obj2) {
                int retVal = 0;
                try {
                    // 首字母转大写
                    String newStr = sortField.substring(0, 1).toUpperCase() + sortField.replaceFirst("\\w", "");
                    String methodStr = "get" + newStr;

                    Method method1 = ((T) obj1).getClass().getMethod(methodStr, null);
                    Method method2 = ((T) obj2).getClass().getMethod(methodStr, null);
                    if (sortMode != null && "desc".equals(sortMode)) {
                        retVal = ((Double) method2.invoke(((T) obj2), null))
                                .compareTo((Double) method1.invoke(((T) obj1), null)); // 倒序
                    } else {
                        retVal = ((Double) method1.invoke(((T) obj1), null))
                                .compareTo((Double) method2.invoke(((T) obj2), null)); // 倒序
                    }
                } catch (Exception e) {
                    throw new RuntimeException();
                }
                return retVal;
            }
        });
    }
}
