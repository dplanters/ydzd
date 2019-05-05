/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/28  20:27
 */
@Data
public class ProductListDTO implements Serializable {

    private Long productId;
    private String logoUrl;
    private String productName;
    private Date loanAmountMin;
    private Date loanAmountMax;
    private Byte loanPeriodUnit;
    private Date loanPeriodStart;
    private Date loanPeriodEnd;
    private String partnerName;
    private Byte   settlementMode;
    private BigDecimal settlementPrice;
    private Date createTime;
    private Byte productStatus;
    private Date lastOnlineTime;
    private Date lastOfflineTime;

}
