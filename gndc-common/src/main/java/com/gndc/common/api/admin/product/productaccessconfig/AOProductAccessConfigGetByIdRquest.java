package com.gndc.common.api.admin.product.productaccessconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AOProductAccessConfigGetByIdRquest extends RequestMessage {

    @NotNull
    private Integer id;

}