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

import java.math.BigDecimal;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/5/5  15:16
 */
@Data
public class SettlementReportDetailDTO {

    //UV量；5：CPA-注册成功(H5对接) 或 一推成功(API对接)；10：CPS-放款成功；
    private BigDecimal uvFee;
    private BigDecimal cpaFee;
    private BigDecimal cpsFee;
    private Integer count;
    private String  moth;


}
