package com.gndc.core.api.admin.product;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
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
    @Min(1)
    private Integer id;

    /**
     * 上下线：2：上线；-1：下线
     */
    @NotNull
    private Byte upperAndLowerLine;

}
