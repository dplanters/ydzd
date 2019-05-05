package com.gndc.common.api.admin.systemconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AOSystemConfigGetByIdRequest extends RequestMessage {

    @NotNull
    private Integer id;

}