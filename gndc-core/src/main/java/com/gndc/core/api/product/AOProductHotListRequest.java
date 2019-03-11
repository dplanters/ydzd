package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOProductHotListRequest extends RequestMessage {

    /**
     * 产品名
     */
    private String name;

    /**
     * 合作机构id
     */
    private Integer partnerId;


    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_PRODUCT_MANAGER_PRODUCT_LIST);
    }
}
