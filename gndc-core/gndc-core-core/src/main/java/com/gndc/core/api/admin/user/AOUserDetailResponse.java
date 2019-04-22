/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.admin.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AOUserDetailResponse implements Serializable {

    private static final long serialVersionUID = -6144625026701292484L;

    /**
     * 行为时间
     */
    private String eventTime;
    /**
     * 事件类型 1banner列表点击；2爆款列表点击；3点击下载；4收藏；5取消收藏；6打开app;7 登录;8找贷款列表点击
     */
    private Byte eventType;

    /**
     * 产品名称
     */
    private String name;

}
