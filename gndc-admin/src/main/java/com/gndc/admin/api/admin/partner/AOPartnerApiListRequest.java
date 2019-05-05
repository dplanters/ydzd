/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.api.admin.partner;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import java.util.Date;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/15  11:28
 */
@Data
public class AOPartnerApiListRequest extends RequestMessage {


    private Integer id;
    /**
     * 机构id
     */
    private Integer partnerId;
    /**
     * 接口地址
     */
    private String apiUrl;
    /**
     * 接口类型
     */
    private Byte apiType;

    private Date createTime;

    private Date updateTime;
    /**
     * 状态  1：正常；0：删除
     */
    private Byte status;
}
