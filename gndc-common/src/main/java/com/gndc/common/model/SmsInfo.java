/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.model;

import java.io.Serializable;

/**
 * 验证码短信，需要用ehache缓存
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2017年10月19日 下午6:18:39
 */
public class SmsInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2904857299067163792L;
    /**
     * 验证码
     */
    private String valCode;
    /**
     * 获取短信次数
     */
    private Integer count = 0;
    /**
     * 失败次数
     */
    private Integer failCount = 0;

    public SmsInfo() {
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    @Override
    public String toString() {
        return "SmsInfo [authCode=" + valCode + ", count=" + count + ", failCount=" + failCount + "]";
    }

}
