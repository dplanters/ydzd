/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.product;

import java.util.List;

/**
 * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
 * @version V1.0.1
 * @Description
 * @date Aug 27, 2018 5:18:36 PM
 */
public class ProductAmountModel {
    private Integer amount;

    private List<ProductAmountData> amountDataList;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<ProductAmountData> getAmountDataList() {
        return amountDataList;
    }

    public void setAmountDataList(List<ProductAmountData> amountDataList) {
        this.amountDataList = amountDataList;
    }
}
