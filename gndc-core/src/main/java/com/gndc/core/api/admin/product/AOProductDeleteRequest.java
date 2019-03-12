package com.gndc.core.api.admin.product;

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
public class AOProductDeleteRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    private Integer id;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_PRODUCT_MANAGER_PRODUCT_DELETE);
    }
}
