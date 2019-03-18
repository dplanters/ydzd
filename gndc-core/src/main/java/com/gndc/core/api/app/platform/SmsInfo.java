/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.app.platform;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 验证码短信，需要用缓存
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2017年10月19日 下午6:18:39
 */
@Getter
@Setter
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

}
