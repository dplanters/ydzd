package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOProductHotEditRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    private Integer productId;

    private Integer partnerId;

    private Byte position;

    @NotNull
    private Byte hotStatus;

    /**
     * 产品附加信息
     */
    private AOProductHotEditRequest extra;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_PRODUCT_MANAGER_PRODUCT_HOT_EDIT);
    }
}
