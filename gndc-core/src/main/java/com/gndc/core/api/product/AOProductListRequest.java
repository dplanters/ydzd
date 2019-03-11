package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOProductListRequest extends RequestMessage {

    /**
     * 合作模式
     */
    private Byte coopeMode;

    /**
     * 产品名
     */
    private String name;

    /**
     * 产品状态
     */
    private Byte status;

    /**
     * 合作机构id
     */
    private Integer partnerId;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_PRODUCT_MANAGER_PRODUCT_LIST);
    }
}
