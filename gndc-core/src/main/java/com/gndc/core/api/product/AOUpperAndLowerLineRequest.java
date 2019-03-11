package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author jingkaihui
 * @date 2019/3/6
 */
@Getter
@Setter
public class AOUpperAndLowerLineRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    private Integer id;

    /**
     * 上下线：2：上线；-1：下线
     */
    @NotNull
    private Byte upperAndLowerLine;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_PRODUCT_MANAGER_PRODUCT_UPPER_AND_LOWER_LINE);
    }
}
