package com.gndc.core.etc.product;

/**
 * Description: 客户端产品申请（UV）统计
 * User: chenzuozhou
 * Date: 2019-03-04
 * Time: 下午8:13
 */
public class PProductStaticUV {
    private Integer staticCount;
    private Integer productId;

    public Integer getStaticCount() {
        return staticCount;
    }

    public void setStaticCount(Integer staticCount) {
        this.staticCount = staticCount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
