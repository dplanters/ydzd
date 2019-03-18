/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.third.sms;

import com.gndc.common.enums.sms.SmsTemplateType;

import java.util.Map;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 短信发送接口
 * @date 2018年1月25日 下午8:55:19
 */
public interface ISmsService {

    /**
     * 发送即时短信
     *
     * @param phone
     * @param message
     * @return
     * @throws Exception
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    Map<String, String> sendSms(String phone, String message, SmsTemplateType smsType) throws Exception;

    /**
     * 发送即时短信
     *
     * @param phone
     * @param message
     * @return
     * @throws Exception
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    Map<String, String> marketSms(String phone, String message) throws Exception;

}
