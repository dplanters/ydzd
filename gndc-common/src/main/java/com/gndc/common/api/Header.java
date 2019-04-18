/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.api;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 请求响应头封装
 * @date 2018年1月27日 上午10:19:23
 */
@Getter
@Setter
@Accessors(chain = true)
public class Header implements Serializable {

    /**
     * 设备类型，必填 web, wx, ios, android
     */
    private String deviceType;

    /**
     * 手机型号
     */
    private String clientModel;

    /**
     * 客户端版本
     */
    private String clientVersion;

    /**
     * 请求发起的位置-纬度
     */
    private Double locLatitude;

    /**
     * 请求发起的位置-经度
     */
    private Double locLongitude;

    /**
     * sessionId号，登录成功后服务端返回
     */
    private String sessionId;

    /**
     * 请求者IP或者MAC地址，预留
     */
    private String ip;
    /**
     * 发送时间，格式：yyyy-MM-dd HH:mm:ss.SSS
     */
    private Date timestamp;

    /**
     * 签名算法
     */
    private String algorithm;
    /**
     * 签名信息
     */
    private String sign;

    /**
     * 地区
     */
    private String locale;

    /**
     * 分页信息
     */
    private Page page;

}