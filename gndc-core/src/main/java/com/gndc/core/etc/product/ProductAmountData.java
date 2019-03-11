/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.product;

import java.math.BigDecimal;

/**
 * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
 * @version V1.0.1
 * @Description
 * @date Aug 25, 2018 2:29:14 PM
 */
public class ProductAmountData implements Comparable<ProductAmountData> {
    private BigDecimal interest;

    private BigDecimal repayAmount;


    private Integer borrowPeriod;

    /**
     * Description
     *
     * @param o
     * @return
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(ProductAmountData o) {
        if (o.getBorrowPeriod() < this.getBorrowPeriod()) {
            return -1;
        } else {
            return 0;

        }
    }


    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Integer getBorrowPeriod() {
        return borrowPeriod;
    }

    public void setBorrowPeriod(Integer borrowPeriod) {
        this.borrowPeriod = borrowPeriod;
    }


}
