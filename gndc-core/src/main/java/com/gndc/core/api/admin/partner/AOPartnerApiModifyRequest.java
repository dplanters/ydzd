/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.admin.partner;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/15  11:28
 */
@Data
public class AOPartnerApiModifyRequest extends RequestMessage {

    @NotNull
    private Integer id;
    /**
     * 接口地址
     */
    @NotNull
    private String apiUrl;
    /**
     * 接口类型
     */
    @NotNull
    private Byte apiType;

    @NotNull
    private Date updateTime;
    /**
     * 状态  1：正常；0：删除
     */
    @NotNull
    private Byte status;
}
