/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/30  9:49
 */
@Data
public class ProductShowConfigListDTO implements Serializable {

    private String productName;
    private String partnerName;
    private String appName;
    private Byte showModule;//展示模块 1：首页-精选爆款；5：找贷款；15：极速贷；
    private Byte settlementMode;//结算方式
    private BigDecimal settlementPrice;//结算价格
    private Byte online_status;//上线状态
    private Date createTime;//添加时间
    private Date lastOnlineTime;//上线时间
    private Date lastOfflineTime;//下线时间

}
