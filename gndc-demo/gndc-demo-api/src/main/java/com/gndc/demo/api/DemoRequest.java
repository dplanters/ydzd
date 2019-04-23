package com.gndc.demo.api;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/23
 */
@Getter
@Setter
public class DemoRequest extends RequestMessage {

    @NotNull
    @Min(1)
    private Long id;
}
